package net.rainmore.platform.web.config.jpa;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class JpaCustomNamingStrategy extends ImprovedNamingStrategy {
    public String tableName(String tableName) {
        return tableName;
    }

    public String columnName(String columnName) {
        return columnName;
    }

    public String propertyToColumnName(String propertyName) {
        return propertyName;
    }
}
