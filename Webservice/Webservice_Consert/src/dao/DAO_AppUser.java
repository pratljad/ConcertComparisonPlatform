/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import controller.PropertyFileReader;
import data.AppUser;

/**
 * @author Joulian
 *
 */
public class DAO_AppUser {
	private PropertyFileReader propertyFR = PropertyFileReader.getPropFileReader();
	private String myDriver = propertyFR.getDriver();
    private String myUrl = propertyFR.getUrl();
    private String username = propertyFR.getUsername();
    private String password = propertyFR.getPassword();
    private static DAO_AppUser daoAppUser;
    
	/**
	 * 
	 */
	private DAO_AppUser() {
		super();
	}
	
	public void insertAppUser(String appUsername, String appPassword) throws SQLException {
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		Statement st = conn.createStatement();
		int id = -1;
		
		st.executeUpdate("insert into AppUser values (" + id + ",'" + appUsername + "','" + appPassword + "')");
		
		conn.close();
	}
	
	public Set<AppUser> getAllAppUsers() throws ClassNotFoundException, SQLException  {
		Set<AppUser> allAppUsers = new HashSet<AppUser>();
		String query = "select UserID, Username, UPassword from AppUser";
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		while (rs.next()) {
			allAppUsers.add(new AppUser(rs.getInt("UserID"), rs.getString("Username"), rs.getString("UPassword")));
		}
		
		st.close();
		conn.close();
		
		return allAppUsers;
	}
	
	
	public AppUser getAppUserById(int userId) throws ClassNotFoundException, SQLException  {
		AppUser appUser = null;
		String query = "select UserID, Username, UPassword from AppUser where UserID = " + userId;
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		while (rs.next()) {
			appUser = new AppUser(rs.getInt("UserID"), rs.getString("Username"), rs.getString("UPassword"));
		}
		
		st.close();
		conn.close();
		
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
