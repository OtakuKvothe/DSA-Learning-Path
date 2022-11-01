package NearByApp.backend.api;

import java.util.ArrayList;
import java.util.List;

import NearByApp.backend.repository.ActivityRepository;
import NearByApp.model.Activity;

public class ActivityRepositoryService {
    
    private ActivityRepository repository;
    private String currentLocation;
    private String currentCategory;
    private List<Activity> currentActivities;

    public ActivityRepositoryService() {
        repository = new ActivityRepository();
        currentActivities = new ArrayList<>();
        currentLocation = null;
        currentCategory = null;
    }

    public void addActivity(String name, String location, String category, Integer distance, Integer time, Integer rating) {
        repository.addActivity(name, location, category, distance, time, rating);
    }

    private List<Activity> getAllActivities(String location) {
        return repository.getActivities(location, null);
    }

    private List<Activity> getActivitiesForCategory(String location, String category) {
        return repository.getActivities(location, category);
    }

    private List<Activity> getNextActivities() {
        List<Activity> result = new ArrayList<>();
        int count = 0;
        while(!currentActivities.isEmpty() && count++ < 10) {
            result.add(currentActivities.get(0));
            currentActivities.remove(0);
        }
        return result;
    }

    public List<Activity> getActivities(String location) {
        if(!currentActivities.isEmpty()) {
            if(!location.equals(currentLocation)) {
                currentActivities = this.getAllActivities(location);
                currentLocation = location;
                currentCategory = null;
            }
        } else {
            currentActivities = this.getActivities(location);
            currentLocation = location;
            currentCategory = null;
        }
        return getNextActivities();
    }

    public List<Activity> getActivities(String location, String category) {
        if(currentActivities.isEmpty() || !currentCategory.equals(category) || !currentLocation.equals(location)) {
            currentActivities = getActivitiesForCategory(location, category);
            currentLocation = location;
            currentCategory = category;
        }
        return getNextActivities();
    }
}
