package OperationsBase;

import BusesShedule.BusSchedule;
import BusesShedule.MakeSchedule;
import OperationsBase.FindOperation.OperationFind;
import OperationsBase.MenuOperations.OperationChooseSchedule;
import OperationsBase.MenuOperations.OperationClose;
import OperationsBase.MenuOperations.OperationShowShedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operations {
    private static int way;

    private Map<Integer, Operation> operationMap = new HashMap<>();
    private Map<Integer, BusSchedule> busScheduleMap = new HashMap<>();
    private List<BusSchedule> busSchedules = MakeSchedule.getMakeSchedule().getBusScheduleList();

    public Operations() {
    }

    public Operations(int way) {
        this.way = way;
    }

    public void setWay(int way) {
        this.way = way;
    }

    public void getOperationMap(int key) {
        addOperations();
        operationMap.get(key).execute();
    }

    protected BusSchedule getWay() {
        setBusScheduleWay();
        return busScheduleMap.get(way);
    }

    private void setBusScheduleWay() {
        busScheduleMap.put(1, busSchedules.get(0));
        busScheduleMap.put(2, busSchedules.get(1));
    }

    private void addOperations() {
        operationMap.put(0, new OperationClose());
        operationMap.put(1, new OperationShowShedule());
        operationMap.put(2, new OperationFind());
        operationMap.put(3, new OperationChooseSchedule(this));
    }
}