/**
 * 
 */
package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import controller.DatabaseController;
import data.Artist;
import data.Concert;

/**
 * @author Joulian
 * This is a DAO for a concert
 */
public class DAO_Concert {
    private DAO_Artist daoArtist = DAO_Artist.getDaoArtist();
    private DatabaseController dbController = DatabaseController.getDbController();
    
    private static DAO_Concert daoConcert;
    
    
	/**
	 * 
	 */
	private DAO_Concert() {
		super();
	}
	
	/**
	 * This method inserts an Concert in the database
	 * @param artistId
	 * @param concertDate
	 * @param description
	 * @throws SQLException
	 */
	public void insertConcert(int artistId, Date concertDate, String description) throws SQLException {
		int id = -1;
		String query = "insert into Concert values (" + id + ",TO_DATE('" + concertDate + "'),'" + description + "')";
		
		dbController.insert(query);
		dbController.closeConnection();
	}
	
	/**
	 * This method gets all concerts
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Set<Concert> getAllConcerts() throws ClassNotFoundException, SQLException  {
		Set<Concert> allConcerts = new HashSet<Concert>();
		String query = "select CID, AID, ConcertDate, Title from Concert";
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			Artist artist = daoArtist.getArtistById(rs.getInt("AID"));
			allConcerts.add(new Concert(rs.getInt("CID"), artist, rs.getDate("ConcertDate"), rs.getString("Title")));
		}
		
		dbController.closeConnection();
		
		return allConcerts;
	}
	
	/**
	 * This method gets alls concerts by the Artisname
	 * @param artistname
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Set<Concert> getConcertByName(String artistname) throws ClassNotFoundException, SQLException  {
		Set<Concert> concerts = new HashSet<Concert>();
		String query = "select c.CID, c.AID, c.ConcertDate,c.Title from Concert c join Artist a on a.AID = c.AID where a.ANAME = '" + artistname + "'";
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			Artist artist = daoArtist.getArtistById(rs.getInt("AID"));
			concerts.add(new Concert(rs.getInt("CID"), artist, rs.getDate("ConcertDate"), rs.getString("Title")));
		}
		
		dbController.closeConnection();
		
		return concerts;
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
