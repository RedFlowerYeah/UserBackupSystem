package com.aaa.biz;

import com.aaa.entity.Dept;
import com.aaa.entity.Role;

import java.util.List;

public interface DeptBiz {
   List<Dept> selectAllDept();
   int insert(Dept record);
   int deleteByPrimaryKey(Integer deptId);
   int delDeptByID(List<String> ids);
   int updateByPrimaryKeySelective(Dept record);
   List<Dept> showDeptInfo(String status,String deptName);
}
