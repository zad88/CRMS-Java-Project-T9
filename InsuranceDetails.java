public class InsuranceDetails {
    private String provider;
    private String coverageOptions;
    private String addOns;
    //Constructor
    public InsuranceDetails(String provider, String coverageOptions, String addOns) {
        this.provider = provider;
        this.coverageOptions = coverageOptions;
        this.addOns = addOns;
    }
    //Getters and Setters
    public String getProvider() {
        return provider;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    public String getCoverageOptions() {
        return coverageOptions;
    }
    public void setCoverageOptions(String coverageOptions) {
        this.coverageOptions = coverageOptions;
    }
    public String getAddOns() {
        return addOns;
    }
    public void setAddOns(String addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        return "InsuranceDetails{" +
                "provider='" + provider + '\'' +
                ", coverageOptions='" + coverageOptions + '\'' +
                ", addOns='" + addOns + '\'' +
                '}';
    }
}
