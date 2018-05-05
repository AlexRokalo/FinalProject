package BusesShedule;

public class Waypoints {
    private String place;

    public Waypoints(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return "\n\t\t" + place;
    }
}