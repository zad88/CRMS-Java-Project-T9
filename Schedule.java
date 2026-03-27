public class Schedule {
    private int WorkingHours;
    public boolean isAvailable(){
        return true;
    }

    public int getWorking_hours() {
        return WorkingHours;
    }

    public void setWorking_hours(int WorkingHours) {
        this.WorkingHours = WorkingHours;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "workingHours=" + WorkingHours +
                '}';
    }
}
