public class Car {
    private String licensePlate;
    private String brand;
    private String color;
    private String pricePerDay;
    private Features features;
    private InsuranceDetails insuranceDetails;
    private String Model;

    //Constructor


    public Car(String licensePlate, String brand, String color, String pricePerDay, Features features, InsuranceDetails insuranceDetails, String model) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.color = color;
        this.pricePerDay = pricePerDay;
        this.features = features;
        this.insuranceDetails = insuranceDetails;
        Model = model;
    }
    //Getters and Setters
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public InsuranceDetails getInsuranceDetails() {
        return insuranceDetails;
    }

    public void setInsuranceDetails(InsuranceDetails insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", pricePerDay='" + pricePerDay + '\'' +
                ", features=" + features +
                ", insuranceDetails=" + insuranceDetails +
                ", Model='" + Model + '\'' +
                '}';
    }
}