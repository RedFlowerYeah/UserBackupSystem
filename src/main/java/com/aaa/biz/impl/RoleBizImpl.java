package com.aaa.biz.impl;

import com.aaa.biz.RoleBiz;
import com.aaa.dao.RoleMapper;
import com.aaa.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:36
 * @Version 1.0
 */
@Service
public class RoleBizImpl implements RoleBiz {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }

    //增加角色
    @Override
    public int insert(Role record){
        return roleMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer roleId){
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int delRoleByID(@Param("ids") List<String> ids){
        return roleMapper.delRoleByID(ids);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record){
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Role> showRoleInfo(String roleName,String roleKey,String status ) {
        return roleMapper.selectRoleInfo(roleName,roleKey,status);
    }
}
