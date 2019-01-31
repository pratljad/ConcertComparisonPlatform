/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import controller.DatabaseController;
import data.AppUser;
import data.Artist;
import data.Favourites;

/**
 * @author Joulian
 * This class is a dao for the favourite artists of an user
 */
public class DAO_Favourites {
    private DAO_Artist daoArtist = DAO_Artist.getDaoArtist();
    private DatabaseController dbController = DatabaseController.getDbController();
    private DAO_AppUser daoAppUser = DAO_AppUser.getDaoAppUser();
    
    private static DAO_Favourites daoFavourites;
    
	/**
	 * 
	 */
	private DAO_Favourites() {
		super();
	}
	
	/**
	 * This method is inserting a Favourites object in a sql table
	 * @param userId
	 * @param artistId
	 * @throws SQLException
	 */
	public void insertFavourites(int userId, int artistId) throws SQLException {
		String query = "insert into Favourites values (" + userId + "," + artistId + ")";
		
		dbController.insert(query);
		dbController.closeConnection();
	}
	
	/**
	 * This method is getting all favourites from the sql table
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Set<Favourites> getAllFavourites() throws ClassNotFoundException, SQLException  {
		Set<Favourites> allFavourites = new HashSet<Favourites>();
		String query = "select UserID, AID from Favourites";
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			AppUser appUser = this.daoAppUser.getAppUserById(rs.getInt("UserID"));
			Artist artist = this.daoArtist.getArtistById(rs.getInt("AID"));
			allFavourites.add(new Favourites(appUser, artist));
		}
		
		dbController.closeConnection();
		
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
