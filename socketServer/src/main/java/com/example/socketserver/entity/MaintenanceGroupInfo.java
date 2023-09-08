package com.example.socketserver.entity;

import lombok.Data;

import java.io.Serializable;

//@ApiModel(value="maintenance_group_info")
@Data
public class MaintenanceGroupInfo implements Serializable {
    /**
    * id
    */
//    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 区域名称
     */
//    @ApiModelProperty(value="区域名称")
    private String areaName;

    /**
    * 部门id（机房或楼宇的id）
    */
//    @ApiModelProperty(value="部门id（机房或楼宇的id）")
    private Long deptId;

    /**
    * 部门名称（机房或楼宇的名称）
    */
//    @ApiModelProperty(value="部门名称（机房或楼宇的名称）")
    private String deptName;

    /**
    * 维护组名称
    */
//    @ApiModelProperty(value="维护组名称")
    private String maintenanceName;

}