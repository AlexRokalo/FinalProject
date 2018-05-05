package BusesShedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusSchedule {
    private String name;
    private Date date;
    private List<Bus> schedule = new ArrayList<>();

    public List<Bus> getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Расписание автобусов : " + show();
    }

    private String show() {
        String s = "";
        for (Bus bus : schedule)
            s += bus.toString();
        return s;
    }

    public static class BusScheduleBuilder {
        private BusSchedule busSchedule = new BusSchedule();

        public BusScheduleBuilder setName(String name) {
            busSchedule.name = name;
            return this;
        }

        public BusScheduleBuilder setDate(String date) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
            try {
                busSchedule.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return this;
        }

        public BusScheduleBuilder setSchedule(List<Bus> buses) {
            busSchedule.schedule = buses;
            return this;
        }

        public BusSchedule crate() {
            return busSchedule;
        }

    }
}