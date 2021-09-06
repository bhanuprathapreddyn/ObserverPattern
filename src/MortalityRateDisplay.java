
public class MortalityRateDisplay implements Observer, DisplayElement {
	private int caseCount;
	private int deathCount;
	private CovidStats covidStats;

	public MortalityRateDisplay(CovidStats data) {
		this.covidStats = covidStats;
		data.registerObserver(this);
	}

	public void update(int cases, int deaths, int vaccinations) {
        caseCount = cases;
		deathCount = deaths;

		display();
	}

	public void display() {
		System.out.println("--------------------------\n Mortality Stats: "
				+ "\n Current Cases " + caseCount
				+ "\n Deaths " + deathCount
				+ "\n Mortality " + (deathCount/(caseCount*1.0)
				+ "\n --------------------------\n")
		);
	}


	}

