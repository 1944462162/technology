package com.imustacm;

import com.imustacm.domain.Po.*;
import com.imustacm.domain.Vo.SmeltVo;
import com.imustacm.domain.Vo.SmeltingRecordVo;
import com.imustacm.domain.Vo.SparePartsVo;
import com.imustacm.domain.Vo.StockVo;
import com.imustacm.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testService {

    @Test
    public void Stock_Test() throws Exception {
        ApplicationContext ap=new ClassPathXmlApplicationContext("spring-service.xml");
        StockService service = (StockService) ap.getBean("stockService");
        List<StockVo> allStoch = service.getAllStoch();
        System.out.println(allStoch);
    }

    @Test
    public void SpareParts_Test() throws Exception {
        ApplicationContext ap=new ClassPathXmlApplicationContext("spring-service.xml");
        SparePartsService service = (SparePartsService) ap.getBean("sparePartsService");
        System.out.println(service);
        List<SparePartsVo> allSpareParts = service.getAllSpareParts();
        System.out.println(allSpareParts);

    }

    @Test
    public void Smelt_Test() throws Exception {
        ApplicationContext ap=new ClassPathXmlApplicationContext("spring-service.xml");
        SmeltService service= (SmeltService) ap.getBean("smeltService");
        System.out.println(service);
        List<SmeltVo> allSmelt = service.getAllSmelt();
        System.out.println(allSmelt);
    }

    @Test
    public void SmeltRecord_test() throws Exception {
        ApplicationContext ap =new ClassPathXmlApplicationContext("spring-service.xml");
        SmeltingRecordService service= (SmeltingRecordService) ap.getBean("smeltingRecordService");
        System.out.println(service);
        List<SmeltingRecordVo> allSmeltingRecord = service.getAllSmeltingRecord();
        System.out.println(allSmeltingRecord);

    }

    @Test
    public void PressureRecord_test() throws Exception {
        ApplicationContext ap =new ClassPathXmlApplicationContext("spring-service.xml");
        PressureRecordService service=(PressureRecordService)ap.getBean("pressureRecordService");
        System.out.println(service);
        List<PressureRecord> allPressureRecord = service.getAllPressureRecord();
        System.out.println(allPressureRecord);

    }

    @Test
    public void FlourMillingProcessRecord_test() throws Exception {
        ApplicationContext ap =new ClassPathXmlApplicationContext("spring-service.xml");
        FlourMillingProcessRecordService service= (FlourMillingProcessRecordService) ap.getBean("flourMillingProcessRecordService");
        System.out.println(service);
        List<FlourMillingProcessRecord> allFlourMillingProcessRecord = service.getAllFlourMillingProcessRecord();
        System.out.println(allFlourMillingProcessRecord);
    }

    @Test
    public void BlankSize_test() throws Exception {
        ApplicationContext ap =new ClassPathXmlApplicationContext("spring-service.xml");
        BlankSizeService service= (BlankSizeService) ap.getBean("blankSizeService");
        System.out.println(service);
        service.getAllBlankSize();

    }

    @Test
    public void AgglomerationProcess_test() throws Exception {
        ApplicationContext ap =new ClassPathXmlApplicationContext("spring-service.xml");
        AgglomerationProcessService service= (AgglomerationProcessService) ap.getBean("agglomerationProcessService");
        System.out.println(service);
        System.out.println(service.getAllAgglomerationProcess());
    }

    @Test
    public void AgglomerationProcessRecord_test() throws Exception {
        ApplicationContext ap =new ClassPathXmlApplicationContext("spring-service.xml");
        AgglomerationProcessRecordService service= (AgglomerationProcessRecordService) ap.getBean("agglomerationProcessRecordService");
        System.out.println(service);
        System.out.println(service.getAllAgglomerationProcessRecord());
    }
}
