package com.soft1841.book.dao;

import com.soft1841.book.entity.Admin;
import com.soft1841.book.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class AdminDAOTest {
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    @Test
    public void selectAdmins() throws SQLException {
        List<Admin> adminList = adminDAO.selectAdmins();
        adminList.forEach(admin -> System.out.println(admin));
    }

    @Test
    public void getAdminByAccount() throws SQLException {
        Admin admin = adminDAO.getAdminByAccount("aaa@qq.com");
        System.out.println(admin);
    }
}