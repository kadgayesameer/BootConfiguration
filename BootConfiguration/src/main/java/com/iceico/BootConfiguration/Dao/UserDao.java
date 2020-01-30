/**
 * 
 */
package com.iceico.BootConfiguration.Dao;

import java.util.List;

import com.iceico.BootConfiguration.model.User;

/**
 * @author sameer
 *
 */
public interface UserDao {

	User findById(int id);

	User findBySSO(String sso);

	void save(User user);

	void deleteBySSO(String sso);

	List<User> findAllUsers();

}
