package ParkingLot.exceptions;

public class NoSuchTypeException extends Exception {
    public NoSuchTypeException() {
        super("No such type exists");
    }
}
