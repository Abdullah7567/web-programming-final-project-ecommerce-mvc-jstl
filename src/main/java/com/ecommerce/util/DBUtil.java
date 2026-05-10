package com.ecommerce.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
    private static final Properties PROPS = new Properties();
    static {
        try (InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            PROPS.load(in);
            Class.forName(PROPS.getProperty("db.driver"));
        } catch (Exception e) { throw new RuntimeException("DB ayarları okunamadı", e); }
    }
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(PROPS.getProperty("db.url"), PROPS.getProperty("db.username"), PROPS.getProperty("db.password"));
    }
}
