package com.test.common.ds;


public class DataSourceHolder {
	
    //线程本地环境
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();
    
    //设置数据源
    public static void setDataSource(String customerType) {
        dataSources.set(customerType);
    }
    //获取数据源
    public static String getDataSource() {
    	String dataSource = (String) dataSources.get();
        return dataSource;
    }
    //清除数据源
    public static void clearDataSource() {
        dataSources.remove();
    }
 
}
