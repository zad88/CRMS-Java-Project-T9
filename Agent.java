public class Agent {
    private String name;
    private String ID;
    private Branch branch;
    private Schedule schedule;

    public Agent(String name, String ID, Branch branch, Schedule schedule) {
        this.name = name;
        this.ID = ID;
        this.branch = branch;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public Branch getBranch() {
        return branch;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", branch=" + branch +
                ", schedule=" + schedule +
                '}';
    }
}
