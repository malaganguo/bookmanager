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
     * 根据账号查询管理员
     *
     * @param account
     * @return Entity
     * @throws SQLException
     */
    Admin getAdminByAccount(String account) throws SQLException;

    /**
     * 统计管理员总数
     *
     * @return
     * @throws SQLException
     */
    int countAdmins() throws SQLException;
}
