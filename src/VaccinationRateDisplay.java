
public class VaccinationRateDisplay implements Observer, DisplayElement {
	private int vaccinationCount;
	private int population = 1000000;

	private CovidStats covidStats;

	public VaccinationRateDisplay(CovidStats data) {
		this.covidStats = covidStats;
		data.registerObserver(this);
	}

	public void update(int cases, int deaths, int vaccinations) {
		vaccinationCount = vaccinations;

		display();
	}

	public void display() {
		System.out.println("--------------------------\n Vaccination Stats: "
				+ "\n Total Population " + population
				+ "\n Vaccinated " + vaccinationCount
				+ "\n Vaccination Rate " + (vaccinationCount/(population*1.0)
				+ "\n --------------------------\n")
		);
	}


}

