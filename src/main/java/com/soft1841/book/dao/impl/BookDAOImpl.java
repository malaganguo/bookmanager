package com.soft1841.book.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.book.dao.BookDAO;
import com.soft1841.book.entity.Book;

import java.sql.SQLException;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public Long insertBook(Book book) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_book")
                        .set("type_id", book.getTypeId())
                        .set("name", book.getName())
                        .set("author", book.getAuthor())
                        .set("price", book.getPrice())
                        .set("cover", book.getCover())
                        .set("summary", book.getSummary())
                        .set("stock",book.getStock())
        );
    }

    @Override
    public int deleteBookById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_book").set("id", id)
        );
    }

    @Override
    public int updateBook(Book book) throws SQLException {
        //只修改了图书的价格和库存
        return Db.use().update(
                Entity.create().set("price", book.getPrice())
                                .set("stock",book.getStock()),
                Entity.create("t_book").set("id", book.getId())
        );
    }

    @Override
    public List<Entity> selectAllBooks() throws SQLException {
        return Db.use().query("SELECT * FROM t_book ");
    }

    @Override
    public Entity getBookById(long id) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_book WHERE id = ? ", id);
    }

    @Override
    public List<Entity> selectBooksLike(String keywords) throws SQLException {
        return Db.use().findLike("t_book", "name", keywords, Condition.LikeType.Contains);
    }

    @Override
    public List<Entity> selectBooksByTypeId(long typeId) throws SQLException {
        return Db.use().query("SELECT * FROM t_book WHERE type_id = ? ", typeId);
    }

    @Override
    public int countByType(long typeId) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_book WHERE type_id = ? ", typeId).intValue();
    }
}
