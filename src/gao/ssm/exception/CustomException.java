package gao.ssm.exception;
/**
 * ϵͳ�Զ����쳣�࣬���Ԥ�ڵ��쳣����Ҫ��ϵͳ���׳������쳣
 * @author DELL
 *
 */
public class CustomException extends Exception {
	// �쳣��Ϣ
	private String message;
	
	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
