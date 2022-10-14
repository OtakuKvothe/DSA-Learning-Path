package ParkingLot.exceptions;

public class FloorFilledException extends Exception {
    public FloorFilledException() {
        super("No room on this floor for given type.");
    }
}
