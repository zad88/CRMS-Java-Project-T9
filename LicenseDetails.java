public class LicenseDetails {
    String licenseNumber;
    String validityPeriod;
    String restrictions;

    public LicenseDetails(String licenseNumber, String validityPeriod, String restrictions) {

        this.licenseNumber = licenseNumber;
        this.validityPeriod = validityPeriod;
        this.restrictions = restrictions;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    @Override
    public String toString() {
        return "LicenseDetails{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", validityPeriod='" + validityPeriod + '\'' +
                ", restrictions='" + restrictions + '\'' +
                '}';
    }
}
