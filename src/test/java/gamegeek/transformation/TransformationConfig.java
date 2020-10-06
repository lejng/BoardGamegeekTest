package gamegeek.transformation;

import gamegeek.portal.entities.UserEntity;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableTransformer;
import utils.CucumberTableUtils;
import java.util.Locale;

public class TransformationConfig implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(
                new DataTableType(UserEntity.class, (TableTransformer) table -> CucumberTableUtils.tableByFirstColumnToEntity(table,new UserEntity()))
        );
    }
}
