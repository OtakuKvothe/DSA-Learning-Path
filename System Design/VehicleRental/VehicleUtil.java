package VehicleRental;

public class VehicleUtil {
    public static VehicleType vehicleTypeFromString(String type) {
        switch(type) {
            case "Sedan":
                return VehicleType.SEDAN;

            case "SUV":
                return VehicleType.SUV;

            case "Hatchback":
                return VehicleType.HATCH;

            default:
                return null;
        }
    }
}
