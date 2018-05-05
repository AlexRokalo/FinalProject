
import OperationsBase.AppSkin;
import OperationsBase.Operations;

import java.util.Scanner;

public class Menu implements AppSkin {
    private Operations operations = new Operations(way());

    public void start()  {
        while (true)
            operations.getOperationMap(appSkin());
    }

    private int way() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("1.Расписание  фирмы GsonBus.");
        System.out.println("2.Расписание  фирмы BigXmlBus.");
        choice = scanner.nextInt();
        return choice;
    }

    @Override
    public int appSkin() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("1.Показать рассписание.");
        System.out.println("2.Поиск.");
        System.out.println("3.Выбрать рассписание.");
        System.out.println("0.Выход.");
        choice = scanner.nextInt();
        return choice;
    }
}