package NearByApp.backend.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import NearByApp.model.Activity;
import NearByApp.model.Location;

public class ActivityRepository {
    
    HashMap<String, Location> locations;

    public ActivityRepository() {
        locations = new HashMap<>();
    }

    public void addActivity(String name, String location, String category, Integer distance, Integer time, Integer rating) {
        if(!locations.containsKey(location)) {
            locations.put(location, new Location());
        }
        Location targetLocation = locations.get(location);
        targetLocation.addActivity(name, category, distance, time, rating);
    }

    public List<Activity> getActivities(String location, String category) {
        if(!locations.containsKey(location)) {
            return Collections.emptyList();
        }
        List<Activity> data = new ArrayList<>();
        if(category == null) {
            data = locations.get(location).getActivities();
        } else {
            data = locations.get(location).getActivities(category);
        }
        return data;
    }
}
