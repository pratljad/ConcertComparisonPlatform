/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import controller.DatabaseController;
import data.ConcertLocation;

/**
 * @author root
 * This dao represents the concert location
 */
public class DAO_Concertlocation {
    private DatabaseController dbController = DatabaseController.getDbController();
    private static DAO_Concertlocation daoConcertLocation;
    
	/**
	 * 
	 */
	private DAO_Concertlocation() {
		super();
	}
	
	/**
	 * This method is inserting a ConcertLocation object in the sql table
	 * @param plz
	 * @param country
	 * @param city
	 * @param adress
	 * @throws SQLException
	 */
	public void insertConcertLocation(int plz, String country, String city, String adress) throws SQLException {
		int id = -1;
		String query = "insert into ConcertLocation values (" + id + "," + plz + ",'" + country + "','" + city + "','" + adress + "')";
		
		dbController.insert(query);
		dbController.closeConnection();
	}
	
	/**
	 * This method is getting all concert locations from the sql table
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Set<ConcertLocation> getAllConcertLocations() throws ClassNotFoundException, SQLException  {
		Set<ConcertLocation> allConcertLocations = new HashSet<ConcertLocation>();
		String query = "select CLID, PLZ, Country, City, Adress from ConcertLocation";
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			allConcertLocations.add(new ConcertLocation(rs.getInt("CLID"), rs.getInt("PLZ"),rs.getString("Country"), rs.getString("City"), rs.getString("Adress")));
		}
		
		dbController.closeConnection();
		
		return allConcertLocations;
	}
	
	/**
	 * This method is getting a concert location by its id from the sql table
	 * @param concertLocationId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ConcertLocation getConcertLocationById(int concertLocationId) throws ClassNotFoundException, SQLException  {
		ConcertLocation concertLocation = null;
		String query = "select CLID, PLZ, Country, City, Adress from ConcertLocation where CLID = " + concertLocationId;
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			concertLocation = new ConcertLocation(rs.getInt("CLID"), rs.getInt("PLZ"),rs.getString("Country"), rs.getString("City"), rs.getString("Adress"));
		}
		
		dbController.closeConnection();
		
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
