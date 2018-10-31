package sch.hunnu.exception;

public class JsonResult {

	private String code;
	private String message;
	private String status;
	
	public JsonResult() {
	}

	@Override
	public String toString() {
		return "JsonResult [code=" + code + ", message=" + message + ", status=" + status + "]";
	}

	public JsonResult(String code, String message, String status) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
