package com.example.javamall.service.impl;

import com.example.javamall.dao.UmsAdminRoleRelationDao;
import com.example.javamall.dto.UmsPermissionNode;
import com.example.javamall.mbg.model.UmsPermission;
import com.example.javamall.service.UmsPermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UmsPermissionServiceImpl implements UmsPermissionService {

    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;

    @Override
    public List<UmsPermissionNode> permissionTreeList() {
        List<UmsPermission> permissionList = adminRoleRelationDao.getAllPermissionList();
        List<UmsPermissionNode> result = permissionList.stream()
                .filter(permission -> permission.getPid().equals(0L))
                .map(permission -> covert(permission, permissionList))
                .collect(Collectors.toList());
        return result;
    }

    public UmsPermissionNode covert(UmsPermission umsPermission, List<UmsPermission> permissionList) {
        UmsPermissionNode node = new UmsPermissionNode();
        BeanUtils.copyProperties(umsPermission, node);
        List<UmsPermissionNode> children = permissionList.stream()
                .filter(subPermission -> subPermission.getPid().equals(umsPermission.getId()))
                .map(subPermission -> covert(subPermission, permissionList))
                .collect(Collectors.toList());
        node.setChild(children);
        return node;
    }
}
