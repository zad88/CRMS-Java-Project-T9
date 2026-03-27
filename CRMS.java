public interface CRMS {
    void InitializeRentalSystem(int numClients, int numCars, int numAgents);

    BookingRecord createBooking(Client client, Car car, Agent agent, String startDate, String endDate);

    ProcessedRecord process(BookingRecord br);

    FinalizedRecord Finalize(ProcessedRecord pr);
}
