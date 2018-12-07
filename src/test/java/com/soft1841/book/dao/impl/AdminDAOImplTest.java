package com.soft1841.book.dao.impl;

import cn.hutool.db.Entity;
import com.soft1841.book.dao.AdminDAO;
import com.soft1841.book.entity.Admin;
import com.soft1841.book.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AdminDAOImplTest {
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    @Test
    public void selectAdmins() throws SQLException {
        List<Admin> adminList = adminDAO.selectAdmins();
        adminList.forEach(admin -> System.out.println(admin));

    }

    @Test
    public void getAdminById() throws SQLException {
        Admin admin = adminDAO.getAdminById(1L);
        System.out.println(admin);
    }
}