package utils;

import base.BaseEntity;
import org.junit.Assert;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class EntityHelper {
    public static <T extends BaseEntity> void assertEntity(T expectedEntity, T actualEntity, String commonMessage){
        List<String> fieldNames = expectedEntity.getFieldNames();
        StringBuilder fullMessage = new StringBuilder(commonMessage);
        String template = "\n\t Incorrect value for field '%s' expected '%s' but actual '%s'";
        AtomicBoolean isNotEquals = new AtomicBoolean(false);
        fieldNames.forEach(fieldName -> {
            Object expectedValue = expectedEntity.getFieldValue(fieldName);
            Object actualValue = actualEntity.getFieldValue(fieldName);
            if(!expectedValue.equals(actualValue)){
                isNotEquals.set(true);
                fullMessage.append(String.format(template, fieldName, expectedValue, actualValue));
            }
        });
        if(isNotEquals.get()){
            Assert.fail(fullMessage.toString());
        }
    }

    public static <T extends BaseEntity> void assertEntities(List<T> expected, List<T> actual, String commonMessage){
        String errorMessage = String.format("%s Item count in expected list and actual is different", commonMessage);
        Assert.assertEquals(errorMessage, expected.size(), actual.size());
        for (int index = 0; index < expected.size(); index++){
            T actualItem = actual.get(index);
            T expectedItem = expected.get(index);
            EntityHelper.assertEntity(expectedItem, actualItem, commonMessage);
        }
    }
}
