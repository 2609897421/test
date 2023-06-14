package com.dao;

import com.pojo.Department;
import com.pojo.Position;
import com.util.DbUtils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    public List<Department> list() throws Exception {
        List<Department> list = new ArrayList<>();
        ResultSet rs = DbUtils.executeQuery("select * from department");
        while (rs.next()) {
            Department department = new Department();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            department.setId(id);
            department.setName(name);
            list.add(department);
        }
        return list;
    }

    public void add(Department department) {
        String sql = "insert into department(name) value(?)";
        int rs = DbUtils.executeUpdate(sql, department.getName());
        if (rs > 0) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }

    }

    public void update(Department department) {
        String sql = "update set name=? from department where id=?";
        int rs = DbUtils.executeUpdate(sql, department.getName(), department.getId());
        if (rs > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    public void delete(int id) {
        int rs = DbUtils.executeUpdate("delete from department where id=?", id);
        if (rs > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    public Department queryById(int qid) throws Exception{
        ResultSet rs = DbUtils.executeQuery("select * from department where id=?", qid);
        Department department = new Department();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            department.setId(id);
            department.setName(name);
        }
        return department;
    }

    public List<Department> queryByName(String qname) throws Exception {
        List<Department> list = new ArrayList<>();
        ResultSet rs = DbUtils.executeQuery("select * from department where name like concat('%',?,'%')", qname);
        while (rs.next()) {
            Department department = new Department();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            department.setId(id);
            department.setName(name);
            list.add(department);
        }
        return list;

    }


}
