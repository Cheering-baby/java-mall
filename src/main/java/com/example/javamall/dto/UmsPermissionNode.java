package com.example.javamall.dto;

import com.example.javamall.mbg.model.UmsPermission;

import java.util.List;

public class UmsPermissionNode extends UmsPermission {
    private List<UmsPermissionNode> child;

    public List<UmsPermissionNode> getChild() {
        return child;
    }

    public void setChild(List<UmsPermissionNode> child) {
        this.child = child;
    }
}
