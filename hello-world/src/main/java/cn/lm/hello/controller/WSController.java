/*package cn.lm.hello.controller;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import util.SLF4JUtil;

@ServerEndpoint(value = "/websocket")
public class WSController {

	@OnOpen
	public void onOpen(Session session) {
		SLF4JUtil.info("连上了。。。");
	}
	
	@OnError
	public void onError(Session session) {
		SLF4JUtil.info("错误。。。");
	}
	
	@OnMessage
	public void OnMessage(Session session) {
		SLF4JUtil.info("信息。。。");
	}
	
	@OnClose
	public void onClose(Session session) {
		SLF4JUtil.info("关闭了。。。");
	}
	
}
*/