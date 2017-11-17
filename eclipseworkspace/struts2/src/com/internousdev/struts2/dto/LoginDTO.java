/**
 * 
 */
package com.internousdev.struts2.dto;

/**
 * @author admin
 *
 */
public class LoginDTO {
	private int id;
	private String name;
	private String password;
	public int getId() {
	return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassoword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
