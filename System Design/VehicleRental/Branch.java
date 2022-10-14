package VehicleRental;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Branch {
    
    private EnumMap<VehicleType, List<Vehicle>> vehicles;
    private EnumMap<VehicleType, Integer> prices;

    public Branch() {
        vehicles = new EnumMap<>(VehicleType.class);
        vehicles.put(VehicleType.SEDAN, new ArrayList<>());
        vehicles.put(VehicleType.SUV, new ArrayList<>());
        vehicles.put(VehicleType.HATCH, new ArrayList<>());
        prices = new EnumMap<>(VehicleType.class);
        prices.put(VehicleType.SEDAN, null);
        prices.put(VehicleType.SUV, null);
        prices.put(VehicleType.HATCH, null);
    }

    public void allocatePrice(VehicleType type, Integer price) {
        prices.put(type, price);
    }

    public void addVehicle(VehicleType type, String id) {
        Vehicle newVehicle = new Vehicle(type, id);
        vehicles.get(type).add(newVehicle);
    }

    public boolean bookVehicle(VehicleType type, Integer startTime, Integer endTime) {
        List<Vehicle> typeVehicles = vehicles.get(type); 
        for(Vehicle vehicle: typeVehicles) {
            if(vehicle.book(startTime, endTime)) {
                return true;
            }
        }
        return false;
    }

    public int getPriceForType(VehicleType type) {
        if(prices.get(type) == null) return -1;
        return prices.get(type);
    }

    public boolean hasVehicleOfType(VehicleType type) {
        return !vehicles.get(type).isEmpty();
    } 
}
