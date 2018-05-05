package OperationsBase.MenuOperations;

import OperationsBase.Operation;
import OperationsBase.Operations;

import java.util.Scanner;

public class OperationChooseSchedule implements Operation {
    private Operations operations;

    public OperationChooseSchedule(Operations operations) {
        this.operations = operations;
    }

    @Override
    public void execute() {
        operations.setWay(way());
    }

    private int way() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("1.GsonBus.");
        System.out.println("2.BigXmlBus");
        choice = scanner.nextInt();
        return choice;
    }
}