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
import data.Genre;

/**
 * @author Joulian
 * This class is the dao of genre
 */
public class DAO_Genre {
	private PropertyFileReader propertyFR = PropertyFileReader.getPropFileReader();
	private String myDriver = propertyFR.getDriver();
    private String myUrl = propertyFR.getUrl();
    private String username = propertyFR.getUsername();
    private String password = propertyFR.getPassword();
    private static DAO_Genre daoGenre;
    
	/**
	 * 
	 */
	private DAO_Genre() {
		super();
	}
	
	public void insertGenre(String description) throws SQLException {
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		Statement st = conn.createStatement();
		int id = -1;
		
		st.executeUpdate("insert into Genre values (" + id + ",'" + description + "')");
		
		conn.close();
	}
	
	public Set<Genre> getAllGenres() throws ClassNotFoundException, SQLException  {
		Set<Genre> allGenres = new HashSet<Genre>();
		String query = "select GID, Description from Genre";
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		while (rs.next()) {
			allGenres.add(new Genre(rs.getInt("GID"), rs.getString("Description")));
		}
		
		st.close();
		conn.close();
		
		return allGenres;
	}
	
	public Genre getGenreById(int genreId) throws ClassNotFoundException, SQLException  {
		Genre genre = null;
		String query = "select GID, Description from Genre where GID = " + genreId;
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		while (rs.next()) {
			genre = new Genre(rs.getInt("GID"), rs.getString("Description"));
		}
		
		st.close();
		conn.close();
		
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
