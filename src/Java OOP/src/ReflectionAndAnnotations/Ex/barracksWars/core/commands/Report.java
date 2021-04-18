package ReflectionAndAnnotations.Ex.barracksWars.core.commands;

import ReflectionAndAnnotations.Ex.barracksWars.interfaces.Inject;
import ReflectionAndAnnotations.Ex.barracksWars.interfaces.Repository;


public class Report extends Command{
    @Inject
    private Repository repository;
    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
