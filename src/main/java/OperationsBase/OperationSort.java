package OperationsBase;

import BusesShedule.Bus;

import java.util.*;

public class OperationSort extends Operations implements AppSkin {

    public void sort(List<Bus> buses) {
        int choies = appSkin();
        if (choies == 1)
            sortByPrice(buses);
        else if (choies == 2)
            sortByTime(buses);
        else if (choies == 3)
            sortByAmountTime(buses);

    }

    public void sortByPrice(List<Bus> buses) {
        Collections.sort(buses, (Bus o1, Bus o2) -> {
            return o1.getPrice() - o2.getPrice();
        });
        buses.forEach(System.out::println);
    }

    public void sortByTime(List<Bus> buses) {
        Collections.sort(buses, (Bus o1, Bus o2) -> {
            return o1.getDateStart().compareTo(o2.getDateStart());
        });
        buses.forEach(System.out::println);
    }

    public void sortByAmountTime(List<Bus> buses) {
        List<Long> timeStart = new ArrayList<>();
        List<Long> timeEnd = new ArrayList<>();
        for (Bus bus : buses) {
            timeStart.add(bus.getDateStart().getTime());
            timeEnd.add(bus.getDateEnd().getTime());
        }
        Collections.sort(buses, new Comparator<Bus>() {
            @Override
            public int compare(Bus o1, Bus o2) {
                int start = 0, end = 0;
                for (int i = 0; i < timeStart.size(); i++) {
                    start += timeStart.get(i);
                    end += timeEnd.get(i);
                }
                return end - start;
            }
        });

        buses.forEach(System.out::println);
    }


    @Override
    public int appSkin() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("1.Показать по цене.");
        System.out.println("2.Показать по времени отправления.");
        System.out.println("3.Показать по количеству времени в пути.");
        choice = scanner.nextInt();
        return choice;
    }
}