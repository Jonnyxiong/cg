package com.jsmsframework.factory.config;

/**
 * @author huangwenjie
 * @since 2018-01-16
 */
public class ArtifactDefinition {
    /**
     * 模块名
     */
    private String id;


    /**
     * 描述
     */
    private String description;

    /**
     * 模块名前缀
     * <p>
     * 一般是多模块时使用，如springframework项目下的多模块，spring-core，spring-context，其中spring就是前缀
     */
    private String prefix;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
