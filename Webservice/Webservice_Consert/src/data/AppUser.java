/**
 * 
 */
package data;

/**
 * @author Joulian
 * This is the domainclass for the user of the app.
 */
public class AppUser {
	private int userId = -1;
	private String userName = "";
	private String userPassword = "";
	
	/**
	 * @param userId
	 * @param userName
	 * @param userPassword
	 */
	public AppUser(int userId, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
}
