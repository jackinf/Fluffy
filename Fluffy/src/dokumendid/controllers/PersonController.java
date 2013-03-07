package dokumendid.controllers;

import dokumendid.database.DBQuery;

public class PersonController {

	/*
	 * Declarations
	 */

	private DBQuery dbquery = new DBQuery();

	/**
	 * Check in database, if combination of username and password is correct
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean Login(String username, String password) {
		return dbquery.Login(username, password);
	}

}
