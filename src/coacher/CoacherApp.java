package coacher;

import java.util.Scanner;

public class CoacherApp {

    public static void main(String[] args) {

        System.out.println("Введите наименование области для поиска задачи (java,alg,sql):");
        String userChoice = getLine();             // вызываем метод для обработки ввода пользователя
        Coacher coach = new Coacher(userChoice);   // создаем объект класса Coacher и передаем строку
        coach.startCoacher();
    }

    private static String getLine() {           // обрабатываем ввод пользователя
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }
}

