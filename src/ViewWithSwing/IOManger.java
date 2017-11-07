package ViewWithSwing;

public class IOManger {
	static IOManger instance;
	private String  user;
	private String pass;
	private String ip;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public static IOManger  getInstance() {
		if(instance==null){
				instance=new IOManger(); 
			 
		}
		return instance;
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
