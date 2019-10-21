package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * Author: wangJianBo
 * Date: 2019/10/21 9:32
 * Content:
 */

@ApiModel("烧结工艺记录")
@Data
public class AgglomerationProcessRecordVo {
    public AgglomerationProcessRecordVo() {
        //默认无参构造方法
    }
    private Integer id;

    private Date createTime;

    // max length: 100
    private String number;

    private Integer blockNumber;

    private String furnaceWeight;

    private String singleRoomWeight;

    private String mononuclearWeight;

    private String startPower;

    private String endPower;

    private String sharePower;

    // max length: 100
    private String fristOperatorDay;

    private String fristOperatorNight;

    // max length: 100
    private String secondOperatorDay;

    private String secondOperatorNight;
}
