/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import controller.DatabaseController;
import data.AppUser;

/**
 * @author Joulian
 *
 */
public class DAO_AppUser {
    private static DAO_AppUser daoAppUser;
    private DatabaseController dbController = DatabaseController.getDbController();
    
	/**
	 * 
	 */
	private DAO_AppUser() {
		super();
	}
	
	/**
	 * This method is inserting a AppUser object in a sql table
	 * @param appUsername
	 * @param appPassword
	 * @throws SQLException
	 */
	public void insertAppUser(String appUsername, String appPassword) throws SQLException {
		int id = -1;
		String query = "insert into AppUser values (" + id + ",'" + appUsername + "','" + appPassword + "')";
		
		dbController.insert(query);
		dbController.closeConnection();
	}
	
	/**
	 * This method is getting all app users from the sql table
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Set<AppUser> getAllAppUsers() throws ClassNotFoundException, SQLException  {
		Set<AppUser> allAppUsers = new HashSet<AppUser>();
		String query = "select UserID, Username, UPassword from AppUser";
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			allAppUsers.add(new AppUser(rs.getInt("UserID"), rs.getString("Username"), rs.getString("UPassword")));
		}
		
		dbController.closeConnection();
		
		return allAppUsers;
	}
	
	/**
	 * This method is getting an user by his id from the sql table
	 * @param userId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public AppUser getAppUserById(int userId) throws ClassNotFoundException, SQLException  {
		AppUser appUser = null;
		String query = "select UserID, Username, UPassword from AppUser where UserID = " + userId;
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			appUser = new AppUser(rs.getInt("UserID"), rs.getString("Username"), rs.getString("UPassword"));
		}
		
		dbController.closeConnection();
		
		return appUser;
	}
	
	/**
	 * @return the daoAppUser
	 */
	public static DAO_AppUser getDaoAppUser() {
		if(DAO_AppUser.daoAppUser == null) {
			DAO_AppUser.daoAppUser = new DAO_AppUser();
		}
		
		return DAO_AppUser.daoAppUser;
	}
}
