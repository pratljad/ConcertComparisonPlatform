/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import controller.DatabaseController;
import data.Affilation;
import data.Artist;
import data.Genre;

/**
 * @author Joulian
 * This class shows the affilation between artist and music genre
 */
public class DAO_Affilation {
    private DAO_Artist daoArtist = DAO_Artist.getDaoArtist();
    private DAO_Genre daoGenre = DAO_Genre.getDaoGenre();
    private DatabaseController dbController = DatabaseController.getDbController();
    
    private static DAO_Affilation daoAffilation;
    
	/**
	 * 
	 */
	private DAO_Affilation() {
		super();
	}
	
	/**
	 * This method is inserting an affilation object in a sql table
	 * @param artistId
	 * @param genreId
	 * @throws SQLException
	 */
	public void insertAffilation(int artistId, int genreId) throws SQLException {
		String query = "insert into Affilation values (" + artistId + "," + genreId + ")";
		
		dbController.insert(query);
		dbController.closeConnection();
	}
	
	/**
	 * This method is getting all affilations
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Set<Affilation> getAllAffilation() throws ClassNotFoundException, SQLException  {
		Set<Affilation> allAffilation = new HashSet<Affilation>();
		String query = "select AID, GID from Affilation";
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			Genre genre = this.daoGenre.getGenreById(rs.getInt("GID"));
			Artist artist = this.daoArtist.getArtistById(rs.getInt("AID"));
			allAffilation.add(new Affilation(artist, genre));
		}
		
		dbController.closeConnection();
		
		return allAffilation;
	}
	
	/**
	 * @return the daoAffilation
	 */
	public static DAO_Affilation getDaoAffilation() {
		if(DAO_Affilation.daoAffilation == null) {
			DAO_Affilation.daoAffilation = new DAO_Affilation();
		}
		
		return DAO_Affilation.daoAffilation;
	}
}
