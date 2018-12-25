package com.soft1841.book.utils;

import com.soft1841.book.service.AdminService;
import com.soft1841.book.service.BookService;
import com.soft1841.book.service.ReaderService;
import com.soft1841.book.service.TypeService;
import com.soft1841.book.service.impl.AdminServiceImpl;
import com.soft1841.book.service.impl.BookServiceImpl;
import com.soft1841.book.service.impl.ReaderServiceImpl;
import com.soft1841.book.service.impl.TypeServiceImpl;

/**
 * 业务逻辑类工厂
 */
public class ServiceFactory {
    public static TypeService getTypeServiceInstance() {
        return new TypeServiceImpl();
    }

    public static BookService getBookServiceInstance() {
        return new BookServiceImpl();
    }

    public static ReaderService getReaderServiceInstance() {
        return new ReaderServiceImpl();
    }

    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }
}
