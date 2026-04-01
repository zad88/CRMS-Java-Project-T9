import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class CarRentalImplementer implements CRMS {
    ArrayList<Car> cars;
    ArrayList<Client> clients;
    ArrayList<Agent> agents;
    ArrayList<BookingRecord> processedBookings;
    int bookingCounter;

    public CarRentalImplementer() {
        cars = new ArrayList<>();
        clients = new ArrayList<>();
        agents = new ArrayList<>();
        processedBookings = new ArrayList<>();
        bookingCounter = 0;
    }

    public ArrayList<Client> getClients() { return clients; }
    public ArrayList<Car> getCars() { return cars; }
    public ArrayList<Agent> getAgents() { return agents; }

    @Override
    public void InitializeRentalSystem(int numClients, int numCars, int numAgents) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < numClients; i++) {

            // Name: non-empty, letters only
            System.out.println("Enter client name:");
            String name = sc.nextLine().trim();
            while (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Name must contain letters only. Try again:");
                name = sc.nextLine().trim();
            }

            String id = "C" + (i + 1);

            // License number: non-empty, numbers only
            System.out.println("Enter license number:");
            String licenseNumber = sc.nextLine().trim();
            while (licenseNumber.isEmpty() || !licenseNumber.matches("\\d+")) {
                System.out.println("Invalid license number. Must contain numbers only. Try again:");
                licenseNumber = sc.nextLine().trim();
            }

            // License expiry: valid format and not expired
            System.out.println("Enter license expiry date (yyyy-MM-dd):");
            String expiry = sc.nextLine().trim();
            while (true) {
                try {
                    LocalDate expiryDate = LocalDate.parse(expiry, fmt);
                    if (expiryDate.isBefore(LocalDate.now())) {
                        System.out.println("License is expired. Enter a valid expiry date (yyyy-MM-dd):");
                        expiry = sc.nextLine().trim();
                    } else {
                        break;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid format. Enter license expiry date (yyyy-MM-dd):");
                    expiry = sc.nextLine().trim();
                }
            }

            System.out.println("Enter license restrictions:");
            String restrictions = sc.nextLine();

            LicenseDetails license = new LicenseDetails(licenseNumber, expiry, restrictions);

            // Address: non-empty and not numbers only
            System.out.println("Enter address:");
            String address = sc.nextLine().trim();
            while (address.isEmpty() || address.matches("\\d+")) {
                System.out.println("Invalid address. Address must be provided and cannot be numbers only. Try again:");
                address = sc.nextLine().trim();
            }

            // Phone: exactly 11 digits
            System.out.println("Enter phone number (must be 11 digits):");
            String phone = sc.nextLine().trim();
            while (!phone.matches("\\d{11}")) {
                System.out.println("Invalid. Phone must be exactly 11 digits. Try again:");
                phone = sc.nextLine().trim();
            }

            // Email: must end with @gmail.com and part before @ must contain client name not numbers only
            System.out.println("Enter email (must include @gmail.com):");
            String email = sc.nextLine().trim();
            while (true) {
                if (!email.endsWith("@gmail.com")) {
                    System.out.println("Invalid. Email must include @gmail.com. Try again:");
                    email = sc.nextLine().trim();
                } else {
                    String beforeAt = email.substring(0, email.indexOf("@"));
                    if (beforeAt.isEmpty() || beforeAt.matches("\\d+")) {
                        System.out.println("Invalid. The part before @gmail.com must include your name, not numbers only. Try again:");
                        email = sc.nextLine().trim();
                    } else {
                        break;
                    }
                }
            }

            ContactDetails contact = new ContactDetails(address, phone, email);
            clients.add(new Client(name, id, license, contact));
        }

        for (int i = 0; i < numCars; i++) {
            Features features = new Features("Petrol", "Automatic", 5, "Sedan");
            InsuranceDetails insurance = new InsuranceDetails("AXA", "Basic", "None");
            cars.add(new Car("CAR" + (i + 1), "Toyota", "White", "100", features, insurance, "Corolla", true));
        }

        for (int i = 0; i < numAgents; i++) {
            Branch branch = new Branch("Cairo", "B" + (i + 1));
            Schedule schedule = new Schedule(8, true);
            agents.add(new Agent("Agent " + (i + 1), "A" + (i + 1), branch, schedule));
        }
    }

    @Override
    public BookingRecord createBooking(Client client, Car car, Agent agent, String startDate, String endDate) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Check license expiry covers through the end date
        LocalDate expiry = LocalDate.parse(client.getLicense().getValidityPeriod(), fmt);
        LocalDate end = LocalDate.parse(endDate, fmt);
        if (expiry.isBefore(end)) {
            System.out.println("Booking rejected. Client license expires before the booking end date.");
            return null;
        }

        // Check agent availability
        if (!agent.getSchedule().isAvailable()) {
            System.out.println("Booking rejected. Agent " + agent.getName() + " is not available.");
            return null;
        }

        // Check car availability
        if (!car.isAvailable()) {
            System.out.println("Booking rejected. Car " + car.getModel() + " is not available.");
            return null;
        }

        LocalDate start = LocalDate.parse(startDate, fmt);
        long days = ChronoUnit.DAYS.between(start, end);

        double pricePerDay = Double.parseDouble(car.getPricePerDay());
        double baseCost = days * pricePerDay;

        bookingCounter++;
        System.out.println("Booking created for " + client.getName() + " | Booking ID: B" + bookingCounter + " | Agent: " + agent.getName() + " | Days: " + days + " | Base Cost: " + baseCost);

        return new BookingRecord(client, car, agent, startDate, endDate, baseCost, "B" + bookingCounter);
    }

    @Override
    public ProcessedRecord process(BookingRecord br) {
        // Check if this booking has already been processed
        if (processedBookings.contains(br)) {
            System.out.println("This booking has already been processed.");
            return null;
        }

        // Insurance selection
        InsuranceOption[] options = {
                new InsuranceOption("Basic", 30),
                new InsuranceOption("Standard", 50),
                new InsuranceOption("Premium", 100)
        };

        System.out.println("Select insurance for " + br.getBookingID() + ":");
        System.out.println("1. Basic - $30");
        System.out.println("2. Standard - $50");
        System.out.println("3. Premium - $100");
        System.out.println("4. No Insurance");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().trim();
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) {
            System.out.println("Invalid choice. Enter 1, 2, 3, or 4:");
            choice = sc.nextLine().trim();
        }

        InsuranceOption selectedInsurance;
        if (choice.equals("4")) {
            selectedInsurance = null;
        } else {
            selectedInsurance = options[Integer.parseInt(choice) - 1];
        }

        // Discount based on number of rental days
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(br.getStartDate(), fmt);
        LocalDate end = LocalDate.parse(br.getEndDate(), fmt);
        long days = ChronoUnit.DAYS.between(start, end);

        Discount discount;
        if (days <= 5) {
            discount = new Discount("No Discount", 0);
        } else if (days > 7 && days < 15) {
            discount = new Discount("10% Discount", 10);
        } else if (days > 15 && days < 30) {
            discount = new Discount("20% Discount", 20);
        } else if (days > 30) {
            discount = new Discount("25% Discount", 25);
        } else {
            discount = new Discount("No Discount", 0);
        }

        ProcessedRecord pr = new ProcessedRecord(br, selectedInsurance, discount);

        // Mark this booking as processed
        processedBookings.add(br);

        String insuranceName = (selectedInsurance != null) ? selectedInsurance.getType() : "None";
        System.out.println("Processed " + br.getBookingID() + " | Insurance: " + insuranceName + " | Discount: " + discount.getPercentage() + "% | Final Cost: " + pr.getFinalCost());

        return pr;
    }

    @Override
    public FinalizedRecord Finalize(ProcessedRecord pr) {
        double totalCost = pr.getFinalCost();
        double deposit = totalCost * 0.3;

        PaymentDetails paymentDetails = new PaymentDetails(deposit, totalCost);
        PickupDetails pickupDetails = new PickupDetails(
                pr.getAgent().getBranch().getLocation(),
                pr.getStartDate(),
                "Bring your license and ID"
        );

        FinalizedRecord fr = new FinalizedRecord(pr, paymentDetails, pickupDetails);

        System.out.println("Finalized: " + fr);

        return fr;
    }
}