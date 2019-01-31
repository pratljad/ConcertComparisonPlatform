/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import controller.DatabaseController;
import data.TakesPlace;

/**
 * @author Joulian
 * This dao is responsible for the TakesPlace class
 */
public class DAO_TakesPlace {
    private DAO_Concert daoConcert = DAO_Concert.getDaoConcert();
    private DatabaseController dbController = DatabaseController.getDbController();
    private DAO_Concertlocation daoConcertLocation = DAO_Concertlocation.getDaoConcertLocation();
    
    private static DAO_TakesPlace daoTakesPlace;
    
	/**
	 * 
	 */
	private DAO_TakesPlace() {
		super();
	}
	
	/**
	 * This method is inserting the takes_place object in the sql table
	 * @param concertId
	 * @param concertLocationId
	 * @throws SQLException
	 */
	public void insertTakesPlace(int concertId, int concertLocationId) throws SQLException {
		String query = "insert into Takes_Place values (" + concertId + "," + concertLocationId + ")";
		
		dbController.insert(query);
		dbController.closeConnection();
	}
	
	/**
	 * This method is getting all takes_place objects from the sql table
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Set<TakesPlace> getAllTakesPlace() throws ClassNotFoundException, SQLException  {
		Set<TakesPlace> allTakesPlaces = new HashSet<TakesPlace>();
		String query = "select CID, CLID from Takes_Place";
		
		ResultSet rs = dbController.select(query);
		
		//TODO: Write getconcert by id
		/*/
		while (rs.next()) {
			Concert concert = this.daoConcert.getConcertById(rs.getInt("CID"));
			ConcertLocation concertLocation = this.daoConcertLocation.getConcertLocationById(rs.getInt("CLID"));
			allTakesPlaces.add(new TakesPlace(concert, concertLocation));
		}*/
		
		dbController.closeConnection();
		
		return allTakesPlaces;
	}
	
	/**
	 * @return the daoAffilation
	 */
	public static DAO_TakesPlace getDaoTakesPlace() {
		if(DAO_TakesPlace.daoTakesPlace == null) {
			DAO_TakesPlace.daoTakesPlace = new DAO_TakesPlace();
		}
		
		return DAO_TakesPlace.daoTakesPlace;
	}
}
