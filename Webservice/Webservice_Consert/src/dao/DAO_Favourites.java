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
import data.Artist;
import data.Favourites;

/**
 * @author Joulian
 * This class is a dao for the favourite artists of an user
 */
public class DAO_Favourites {
	private PropertyFileReader propertyFR = PropertyFileReader.getPropFileReader();
	private String myDriver = propertyFR.getDriver();
    private String myUrl = propertyFR.getUrl();
    private String username = propertyFR.getUsername();
    private String password = propertyFR.getPassword();
    private DAO_Artist daoArtist = DAO_Artist.getDaoArtist();
    private DAO_AppUser daoAppUser = DAO_AppUser.getDaoAppUser();
    
    private static DAO_Favourites daoFavourites;
    
	/**
	 * 
	 */
	private DAO_Favourites() {
		super();
	}
	
	public void insertFavourites(int userId, int artistId) throws SQLException {
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		Statement st = conn.createStatement();
		
		st.executeUpdate("insert into Favourites values (" + userId + "," + artistId + ")");
		
		conn.close();
	}
	
	public Set<Favourites> getAllFavourites() throws ClassNotFoundException, SQLException  {
		Set<Favourites> allFavourites = new HashSet<Favourites>();
		String query = "select UserID, AID from Favourites";
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while (rs.next()) {
			AppUser appUser = this.daoAppUser.getAppUserById(rs.getInt("UserID"));
			Artist artist = this.daoArtist.getArtistById(rs.getInt("AID"));
			allFavourites.add(new Favourites(appUser, artist));
		}
		
		st.close();
		conn.close();
		
		return allFavourites;
	}
	
	/**
	 * @return the daoFavourites
	 */
	public static DAO_Favourites getDaoFavourites() {
		if(DAO_Favourites.daoFavourites == null) {
			DAO_Favourites.daoFavourites = new DAO_Favourites();
		}
		
		return DAO_Favourites.daoFavourites;
	}
}
