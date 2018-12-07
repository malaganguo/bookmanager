package com.soft1841.book.dao;

import cn.hutool.db.Entity;
import com.soft1841.book.entity.Admin;

import java.sql.SQLException;
import java.util.List;

/**
 * 管理员DAO接口
 */
public interface AdminDAO {
    /**
     * 查询所有管理员
     *
     * @return List<Admin>
     * @throws SQLException
     */
    List<Admin> selectAdmins() throws SQLException;

    /**
     * 根据id查询管理员
     *
     * @param id
     * @return Entity
     * @throws SQLException
     */
    Admin getAdminById(Long id) throws SQLException;
}
