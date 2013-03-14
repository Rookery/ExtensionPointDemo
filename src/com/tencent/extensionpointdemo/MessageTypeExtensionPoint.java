package com.tencent.extensionpointdemo;

import java.util.HashMap;
import java.util.Map;

public class MessageTypeExtensionPoint implements ExtensionPoint{
	Map<Integer, MessageType> mMsgTypeMap = new HashMap<Integer, MessageType>();
	
	
	private static MessageTypeExtensionPoint messageTypeExtensionPoint;
	public static MessageTypeExtensionPoint getInstance(){
		if (messageTypeExtensionPoint == null) {
			messageTypeExtensionPoint = new MessageTypeExtensionPoint();
		}
		return messageTypeExtensionPoint;
	}

	@Override
	public void register(Object o) {
		MessageType msgType = (MessageType)o;
		mMsgTypeMap.put(msgType.getType(), msgType);
		
	}

	@Override
	public void unregister(Object o) {
		mMsgTypeMap.remove(o);
	}
	
	public MessageType getMessageType(int type){
		return mMsgTypeMap.get(type);
	}
}
