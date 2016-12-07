package com.jfinal.ext.interceptor.excel;


/**
 * @author zhoulei
 *
 * @param <T>
 */
public interface PostExcelProcessor<T> {
	void process(T obj);
}
