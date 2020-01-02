package com.imustacm.service;

import com.imustacm.domain.Po.PressedProcessRecord;
import com.imustacm.domain.Vo.PressedProcessRecordVo;

import java.util.List;

/**
 * Date: 2020/1/2 10:18
 * Content:
 */
public interface PressedProcessRecordService {

    List<PressedProcessRecordVo> getAllPressedProcessRecord();

    int insertPressedProcessRecord(PressedProcessRecordVo pressedProcessRecordVo);

    int deletePressedProcessRecordById(int index);

    int updatePressedProcessRecord(PressedProcessRecordVo pressedProcessRecordVo);

    PressedProcessRecordVo getOnePressedProcessRecordBySerial(String serial);
}
