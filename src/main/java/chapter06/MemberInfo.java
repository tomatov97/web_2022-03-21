package chapter06;

public class MemberInfo {

	private String id;
	private String pw;
	private String name;
	
	public MemberInfo(String id, String pw, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}


			
}
