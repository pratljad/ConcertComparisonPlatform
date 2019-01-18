/**
 * 
 */
package data;

import java.sql.Date;

/**
 * @author Joulian
 * This class represents a concert
 */
public class Concert {
	private int cid = -1;
	private Artist artist = null;
	private Date concertDate = null;
	private String description = "";
	
	/**
	 * @param cid
	 * @param artist
	 * @param concertDate
	 * @param description
	 */
	public Concert(int cid, Artist artist, Date concertDate, String description) {
		super();
		this.cid = cid;
		this.artist = artist;
		this.concertDate = concertDate;
		this.description = description;
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
	 * @return the concertDate
	 */
	public Date getConcertDate() {
		return concertDate;
	}

	/**
	 * @param concertDate the concertDate to set
	 */
	public void setConcertDate(Date concertDate) {
		this.concertDate = concertDate;
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
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}
}
