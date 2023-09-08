package com.example.socketserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.socketserver.componet.WebSocketServer;
import com.example.socketserver.entity.AiBusinessWarnRecord;
import com.example.socketserver.entity.MaintenanceGroupInfo;
import com.example.socketserver.service.AlarmPlatformService;
import com.example.socketserver.service.MaintenanceGroupInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class PushZhongGaoJob {

    @Autowired
    private WebSocketServer webSocketServer;

    @Autowired
    private MaintenanceGroupInfoService maintenanceService;

    @Autowired
    private AlarmPlatformService alarmPlatformService;

    @Scheduled(cron = "${socket.schedule}")
    public void aiWarnRecordHandler() {
        if (new WebSocketServer().getWebSocketSize() <= 0) {
            log.info("未发现客户端连接");
            return;
        }

        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 控制执行开关
        QueryWrapper<MaintenanceGroupInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("area_name", "推送开关");
        MaintenanceGroupInfo one = maintenanceService.getOne(wrapper);
        Boolean isPush = true;
        if (Optional.ofNullable(one).isPresent()) {
            if ("开启".equals(one.getMaintenanceName())) {
                isPush = true;
            } else {
                isPush = false;
            }
        }
        log.info("告警记录推送开关状态: " + (isPush ? "开启" : "关闭"));

        if (isPush) {
            LocalDateTime yesterday = dateTimeNow.plusDays(-1);
            String yesterdayStr = yesterday.format(formatter2);

            List<AiBusinessWarnRecord> list = alarmPlatformService.getList(yesterdayStr);
            log.info("查询到条数: " + list.size());

            if (list.size() > 0) {
                list.forEach(item -> {
                    // 获取维护组信息
                    MaintenanceGroupInfo info = maintenanceService.getMaintenanceInfoByDeptId(item.getDeptId());
                    if (Optional.ofNullable(info).isPresent() && StringUtils.isNotBlank(info.getMaintenanceName())) {
                        String maintenanceName = info.getMaintenanceName();
                        item.setMaintaingroup(maintenanceName);
                        try {
                            String data = JSONObject.toJSONString(item);
                            log.info("推送数据: " + data);
                            webSocketServer.AppointSending("zhonggao", data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        log.info("业务告警id: " + item.getId() + ", 维护组为空, 不发送告警数据");
                    }
                });
            }
        }
    }


    public void aiWarnRecordTest() {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime yesterday = dateTimeNow.plusDays(-1);
        String yesterdayStr = yesterday.format(formatter2);

        List<AiBusinessWarnRecord> list = alarmPlatformService.getList(yesterdayStr);
        log.info("查询到条数: " + list.size());

        if (list.size() > 0) {
            list.forEach(item -> {
                try {
                    String data = JSONObject.toJSONString(item);
                    log.info("推送数据: " + data);
                    webSocketServer.AppointSending("zhonggao", data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
