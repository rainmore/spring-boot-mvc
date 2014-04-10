package net.rainmore.platform.utils;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public final class DbUtils {
    public static Long getLong(ResultSet resultSet, String key) throws SQLException {
        Long value = resultSet.getLong(key);
        if (value != null && value.equals(0L))
            return null;
        return value;
    }

    public static Integer getInteger(ResultSet resultSet, String key) throws SQLException{
        Integer value = resultSet.getInt(key);
        if (value != null && value.equals(0))
            return null;
        return value;
    }

    public static String getString(ResultSet resultSet, String key) throws SQLException{
        String value = resultSet.getString(key);
        if (value != null && value.equals(""))
            return null;
        return value;
    }

    public static LocalDate getLocalDate(ResultSet resultSet, String key) throws SQLException {
        LocalDate localDate = null;
        Date value = resultSet.getDate(key);
        if (value != null) {
            localDate = new LocalDate(value);
        }
        return localDate;
    }

    public static LocalDateTime getLocalDateTime(ResultSet resultSet, String key) throws SQLException {
        LocalDateTime localDate = null;
        Timestamp value = resultSet.getTimestamp(key);
        if (value != null) {
            localDate = new LocalDateTime(value);
        }
        return localDate;
    }

}
