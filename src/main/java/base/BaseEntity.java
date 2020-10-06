package base;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BaseEntity {
    public List<String> getFieldNames() {
        Field[] fields = this.getClass().getDeclaredFields();
        return Stream.of(fields).map(field -> field.getName()).collect(Collectors.toList());
    }

    public Object getFieldValue(final String fieldName) {
        try {
            String nameOfField = getFieldNameInCorrectRegister(fieldName);
            Field field = this.getClass().getDeclaredField(nameOfField);
            field.setAccessible(true);
            return field.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFieldValue(final String fieldName, final Object fieldValue) {
        try {
            String nameOfField = getFieldNameInCorrectRegister(fieldName);
            Field field = this.getClass().getDeclaredField(nameOfField);
            field.setAccessible(true);
            field.set(this, fieldValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getFieldNameInCorrectRegister(final String fieldNameWithIncorrectRegister) {
        List<String> resultList = getFieldNames().stream()
                .filter(fieldName -> fieldName.equalsIgnoreCase(fieldNameWithIncorrectRegister))
                .collect(Collectors.toList());
        return resultList.size() > 0 ? resultList.get(0) : fieldNameWithIncorrectRegister;
    }
}
