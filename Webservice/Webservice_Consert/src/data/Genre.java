/**
 * 
 */
package data;

/**
 * @author Joulian
 * This class represent the music genre
 */
public class Genre {
	private int genreId = -1;
	private String description = "";
	
	/**
	 * @param genreId
	 * @param description
	 */
	public Genre(int genreId, String description) {
		super();
		this.genreId = genreId;
		this.description = description;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the genreId
	 */
	public int getGenreId() {
		return genreId;
	}
}
