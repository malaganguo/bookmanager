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
            adminList.add(convert(entity));
        }
        return adminList;
    }

    @Override
    public Admin getAdminById(Long id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_admin WHERE id = ? ", id);
        return convert(entity);
    }

    /**
     * 封装一个将Entity转换为Admin的方法
     * @param entity
     * @return
     */
    private Admin convert(Entity entity) {
        Admin admin = new Admin();
        admin.setId(entity.getLong("id"));
        admin.setAccount(entity.getStr("account"));
        admin.setPassword(entity.getStr("password"));
        admin.setName(entity.getStr("name"));
        admin.setAvatar(entity.getStr("avatar"));
        return admin;
    }
}
