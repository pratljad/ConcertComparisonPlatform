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
import data.Affilation;
import data.AppUser;
import data.Artist;
import data.Genre;

/**
 * @author Joulian
 * This class shows the affilation between artist and music genre
 */
public class DAO_Affilation {
	private PropertyFileReader propertyFR = PropertyFileReader.getPropFileReader();
	private String myDriver = propertyFR.getDriver();
    private String myUrl = propertyFR.getUrl();
    private String username = propertyFR.getUsername();
    private String password = propertyFR.getPassword();
    private DAO_Artist daoArtist = DAO_Artist.getDaoArtist();
    private DAO_Genre daoGenre = DAO_Genre.getDaoGenre();
    
    private static DAO_Affilation daoAffilation;
    
	/**
	 * 
	 */
	private DAO_Affilation() {
		super();
	}
	
	public void insertAffilation(int artistId, int genreId) throws SQLException {
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		Statement st = conn.createStatement();
		
		st.executeUpdate("insert into Affilation values (" + artistId + "," + genreId + ")");
		
		conn.close();
	}
	
	public Set<Affilation> getAllAffilation() throws ClassNotFoundException, SQLException  {
		Set<Affilation> allAffilation = new HashSet<Affilation>();
		String query = "select AID, GID from Affilation";
		
		Class.forName(this.myDriver);
		Connection conn = DriverManager.getConnection(myUrl, username, password);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while (rs.next()) {
			Genre genre = this.daoGenre.getGenreById(rs.getInt("GID"));
			Artist artist = this.daoArtist.getArtistById(rs.getInt("AID"));
			allAffilation.add(new Affilation(artist, genre));
		}
		
		st.close();
		conn.close();
		
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
