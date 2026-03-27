public class Discount {
    private String type;
    private double percentage;

    public Discount(String type, double percentage) {
        this.type = type;
        this.percentage = percentage;
    }

    public String getType() {
        return type;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "type='" + type + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
