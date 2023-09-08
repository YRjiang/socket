package com.example.socketserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.socketserver.entity.MaintenanceGroupInfo;
import com.example.socketserver.mapper.MaintenanceGroupInfoMapper;
import com.example.socketserver.service.MaintenanceGroupInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (AiBusinessWarn)表服务实现类
 *
 * @author makejava
 * @since 2022-08-16 17:37:14
 */
@Service
public class MaintenanceGroupInfoServiceImpl extends ServiceImpl<MaintenanceGroupInfoMapper, MaintenanceGroupInfo>
        implements MaintenanceGroupInfoService {

    @Autowired
    private MaintenanceGroupInfoMapper mapper;

    @Override
    public MaintenanceGroupInfo getMaintenanceInfoByDeptId(Long deptId) {
        MaintenanceGroupInfo maintenanceInfoByDeptId = mapper.getMaintenanceInfoByDeptId(deptId);
        return maintenanceInfoByDeptId;
    }
}
