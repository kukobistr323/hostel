package by.bsu.people.observer;

import by.bsu.people.administration.Commandant;
import by.bsu.people.administration.Security;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Observer {
    private List<Observable> observables;

    public Observer() {
        observables = new ArrayList<>(100);
    }

    public void addObservable(Observable observable) {
        observables.add(observable);
    }

    public void removeObservable(Observable observable) {
        observables.remove(observable);
    }

    public void setNewYear() {
        observables.forEach(Observable::newYear);
    }

    public List<Observable> getObservables() {
        return observables;
    }

    public void setObservables(List<Observable> observables) {
        this.observables = observables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Observer observer = (Observer) o;
        return Objects.equals(observables, observer.observables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(observables);
    }
}
