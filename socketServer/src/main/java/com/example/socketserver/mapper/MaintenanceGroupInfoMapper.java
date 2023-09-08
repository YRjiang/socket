package com.example.socketserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.socketserver.entity.MaintenanceGroupInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MaintenanceGroupInfoMapper extends BaseMapper<MaintenanceGroupInfo>  {

    @Select("select mgi.* from maintenance_group_info mgi " +
            "inner join sys_dept sd on sd.dept_name = mgi.dept_name " +
            "inner join sys_dept sd2 on sd.dept_id = sd2.parent_id " +
            "where sd2.dept_id = #{deptId}")
    MaintenanceGroupInfo getMaintenanceInfoByDeptId(Long deptId);

}
