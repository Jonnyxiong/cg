package com.jsmsframework.factory.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class PluggableSchemaResolver implements EntityResolver {
    private static final Logger logger = LoggerFactory.getLogger(PluggableSchemaResolver.class);

    /**
     * 定义schema映射的文件的位置
     * 为了可可扩展, 所以schema可能来自不同的jar文件
     */
    public static final String DEFAULT_SCHEMA_MAPPINGS_LOCATION = "META-INF/jsms-cg.schemas";


    private final ClassLoader classLoader;

    private final String schemaMappingsLocation;


    /**
     * 保存schema的映射（URL-&gt;本地schema位置）
     */
    private volatile Map<String, String> schemaMappings;


    /**
     * 加载schema的映射（URL-&gt;本地schema位置）, 使用默认映射文件位置"META-INF/jsms-cg.schemas"
     *
     * @param classLoader 指定加载器
     */
    public PluggableSchemaResolver(ClassLoader classLoader) {
        this.classLoader = classLoader;
        this.schemaMappingsLocation = DEFAULT_SCHEMA_MAPPINGS_LOCATION;
    }

    /**
     * 加载schema的映射（URL-&gt;本地schema位置）, 指定映射文件位置
     *
     * @param classLoader 指定加载器
     * @param schemaMappingsLocation 定义schema映射的文件位置（不能为空）
     */
    public PluggableSchemaResolver(ClassLoader classLoader, String schemaMappingsLocation) {
        Assert.hasText(schemaMappingsLocation, "'schemaMappingsLocation' must not be empty");
        this.classLoader = classLoader;
        this.schemaMappingsLocation = schemaMappingsLocation;
    }

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws IOException {
        logger.trace("Trying to resolve XML entity with public id [" + publicId +
                "] and system id [" + systemId + "]");

        if (systemId != null) {
            String resourceLocation = getSchemaMappings().get(systemId);
            if (resourceLocation != null) {
                Resource resource = new ClassPathResource(resourceLocation, this.classLoader);
                try {
                    InputSource source = new InputSource(resource.getInputStream());
                    source.setPublicId(publicId);
                    source.setSystemId(systemId);
                    logger.debug("Found XML schema [" + systemId + "] in classpath: " + resourceLocation);
                    return source;
                } catch (FileNotFoundException ex) {
                    logger.debug("Couldn't find XML schema [" + systemId + "]: " + resource, ex);
                }
            }
        }
        return null;
    }

    /**
     * 懒加载制定的schema映射
     *
     * @return 返回schema的映射map
     */
    private Map<String, String> getSchemaMappings() {
        if (this.schemaMappings == null) {
            synchronized (this) {
                if (this.schemaMappings == null) {

                    logger.debug("Loading schema mappings from [" + this.schemaMappingsLocation + "]");
                    try {
                        Properties mappings =
                                PropertiesLoaderUtils.loadAllProperties(this.schemaMappingsLocation, this.classLoader);
                        logger.debug("Loaded schema mappings: " + mappings);
                        Map<String, String> schemaMappings = new ConcurrentHashMap<String, String>(mappings.size());
                        CollectionUtils.mergePropertiesIntoMap(mappings, schemaMappings);
                        this.schemaMappings = schemaMappings;
                    } catch (IOException ex) {
                        throw new IllegalStateException(
                                "Unable to load schema mappings from location [" + this.schemaMappingsLocation + "]", ex);
                    }
                }
            }
        }
        return this.schemaMappings;
    }


    @Override
    public String toString() {
        return "EntityResolver using mappings " + getSchemaMappings();
    }
}
