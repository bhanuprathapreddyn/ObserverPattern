
public class CovidData {

	public static void main(String[] args) {
		CovidStats data = new CovidStats();
	
		CurrentStats currentDisplay = new CurrentStats(data);
		VaccinationRateDisplay vaccinationRateDisplay = new VaccinationRateDisplay(data);
		MortalityRateDisplay mortalityRateDisplay = new MortalityRateDisplay(data);

		data.setStats(100000, 200, 20000);
		data.setStats(150000, 500, 30000);
		data.setStats(200000, 550, 50000);
		
		data.removeObserver(mortalityRateDisplay);
		data.setStats(250000, 600, 60000);
		data.setStats(300000, 625, 70000);

	}
}
