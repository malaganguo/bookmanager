package com.soft1841.book.service.impl;

import com.soft1841.book.dao.AdminDAO;
import com.soft1841.book.entity.Admin;
import com.soft1841.book.service.AdminService;
import com.soft1841.book.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> adminList = new ArrayList<>();
        try {
            adminList = adminDAO.selectAdmins();
        } catch (SQLException e) {
            System.err.println("查询所有管理员出现异常!");
        }
        return adminList;
    }


    @Override
    public boolean login(String account, String password) {
        boolean flag = false;
        Admin admin = null;
        try {
            admin = adminDAO.getAdminByAccount(account);
        } catch (SQLException e) {
            System.err.println("根据账号查找管理员出现异常");
        }
        if (admin != null) {
            if (password.equals(admin.getPassword())) {
                flag = true;
            }
        }
        return flag;
    }
}
