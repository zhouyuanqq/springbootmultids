package com.uas.suport;
import com.alibaba.druid.pool.DruidDataSource;
import com.uas.model.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
public class DataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private  Logger  logger = Logger.getLogger(DataSourceRegister.class);
    @Override
    public void setEnvironment(Environment environment) {
        initDataSource(environment);
    }
    private void initDefaultDataSource(Environment env) {
        // 读取主数据源
        DataSource ds=new DataSource();
        buildDataSource(ds);
    }
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();

        // 将主数据源添加到更多数据源中

        targetDataSources.put("dataSource", defaultDataSource);

        DataSourceContextHolder.dataSourceIds.add("dataSource");

        // 添加更多数据源

        targetDataSources.putAll(customDataSources);

        for (String key : customDataSources.keySet()) {

            DynamicDataSourceContextHolder.dataSourceIds.add(key);

        }



        // 创建DruidDataSource
        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(DruidDataSource.class);
        bd.setSynthetic(true);
        MutablePropertyValues mpv = bd.getPropertyValues();
        registry.registerBeanDefinition("dataSource", beanDefinition);
    }

    public DruidDataSource  buildDataSource(DataSource dataSource) {
            // 自定义DataSource配置
           DruidDataSource druid=new DruidDataSource();
           druid.setDriverClassName(dataSource.getDriverclass());
           druid.setUsername(dataSource.getUsername());
           druid.setPassword(dataSource.getPassword());
           return druid;
    }

}
