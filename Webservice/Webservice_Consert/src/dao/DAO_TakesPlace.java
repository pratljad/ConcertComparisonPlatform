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
import data.Concert;
import data.ConcertLocation;
import data.TakesPlace;

/**
 * @author Joulian
 * This dao is responsible for the TakesPlace class
 */
public class DAO_TakesPlace {
	private PropertyFileReader propertyFR = PropertyFileReader.getPropFileReader();
	private String myDriver = propertyFR.getDriver();
    private String myUrl = propertyFR.getUrl();
    private String username = propertyFR.getUsername();
    private String password = propertyFR.getPassword();
    private DAO_Concert daoConcert = DAO_Concert.getDaoConcert();
    private DAO_Concertlocation daoConcertLocation = DAO_Concertlocation.getDaoConcertLocation();
    
    private static DAO_TakesPlace daoTakesPlace;
    
	/**
	 * 
	 */
	private DAO_TakesPlace() {
		super();
	}
	
	public void insertTakesPlace(int concertId, int concertLocationId) throws SQLException {
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		Statement st = conn.createStatement();
		
		st.executeUpdate("insert into Takes_Place values (" + concertId + "," + concertLocationId + ")");
		
		conn.close();
	}
	
	public Set<TakesPlace> getAllTakesPlace() throws ClassNotFoundException, SQLException  {
		Set<TakesPlace> allTakesPlaces = new HashSet<TakesPlace>();
		String query = "select CID, CLID from Takes_Place";
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while (rs.next()) {
			Concert concert = this.daoConcert.getConcertById(rs.getInt("CID"));
			ConcertLocation concertLocation = this.daoConcertLocation.getConcertLocationById(rs.getInt("CLID"));
			allTakesPlaces.add(new TakesPlace(concert, concertLocation));
		}
		
		st.close();
		conn.close();
		
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
