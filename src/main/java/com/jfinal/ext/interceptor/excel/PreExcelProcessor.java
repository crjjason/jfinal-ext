package com.jfinal.ext.interceptor.excel;


/**
 * @author zhoulei
 *
 * @param <T>
 */
public interface PreExcelProcessor<T> {
	void process(T obj);
}
