package org.keep.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.keep.demo.entity.primary.DatasourceConfig;
import org.keep.demo.entity.secondary.TrainRecord;
import org.keep.demo.entity.third.Member;
import org.keep.demo.service.IDatasourceConfigService;
import org.keep.demo.service.IMemberService;
import org.keep.demo.service.ITrainRecordService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Random;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note: TODO
 * @date 2023/11/22 21:22
 */
@Slf4j
@SpringBootTest
class IMemberServiceImplTest {

    @Resource
    private IDatasourceConfigService datasourceConfigService;

    @Resource
    private ITrainRecordService trainRecordService;

    @Resource
    private IMemberService memberService;


    @Test
    void add() {

        Member member = new Member();
        member.setAge((byte) 1);
        member.setName("helloworld");
        member.setEducation("大专");
        member.setHobbies("看书、跑步、买币");
        member.setSkill("投资");
        member.setMarriage(true);
        member.setPhoneNumber(1778871777L);

        Random random = new Random();
        TrainRecord trainRecord = new TrainRecord();
        trainRecord.setId(random.nextInt());
        trainRecord.setCreatedDate(new Date());
        trainRecord.setType((byte) 0);
        trainRecord.setStatus((byte) 0);
        trainRecord.setUpdatedTime(new Date());
        trainRecord.setCreateUser("marchawake");

        DatasourceConfig config = new DatasourceConfig();
        config.setId(random.nextLong());
        config.setStatus((byte) 0);
        config.setDatasourceName("test");
        config.setCreatedAt(new Date());
        config.setUpdatedAt(new Date());
        config.setDriverClass("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        config.setDbType("mysql");
        config.setUsername("marchawake");
        config.setIdleTimeout(random.nextInt());
        config.setPasswordEncrypted("Hello@2020".getBytes(StandardCharsets.UTF_8));
        config.setPoolSize(random.nextInt());
        config.setMinIdle(random.nextInt());

        boolean add1 = datasourceConfigService.add(config);
        boolean add2 = trainRecordService.add(trainRecord);
        boolean add3 = memberService.add(member);
        System.out.printf("%s,%s,%s%n", add1, add2, add3);
    }

    @Test
    void loopAdd() {
        for (;;) {
            try {
                add();
            } catch (Exception e) {}
        }
    }

    @Test
    void concurrent() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            new Thread(this::loopAdd).start();
        }
        Thread.currentThread().join();
    }
}