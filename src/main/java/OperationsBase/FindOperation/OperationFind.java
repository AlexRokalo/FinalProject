package OperationsBase.FindOperation;

import BusesShedule.Bus;
import OperationsBase.AppSkin;
import OperationsBase.Operation;
import OperationsBase.OperationSort;
import OperationsBase.Operations;

import java.util.List;
import java.util.Scanner;

public class OperationFind extends Operations implements Operation, AppSkin
{
    private OperationSort operationSort = new OperationSort();

    private void find(List<Bus> buses, int answer) {
        Scanner scanner = new Scanner(System.in);
        if (answer == 1) {
            System.out.println("Ввидите номер автобуса : ");
            new OperationFindNumber(operationSort).findNumber(buses, scanner.nextInt());
        }
        if (answer == 2) {
            System.out.println("Ввидите точку начала отправления автобуса и точку прибытия \n");
            System.out.println("Отправлеие : ");
            String locS = scanner.next();
            System.out.println("Прибытие : ");
            String locE = scanner.next();
            new OperationFindByPoints(operationSort).findByPoints(buses, locS, locE);
        }
    }

    @Override
    public void execute() {
        find(getWay().getSchedule(),appSkin());
    }

    @Override
    public int appSkin() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Поиск :");
        System.out.println("\t\t1.По номеру.");
        System.out.println("\t\t2.По названию точек начала и конца маршрута, учитываю остоновки.");
        choice = scanner.nextInt();
        return choice;
    }
}