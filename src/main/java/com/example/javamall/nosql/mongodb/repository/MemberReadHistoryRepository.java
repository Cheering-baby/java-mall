package com.example.javamall.nosql.mongodb.repository;

import com.example.javamall.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 会员商品浏览历史Repository
 * Created by daizhihong on 2022/03/03
 */

public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {
    /**
     * 根据会员id按照时间倒序获取浏览记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
