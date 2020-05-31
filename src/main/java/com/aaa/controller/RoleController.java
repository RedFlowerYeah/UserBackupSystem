package com.aaa.controller;

import com.aaa.biz.RoleBiz;
import com.aaa.entity.LayUiTable;
import com.aaa.entity.Menu;
import com.aaa.entity.Role;
import com.aaa.entity.User;
import com.aaa.util.MyConstants;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleBiz roleBizImpl;
    @RequestMapping("/toShowRole")
    public String  toShowRole(){
        return "role/showRole";
    }

    @RequestMapping("/showRole")
    @ResponseBody
    public LayUiTable showRoleLayui() {
        //开始查询
        List<Role> roleList = roleBizImpl.selectAllRole();
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(roleList);
        return layUiTable;
    }

    //新增角色
    @RequestMapping("/saveRole")
    @ResponseBody
    public Object saveUser(Role role){
        int i = roleBizImpl.insert(role);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.saveSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.saveFailMsg);
        }
        return map;
    }

    //删除角色
    @RequestMapping("/delRole")
    @ResponseBody
    public Object delUser( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<String> list= (List<String>) JSON.parse(ids);
        int i = roleBizImpl.delRoleByID(list);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.delSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.delFailMsg);
        }
        return map;
    }

    //修改角色
    @RequestMapping("/editRole")
    @ResponseBody
    public Object editUser(Role record){
        int i = roleBizImpl.updateByPrimaryKeySelective(record);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.editSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.editFailMsg);
        }
        return map;
    }

    @RequestMapping("/searchRole")
    @ResponseBody
    public LayUiTable showRoleInfo(
            @RequestParam(value="roleName",defaultValue="" ) String roleName,
            @RequestParam(value="roleKey",defaultValue="" ) String roleKey,
            @RequestParam (value="status",defaultValue="" ) String status) {
        //开始查询
        List<Role> role = roleBizImpl.showRoleInfo(roleName,roleKey,status);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(role);
        return layUiTable;
    }
}
