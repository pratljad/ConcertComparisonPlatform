/**
 * 
 */
package data;

/**
 * @author Joulian
 * This class represents the concert location.
 */
public class ConcertLocation {
	private int concertLocationId = -1;
	private int PLZ = -1;
	private String country = "";
	private String city = "";
	private String adress = "";
	
	/**
	 * @param concertLocationId
	 * @param pLZ
	 * @param country
	 * @param city
	 * @param adress
	 */
	public ConcertLocation(int concertLocationId, int pLZ, String country, String city, String adress) {
		super();
		this.concertLocationId = concertLocationId;
		PLZ = pLZ;
		this.country = country;
		this.city = city;
		this.adress = adress;
	}
	
	/**
	 * @return the pLZ
	 */
	public int getPLZ() {
		return PLZ;
	}
	/**
	 * @param pLZ the pLZ to set
	 */
	public void setPLZ(int pLZ) {
		PLZ = pLZ;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * @return the concertLocationId
	 */
	public int getConcertLocationId() {
		return concertLocationId;
	}
}
