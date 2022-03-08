package com.example.javamall.service;

import com.example.javamall.dto.UmsPermissionNode;
import com.example.javamall.mbg.model.UmsPermission;

import java.util.List;

public interface UmsPermissionService {

    List<UmsPermissionNode> permissionTreeList();

}
