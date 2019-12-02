package onpu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

public class Graph extends JFrame  {

    private int rand = generateRandomIntIntRange(0,16);
    private JTextField field = new JTextField();
    private JTextArea text = new JTextArea();
    private JLabel label1 = new JLabel("Переведите данное число в двоичную систему счисления: "+ rand+". Приложение запущено: ");
    private JLabel label2 = new JLabel("Правильный ответ: ");
    private JButton button = new JButton("Проверить");
    private JButton button1 = new JButton("Другое число");
    private JPanel panel = new JPanel();
    private Date  date = new Date ();
    private JLabel label3 = new JLabel(date.toString());

    public Graph(){
        super("Application");
        pack();
        this.setBounds(300, 100, 700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();

        container.setLayout(new GridLayout(6, 1));
        panel.add(label1);
        panel.add(label3);
        container.add(panel);
        container.add(field);
        container.add(button);
        container.add(label2);
        container.add(text);
        container.add(button1);
        button.setBackground(Color.WHITE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (field.getText().equals(""))
                    JOptionPane.showMessageDialog((Component) null,"Ошибка! Введите свой вариант ответа!");
                else{
                    text.setText(binar(rand));
                    if (field.getText().equals(text.getText()))
                        button.setBackground(Color.GREEN);
                    else button.setBackground(Color.RED);
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rand = generateRandomIntIntRange(0,16);
                label1.setText("Переведите данное число в двоичную систему счисления: "+ rand);
                text.setText("");
                field.setText("");
                button.setBackground(Color.WHITE);
            }
        });

    }
    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public static String binar(int a){
        int b;
        String temp = "";
        if(a==0)
            return temp =""+0;
        while(a !=0){
            b = a%2;
            temp = b + temp;
            a = a/2;
        }
        return temp;
    }

}
