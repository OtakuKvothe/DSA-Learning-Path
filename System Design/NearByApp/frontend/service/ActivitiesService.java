package NearByApp.frontend.service;

import java.util.Collections;
import java.util.List;

import NearByApp.backend.api.ActivityRepositoryService;
import NearByApp.frontend.cache.ActivitiesCache;
import NearByApp.model.Activity;

public class ActivitiesService {
    
    ActivitiesCache cache;
    ActivityRepositoryService service;

    public ActivitiesService() {
        cache = new ActivitiesCache();
        service = new ActivityRepositoryService();
    }

    public List<String> getActivities(String location, String category, boolean incDist, boolean incTime, boolean incRating) {
        List<String> result = cache.getActivities();
        List<Activity> data = category == null ? service.getActivities(location) : service.getActivities(location, category);
        Collections.sort(data, (a, b) -> {
            Activity x = (Activity)a, y = (Activity)b;
            if(x.getDistance() != y.getDistance()) {
                return (incDist ? 1 : -1) * Integer.compare(x.getDistance(), y.getDistance());
            } else if(x.getTime() != y.getTime()) {
                return (incTime ? 1 : -1) * Integer.compare(x.getTime(), y.getTime());
            } else if(x.getRating() != y.getRating()) {
                return (incRating ? 1 : -1) * Integer.compare(x.getRating(), y.getRating());
            }
            return 0;
        });
        List<String> res = data.stream().map(Activity::getString).toList();
        cache.addActivities(res);
        result.addAll(res);
        return result;
    }

    public void addActivity(String name, String location, String category, Integer distance, Integer time, Integer rating) {
        service.addActivity(name, location, category, distance, time, rating);
    }
}
