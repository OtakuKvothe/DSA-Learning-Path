package NearByApp.frontend.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ActivitiesCache {
    
    private List<String> cache;
    
    public ActivitiesCache() {
        cache = new ArrayList<>();
    }

    public List<String> getActivities() {
        return cache;
    }

    public void addActivities(List<String> activities) {
        cache = activities;
    }
}
