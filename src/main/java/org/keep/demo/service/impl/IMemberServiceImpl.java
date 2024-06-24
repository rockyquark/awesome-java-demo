package org.keep.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.keep.demo.entity.primary.Member;
import org.keep.demo.mapper.primary.MemberMapper;
import org.keep.demo.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 成员服务实现类
 * @date 2023/11/22 21:18
 */

@Slf4j
@Service
public class IMemberServiceImpl implements IMemberService {

    private final MemberMapper mapper;

    @Autowired
    public IMemberServiceImpl(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean addMember(Member member) {

        if (member == null) {
            throw new IllegalArgumentException("添加成员操作，参数 `member` 不能为空!");
        }

        try {
            return mapper.insert(member) == 1;
        } catch (Exception e) {
            log.error("【添加成员记录失败】【异常详情：{}，{}】", e.getClass().getName(), e.getMessage());
        }

        return false;
    }
}
