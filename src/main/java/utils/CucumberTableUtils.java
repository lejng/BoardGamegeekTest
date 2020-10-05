package utils;

import base.BaseEntity;
import io.cucumber.datatable.DataTable;
import java.util.List;

public class CucumberTableUtils {
    /**
     * Convert DataTable to entity.
     * Convert only DataTable where first column is names of entity fields
     * Example:
     * When The following info displayed on Login page
     * | name     | Anna          |
     * | comment | Test Comment   |
     * <p>
     * class Comment extends BaseEntity{
     * private String name;
     * private String comment;
     * }
     *
     * @param table  cucumber table
     * @param entity entity instance
     * @return entity instance with data from table
     */
    public static <T extends BaseEntity> T tableByFirstColumnToEntity(DataTable table, T entity) {
        for (int index = 0; index < table.height(); index++) {
            List<String> row = table.row(index);
            String fieldName = row.get(0);
            String fieldValue = row.get(1);
            entity.setFieldValue(fieldName, fieldValue);
        }
        return entity;
    }

    public static <T extends BaseEntity> T getInstance(Class<T> entityClass) {
        try {
            return entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
