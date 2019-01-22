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
	private String title = "";
	
	/**
	 * @param cid
	 * @param artist
	 * @param concertDate
	 * @param description
	 */
	public Concert(int cid, Artist artist, Date concertDate, String title) {
		super();
		this.cid = cid;
		this.artist = artist;
		this.concertDate = concertDate;
		this.title = title;
	}
	
	public String getJSON() {
		String concertJSON = "{";
		String newLine = System.getProperty("line.separator");
		
		concertJSON += newLine;
		concertJSON += "\"Artist\": " + "\"" + this.artist.getAName() + "\",";
		
		concertJSON += newLine;
		concertJSON += "\"Concert Date\": " + "\""  + this.concertDate + "\",";
		
		concertJSON += newLine;
		concertJSON += "\"Description\": " + "\""  + this.title + "\"";
		
		concertJSON += newLine;
		concertJSON += "}";
		
		return concertJSON;
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
	public String getTitle() {
		return title;
	}

	/**
	 * @param description the description to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}
}
