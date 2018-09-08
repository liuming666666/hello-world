package util;

/**
 * 结果封装类
 * @author l1093
 *
 */
public class Result<T> {

	private String code;
	
	private String message;
	
	private boolean isSuccess;
	
	private T o;

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

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public T getO() {
		return o;
	}

	public void setO(T o) {
		this.o = o;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", message=" + message + ", isSuccess=" + isSuccess + ", o=" + o + "]";
	}
	
}
