package VehicleRental;

public class Vehicle implements Bookable {
    private String vehicleID;
    private VehicleType type;
    final Integer SLOTS = 24;

    boolean[] bookings;

    public Vehicle(VehicleType type, String vehicleID) {
        this.type = type;
        this.vehicleID = vehicleID;
        bookings = new boolean[SLOTS];
    }
    public VehicleType getType() {
        return type;
    }
    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getVehicleID() {
        return vehicleID;
    }
    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    @Override
    public boolean book(Integer startTime, Integer endTime) {
        if(isTimeAvailable(startTime, endTime)) {
            for(int i = startTime; i<endTime; i++) {
                bookings[i] = true;
            }
            return true;
        }
        return false;
    }

    private boolean isTimeAvailable(Integer startTime, Integer endTime) {
        for(int i = startTime; i<endTime; i++) {
            if(bookings[i]) return false;
        }
        return true;
    }
}
