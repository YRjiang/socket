package com.example.socketserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/*@ApiModel(value="ai_business_warn_record")*/
@Data
public class AiBusinessWarnRecord implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * 部门id（机房或楼宇的id）
    */
    private Long deptId;

    /**
    * 部门名称（机房或楼宇的名称）
    */
    private String deptName;

    /**
    * 任务id
    */
    private Integer taskId;

    /**
    * 任务名称
    */
    private String taskName;

    /**
    * 设备名称
    */
    private String deviceName;

    /**
    * 设备编码
    */
    private String deviceCoding;

    /**
    * 告警类型
    */
    private String warnType;

    /**
    * 告警时间
    */
    private Date warnTime;

    /**
    * 告警内容
    */
    private String warnContent;

    /**
    * 场景图片
    */
    private String imageInfo;

    /**
    * 识别图片
    */
    private String recognitionImage;

    /**
    * 处理时间
    */
    private Date handleTime;

    /**
    * 处理人
    */
    private String handlePeople;

    /**
    * 状态( 0未处理   1已处理)
    */
    private String status;

    /**
    * 处理描述
    */
    private String handleDescribe;

    /**
    * 创建人
    */
    private String createBy;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 最近更新人
    */
    private String updateBy;

    /**
    * 最近更新时间
    */
    private Date updateTime;

    /**
    * 删除标记（0-正常，1-已删除）
    */
    private String deleteStatus;


    /*@ApiModelProperty(value="租户id")*/
    private String tenantId;
    /*@ApiModelProperty(value="是否通知 1-是 0-否")*/
    private String notice;
    /*@ApiModelProperty(value="设备ID")*/
    private String deviceId;


    /*@ApiModelProperty(value="告警类型名称")*/
    @TableField(exist = false)
    private String warnTypeDict;

    /*@ApiModelProperty(value="祖级列表")*/
    @TableField(exist = false)
    private String ancestors;
    /*@ApiModelProperty(value="递归名称")*/
    @TableField(exist = false)
    private String recursionName;


    /*@ApiModelProperty(value="应答时间")*/
    private Date answerTime;
//    @ApiModelProperty(value="应答人")
    private String answerPeople;
    /*@ApiModelProperty(value="应答描述")*/
    private String answerDescribe;


    /*@ApiModelProperty(value="施工人员")*/
    @TableField(exist = false)
    private String builder;
    /*@ApiModelProperty(value="监理人员")*/
    @TableField(exist = false)
    private String supervisor;
//    @ApiModelProperty(value="巡检人")
    @TableField(exist = false)
    private String inspector;

   /* @ApiModelProperty(value="维护组")*/
    @TableField(exist = false)
    private String maintaingroup;

}