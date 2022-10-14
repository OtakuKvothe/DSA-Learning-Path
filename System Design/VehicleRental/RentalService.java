package VehicleRental;

public interface RentalService {
    public boolean addBranch(String branchName);
    public boolean allocatePrice(String branchName, String vehicleType, Integer price);
    public boolean addVehicle(String vehicleID, String vehicleType, String branchName);
    public boolean bookVehicle(String vehicleType, Integer startTime, Integer endTime);
}
