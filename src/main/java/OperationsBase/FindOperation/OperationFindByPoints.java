package OperationsBase.FindOperation;

import BusesShedule.Bus;
import OperationsBase.OperationSort;

import java.util.ArrayList;
import java.util.List;

public class OperationFindByPoints {
    private OperationSort sort;

    public OperationFindByPoints(OperationSort sort) {
        this.sort = sort;
    }

    public void findByPoints(List<Bus> buses, String locationStart, String locationEnd) {
        boolean flag = false;
        List<Bus> tmp = new ArrayList<>();
        for (int i = 0; i < buses.size(); i++) {
            Bus bus = buses.get(i);
            if (bus.getLocationStart().equals(locationStart)) {
                if (bus.getLocationEnd().equals(locationEnd)) {
                    tmp.add(bus);
                    flag = true;
                }
            }
        }

        sort.sort(tmp);
        if (flag == false) {
            System.out.println("Такого атобуса не существует.");
        }
    }
}