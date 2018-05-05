package OperationsBase.MenuOperations;

import BusesShedule.Bus;
import BusesShedule.BusSchedule;
import OperationsBase.AppSkin;
import OperationsBase.Operation;
import OperationsBase.Operations;

import java.util.Collections;
import java.util.Scanner;

public class OperationShowShedule extends Operations implements Operation, AppSkin {

    private void sortByStarLocation(BusSchedule busSchedule) {
        Collections.sort(busSchedule.getSchedule(), (Bus o1, Bus o2) -> {
            if (o1.getLocationStart().equals(o2.getLocationStart()))
                return o1.getWaypoints().get(0).getPlace().compareTo(o2.getWaypoints().get(0).getPlace());
            return o1.getLocationStart().compareTo(o2.getLocationStart());
        });

        System.out.println(busSchedule);
    }

    private void sortByNumber(BusSchedule busSchedule) {
        Collections.sort(busSchedule.getSchedule(), (Bus o1, Bus o2) -> {
            return o1.getBusNumber() - o2.getBusNumber();
        });
        System.out.println(busSchedule);
    }


    @Override
    public void execute() {
        int ansewr = appSkin();
        BusSchedule busSchedule = getWay();
        if (ansewr == 1) {
            sortByNumber(busSchedule);
        } else if (ansewr == 2)
            sortByStarLocation(busSchedule);
        else {
            System.out.println("Вы ошиблись, потоврите ввод!");
            execute();
        }
    }

    @Override
    public int appSkin() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Показать рассписание : \n\t\t" + "1.По номеру маршрута\n\t\t" + "2.По названию точки маршрута" +
                "и остановок.");
        choice = scanner.nextInt();
        return choice;
    }
}