/**
 * 
 */
package data;

/**
 * @author Joulian
 * This class shows where the concert takes place.
 */
public class TakesPlace {
	private Concert concert = null;
	private ConcertLocation concertLocation = null;
	
	/**
	 * @param concert
	 * @param concertLocation
	 */
	public TakesPlace(Concert concert, ConcertLocation concertLocation) {
		super();
		this.concert = concert;
		this.concertLocation = concertLocation;
	}
	
	/**
	 * @return the concert
	 */
	public Concert getConcert() {
		return concert;
	}
	/**
	 * @param concert the concert to set
	 */
	public void setConcert(Concert concert) {
		this.concert = concert;
	}
	/**
	 * @return the concertLocation
	 */
	public ConcertLocation getConcertLocation() {
		return concertLocation;
	}
	/**
	 * @param concertLocation the concertLocation to set
	 */
	public void setConcertLocation(ConcertLocation concertLocation) {
		this.concertLocation = concertLocation;
	}
}
