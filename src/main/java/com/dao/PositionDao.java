package com.dao;

import com.pojo.Position;
import com.util.DbUtils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PositionDao {

    public List<Position> list() throws Exception {
        List<Position> list = new ArrayList<>();
        ResultSet rs = DbUtils.executeQuery("select * from position");
        while (rs.next()) {
            Position position = new Position();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            position.setId(id);
            position.setName(name);
            list.add(position);
        }
        return list;
    }

    public void add(Position position) {
        String sql = "insert into position (name) VALUES(?);";
        int rs = DbUtils.executeUpdate(sql, position.getName());
        if (rs > 0) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
    }

    public void update(Position position) {
        String sql = "update set name=? from position where id=?";
        int rs = DbUtils.executeUpdate(sql, position.getName(), position.getId());
        if (rs > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

    }

    public void delete(int id) {
        int rs = DbUtils.executeUpdate("delete from position where id=?", id);
        if (rs > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    public Position queryById(int qid) throws Exception{
        ResultSet rs = DbUtils.executeQuery("select * from position where id=?", qid);
        Position position = new Position();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            position.setId(id);
            position.setName(name);
        }
        return position;
    }

    public List<Position> queryByName(String qname) throws Exception {
        List<Position> list = new ArrayList<>();
        ResultSet rs = DbUtils.executeQuery("select * from position where name like concat('%',?,'%')", qname);
        while (rs.next()) {
            Position position = new Position();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            position.setId(id);
            position.setName(name);
            list.add(position);
        }
        return list;

    }

}
