package NearByApp.model;

public class Activity {
    String name;
    String category;
    Integer distance;
    Integer time;
    Integer rating;

    public Activity(String name, String category, Integer distance, Integer time, Integer rating) {
        this.name = name;
        this.category = category;
        this.distance = distance;
        this.time = time;
        this.rating = rating;
    }

    public String getString() {
        return name+", "+category;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getTime() {
        return time;
    }

    public Integer getRating() {
        return rating;
    }

    
}
