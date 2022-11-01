package NearByApp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Location {
    
    HashMap<String, Set<String>> activitiesByCategory;
    HashMap<String, Activity> activities;

    public Location() {
        activities = new HashMap<>();
        activitiesByCategory = new HashMap<>();
    }
    
    public void addActivity(String name, String category, Integer distance, Integer time, Integer rating) {
        if(activities.containsKey(name)) {
            return;
        }

        Activity newActivity = new Activity(name, category, distance, time, rating);
        activities.put(name, newActivity);
        if(!activitiesByCategory.containsKey(category)) {
            activitiesByCategory.put(category, new HashSet<String>());
        }
        activitiesByCategory.get(category).add(name);
    }

    public List<Activity> getActivities(String category) {
        if(!activitiesByCategory.containsKey(category)) {
            return null;
        }

        List<Activity> result = new ArrayList<>();
        for(String activity: activitiesByCategory.get(category)) {
            result.add(activities.get(activity));
        }

        return result;
    }

    public List<Activity> getActivities() {
        List<Activity> result = new ArrayList<>();
        for(String category: activitiesByCategory.keySet()) {
            result.addAll(getActivities(category));
        }
        return result;
    }

    public void deleteActivity(String name) {
        if(!activities.containsKey(name)) {
            return;
        }
        Activity deleteActivity = activities.get(name);
        activities.remove(name);
        activitiesByCategory.get(deleteActivity.category).remove(deleteActivity.name);
    }
}
