package com.imustacm.service.Impl;

import com.imustacm.dao.AgglomerationProcessDao;
import com.imustacm.dao.RelationshipAgglomerationProcessDao;
import com.imustacm.domain.Po.AgglomerationProcess;
import com.imustacm.domain.Po.RelationshipAgglomerationProcess;
import com.imustacm.domain.Vo.AgglomerationProcessVo;
import com.imustacm.service.AgglomerationProcessService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("agglomerationProcessService")
public class AgglomerationProcessServiceImpl implements AgglomerationProcessService {

    @Autowired
    private AgglomerationProcessDao agglomerationProcessDao;

    @Autowired
    private RelationshipAgglomerationProcessDao relationshipAgglomerationProcessDao;
    @Override
    public List<AgglomerationProcessVo> getAllAgglomerationProcess() throws Exception {
        List<AgglomerationProcessVo> result= new ArrayList<>();

        List<AgglomerationProcess> agglomerationProcesses = agglomerationProcessDao.selectEntryList(null);
        if(agglomerationProcesses!=null && agglomerationProcesses.size()!=0  )
        {
            for (AgglomerationProcess agglomerationProcess : agglomerationProcesses) {
                AgglomerationProcessVo agglomerationProcessVo = new AgglomerationProcessVo();
                BeanUtils.copyProperties(agglomerationProcess,agglomerationProcessVo);
                result.add(agglomerationProcessVo);
            }
        }
        return result;
    }

    @Override
    public int insertAgglomerationProcess(AgglomerationProcessVo agglomerationProcessVo) throws Exception {
        AgglomerationProcess agglomerationProcess = new AgglomerationProcess();
        BeanUtils.copyProperties(agglomerationProcessVo,agglomerationProcess);

        int isExist = agglomerationProcessDao.selectEntryListCount(agglomerationProcess);
        if (isExist == 1){
            return 0;
        }
        agglomerationProcessDao.insertEntry(agglomerationProcess);
        return 1;
    }

    @Override
    public int deleteAgglomerationProcessById(int index) throws Exception {
        AgglomerationProcess agglomerationProcess = new AgglomerationProcess();
        agglomerationProcess.setId(index);
        Integer isExist = agglomerationProcessDao.selectEntryListCount(agglomerationProcess);
        if(isExist == 1){
            agglomerationProcessDao.deleteByKey(agglomerationProcess);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateAgglomerationProcess(AgglomerationProcessVo agglomerationProcessVo) throws Exception {
        AgglomerationProcess agglomerationProcess1 = new AgglomerationProcess();
        agglomerationProcess1.setId( agglomerationProcessVo.getId());
        Integer isExist = agglomerationProcessDao.selectEntryListCount(agglomerationProcess1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        BeanUtils.copyProperties(agglomerationProcessVo,agglomerationProcess1);
        agglomerationProcessDao.updateByKey(agglomerationProcess1);
        return 1;
    }

    @Override
    public AgglomerationProcessVo getOneAgglomerationProcess(int index) throws Exception {
        AgglomerationProcess agglomerationProcess = new AgglomerationProcess();
        AgglomerationProcessVo agglomerationProcessVo = new AgglomerationProcessVo();
        agglomerationProcess.setId(index);
        List<AgglomerationProcess> blankSizeList = agglomerationProcessDao.selectEntryList(agglomerationProcess);
        if (blankSizeList.size() != 0){
            agglomerationProcess = blankSizeList.get(0);
            BeanUtils.copyProperties(agglomerationProcess,agglomerationProcessVo);
        }
        return agglomerationProcessVo;
    }


    //    对关系表的增删改
    @Override
    public int insertRelationOfAgglomerationAndProcess(int RecordId, int... processGroupId) throws Exception {
        if(RecordId != 0 && processGroupId.length != 0){
            RelationshipAgglomerationProcess[] relationshipAgglomerationProcesses = new RelationshipAgglomerationProcess[processGroupId.length];
            for (int i = 0; i < processGroupId.length; i++) {
                RelationshipAgglomerationProcess relationshipAgglomerationProcess = new RelationshipAgglomerationProcess();
                relationshipAgglomerationProcess.setRecordId(RecordId);
                relationshipAgglomerationProcess.setAgglomerationId(processGroupId[i]);
                relationshipAgglomerationProcesses[i] = relationshipAgglomerationProcess;
            }
            relationshipAgglomerationProcessDao.insertEntry(relationshipAgglomerationProcesses);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteOneRelation(int RecordId, int ProcessId) throws Exception {
        if (RecordId == 0 && ProcessId == 0){
            return 0;
        }
        RelationshipAgglomerationProcess relationshipAgglomerationProcess = new RelationshipAgglomerationProcess();
        relationshipAgglomerationProcess.setRecordId(RecordId);
        relationshipAgglomerationProcess.setAgglomerationId(ProcessId);
        relationshipAgglomerationProcessDao.deleteByKey(relationshipAgglomerationProcess);
        return 1;
    }

    @Override
    public int updateRelationOfAgglomerationAndProcess(int RecordId, int... processGroupId) throws Exception {
        if (RecordId == 0){
            return 0;
        }
        else{
            deleteAgglomerationProcessById(RecordId);
            insertRelationOfAgglomerationAndProcess(RecordId,processGroupId);
            return 1;
        }
    }

}
