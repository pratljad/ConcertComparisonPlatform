/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import controller.PropertyFileReader;
import data.Artist;
import data.Concert;

/**
 * @author Joulian
 * This is a DAO for a concert
 */
public class DAO_Concert {
	private PropertyFileReader propertyFR = PropertyFileReader.getPropFileReader();
	private String myDriver = propertyFR.getDriver();
    private String myUrl = propertyFR.getUrl();
    private String username = propertyFR.getUsername();
    private String password = propertyFR.getPassword();
    private DAO_Artist daoArtist = DAO_Artist.getDaoArtist();
    
    private static DAO_Concert daoConcert;
    
    
	/**
	 * 
	 */
	private DAO_Concert() {
		super();
	}
	
	public void insertConcert(int artistId, Date concertDate, String description) throws SQLException {
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		Statement st = conn.createStatement();
		int id = -1;
		
		st.executeUpdate("insert into Concert values (" + id + ",TO_DATE('" + concertDate + "'),'" + description + "')");
		
		conn.close();
	}
	
	public Set<Concert> getAllConcerts() throws ClassNotFoundException, SQLException  {
		Set<Concert> allConcerts = new HashSet<Concert>();
		String query = "select CID, AID, ConcertDate,Description from Concert";
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		while (rs.next()) {
			Artist artist = daoArtist.getArtistById(rs.getInt("AID"));
			allConcerts.add(new Concert(rs.getInt("CID"), artist, rs.getDate("ConcertDate"), rs.getString("Description")));
		}
		
		st.close();
		conn.close();
		
		return allConcerts;
	}
	
	
	public Concert getConcertById(int concertId) throws ClassNotFoundException, SQLException  {
		Concert concert = null;
		String query = "select CID, AID, ConcertDate,Description from Concert where CID = " + concertId;
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		while (rs.next()) {
			Artist artist = daoArtist.getArtistById(rs.getInt("AID"));
			concert = new Concert(rs.getInt("CID"), artist, rs.getDate("ConcertDate"), rs.getString("Description"));
		}
		
		st.close();
		conn.close();
		
		return concert;
	}
	
	/**
	 * @return the daoAppUser
	 */
	public static DAO_Concert getDaoConcert() {
		if(DAO_Concert.daoConcert == null) {
			DAO_Concert.daoConcert = new DAO_Concert();
		}
		
		return DAO_Concert.daoConcert;
	}
}
