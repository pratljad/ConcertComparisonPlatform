/**
 * 
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DAO_Concert;

/**
 * @author Joulian
 * This class is a controller for the database
 */
public class DatabaseController {
	private PropertyFileReader propertyFR = PropertyFileReader.getPropFileReader();
	private String myDriver = propertyFR.getDriver();
    private String myUrl = propertyFR.getUrl();
    private String username = propertyFR.getUsername();
    private String password = propertyFR.getPassword();
    private Statement st = null;
    private Connection conn = null;
	
    private static DatabaseController dbController;
    
	/**
	 * 
	 */
	private DatabaseController() {
		super();
	}
	
	/**
	 * This method connecting to a sql database
	 * @return
	 * @throws SQLException
	 */
	private Connection connect() throws SQLException {
		return DriverManager.getConnection(myUrl, username, password);
	}
	
	/**
	 * This method closes a sql connection
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		this.st.close();
		this.conn.close();
	}
	
	/**
	 * This method is executing a sql command
	 * @param query
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet select(String query) throws ClassNotFoundException, SQLException {
		Class.forName(this.myDriver);
		this.conn = connect();
		this.st = conn.createStatement();
		ResultSet resultSet = st.executeQuery(query);
		
		return resultSet;
	}
	
	/**
	 * This method is executing a sql insert
	 * @param query
	 * @throws SQLException
	 */
	public void insert(String query) throws SQLException {
		Connection conn = connect();
		this.st = conn.createStatement();
		st.executeUpdate(query);
	}

	/**
	 * @return the dbController
	 */
	public static DatabaseController getDbController() {
		if(DatabaseController.dbController == null) {
			DatabaseController.dbController = new DatabaseController();
		}
		
		return dbController;
	}
}
