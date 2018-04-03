package com.gupao.edu.gpmybatis;

/**
 * @author wanggang
 * @date 2018年4月2日 上午11:31:30
 * 
 */
public interface GpExecutor {
	
	<T> T query(String statement, String parameter);
	
}
