package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@ApiModel("烧结工艺记录")
@Data
public class AgglomerationProcessRecordVo {
    public AgglomerationProcessRecordVo() {
        //默认无参构造方法
    }
    @ApiModelProperty(value = "烧结工艺的id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "创建的时间，无需从前端传入")
    private String createTime;

    // max length: 100
    @ApiModelProperty(value = "编号", example = "235")
    private String number;

    @ApiModelProperty(value = "装炉块数",example = "3")
    private Integer blockNumber;

    @ApiModelProperty(value = "装炉重量", example = "53.6")
    private String furnaceWeight;

    @ApiModelProperty(value = "单件重量", example = "63.2")
    private String singleRoomWeight;

    @ApiModelProperty(value = "单盒容量", example = "36.2")
    private String mononuclearWeight;

    @ApiModelProperty(value = "开始电量", example = "36.9")
    private String startPower;

    @ApiModelProperty(value = "结束电量", example = "34.2")
    private String endPower;

    @ApiModelProperty(value = "和用电量", example = "25.3")
    private String sharePower;

    // max length: 100
    @ApiModelProperty(value = "第一个白班姓名", example = "张三")
    private String fristOperatorDay;

    @ApiModelProperty(value = "第一个夜班姓名", example = "李四")
    private String fristOperatorNight;

    // max length: 100
    @ApiModelProperty(value = "第二个白班的姓名", example = "王五")
    private String secondOperatorDay;

    @ApiModelProperty(value = "第二个夜班的姓名", example = "韩六")
    private String secondOperatorNight;

    @ApiModelProperty(value = "记录",example = "正常")
    private String remark;
}
