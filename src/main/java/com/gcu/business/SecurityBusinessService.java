package com.gcu.business;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService
{
	/**
	 * checks to see if user is legitimate
	 * @param username username from Login Page
	 * @param password password from Login Page
	 * @return true if user is valid, false if not
	 */
	public boolean authenticate(String username, String password)
	{
		//checks to see if user is legitimate (testing only - this will always be true)
		if(username.equals(username) && password.equals(password))
		{
			//prints out user credentials to the console
			System.out.println("Hello, there, \"" + username + "\" with password \"" + password + "\"");
			return true;
		}
		//returns false if username and password either doesn't exist or doesn't match any records
		return false;
	}
}
