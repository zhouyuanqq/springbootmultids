package com.uas.suport;
import com.alibaba.druid.pool.DruidDataSource;
import com.uas.model.DataSource;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
public class DataSourceRegister  {

    /**
     * 动态创建数据库链接
     * */
    public  boolean buildDataSource(DataSource dataSource){
        ConfigurableApplicationContext configureContext = (ConfigurableApplicationContext)ContextUtil.getApplicationContext();
        DefaultListableBeanFactory defaultListableBeanFactory=(DefaultListableBeanFactory)configureContext.getBeanFactory();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(DruidDataSource.class);
        beanDefinitionBuilder.setLazyInit(true);
        beanDefinitionBuilder.addPropertyReference("url",dataSource.getUrl());
        beanDefinitionBuilder.addPropertyReference("username",dataSource.getUsername());
        beanDefinitionBuilder.addPropertyReference("password",dataSource.getPassword());
        beanDefinitionBuilder.addPropertyReference("port",String.valueOf(dataSource.getPort()));
        defaultListableBeanFactory.registerBeanDefinition(dataSource.getBeanId(),beanDefinitionBuilder.getRawBeanDefinition());
        /**AbstractRoutingDataSource */
        return true;
    }
}
