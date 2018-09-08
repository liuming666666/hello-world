package util;

public enum ResCode {

	SUCCESS("0000","请求成功"),
	ERROR("1000","未知错误");
	
	private String code;
	
	private String message;
	
	private ResCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
