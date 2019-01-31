/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import controller.DatabaseController;
import data.Artist;

/**
 * @author Joulian
 * This class is the dao of the artist
 */
public class DAO_Artist {
    private static DAO_Artist daoArtist;
    private DatabaseController dbController = DatabaseController.getDbController();
    
	/**
	 * 
	 */
	private DAO_Artist() {
		super();
	}
	
	/**
	 * This method is inserting an Artist object in a sql table
	 * @param artistname
	 * @throws SQLException
	 */
	public void insertArtist(String artistname) throws SQLException {
		int id = -1;
		
		String query = "insert into Artist values (" + id + ",'" + artistname + "')";
		
		dbController.insert(query);
		dbController.closeConnection();
	}
	
	/**
	 * This method is getting all artists from the sql tables
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Set<Artist> getAllArtists() throws ClassNotFoundException, SQLException  {
		Set<Artist> allArtists = new HashSet<Artist>();
		String query = "select AID, AName from Artist";
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			allArtists.add(new Artist(rs.getInt("AID"), rs.getString("AName")));
		}
		
		dbController.closeConnection();
		
		return allArtists;
	}
	
	/**
	 * This method is getting an Artist by his id from the sql table
	 * @param artistId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Artist getArtistById(int artistId) throws ClassNotFoundException, SQLException  {
		Artist artist = null;
		String query = "select AID, AName from Artist where AID = " + artistId;
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			artist = new Artist(rs.getInt("AID"), rs.getString("AName"));
		}
		
		dbController.closeConnection();
		
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
