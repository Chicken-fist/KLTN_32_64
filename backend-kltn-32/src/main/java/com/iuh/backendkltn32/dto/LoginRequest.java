package com.iuh.backendkltn32.dto;


public class LoginRequest {

	private String tenTaiKhoan;
	private String password;

	/**
	 * Create an empty LoginRequest object
	 */
	public LoginRequest() {
		super();
	}

	/**
	 * Create a LoginRequest object with full attributes
	 * 
	 * @param username user's user name
	 * @param password
	 */
	public LoginRequest(String tenTaiKhoan, String password) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	/**
	 * @param username the username to set
	 */
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
