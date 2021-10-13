package mybatis.service.domain;

import java.io.Serializable;

import java.sql.Date;

/*
 * FileName : User.java  
 * ㅇ User 의 정보를 갖는 Value Object (도메인객체,비지니스객체)
 * ㅇ USERS TABLE 의 1개의 ROW 의 정보를 갖는다.  
*/ 
public class User implements Serializable {

	///Field
    private String userId; 			// 회원 ID 
    private String userName;		// 회원 이름 
    private String password;     // 비밀번호 
    private String role;    			// 나이 :: Integer wrapper class 사용 :: 추후 용도 확인  
    private String ssn;    				// 등급 :: int primitive 사용 :: :: 추후 용도 확인 
    private String phone;    				// 등급 :: int primitive 사용 :: :: 추후 용도 확인 
    private String addr;    				// 등급 :: int primitive 사용 :: :: 추후 용도 확인 
    private String email;    				// 등급 :: int primitive 사용 :: :: 추후 용도 확인 
    private Date regDate; // 가입일자 
    //private Timestamp regDate	= new Timestamp(new Date().getTime()); // 가입일자
    private boolean active; 
    
    ///Constructor
    public User() {
	}
    public User (	String userId, String userName,String password,String role, 
    		String ssn,String phone,String addr,String email,Date regDate) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.ssn = ssn;
		this.phone = phone;
		this.addr = addr;
		this.email = email;
		this.regDate = regDate;
	}    

	///Method (getter/setter)

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", ssn=" + ssn + ", phone=" + phone + ", addr=" + addr + ", email=" + email + ", regDate=" + regDate
				+ ", active=" + active + "]";
	}
	
}//end of class