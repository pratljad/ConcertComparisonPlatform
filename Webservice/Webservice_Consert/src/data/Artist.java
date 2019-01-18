/**
 * 
 */
package data;

/**
 * @author Joulian
 * This is the domainclass for an artist.
 */
public class Artist {
	private int aID = -1;
	private String aName = "";
	
	/**
	 * @param aID
	 * @param aName
	 */
	public Artist(int aID, String aName) {
		super();
		this.aID = aID;
		this.aName = aName;
	}

	/**
	 * @return the aName
	 */
	public String getAName() {
		return aName;
	}

	/**
	 * @param aName the aName to set
	 */
	public void setAName(String aName) {
		this.aName = aName;
	}

	/**
	 * @return the aID
	 */
	public int getAID() {
		return aID;
	}
}
