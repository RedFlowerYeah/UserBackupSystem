package com.aaa.biz.impl;

import com.aaa.biz.DeptBiz;
import com.aaa.dao.DeptMapper;
import com.aaa.entity.Dept;
import com.aaa.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptBizImpl implements DeptBiz {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }
    @Override
    public int insert(Dept record){
        return deptMapper.insert(record);
    }
    @Override
    public int deleteByPrimaryKey(Integer deptId){
        return deptMapper.deleteByPrimaryKey(deptId);
    }
    @Override
    public int delDeptByID(@Param("ids") List<String> ids){
        return deptMapper.delDeptByID(ids);
    }
    @Override
    public int updateByPrimaryKeySelective(Dept record){
        return deptMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public List<Dept> showDeptInfo(String status,String deptName){
        return deptMapper.selectDeptInfo(status,deptName);
    }

}
