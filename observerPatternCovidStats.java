
import java.util.ArrayList;
import java.util.List;

class CovidStatsChangedEvent<T> {
    public T source;
    public String propertyName;
    public Object newValue;

    public CovidStatsChangedEvent(T source, String propertyName,
                                  Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}

// observes objects of type T
interface Observer<T> {
    void handle(CovidStatsChangedEvent<T> args);
}

// can be observed
class Observable<T> {
    private final List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        observers.add(observer);
    }

    protected void propertyChanged(T source,
                                   String statName,
                                   Object newValue) {
        for (Observer<T> o : observers)
            o.handle(new CovidStatsChangedEvent<T>(
                    source, statName, newValue
            ));
    }
}

class caseStats extends Observable<caseStats> {
    public int getCaseCount() {
        return caseCount;
    }

    public void setCaseCount(int caseCount) {
        if (this.caseCount == caseCount) return;
        this.caseCount = caseCount;
        propertyChanged(this, "caseCount", caseCount);
    }

    private int caseCount;
    /*
Only caseCount  has been set to the property
More properties like vaccinations, deathCount, mortality, infection rate can be added
 */
}

class ObserverPatternCovidStats implements Observer<caseStats>
        // Observer
{
    public ObserverPatternCovidStats() {
        caseStats caseStats = new caseStats();
        caseStats.subscribe(this);
        for (int i = 10000; i < 10010; ++i)
            caseStats.setCaseCount(i);
    }

    public static void main(String[] args) {
        new ObserverPatternCovidStats();
    }

    @Override
    public void handle(CovidStatsChangedEvent<caseStats> args) {
        System.out.println("COVID " + args.propertyName
                + " has been updated to " + args.newValue);
    }
}

