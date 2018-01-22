package com.jsmsframework;

import com.jsmsframework.factory.context.CodegenContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {

    private static Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) {
        logger.info("启动代码生成工具");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        CodegenContext codegenContext = new CodegenContext();
        codegenContext.refresh();
        codegenContext.gen();

        logger.info("结束");
    }
}
