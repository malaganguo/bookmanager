package com.soft1841.book.utils;

import com.soft1841.book.service.*;
import com.soft1841.book.service.impl.*;

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

    public static AnalysisService getAnalysisServiceInstance() {
        return new AnalysisServiceImpl();
    }
}
