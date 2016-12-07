package com.jfinal.ext.kit.excel.convert;

/**
 * @author zhoulei
 *
 */
public interface CellConvert<T> {
	T convert(String val, T obj);
}
