
public class CurrentStats implements Observer, DisplayElement {
	private int cases;
	private int deaths;
	private int vaccinations;

	private CovidStats covidStats;
	
	public CurrentStats(CovidStats covidStats) {
		this.covidStats = covidStats;
		covidStats.registerObserver(this);
	}

	public void update(int cases, int deaths, int vaccinations) {
		this.cases = cases;
		this.deaths = deaths;
		this.vaccinations = vaccinations;
		display();
	}
	
	public void display() {
		System.out.println("Current Cases: " + cases
			+ "\n Current Deaths: " + deaths
				+ "\n Vaccinated count:" + vaccinations);
	}


}
