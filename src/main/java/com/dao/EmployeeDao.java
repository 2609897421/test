package com.dao;

import com.pojo.Employee;
import com.util.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    // 员工列表
    public List<Employee> list() throws Exception {
        ResultSet rs = DbUtils.executeQuery("select * from employee");
        List<Employee> list = new ArrayList<>();
        DepartmentDao departmentDao = new DepartmentDao();
        PositionDao positionDao = new PositionDao();


        extracted(rs, list, departmentDao, positionDao);
        return list;
    }

    //添加员工
    public void add(Employee employee) {
        int rs = DbUtils.executeUpdate("insert into employee (name, id_number, phone, gender, position_id, department_id) VALUES ( ?, ?, ?, ?, ?, ?)", employee.getName(), employee.getIdNumber(), employee.getPhone(), employee.getGender(), employee.getPositionId(), employee.getDepartmentId());
        if (rs > 0) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
    }

    //修改员工
    public void update(Employee employee) {
        String sql = "UPDATE employee SET name = ?, id_number = ?, phone = ?, gender = ?, position_id = ? department_id = ? WHERE id = ?;";
        int rs = DbUtils.executeUpdate(sql, employee.getName(), employee.getIdNumber(), employee.getPhone(), employee.getGender(), employee.getPositionId(), employee.getDepartmentId(), employee.getId());
        if (rs > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }


    }

    //根据员工名称模糊查询
    public List<Employee> queryByName(String qname) throws Exception {
        ResultSet rs = DbUtils.executeQuery("select * from employee where name like concat('%',?,'%')", qname);
        List<Employee> list = new ArrayList<>();
        DepartmentDao departmentDao = new DepartmentDao();
        PositionDao positionDao = new PositionDao();
        // 遍历ResultSet
        extracted(rs, list, departmentDao, positionDao);
        return list;
    }

    //根据员工名称模糊查询
    public List<Employee> queryByPhone(String qname) throws Exception {
        ResultSet rs = DbUtils.executeQuery("select * from employee where phone like concat('%',?,'%')", qname);
        List<Employee> list = new ArrayList<>();
        DepartmentDao departmentDao = new DepartmentDao();
        PositionDao positionDao = new PositionDao();
        // 遍历ResultSet
        extracted(rs, list, departmentDao, positionDao);
        return list;
    }

    //根据员工名称模糊查询
    public List<Employee> queryByGender(int qname) throws Exception {
        ResultSet rs = DbUtils.executeQuery("select * from employee where gender=?", qname);
        List<Employee> list = new ArrayList<>();
        DepartmentDao departmentDao = new DepartmentDao();
        PositionDao positionDao = new PositionDao();
        // 遍历ResultSet
        extracted(rs, list, departmentDao, positionDao);
        return list;
    }

    //根据员工名称模糊查询
    public List<Employee> queryByDepartmentId(int qname) throws Exception {
        ResultSet rs = DbUtils.executeQuery("select * from employee where department_id=?", qname);
        List<Employee> list = new ArrayList<>();
        DepartmentDao departmentDao = new DepartmentDao();
        PositionDao positionDao = new PositionDao();
        // 遍历ResultSet
        extracted(rs, list, departmentDao, positionDao);
        return list;
    }


    //根据员工名称模糊查询
    public List<Employee> queryByPositionId(int qname) throws Exception {
        ResultSet rs = DbUtils.executeQuery("select * from employee where position_id=?", qname);
        List<Employee> list = new ArrayList<>();
        DepartmentDao departmentDao = new DepartmentDao();
        PositionDao positionDao = new PositionDao();
        // 遍历ResultSet
        extracted(rs, list, departmentDao, positionDao);
        return list;
    }

    private void extracted(ResultSet rs, List<Employee> list, DepartmentDao departmentDao, PositionDao positionDao) throws Exception {
        while (rs.next()) {
            Employee employee = new Employee();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String idNumber = rs.getString("id_number");
            String phone = rs.getString("phone");
            int gender = rs.getInt("gender");
            int positionId = rs.getInt("position_id");
            int departmentId = rs.getInt("department_id");
            employee.setId(id);
            employee.setName(name);
            employee.setIdNumber(idNumber);
            employee.setPhone(phone);
            employee.setGender(gender);
            employee.setDepartmentId(departmentId);
            employee.setPositionId(positionId);
            employee.setDepartment(departmentDao.queryById(departmentId));
            employee.setPosition(positionDao.queryById(positionId));
            list.add(employee);
        }
    }

    //删除员工
    public void delete(int id) {
        int rs = DbUtils.executeUpdate("delete from employee where id=?", id);
        if (rs > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }


}
