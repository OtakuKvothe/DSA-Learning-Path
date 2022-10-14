package ParkingLot.exceptions;

public class InvalidSlotException extends Exception {
    public InvalidSlotException() {
        super("Given slot is invalid.");
    }
}
