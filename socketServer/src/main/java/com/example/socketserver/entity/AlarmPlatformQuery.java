package com.example.socketserver.entity;

import lombok.Data;

import java.util.List;

@Data
public class AlarmPlatformQuery {

//    @ApiModelProperty(value = "页码")
    private Integer pageNum;

//    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

//    @ApiModelProperty(value = "指标类型 1-今天 2-本周 3-本月 4-自定义")
    private String type;

//    @ApiModelProperty(value = "开始警告时间")
    private String startWarnTime;

//    @ApiModelProperty(value = "结束警告时间")
    private String endWarnTime;

//    @ApiModelProperty(value = "指定小时")
    private String hourTime;

//    @ApiModelProperty(value = "告警记录id")
    private String warnId;

//    @ApiModelProperty(value = "告警记录id列表")
    private List<String> warnIdList;

//    @ApiModelProperty(value = "状态( 0未处理(待应答)   1已处理   2待处理   3无需处理)")
    private List<String> statusList;
}
