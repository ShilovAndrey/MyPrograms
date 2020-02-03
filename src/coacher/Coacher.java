package coacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Coacher {
    // переменные с наименованиями файлов по направлениям
    private String[] java = {"запись_извлечение_текста.txt", "многопоточность.txt", "подписка на событие.txt",
            "рекурсия.txt", "сериализация.txt", "создание массива.txt", "выбор_задания.txt",
            "сортировка книг.txt", "подключение к JDBC.txt"};
    private String[] algorithms = {"1_OrderedArray.txt", "2_ClassDataApp.txt", "3_StackApp.txt", "4_BracketsApp.txt",
            "5_Queue.txt", "6_PriorityQueue.txt"};
    private String[] sql = {"1 create, insert.txt", "2 select,order.txt", "3 like, where IN.txt", "4 inner join.txt",
            "5 union.txt", "6 функции.txt", "7 группировка и агрегаты.txt", "8 подзапросы.txt",
            "9 внешние соединения.txt", "10 условная логика.txt"};
    private String adressJava = "повторение_IT/задания_Java/";              // часть адреса к файлу
    private String adressAlgorithms = "повторение_IT/задания_Algorithms/";
    private String adressSQL = "повторение_IT/задания_sql/";
    private String adress;
    private String task;


    private String line;

    public Coacher(String inputLine) {                             // конструктор
        line = inputLine;                                          // получаем пользовательский ввод
    }

    public void startCoacher() {
        if (line.equalsIgnoreCase("java")) {          // обрабатываем пользовательский ввод
            adress = adressJava;                                   //  сохраняем в переменную часть адреса,
            // зависимости от того, какую тему хочет повторить пользователь
            getTitleTask(java);                    // передаем ссылку на массив с заданиями по выбранной теме
        } else if (line.equalsIgnoreCase("sql")) {
            adress = adressSQL;
            getTitleTask(sql);
        } else if (line.equalsIgnoreCase("alg")) {
            adress = adressAlgorithms;
            getTitleTask(algorithms);
        }
    }

    private void getTitleTask(String[] arrayTasks) {
        int num = (int) (Math.random() * arrayTasks.length);  // получаем рандомное число
        task = arrayTasks[num];                               // используем его для выбора задачи в нашем массиве
        System.out.println("выполни задание " + task + " ");
        downloadTask();                                       // считываем файл и выводим задачу на экран
    }

    private void downloadTask() {
        File file = new File(adress + task);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String string = null;
            while ((string = reader.readLine()) != null)  // пока есть что считывать
                System.out.println(string);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
