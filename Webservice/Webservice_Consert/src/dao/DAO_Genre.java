/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import controller.DatabaseController;
import data.Genre;

/**
 * @author Joulian
 * This class is the dao of genre
 */
public class DAO_Genre {
    private DatabaseController dbController = DatabaseController.getDbController();
    private static DAO_Genre daoGenre;
    
	/**
	 * 
	 */
	private DAO_Genre() {
		super();
	}
	
	/**
	 * This method is inserting a genre in the sql table
	 * @param description
	 * @throws SQLException
	 */
	public void insertGenre(String description) throws SQLException {
		int id = -1;
		String query = "insert into Genre values (" + id + ",'" + description + "')";
		
		dbController.insert(query);
		dbController.closeConnection();
	}
	
	/**
	 * This method is getting all genres from a sql table
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Set<Genre> getAllGenres() throws ClassNotFoundException, SQLException  {
		Set<Genre> allGenres = new HashSet<Genre>();
		String query = "select GID, Description from Genre";
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			allGenres.add(new Genre(rs.getInt("GID"), rs.getString("Description")));
		}
		
		dbController.closeConnection();		
		return allGenres;
	}
	
	/**
	 * This method is getting a genre by his id from the sql table
	 * @param genreId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Genre getGenreById(int genreId) throws ClassNotFoundException, SQLException  {
		Genre genre = null;
		String query = "select GID, Description from Genre where GID = " + genreId;
		
		ResultSet rs = dbController.select(query);
		
		while (rs.next()) {
			genre = new Genre(rs.getInt("GID"), rs.getString("Description"));
		}
		
		dbController.closeConnection();
		
		return genre;
	}
	
	/**
	 * @return the daoGenre
	 */
	public static DAO_Genre getDaoGenre() {
		if(DAO_Genre.daoGenre == null) {
			DAO_Genre.daoGenre = new DAO_Genre();
		}
		
		return DAO_Genre.daoGenre;
	}
}
