/**
 * 
 */
package app;

import java.sql.SQLException;
import java.util.Set;

import dao.DAO_Affilation;
import dao.DAO_AppUser;
import dao.DAO_Artist;
import dao.DAO_Favourites;
import dao.DAO_Genre;
import data.Affilation;
import data.AppUser;
import data.Artist;
import data.Favourites;
import data.Genre;

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
		DAO_Artist dao = DAO_Artist.getDaoArtist();
		DAO_Genre daog = DAO_Genre.getDaoGenre();
		DAO_AppUser daoap = DAO_AppUser.getDaoAppUser();
		DAO_Favourites daof = DAO_Favourites.getDaoFavourites();
		DAO_Affilation daoaff = DAO_Affilation.getDaoAffilation();
		
		try {
			Set<Artist> artists = dao.getAllArtists();
			Set<Genre> genres = daog.getAllGenres();
			Set<AppUser> appusers = daoap.getAllAppUsers();
			Set<Favourites> favourites = daof.getAllFavourites();
			Set<Affilation> affilations = daoaff.getAllAffilation();
			
			for(Artist artist : artists) {
				System.out.println("Artist Id: " + artist.getAID() + " Artistname: " + artist.getAName());
			}
			System.out.println("\n");
			
			for(Genre genre : genres) {
				System.out.println("Genre Id: " + genre.getGenreId() + " Genrename: " + genre.getDescription());
			}
			System.out.println("\n");
			for(AppUser appUser : appusers) {
				System.out.println("AppUser Id: " + appUser.getUserId() + " Username: " + appUser.getUserName() + " Password: " + appUser.getUserPassword());
			}
			System.out.println("\n");
			for(Favourites favourite : favourites) {
				System.out.println("Favourite Id: " + favourite.getUser().getUserId() + " Aritst Id: " + favourite.getArtist().getAID());
			}
			System.out.println("\n");
			for(Affilation affilation : affilations) {
				System.out.println("Affilation Id: " + affilation.getArtist().getAID() + " Aritst Id: " + affilation.getGenre().getGenreId());
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
