package com.aaa.biz;

import com.aaa.entity.Role;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:36
 * @Version 1.0
 */
public interface  RoleBiz {
   List<Role> selectAllRole();

   //增加角色
   int insert(Role record);

    int deleteByPrimaryKey(Integer roleId);

    //通过roleid删除角色
    int delRoleByID(List<String> ids);

    //修改角色
    int updateByPrimaryKeySelective(Role record);

    public List<Role> showRoleInfo(String roleName,String roleKey,String status );
}
