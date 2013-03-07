package dokumendid.models;

public class PersonModel {

	/*
	 * Declarations
	 */

	private String _username;
	private String _password;
	private String _firstName;
	private String _lastName;

	/*
	 * Setters
	 */

	public void setUsername(String username) {
		_username = username;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	/*
	 * Getters
	 */

	public String getUsername() {
		return _username;
	}

	public String getPassword() {
		return _password;
	}

	public String getFirstName() {
		return _firstName;
	}

	public String getLastName() {
		return _lastName;
	}
}
