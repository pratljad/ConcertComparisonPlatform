/**
 * 
 */
package data;

/**
 * @author Joulian
 * This class shows which artist is in which genre.
 */
public class Affilation {
	private Artist artist = null;
	private Genre genre = null;
	
	/**
	 * @param artist
	 * @param genre
	 */
	public Affilation(Artist artist, Genre genre) {
		super();
		this.artist = artist;
		this.genre = genre;
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

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
