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
import data.Artist;

/**
 * @author Joulian
 * This class is the dao of the artist
 */
public class DAO_Artist {
	private PropertyFileReader propertyFR = PropertyFileReader.getPropFileReader();
	private String myDriver = propertyFR.getDriver();
    private String myUrl = propertyFR.getUrl();
    private String username = propertyFR.getUsername();
    private String password = propertyFR.getPassword();
    private static DAO_Artist daoArtist;
    
	/**
	 * 
	 */
	private DAO_Artist() {
		super();
	}
	
	public void insertArtist(String artistname) throws SQLException {
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		Statement st = conn.createStatement();
		int id = -1;
		
		st.executeUpdate("insert into Artist values (" + id + ",'" + artistname + "')");
		
		conn.close();
	}
	
	public Set<Artist> getAllArtists() throws ClassNotFoundException, SQLException  {
		Set<Artist> allArtists = new HashSet<Artist>();
		String query = "select AID, AName from Artist";
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		while (rs.next()) {
			allArtists.add(new Artist(rs.getInt("AID"), rs.getString("AName")));
		}
		
		st.close();
		conn.close();
		
		return allArtists;
	}
	
	public Artist getArtistById(int artistId) throws ClassNotFoundException, SQLException  {
		Artist artist = null;
		String query = "select AID, AName from Artist where AID = " + artistId;
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		while (rs.next()) {
			artist = new Artist(rs.getInt("AID"), rs.getString("AName"));
		}
		
		st.close();
		conn.close();
		
		return artist;
	}

	/**
	 * @return the daoArtist
	 */
	public static DAO_Artist getDaoArtist() {
		if(DAO_Artist.daoArtist == null) {
			DAO_Artist.daoArtist = new DAO_Artist();
		}
		
		return DAO_Artist.daoArtist;
	}
}