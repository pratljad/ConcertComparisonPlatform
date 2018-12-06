package data;

public class Concert {
	private int concertID;
	private String description = "fixed Description";
	
	public Concert(int concertID) {
		super();
		this.concertID = concertID;
		this.description = description;
	}

	public int getConcertID() {
		return concertID;
	}

	public void setConcertID(int concertID) {
		this.concertID = concertID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
