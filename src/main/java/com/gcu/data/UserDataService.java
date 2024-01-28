package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;

@Service
public class UserDataService implements UserAccessInterface <UserEntity>
{

	@Autowired
	private UsersRepository usersRepository;
	
	/**
	 * Non-Default constructor for constructor injection.
	 */
	
	private UserDataService(UsersRepository usersRepository)
	{
		this.usersRepository = usersRepository;
	}
	
	
	@Override
	public List<UserEntity> findAll()
	{
		List <UserEntity> users = new ArrayList<UserEntity>();
		
		try
		{
			// Get all the Users
			Iterable<UserEntity> usersIterable = usersRepository.findAll();
		
			// Convert to a List and return the List
			users = new ArrayList<UserEntity>();
			usersIterable.forEach(users::add);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//return the List
		return users;
	}

	@Override
	public UserEntity findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(UserEntity user)
	{
		try
		{
			this.usersRepository.save(user);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UserEntity t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(UserEntity t) {
		// TODO Auto-generated method stub
		return true;
	}

	

}
