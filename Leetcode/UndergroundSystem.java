//https://leetcode.com/problems/design-underground-system/

import java.util.HashMap;
import java.util.Map;

class Pair<T1, T2> {
    private T1 key;
    private T2 value;

    public Pair(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }

    public T1 getKey() {
        return key;
    }

    public T2 getValue() {
        return value;
    }
}

public class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();  // Uid - {StationName, Time}
    Map<String, Pair<Double, Integer>> routeMap = new HashMap<>(); // RouteName - {TotalTime, Count}

    public UndergroundSystem() {}

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        checkInMap.remove(id);

        String routeName = checkIn.getKey() + "_" + stationName;
        int totalTime = t - checkIn.getValue();

        Pair<Double, Integer> route = routeMap.getOrDefault(routeName, new Pair<>(0.0, 0));
        routeMap.put(routeName, new Pair<>(route.getKey() + totalTime, route.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeName = startStation + "_" + endStation;
        Pair<Double, Integer> trip = routeMap.get(routeName);
        return trip.getKey() / trip.getValue();
    }
}
