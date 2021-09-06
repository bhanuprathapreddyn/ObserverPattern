
import java.util.*;

public class CovidStats implements Subject {
	private int cases;
	private int deaths;
	private int vaccinations;

	private List<Observer> observers;

	public CovidStats() {
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(cases, deaths, vaccinations);
		}
	}
	
	public void updatedStats() {
		notifyObservers();
	}
	
	public void setStats(int cases, int deaths, int vaccinations) {
		this.cases = cases;
		this.deaths = deaths;
		this.vaccinations = vaccinations;
		updatedStats();
	}

	public int getCases() {
		return cases;
	}
	
	public int getDeaths() {
		return deaths;
	}
	
	public int getVaccinations() {
		return vaccinations;
	}

}
