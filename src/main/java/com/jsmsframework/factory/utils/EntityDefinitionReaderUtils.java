package com.jsmsframework.factory.utils;


import com.jsmsframework.factory.config.EntityDefinitionHolder;
import com.jsmsframework.factory.context.CodegenContext;

public class EntityDefinitionReaderUtils {
    public static void registerEntityDefinition(EntityDefinitionHolder holder, CodegenContext codegenContext) {
        codegenContext.registerEntityDefinition(holder);
    }
}
