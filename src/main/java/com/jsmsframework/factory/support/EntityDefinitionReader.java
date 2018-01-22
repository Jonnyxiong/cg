package com.jsmsframework.factory.support;

import com.jsmsframework.exception.EntityDefinitionStoreException;
import org.springframework.core.io.Resource;

public interface EntityDefinitionReader {


    int loadEntityDefinitions(Resource resource) throws EntityDefinitionStoreException;

    int loadEntityDefinitions(String locationConfig);
}
