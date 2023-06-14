package com.dao;

import com.pojo.User;
import com.util.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public List<User> list() throws SQLException {
        ResultSet rs = DbUtils.executeQuery("select * from user");
        List<User> list = new ArrayList<>();
        // 遍历ResultSet
        while (rs.next()) {
            User user = new User();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int role = rs.getInt("role");
            int status = rs.getInt("status");
            user.setId(id);
            user.setName(name);
            user.setRole(role);
            user.setStatus(status);
            list.add(user);
        }
        return list;
    }

    public void add(User user) {
        int rs = DbUtils.executeUpdate("insert user(name,role,status) value(?,?,?)", user.getName(), user.getRole(), user.getStatus());
        if (rs > 0) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
    }

    public void update(User user) {
        int rs = DbUtils.executeUpdate("update user set name=?,role=?,status=?  where id=?", user.getName(), user.getRole(), user.getStatus(), user.getId());
        if (rs > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    public void delete(int userId) {
        int rs = DbUtils.executeUpdate("delete from user where id=?", userId);
        if (rs > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    public List<User> queryByName(String qname) throws SQLException {
        ResultSet rs = DbUtils.executeQuery("select * from user where name like concat('%',?,'%')", qname);
        List<User> list = new ArrayList<>();
        // 遍历ResultSet
        while (rs.next()) {
            User user = new User();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int role = rs.getInt("role");
            int status = rs.getInt("status");
            user.setId(id);
            user.setName(name);
            user.setRole(role);
            user.setStatus(status);
            list.add(user);
        }
        return list;
    }

    // 根据用户状态查询用户
    public List<User> queryByStatus(int qstatus) throws SQLException {
        ResultSet rs = DbUtils.executeQuery("select * from user where status=?", qstatus);
        List<User> list = new ArrayList<>();
        // 遍历ResultSet
        while (rs.next()) {
            User user = new User();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int role = rs.getInt("role");
            int status = rs.getInt("status");
            user.setId(id);
            user.setName(name);
            user.setRole(role);
            user.setStatus(status);
            list.add(user);
        }
        return list;
    }


}
