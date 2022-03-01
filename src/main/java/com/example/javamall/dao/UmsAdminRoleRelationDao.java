package com.example.javamall.dao;


import com.example.javamall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 * Created by macro on 2018/10/8.
 */
@Repository
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    @Select("SELECT * FROM ums_permission WHERE id in (SELECT permission_id FROM ums_admin_permission_relation WHERE admin_id=#{adminId})")
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}