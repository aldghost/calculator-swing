package com.praktikum.gui;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainFrame extends JFrame{
    private JTextField fieldAngka;
    private CalcButton calcButton;
    private double prev, next, hasil;
    private char op;
    public MainFrame(){
        init();
        changeFeature();
        layoutSetting();
    }

    public void init(){
        setTitle("Calculator Praktikum Aldin Gans");
        setSize(500,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        calcButton = new CalcButton();


        calcButton.setCalcInterface((e) -> {

            if(e.getText().equals("C")){
                fieldAngka.setText("");
                prev = 0;
                next = 0;
                hasil = 0;
                return;
            }

            fieldAngka.setText(fieldAngka.getText()+e.getText());
            Pattern pattern = Pattern.compile("(^[+/*])|[+\\-/*][+\\-/*]+");
            Matcher matcher = pattern.matcher(fieldAngka.getText());

            if(matcher.find()){
                JOptionPane.showMessageDialog(calcButton, "Masukan operator setelah angka");
                fieldAngka.setText(fieldAngka.getText().substring(0, fieldAngka.getText().length() -1));
            }

            pattern = Pattern.compile("^([\\.\\-0-9]+)([+\\-/*])([0-9]+)([+\\-/*=])$");
            matcher = pattern.matcher(fieldAngka.getText());

            if(matcher.find()){
                prev = Double.parseDouble(matcher.group(1));
                op = matcher.group(2).charAt(0);
                next = Double.parseDouble(matcher.group(3));

                if(op == '+')
                    hasil = prev + next;
                else if(op == '-')
                    hasil = prev - next;
                else if(op == '/')
                    hasil = prev / next;
                else if (op == '*')
                    hasil = prev * next;

                op = matcher.group(4).charAt(0);

                if ((hasil == Math.floor(hasil )) && !Double.isInfinite(hasil)) {
                    fieldAngka.setText((int)(hasil)+""+op);
                } else fieldAngka.setText(hasil +""+op);

            }

            if(e.getText().equals("=")){
                fieldAngka.setText(fieldAngka.getText().substring(0, fieldAngka.getText().length() -1));
                prev = 0;
                next = 0;
                hasil = 0;
                op = 0;
            }
        });
    }
    public void changeFeature(){
        fieldAngka = new JTextField(20);
        fieldAngka.setHorizontalAlignment(JTextField.RIGHT);
        Font font = new Font("Arial", Font.BOLD, 40);
        fieldAngka.setFont(font);
        fieldAngka.setEditable(false);
        fieldAngka.setBackground(new Color(255, 255, 255, 255));
        fieldAngka.setPreferredSize(new Dimension(100,100));
    }
    public void layoutSetting(){
        setLayout(new BorderLayout());
        add(fieldAngka, BorderLayout.NORTH);
        add(calcButton, BorderLayout.CENTER);
    }
}
