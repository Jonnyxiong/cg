package com.jsmsframework.factory.xml;

import com.jsmsframework.exception.EntityDefinitionStoreException;
import org.w3c.dom.Document;

public interface EntityDefinitionDocumentReader {


    void registerBeanDefinitions(Document doc, XmlReaderContext xmlReaderContext)
            throws EntityDefinitionStoreException;
}
