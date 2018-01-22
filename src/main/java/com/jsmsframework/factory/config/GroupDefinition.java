package com.jsmsframework.factory.config;

import java.util.Date;

/**
 * @author huangwenjie
 * @since 2018-01-16
 */
public class GroupDefinition {


    /**
     * 根包的名称, 以"."间隔
     */
    private String id;

    /**
     * 作者
     */
    private String author;

    /**
     * 日期
     */
    private Date date;

    /**
     * 公司
     */
    private String company;

    /**
     * 项目路径
     */
    private String projectDir;

    /**
     * 是否是多模块项目
     */
    private boolean multiModule;

    /**
     * 分页类的class
     */
    private String defualtPageClass;

    public boolean isMultiModule() {
        return multiModule;
    }

    public void setMultiModule(boolean multiModule) {
        this.multiModule = multiModule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProjectDir() {
        return projectDir;
    }

    public void setProjectDir(String projectDir) {
        this.projectDir = projectDir;
    }

    public String getDefualtPageClass() {
        return defualtPageClass;
    }

    public void setDefualtPageClass(String defualtPageClass) {
        this.defualtPageClass = defualtPageClass;
    }
}
