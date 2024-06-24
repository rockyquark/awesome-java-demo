package org.keep.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.keep.demo.entity.primary.Member;
import org.keep.demo.service.IMemberService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

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
    private IMemberService memberService;

    @Test
    void addMember() {

        Member member = new Member();
        member.setAge((byte) 1);
        member.setName("helloworld");
        member.setEducation("大专");
        member.setHobbies("看书、跑步、买币");
        member.setSkill("投资");
        member.setMarriage(true);
        member.setPhoneNumber(1778871777);
        boolean added = memberService.addMember(member);
        System.out.println(added);
    }
}