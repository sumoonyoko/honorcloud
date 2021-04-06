package org.honorcloud.code.controller.base;

public interface BaseControFunc {
	
	/**
	 * 当前主页
	 * @return
	 */
	String index();
	/**
	 * 保存
	 * @param object
	 * @return
	 */
	boolean save(Object object);
	/**
	 * 删除
	 * @param object
	 * @return
	 */
	boolean delete(Object object);
	/**
	 * 上传
	 * @param object
	 * @return
	 */
	boolean upload(Object object);
	/**
	 * 下载
	 * @param object
	 * @return
	 */
	boolean dowmload(Object object);
	/**
	 * 查询
	 * @param object
	 * @return
	 */
	Object search(Object object);
	/**
	 * 判重
	 * @param object
	 * @return
	 */
	boolean compare(Object object);

}
