package com.example.socketserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.socketserver.entity.MaintenanceGroupInfo;

public interface MaintenanceGroupInfoService extends IService<MaintenanceGroupInfo>  {

    MaintenanceGroupInfo getMaintenanceInfoByDeptId(Long deptId);

}
