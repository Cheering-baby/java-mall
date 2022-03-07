package com.example.javamall.service;

import com.example.javamall.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 删除浏览记录
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> list(long memberId);
}
