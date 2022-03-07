package com.example.javamall.service.impl;

import com.example.javamall.nosql.mongodb.document.MemberReadHistory;
import com.example.javamall.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.example.javamall.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for(String id: ids) {
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteList.add(memberReadHistory);
        }
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> list(long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
