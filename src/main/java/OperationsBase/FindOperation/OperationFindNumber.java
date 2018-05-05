package OperationsBase.FindOperation;

import BusesShedule.Bus;
import OperationsBase.OperationSort;

import java.util.ArrayList;
import java.util.List;

public class OperationFindNumber {
    private OperationSort sort;

    public OperationFindNumber(OperationSort sort) {
        this.sort = sort;
    }

    public void findNumber(List<Bus> buses, int number) {
        List<Bus> tmp = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < buses.size(); i++) {
            Bus bus = buses.get(i);
            if (bus.getBusNumber() == number) {
                tmp.add(bus);
                flag = true;
            }
        }
        sort.sort(tmp);
        if (flag == false) {
            System.out.println("Такого марщрута не существует.");
        }
    }
}