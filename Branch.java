public class Branch {
    private String location;
    private String B_ID;
    public Branch(String location,String B_ID) {
        this.location = location;
        this.B_ID=B_ID;
    }
    public String getLocation() {
        return location;
    }
    public String getB_ID(){
        return B_ID;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "location='" + location + '\'' +
                ", B_ID='" + B_ID + '\'' +
                '}';
    }
}
