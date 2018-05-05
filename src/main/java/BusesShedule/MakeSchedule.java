package BusesShedule;

import OnlineReadBase.OnlineReadJSON;
import OnlineReadBase.OnlineReadXML;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MakeSchedule {

    private static MakeSchedule makeSchedule;
    private List<BusSchedule> busScheduleList = new ArrayList<>();

    private MakeSchedule() {
        start();
    }

    public List<BusSchedule> getBusScheduleList() {
        return busScheduleList;
    }

    public static MakeSchedule getMakeSchedule() {
        if (makeSchedule == null) {
            makeSchedule = new MakeSchedule();
        }
        return makeSchedule;
    }

    private void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new ReadThread());
        executorService.submit(new ReadThread());
    }

    private class ReadThread implements Runnable {
        @Override
        public void run() {
            try {
                if (busScheduleList.isEmpty()) {
                    synchronized (busScheduleList) {
                        if (busScheduleList.size() == 0) {
                            busScheduleList.add(new OnlineReadJSON().makeSchedule());
                        } else {
                            busScheduleList.add(new OnlineReadXML().makeSchedule());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}