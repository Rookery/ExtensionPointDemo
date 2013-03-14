package com.tencent.extensionpointdemo;

public interface ExtensionPoint {
	public void register(Object o);
	public void unregister(Object o);
}
