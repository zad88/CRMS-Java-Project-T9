import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Tester {
    public static void main(String[] args) {
        CarRentalImplementer system = new CarRentalImplementer();
        system.InitializeRentalSystem(1, 1, 2);

        if (system.getClients().isEmpty()) {
            System.out.println("No clients registered. Exiting.");
            return;
        }

        Client client = system.getClients().get(0);
        Car car = system.getCars().get(0);
        Agent agent1 = system.getAgents().get(0);
        Agent agent2 = system.getAgents().get(1);

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Start date 1: must be today or later
        System.out.println("Enter start date for Booking 1 (yyyy-MM-dd):");
        String startDate1 = sc.nextLine().trim();
        while (true) {
            try {
                LocalDate parsed = LocalDate.parse(startDate1, fmt);
                if (parsed.isBefore(LocalDate.now())) {
                    System.out.println("Start date cannot be in the past. Try again:");
                    startDate1 = sc.nextLine().trim();
                } else {
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Enter start date for Booking 1 (yyyy-MM-dd):");
                startDate1 = sc.nextLine().trim();
            }
        }

        // End date 1: must be after start date
        System.out.println("Enter end date for Booking 1 (yyyy-MM-dd):");
        String endDate1 = sc.nextLine().trim();
        while (true) {
            try {
                LocalDate parsed = LocalDate.parse(endDate1, fmt);
                if (parsed.isAfter(LocalDate.parse(startDate1, fmt))) break;
                System.out.println("End date must be after start date. Try again:");
                endDate1 = sc.nextLine().trim();
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Enter end date for Booking 1 (yyyy-MM-dd):");
                endDate1 = sc.nextLine().trim();
            }
        }

        // Start date 2: must be today or later
        System.out.println("Enter start date for Booking 2 (yyyy-MM-dd):");
        String startDate2 = sc.nextLine().trim();
        while (true) {
            try {
                LocalDate parsed = LocalDate.parse(startDate2, fmt);
                if (parsed.isBefore(LocalDate.now())) {
                    System.out.println("Start date cannot be in the past. Try again:");
                    startDate2 = sc.nextLine().trim();
                } else {
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Enter start date for Booking 2 (yyyy-MM-dd):");
                startDate2 = sc.nextLine().trim();
            }
        }

        // End date 2: must be after start date
        System.out.println("Enter end date for Booking 2 (yyyy-MM-dd):");
        String endDate2 = sc.nextLine().trim();
        while (true) {
            try {
                LocalDate parsed = LocalDate.parse(endDate2, fmt);
                if (parsed.isAfter(LocalDate.parse(startDate2, fmt))) break;
                System.out.println("End date must be after start date. Try again:");
                endDate2 = sc.nextLine().trim();
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Enter end date for Booking 2 (yyyy-MM-dd):");
                endDate2 = sc.nextLine().trim();
            }
        }

        BookingRecord booking1 = system.createBooking(client, car, agent1, startDate1, endDate1);
        BookingRecord booking2 = system.createBooking(client, car, agent2, startDate2, endDate2);

        if (booking1 == null || booking2 == null) {
            System.out.println("One or more bookings could not be created. Exiting.");
            return;
        }

        ProcessedRecord processed1 = system.process(booking1);
        ProcessedRecord processed2 = system.process(booking2);

        if (processed1 == null || processed2 == null) {
            System.out.println("One or more bookings could not be processed. Exiting.");
            return;
        }

        System.out.println("Booking 1 final cost: " + processed1.getFinalCost());
        System.out.println("Booking 2 final cost: " + processed2.getFinalCost());

        ProcessedRecord cheaper;
        if (processed1.getFinalCost() <= processed2.getFinalCost()) {
            System.out.println("Booking 1 is cheaper. Finalizing Booking 1.");
            cheaper = processed1;
        } else {
            System.out.println("Booking 2 is cheaper. Finalizing Booking 2.");
            cheaper = processed2;
        }

        system.Finalize(cheaper);
    }
}