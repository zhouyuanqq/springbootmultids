package com.uas.aop;

import com.uas.suport.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(-1)// 保证该AOP在@Transactional之前执行
public class DataSourceChangeAspect{

    private static final Logger logger = Logger.getLogger(DataSourceChangeAspect.class);

    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource){
        String dsName = targetDataSource.value();
        if (!DataSourceContextHolder.checkExists(dsName)) {
            System.err.println("数据源[{}]不存在，使用默认数据源 > {}" + targetDataSource.value() + joinPoint.getSignature());
        } else {
           DataSourceContextHolder.setDataSourceName(targetDataSource.value()); //设置到动态数据源上下文中
        }
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource){
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DataSourceContextHolder.clearDataSourceName();
    }
}
