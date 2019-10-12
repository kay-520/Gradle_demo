package com.digitalchina.sc.demo.common.base.web.message;


/**
 * 响应枚举，针对业务自行添加
 * @author jiangxian
 *
 */
public enum ResponseCode {

	TRUE(200,"true"),
	FALSE(201, "false"),
	NO_EXIST(1000, "no_exist"),
	UNKNOW_ERROR(1001, "unknow_error");
	
	
	private Integer value;
	private String desc;
	
	ResponseCode(Integer value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public Integer getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
	
}
