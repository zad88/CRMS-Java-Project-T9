public class BookingRecord {
    private Client client;
    private Car car;
    private Agent agent;
    private String startDate;
    private String endDate;
    private double baseCost;
    private String bookingID;

    public BookingRecord(Client client, Car car, Agent agent,
                         String startDate, String endDate, double baseCost, String bookingID) {
        this.client = client;
        this.car = car;
        this.agent = agent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.baseCost = baseCost;
        this.bookingID = bookingID;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public Agent getAgent() {
        return agent;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    @Override
    public String toString() {
        return "BookingRecord{" +
                "client=" + client +
                ", car=" + car +
                ", agent=" + agent +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", baseCost=" + baseCost +
                ", bookingID='" + bookingID + '\'' +
                '}';
    }
}