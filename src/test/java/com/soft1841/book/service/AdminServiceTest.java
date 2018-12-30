package com.soft1841.book.service;

import com.soft1841.book.entity.Admin;
import com.soft1841.book.utils.ServiceFactory;
import org.junit.Test;

import java.sql.SQLException;


public class AdminServiceTest {
    private AdminService adminService = ServiceFactory.getAdminServiceInstance();

    @Test
    public void getAdminByAccount() throws SQLException {
        Admin admin = adminService.getAdminByAccount("aaa@qq.com");
        System.out.println(admin);
    }

    @Test
    public void updateAdmin() throws SQLException {
        Admin admin = adminService.getAdminByAccount("aaa@qq.com");
        admin.setPassword("88888888");
        adminService.updateAdmin(admin);
    }
}