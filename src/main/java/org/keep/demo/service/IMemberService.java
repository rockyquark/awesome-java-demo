package org.keep.demo.service;

import org.keep.demo.entity.primary.Member;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note: 会员服务入口
 * @date 2023/11/22 21:17
 */
public interface IMemberService {

    boolean addMember(Member member);
}
