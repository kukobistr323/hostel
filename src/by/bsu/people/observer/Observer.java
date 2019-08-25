package by.bsu.people.observer;

import by.bsu.people.administration.Commandant;
import by.bsu.people.administration.Security;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Observer {
    private List<Observable> observables;
    private Commandant commandant;
    private Security security;

    public Observer(Commandant commandant, Security security) {
        observables = new ArrayList<>(100);
        this.commandant = commandant;
        this.security = security;
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

    public Commandant getCommandant() {
        return commandant;
    }

    public void setCommandant(Commandant commandant) {
        this.commandant = commandant;
    }

    public List<Observable> getObservables() {
        return observables;
    }

    public void setObservables(List<Observable> observables) {
        this.observables = observables;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Observer observer = (Observer) o;
        return Objects.equals(observables, observer.observables) &&
                Objects.equals(commandant, observer.commandant) &&
                Objects.equals(security, observer.security);
    }

    @Override
    public int hashCode() {
        return Objects.hash(observables, commandant, security);
    }
}
