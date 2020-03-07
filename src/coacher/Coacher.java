package coacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            "5_Queue.txt", "6_PriorityQueue.txt","7_LinkList_Stack.txt","8_LinkListQueue.txt","9_LinkedList.txt",
            "10_Recursion.txt","11_MergeSort.txt","12_BinaryTree.txt","13_HashTable.txt"};
    private String[] sql = {"1 create, insert.txt", "2 select,order.txt", "3 like, where IN.txt", "4 inner join.txt",
            "5 union.txt", "6 функции.txt", "7 группировка и агрегаты.txt", "8 подзапросы.txt",
            "9 внешние соединения.txt", "10 условная логика.txt"};
    private String addressJava = "C:/Users/1/Desktop/ИТ/повторение_IT/задания_Java/";          // часть адреса к файлу
    private String addressAlgorithms = "C:/Users/1/Desktop/ИТ/повторение_IT/задания_Algorithms/";
    private String addressSQL = "C:/Users/1/Desktop/ИТ/повторение_IT/задания_sql/";
    private String address;
    private String task;
    private JTextArea incoming;
    private JPanel panel;
    private JTextField instructionField;
    private JButton javaButton;
    private JButton algButton;
    private JButton sqlButton;
    private JScrollPane scroller;



    public void startCoacher(){

        JFrame frame = new JFrame("Coacher");
        frame.setLocation(870,10);
        panel = new JPanel();
        createInstructionField();
        createButtons();
        javaButton.addActionListener(new JavaButtonListener());
        algButton.addActionListener(new AlgButtonListener());
        sqlButton.addActionListener(new SQLButtonListener());
        createTextArea();
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(500, 740);
        frame.setVisible(true);

    }

    private void createInstructionField() {

        instructionField = new JTextField(43);
        instructionField.setText("Выберите из какой категории будет задание:");
        instructionField.setEditable(false);
        panel.add(instructionField);
    }

    private void createButtons(){

        javaButton = new JButton("java");
        algButton = new JButton("algorithms");
        sqlButton = new JButton("sql");
        panel.add(javaButton);
        panel.add(algButton);
        panel.add(sqlButton);
    }

    public void createTextArea() {

        incoming=new JTextArea(30,40);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        scroller = new JScrollPane(incoming);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroller);
    }

    private class JavaButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            address = addressJava;
            getTitleTask(java);
        }
    }

    private class AlgButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            address = addressAlgorithms;
            getTitleTask(algorithms);
        }
    }

    private class SQLButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            address = addressSQL;
            getTitleTask(sql);
        }
    }

    private void getTitleTask(String[] arrayTasks) {
        int num = (int) (Math.random() * arrayTasks.length);  // получаем рандомное число
        task = arrayTasks[num];                               // используем его для выбора задачи в нашем массиве
        downloadTask();                                       // считываем файл и выводим задачу в incoming
    }

    private void downloadTask() {
        incoming.setText("Выполните задачу: "+task);
        File file = new File(address + task);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String string = null;
            while ((string = reader.readLine()) != null)      // пока есть что считывать
                incoming.append(string+"\n");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}