package com.tencent.extensionpointdemo;

/**
 * 所有Module需实现该接口
 * @author jamiemo
 *
 */
public interface Module {
	public void init();
	public void destroy();
}
