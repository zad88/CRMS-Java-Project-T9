public class PickupDetails {
    private String branch;
    private String pickupDate;
    private String instructions;

    public PickupDetails(String branch, String pickupDate, String instructions) {
        this.branch = branch;
        this.pickupDate = pickupDate;
        this.instructions = instructions;
    }

    public String getBranch() {
        return branch;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return "PickupDetails{" +
                "branch='" + branch + '\'' +
                ", pickupDate='" + pickupDate + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
