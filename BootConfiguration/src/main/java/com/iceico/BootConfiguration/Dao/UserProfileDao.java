/**
 * 
 */
package com.iceico.BootConfiguration.Dao;

import java.util.List;

import com.iceico.BootConfiguration.model.UserProfile;

/**
 * @author sameer
 *
 */
public interface UserProfileDao {

	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);

}
