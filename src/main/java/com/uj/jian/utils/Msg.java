package com.uj.jian.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * json 模板
 * code（状态码）: 100-成功  200-失败
 * msg（提示信息）: 校验失败信息
 * extend（表示数据）: 多种数据类型
 * @author uj
 */
public class Msg {
	private int code;
	private String msg;
	
	//用户要返回给浏览器的数据
	private Map<String, Object> extend = new HashMap<>();

	public static Msg success(){
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("Success！");
		return result;
	}
	
	public static Msg fail(){
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("Failure！");
		return result;
	}
	
	public Msg add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

	@Override
	public String toString() {
		return "Msg{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", extend=" + extend +
				'}';
	}
}
