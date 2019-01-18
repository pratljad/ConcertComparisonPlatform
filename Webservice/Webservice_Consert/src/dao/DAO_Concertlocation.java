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
import data.ConcertLocation;

/**
 * @author root
 * This dao represents the concert location
 */
public class DAO_Concertlocation {
	private PropertyFileReader propertyFR = PropertyFileReader.getPropFileReader();
	private String myDriver = propertyFR.getDriver();
    private String myUrl = propertyFR.getUrl();
    private String username = propertyFR.getUsername();
    private String password = propertyFR.getPassword();
    private static DAO_Concertlocation daoConcertLocation;
    
	/**
	 * 
	 */
	private DAO_Concertlocation() {
		super();
	}
	
	public void insertConcertLocation(int plz, String country, String city, String adress) throws SQLException {
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		Statement st = conn.createStatement();
		int id = -1;
		
		st.executeUpdate("insert into ConcertLocation values (" + id + "," + plz + ",'" + country + "','" + city + "','" + adress + "')");
		
		conn.close();
	}
	
	public Set<ConcertLocation> getAllConcertLocations() throws ClassNotFoundException, SQLException  {
		Set<ConcertLocation> allConcertLocations = new HashSet<ConcertLocation>();
		String query = "select CLID, PLZ, Country, City, Adress from ConcertLocation";
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		while (rs.next()) {
			allConcertLocations.add(new ConcertLocation(rs.getInt("CLID"), rs.getInt("PLZ"),rs.getString("Country"), rs.getString("City"), rs.getString("Adress")));
		}
		
		st.close();
		conn.close();
		
		return allConcertLocations;
	}
	
	public ConcertLocation getConcertLocationById(int concertLocationId) throws ClassNotFoundException, SQLException  {
		ConcertLocation concertLocation = null;
		String query = "select CLID, PLZ, Country, City, Adress from ConcertLocation where CLID = " + concertLocationId;
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		while (rs.next()) {
			concertLocation = new ConcertLocation(rs.getInt("CLID"), rs.getInt("PLZ"),rs.getString("Country"), rs.getString("City"), rs.getString("Adress"));
		}
		
		st.close();
		conn.close();
		
		return concertLocation;
	}

	/**
	 * @return the daoArtist
	 */
	public static DAO_Concertlocation getDaoConcertLocation() {
		if(DAO_Concertlocation.daoConcertLocation == null) {
			DAO_Concertlocation.daoConcertLocation = new DAO_Concertlocation();
		}
		
		return DAO_Concertlocation.daoConcertLocation;
	}
}
