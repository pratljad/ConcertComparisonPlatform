/**
 * 
 */
package app;

import java.sql.SQLException;
import java.util.Set;

import dao.DAO_Affilation;
import dao.DAO_AppUser;
import dao.DAO_Artist;
import dao.DAO_Concert;
import dao.DAO_Concertlocation;
import dao.DAO_Favourites;
import dao.DAO_Genre;
import dao.DAO_TakesPlace;
import data.Affilation;
import data.AppUser;
import data.Artist;
import data.Concert;
import data.ConcertLocation;
import data.Favourites;
import data.Genre;
import data.TakesPlace;

/**
 * @author root
 *
 */
public class ConsertWS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DAO_Artist dao = DAO_Artist.getDaoArtist();
		DAO_Genre daog = DAO_Genre.getDaoGenre();
		DAO_AppUser daoap = DAO_AppUser.getDaoAppUser();
		DAO_Favourites daof = DAO_Favourites.getDaoFavourites();
		DAO_Affilation daoaff = DAO_Affilation.getDaoAffilation();
		DAO_Concert daocon = DAO_Concert.getDaoConcert();
		DAO_Concertlocation daocol = DAO_Concertlocation.getDaoConcertLocation();
		DAO_TakesPlace daotak = DAO_TakesPlace.getDaoTakesPlace();
		
		try {
			Set<Artist> artists = dao.getAllArtists();
			Set<Genre> genres = daog.getAllGenres();
			Set<AppUser> appusers = daoap.getAllAppUsers();
			Set<Favourites> favourites = daof.getAllFavourites();
			Set<Affilation> affilations = daoaff.getAllAffilation();
			Set<Concert> concerts = daocon.getAllConcerts();
			Set<ConcertLocation> concertlocations = daocol.getAllConcertLocations();
			Set<TakesPlace> takesplaces = daotak.getAllTakesPlace();
			
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
			System.out.println("\n");
			for(Concert concert : concerts) {
				System.out.println("Concert Id: " + concert.getCid() + " Aritst Id: " + concert.getArtist().getAID() + " Date: " + concert.getConcertDate() + " Description: " + concert.getDescription());
			}
			System.out.println("\n");
			for(ConcertLocation concertl : concertlocations) {
				System.out.println("CLID: " + concertl.getConcertLocationId() + " PLZ: " + concertl.getPLZ() + " Country: " + concertl.getCountry());
			}
			System.out.println("\n");
			for(TakesPlace tkp : takesplaces) {
				System.out.println("CID: " + tkp.getConcert().getCid() + " CLID: " + tkp.getConcertLocation().getConcertLocationId());
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
