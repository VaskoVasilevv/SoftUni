package JavaOOP.DesignPatterns.Lab;

import java.util.HashMap;
import java.util.Map;

public class SingletonContainer {
    private static class PopulationTracker {
        private Map<String, Long> counts;
        private static PopulationTracker instance;

        private PopulationTracker() {
            this.counts = new HashMap<>();
        }

        public static PopulationTracker gerInstance() {
            if (instance == null){
                instance = new PopulationTracker();
            }
            return instance;
        }

        public void add(String location , long count) {
            this.counts.putIfAbsent(location,0L);
            this.counts.put(location, this.counts.get(location) + count);
        }

        public void remove(String location,long count) {
            if (this.counts.containsKey(location)){
                this.counts.put(location,this.counts.get(location)- count);
            }
        }
    }


    private static PopulationTracker tracker;
    private static  boolean isInitialized;

    private SingletonContainer() {

    }

    public static PopulationTracker getTracker() {
        if (!isInitialized){
            throw new IllegalStateException("SingletonContainr not initilized call.");
        }
        return tracker;

    }

    public static void  init(){
        if (!isInitialized){
            isInitialized = true;
            tracker = PopulationTracker.gerInstance();
        }
    }

}
