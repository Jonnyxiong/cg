package com.jsmsframework.factory.support;


import com.jsmsframework.factory.context.CodegenContext;

import java.sql.Connection;

public abstract class AbstractTableParser implements  ParserTable {


    protected Connection connection;

    protected CodegenContext codegenContext;

    public AbstractTableParser(Connection connection,CodegenContext codegenContext){
        this.connection = connection;
        this.codegenContext = codegenContext;
    }




}
