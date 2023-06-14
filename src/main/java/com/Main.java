package com;

import com.dao.DepartmentDao;
import com.dao.EmployeeDao;
import com.dao.PositionDao;
import com.dao.UserDao;
import com.pojo.Department;
import com.pojo.Employee;
import com.pojo.Position;
import com.pojo.User;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("========================员工管理系统========================");
        System.out.println("1、用户管理");
        System.out.println("2、部门管理");
        System.out.println("3、职位管理");
        System.out.println("4、员工管理");
        System.out.println("0、退出系统");
        System.out.print("请选择：");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DepartmentDao departmentDao = new DepartmentDao();
        EmployeeDao employeeDao = new EmployeeDao();
        PositionDao positionDao = new PositionDao();
        UserDao userDao = new UserDao();
        boolean disjunctor = true;
        while (disjunctor) {
            menu();
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    boolean disjunctor1 = true;
                    while (disjunctor1) {
                        System.out.println("=============用户管理=============");
                        System.out.println("1、查看用户列表");
                        System.out.println("2、新增用户信息");
                        System.out.println("3、修改用户信息");
                        System.out.println("4、删除用户信息");
                        System.out.println("5、模糊查询用户信息(用户名称)");
                        System.out.println("6、模糊查询用户信息(用户状态)");
                        System.out.println("0、返回上一级菜单");
                        System.out.printf("请选择:\n");
                        String choice1 = scanner.next();
                        switch (choice1) {
                            case "1":
                                System.out.println("************用户列表*************");
                                List<User> list = userDao.list();
                                list.forEach(System.out::println);
                                break;
                            case "2":
                                System.out.println("************新增用户*************");
                                User user = new User();
                                System.out.println("请输入用户名称");
                                user.setName(scanner.next());
                                System.out.println("请输入用户角色（1=管理员，2=普通用户）");
                                user.setRole(scanner.nextInt());
                                System.out.println("请输入用户状态（0=禁用，1=正常）");
                                user.setStatus(scanner.nextInt());
                                userDao.add(user);
                                break;
                            case "3":
                                System.out.println("************修改用户*************");
                                User updateUser = new User();
                                System.out.println("请输入用户ID");
                                updateUser.setId(scanner.nextInt());
                                System.out.println("请输入用户名称");
                                updateUser.setName(scanner.next());
                                System.out.println("请输入用户角色（1=管理员，2=普通用户）");
                                updateUser.setRole(scanner.nextInt());
                                System.out.println("请输入用户状态（0=禁用，1=正常）");
                                updateUser.setStatus(scanner.nextInt());
                                userDao.update(updateUser);
                                break;
                            case "4":
                                System.out.print("请输入需要删除的用户ID:");
                                int userId = scanner.nextInt();
                                System.out.println("************删除用户*************");
                                userDao.delete(userId);
                                break;
                            case "5":
                                System.out.print("请输入用户名称(模糊查询):");
                                List<User> users5 = userDao.queryByName(scanner.next());
                                System.out.println("************查询结果*************");
                                users5.forEach(System.out::println);
                                break;
                            case "6":
                                System.out.print("请输入用户状态(模糊查询):");
                                List<User> users6 = userDao.queryByStatus(scanner.nextInt());
                                System.out.println("************查询结果*************");
                                users6.forEach(System.out::println);
                                break;
                            case "0":
                                disjunctor1 = false;
                                break;
                            default:
                                System.out.println("输入有误");
                                break;
                        }
                    }
                case "2":
                    boolean disjunctor2 = true;
                    while (disjunctor2) {
                        System.out.println("=============部门管理=============");
                        System.out.println("1、查看部门列表");
                        System.out.println("2、新增部门信息");
                        System.out.println("3、修改部门信息");
                        System.out.println("4、删除部门信息");
                        System.out.println("5、模糊查询部门信息");
                        System.out.println("0、返回上一级菜单");
                        System.out.printf("请选择:\n");
                        String choice2 = scanner.next();
                        switch (choice2) {
                            case "1":
                                System.out.println("************部门列表*************");
                                List<Department> list = departmentDao.list();
                                list.forEach(System.out::println);
                                break;
                            case "2":
                                System.out.println("************新增部门*************");
                                System.out.println("请输入部门名称:");
                                Department department = new Department();
                                department.setName(scanner.next());
                                departmentDao.add(department);
                                break;
                            case "3":
                                System.out.println("************修改部门*************");
                                System.out.println("请输入部门ID:");
                                int updatePositionId = scanner.nextInt();
                                System.out.println("请输入部门名称:");
                                String updateDepartmentName = scanner.next();
                                Department updateDepartment = new Department();
                                updateDepartment.setId(updatePositionId);
                                updateDepartment.setName(updateDepartmentName);
                                departmentDao.update(updateDepartment);
                                break;
                            case "4":
                                System.out.print("请输入需要删除的部门ID:");
                                int departmentId = scanner.nextInt();
                                System.out.println("************删除部门*************");
                                departmentDao.delete(departmentId);
                                break;
                            case "5":
                                System.out.print("请输入部门名称(模糊查询):");
                                String name = scanner.next();
                                List<Department> departments = departmentDao.queryByName(name);
                                System.out.println("************查询结果*************");
                                departments.forEach(System.out::println);
                                break;
                            case "0":
                                disjunctor2 = false;
                                break;
                            default:
                                System.out.println("输入有误");
                                break;
                        }
                    }
                    break;
                case "3":
                    boolean disjunctor3 = true;
                    while (disjunctor3) {
                        System.out.println("=============职位管理=============");
                        System.out.println("1、查看职位列表");
                        System.out.println("2、新增职位信息");
                        System.out.println("3、修改职位信息");
                        System.out.println("4、删除职位信息");
                        System.out.println("5、模糊查询职位信息");
                        System.out.println("0、返回上一级菜单");
                        System.out.printf("请选择:\n");
                        String choice3 = scanner.next();
                        switch (choice3) {
                            case "1":
                                System.out.println("************职位列表*************");
                                List<Position> list = positionDao.list();
                                list.forEach(System.out::println);
                                break;
                            case "2":
                                System.out.println("************新增职位*************");
                                System.out.println("请输入职位名称:");
                                Position position = new Position();
                                position.setName(scanner.next());
                                positionDao.add(position);
                                break;
                            case "3":
                                System.out.println("************修改职位*************");
                                System.out.println("请输入职位ID:");
                                int updatePositionId = scanner.nextInt();
                                System.out.println("请输入职位名称:");
                                String updatePositionName = scanner.next();
                                Position updatePosition = new Position();
                                updatePosition.setId(updatePositionId);
                                updatePosition.setName(updatePositionName);
                                positionDao.update(updatePosition);
                                break;
                            case "4":
                                System.out.print("请输入需要删除的职位ID:");
                                int positionId = scanner.nextInt();
                                System.out.println("************删除职位*************");
                                positionDao.delete(positionId);
                                break;
                            case "5":
                                System.out.print("请输入职位名称(模糊查询):");
                                String name = scanner.next();
                                List<Position> positions = positionDao.queryByName(name);
                                System.out.println("************查询结果*************");
                                positions.forEach(System.out::println);
                                break;
                            case "0":
                                disjunctor3 = false;
                                break;
                            default:
                                System.out.println("输入有误");
                                break;
                        }
                    }
                    break;
                case "4":
                    boolean disjunctor4 = true;
                    while (disjunctor4) {
                        System.out.println("=============员工管理=============");
                        System.out.println("1、查看员工列表");
                        System.out.println("2、新增员工信息");
                        System.out.println("3、修改员工信息");
                        System.out.println("4、删除员工信息");
                        System.out.println("5、模糊查询员工信息(姓名)");
                        System.out.println("6、模糊查询员工信息(手机号)");
                        System.out.println("7、查询员工信息(性别)");
                        System.out.println("8、查询员工信息(职位)");
                        System.out.println("9、查询员工信息(部门)");
                        System.out.println("0、返回上一级菜单");
                        System.out.printf("请选择:\n");
                        String choice4 = scanner.next();
                        switch (choice4) {
                            case "1":
                                System.out.println("************员工列表*************");
                                List<Employee> list = employeeDao.list();
                                list.forEach(System.out::println);
                                break;
                            case "2":
                                System.out.println("************新增员工*************");
                                Employee employee = new Employee();
                                System.out.println("请输入员工名称:");
                                employee.setName(scanner.next());
                                System.out.println("请输入员工身份证号:");
                                employee.setIdNumber(scanner.next());
                                System.out.println("请输入员工手机号:");
                                employee.setPhone(scanner.next());
                                System.out.println("请输入员工性别:(0=男，1=女)");
                                employee.setGender(scanner.nextInt());
                                System.out.println("请输入员工职位ID");
                                positionDao.list().forEach(System.out::println);
                                employee.setPositionId(scanner.nextInt());
                                System.out.println("请输入员工部门ID");
                                departmentDao.list().forEach(System.out::println);
                                employee.setDepartmentId(scanner.nextInt());
                                employeeDao.add(employee);
                                break;
                            case "3":
                                System.out.println("************修改员工*************");
                                Employee updateEmployee = new Employee();
                                System.out.println("请输入员工ID:");
                                updateEmployee.setId(scanner.nextInt());
                                System.out.println("请输入员工名称:");
                                updateEmployee.setName(scanner.next());
                                System.out.println("请输入员工身份证号:");
                                updateEmployee.setIdNumber(scanner.next());
                                System.out.println("请输入员工手机号:");
                                updateEmployee.setPhone(scanner.next());
                                System.out.println("请输入员工性别:(0=男，1=女)");
                                updateEmployee.setGender(scanner.nextInt());
                                System.out.println("请输入员工职位ID");
                                positionDao.list().forEach(System.out::println);
                                updateEmployee.setPositionId(scanner.nextInt());
                                System.out.println("请输入员工部门ID");
                                departmentDao.list().forEach(System.out::println);
                                updateEmployee.setDepartmentId(scanner.nextInt());
                                employeeDao.update(updateEmployee);
                                break;
                            case "4":
                                System.out.print("请输入需要删除的员工ID:");
                                int employeeId = scanner.nextInt();
                                System.out.println("************删除员工*************");
                                employeeDao.delete(employeeId);
                                break;
                            case "5":
                                System.out.print("请输入员工姓名:");
                                String q5 = scanner.next();
                                System.out.println("************模糊查询员工信息(姓名)*************");
                                employeeDao.queryByName(q5).forEach(System.out::println);
                                break;
                            case "6":
                                System.out.print("请输入员工手机号:");
                                String q6 = scanner.next();
                                System.out.println("************模糊查询员工信息(手机号)*************");
                                employeeDao.queryByPhone(q6).forEach(System.out::println);
                                break;
                            case "7":
                                System.out.print("请输入员工性别:(0=男，1=女)");
                                int q7 = scanner.nextInt();
                                System.out.println("************查询员工信息(性别)*************");
                                employeeDao.queryByGender(q7).forEach(System.out::println);
                                break;
                            case "8":
                                positionDao.list().forEach(System.out::println);
                                System.out.print("请输入员工职位ID:");
                                int q8 = scanner.nextInt();
                                System.out.println("************查询员工信息(职位)*************");
                                employeeDao.queryByPositionId(q8).forEach(System.out::println);
                                break;
                            case "9":
                                departmentDao.list().forEach(System.out::println);
                                System.out.print("请输入员工职位ID:");
                                int q9 = scanner.nextInt();
                                System.out.println("************查询员工信息(部门)*************");
                                employeeDao.queryByDepartmentId(q9).forEach(System.out::println);
                                break;
                            case "0":
                                disjunctor4 = false;
                                break;
                            default:
                                System.out.println("输入有误");
                                break;
                        }
                    }
                    break;
                case "0":
                    disjunctor = false;
                    System.out.println("已退出系统");
                    break;
                default:
                    break;
            }
        }
    }
}
