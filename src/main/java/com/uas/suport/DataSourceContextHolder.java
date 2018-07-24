package com.uas.suport;

import java.util.ArrayList;
import java.util.List;

public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder =new ThreadLocal<String>();
    /**
     * 通过ID管理相关数据源
     */
    private static List<String> dataSourceIds=new ArrayList<String>();

    public static void setDataSource(String dataSource) {

        contextHolder.set(dataSource);

    }

    public static String getDataSource() {

        return contextHolder.get();

    }

    public static void clearDataSource() {

        contextHolder.remove();

    }

    public static boolean checkExists(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }

}
