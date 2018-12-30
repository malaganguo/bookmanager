package com.soft1841.book.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.book.dao.AdminDAO;
import com.soft1841.book.entity.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public List<Admin> selectAdmins() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_admin ");
        List<Admin> adminList = new ArrayList<>();
        for (Entity entity : entityList) {
            adminList.add(convertAdmin(entity));
        }
        return adminList;
    }

    @Override
    public Admin getAdminByAccount(String account) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_admin WHERE account = ? ", account);
        return convertAdmin(entity);
    }

    @Override
    public int countAdmins() throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_admin ").intValue();
    }

    /**
     * 封装一个将Entity转换为Admin的方法
     *
     * @param entity
     * @return
     */
    private Admin convertAdmin(Entity entity) {
        Admin admin = new Admin();
        admin.setId(entity.getLong("id"));
        admin.setAccount(entity.getStr("account"));
        admin.setPassword(entity.getStr("password"));
        admin.setName(entity.getStr("name"));
        admin.setAvatar(entity.getStr("avatar"));
        return admin;
    }
}
