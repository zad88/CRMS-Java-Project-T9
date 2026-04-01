public class InsuranceOption {
    private String type; // e.g., Standard, Premium
    private double cost;

    public InsuranceOption(String type, double cost) {
        this.type = type;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "InsuranceOption{" +
                "type='" + type + '\'' +
                ", cost=" + cost +
                '}';
    }
}
