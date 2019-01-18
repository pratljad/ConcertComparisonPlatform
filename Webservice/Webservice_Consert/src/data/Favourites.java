/**
 * 
 */
package data;

/**
 * @author Joulian
 * This domainclass represents the favourit artists of an app user.
 */
public class Favourites {
	private AppUser user = null;
	private Artist artist = null;
	
	/**
	 * @param user
	 * @param artist
	 */
	public Favourites(AppUser user, Artist artist) {
		super();
		this.user = user;
		this.artist = artist;
	}

	/**
	 * @return the user
	 */
	public AppUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(AppUser user) {
		this.user = user;
	}

	/**
	 * @return the artist
	 */
	public Artist getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
