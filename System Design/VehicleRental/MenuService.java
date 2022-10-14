package VehicleRental;

import java.util.Scanner;

public class MenuService {
    private RentalService service;

    public MenuService(RentalService service) {
        this.service = service;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        a: while(true) {
            System.out.println("1. Add Branch\n2. Allocate Price\n3. Add Vehicle\n4. Book Vehicle\n5.Quit");
            int c = sc.nextInt();
            switch(c) {
                case 1:
                    
                    break;
                case 2: 
                case 3:
                case 4:
                default:
                    break a; 
            }
        }
        sc.close();
    }

    private void addBranch(String branchName) {
        if(!service.addBranch(branchName)) {
            print(branchName + " already exists!");
            return;
        }
        print(branchName + " successfully added");
    }

    private void allocatePrice(String branchName, String vehicleType, Integer price) {
        if(!service.allocatePrice(branchName, vehicleType, price)) {
            print("Type or branch name invalid.");
            return;
        }
        print("Successfully Completed!");
    }

    private void addVehicle(String vehicleID, String vehicleType, String branchName) {
        if(!service.addVehicle(vehicleID, vehicleType, branchName)) {
            print("Type or branch name invalid.");
            return;
        }
        print("Successfully Completed!");
    }

    private void bookVehicle(String vehicleType, Integer startTime, Integer endTime) {
        if(!service.bookVehicle(vehicleType, startTime, endTime)) {
            print("Type or branch name invalid.");
            return;
        }
        print("Successfully Completed!");
    }

    private void print(String message) {
        System.out.println(message);
    }
}
