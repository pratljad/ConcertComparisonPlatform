/**
 * 
 */
package app;

import java.sql.SQLException;
import java.util.Set;

import dao.DAO_Artist;
import data.Artist;

/**
 * @author root
 *
 */
public class ConsertWS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO_Artist dao = new DAO_Artist();
		
		try {
			Set<Artist> artists = dao.getAllArtists();
			
			for(Artist artist : artists) {
				System.out.println("Artist Id: " + artist.getAID() + " Artistname: " + artist.getAName());
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
