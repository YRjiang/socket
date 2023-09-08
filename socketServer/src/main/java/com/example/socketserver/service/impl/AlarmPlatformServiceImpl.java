package com.example.socketserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.socketserver.entity.AiBusinessWarnRecord;
import com.example.socketserver.service.AiBusinessWarnRecordService;
import com.example.socketserver.service.AlarmPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class AlarmPlatformServiceImpl implements AlarmPlatformService {

    @Autowired
    private AiBusinessWarnRecordService aiBusinessWarnRecordService;

    @Override
    public List<AiBusinessWarnRecord> getList(String date) {
        QueryWrapper<AiBusinessWarnRecord> queryWrapper = new QueryWrapper<>();
        List<String> warnTypeList = Arrays.asList("1", "5", "6", "7", "8", "9");
        queryWrapper.in("warn_type", warnTypeList);
        List<String> statusList = Arrays.asList("0", "2");
        queryWrapper.in("status", statusList);

        String applySql = "(date_format(if(update_time is null, warn_time, update_time), '%Y-%m-%d') = '" + date + "')";
        queryWrapper.apply(applySql);

        List<AiBusinessWarnRecord> list = aiBusinessWarnRecordService.list(queryWrapper);
        return list;
    }
}
