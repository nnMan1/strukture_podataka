package rad_sa_fajlovima;

public class Result {
	private String party;
	private double percentage;
	
	public Result(String party, double percentage) throws Exception {
		setParty(party);
		setPercentage(percentage);
	}
	
	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) throws Exception {
		if(percentage < 0) {
//			System.err.println("Percenage must be larger than 0.");
//			System.exit(0);
			throw new Exception("Percentage must be larger than 0");
		}
		this.percentage = percentage;
	}



	@Override
	public String toString() {
		return "(" + party + ": " + percentage + ")";
	}
}
