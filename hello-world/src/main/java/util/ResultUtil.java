package util;

public class ResultUtil {

	/**
	 * 成功
	 * @param o
	 * @return
	 */
	public static <T> Result<T> success(T o) {
		Result<T> r = new Result<>();
		r.setCode(ResCode.SUCCESS.getCode());
		r.setMessage(ResCode.SUCCESS.getMessage());
		r.setSuccess(true);
		r.setO(o);
		return r;
	}
	
	/**
	 * 
	 * @param resCode
	 * @return
	 */
	public static Result<?> error(ResCode resCode) {
		Result<?> r = new Result<>();
		r.setCode(ResCode.ERROR.getCode());
		r.setMessage(ResCode.ERROR.getMessage());
		r.setSuccess(false);
		r.setO(null);
		return r;
	}
	
}
