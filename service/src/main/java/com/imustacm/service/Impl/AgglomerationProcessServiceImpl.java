package com.imustacm.service.Impl;

import com.imustacm.dao.AgglomerationProcessDao;
import com.imustacm.dao.RelationshipAgglomerationProcessDao;
import com.imustacm.domain.Po.AgglomerationProcess;
import com.imustacm.domain.Po.RelationshipAgglomerationProcess;
import com.imustacm.domain.Vo.AgglomerationProcessVo;
import com.imustacm.domain.Vo.RelationshipAgglomerationProcessVo;
import com.imustacm.service.AgglomerationProcessService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        return agglomerationProcessDao.insertEntry(agglomerationProcess);
    }

    @Override
    public int deleteAgglomerationProcessById(int index) throws Exception {
        AgglomerationProcess agglomerationProcess = new AgglomerationProcess();
        agglomerationProcess.setId(index);
        Integer isExist = agglomerationProcessDao.selectEntryListCount(agglomerationProcess);
        if(isExist == 1){
            return agglomerationProcessDao.deleteByKey(agglomerationProcess);
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
        return agglomerationProcessDao.updateByKey(agglomerationProcess1);
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

            Set<Integer> set = new HashSet<>();
            for (int i : processGroupId) {
                set.add(i);
            }

            int k = 0;
            RelationshipAgglomerationProcess[] relationshipAgglomerationProcesses = new RelationshipAgglomerationProcess[processGroupId.length];
            for (Integer integer : set) {
                RelationshipAgglomerationProcess relationshipAgglomerationProcess = new RelationshipAgglomerationProcess();
                relationshipAgglomerationProcess.setRecordId(RecordId);
                relationshipAgglomerationProcess.setAgglomerationId(integer);

                List<RelationshipAgglomerationProcess> list =  relationshipAgglomerationProcessDao.selectEntryList(relationshipAgglomerationProcess);

                boolean flag = true;
                for (RelationshipAgglomerationProcess agglomerationProcess : list) {
                    if (agglomerationProcess.getAgglomerationId().equals(integer) && agglomerationProcess.getRecordId() == RecordId){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    relationshipAgglomerationProcesses[k++] = relationshipAgglomerationProcess;
                }
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
        return relationshipAgglomerationProcessDao.deleteByKey(relationshipAgglomerationProcess);
    }

    @Override
    public int updateRelationOfAgglomerationAndProcess(int RecordId, int... processGroupId) throws Exception {
        if (RecordId == 0){
            return 0;
        }
        else{
            deleteRelationByRecordId(RecordId);
            insertRelationOfAgglomerationAndProcess(RecordId,processGroupId);
            return 1;
        }
    }

    @Override
    public List<RelationshipAgglomerationProcessVo> getAllRelationshipAgglomerationProcess() throws Exception {
        List<RelationshipAgglomerationProcessVo> relationshipAgglomerationProcessVos = new ArrayList<>();
        List<RelationshipAgglomerationProcess> relationshipAgglomerationProcesses = relationshipAgglomerationProcessDao.selectEntryList(null);
        if (relationshipAgglomerationProcesses != null && relationshipAgglomerationProcesses.size() != 0){
            for (RelationshipAgglomerationProcess relationshipAgglomerationProcess : relationshipAgglomerationProcesses) {
                RelationshipAgglomerationProcessVo relationshipAgglomerationProcessVo = new RelationshipAgglomerationProcessVo();
                BeanUtils.copyProperties(relationshipAgglomerationProcess,relationshipAgglomerationProcessVo);
                relationshipAgglomerationProcessVos.add(relationshipAgglomerationProcessVo);
            }
        }
        return relationshipAgglomerationProcessVos;
    }

    public int deleteRelationByRecordId(int RecordId) throws Exception {
        if(RecordId == 0){
            return 0;
        }
        else{
            RelationshipAgglomerationProcess relationshipAgglomerationProcess = new RelationshipAgglomerationProcess();
            relationshipAgglomerationProcess.setRecordId(RecordId);
            return relationshipAgglomerationProcessDao.deleteByKey(relationshipAgglomerationProcess);
        }
    }


    @Override
    public int getNewInsertagglomerationProcess() {
        int k = 0;
        try {
            List<AgglomerationProcess> agglomerationProcesss = agglomerationProcessDao.selectEntryList(null);
            for (AgglomerationProcess agglomerationProcess: agglomerationProcesss) {
                k = agglomerationProcess.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }


}
