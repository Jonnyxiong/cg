package com.jsmsframework.factory.config;

public class EntityField {


    /**
     * 全限定名 如: com.jsmsframework.code.factory.config.CodeFile
     */
    private String classCanonicalName;

    /**
     * 文件名, 也是类的名字, 如: CodeFile
     */
    private String classSimpleName;

    /**
     * 字段名, 对应数据库的字段
     */
    private String fieldName;

    /**
     * 字段的注释, 读取数据库表结构字段的注释
     */
    private String comment;

    /**
     * 数据库字段长度, 如varchar(50)的50
     */
    private int columnSize;

    /**
     * 是否可为空
     * true代表可为空, 否则不能为空
     */
    private boolean nullable;


    public String getClassCanonicalName() {
        return classCanonicalName;
    }

    public void setClassCanonicalName(String classCanonicalName) {
        this.classCanonicalName = classCanonicalName;
    }

    public String getClassSimpleName() {
        return classSimpleName;
    }

    public void setClassSimpleName(String classSimpleName) {
        this.classSimpleName = classSimpleName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }
}
