package com.jsmsframework.domain;

import java.sql.Types;

/**
 * @author huangwenjie
 * @since 2018-01-16
 * <p>
 * 名词定义:
 * column 可以被称为'列'或'字段'
 */
public class DbColumn {

    /**
     * 表结构的字段类型, 参考sql包的Types
     *
     * @see Types
     */
    private Integer columnType;

    /**
     * 表结构的列名(字段名), 数据库下划线命名方式
     */
    private String columnName;


    /**
     * 列的最大标准宽度, 以字符为单位
     */
    private int columnDisplaySize;

    /**
     * 列的注释
     */
    private String comment; // 注释

    /**
     * 列中的值是否可以为 null
     * true表示可为空
     * 否则不为空
     */
    private boolean nullable; //


}
