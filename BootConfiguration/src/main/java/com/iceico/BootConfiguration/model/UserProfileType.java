/**
 * 
 */
package com.iceico.BootConfiguration.model;

import java.io.Serializable;

/**
 * @author jack
 *
 */
public enum UserProfileType implements Serializable {
	USER("USER"), ADMIN("ADMIN"), TEACHER("TEACHER"), STUDENT("STUDENT");

	String userProfileType;

	private UserProfileType(String userProfileType) {
		this.userProfileType = userProfileType;
	}

	public String getUserProfileType() {
		return userProfileType;
	}

}