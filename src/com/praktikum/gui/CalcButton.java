package com.praktikum.gui;

import javax.swing.*;
import java.awt.*;

public class CalcButton extends JPanel {
    private JButton nol, satu, dua, tiga, empat, lima, enam, tujuh, delapan, sembilan;
    private JButton plus, kali, min, bagi, hasil, hapus;
    private JButton[] listBtn;
    private CalcInterface calcInterface;
    public CalcButton(){

        satu = new JButton("1");
        dua = new JButton("2");
        tiga = new JButton("3");
        plus = new JButton("+");

        empat = new JButton("4");
        lima = new JButton("5");
        enam = new JButton("6");
        min = new JButton("-");

        tujuh = new JButton("7");
        delapan = new JButton("8");
        sembilan = new JButton("9");
        bagi = new JButton("/");

        hapus = new JButton("C");
        nol = new JButton("0");
        hasil = new JButton("=");
        kali = new JButton("*");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        addCustomBtn(satu, gbc, 0,0);
        addCustomBtn(dua, gbc, 1,0);
        addCustomBtn(tiga, gbc, 2,0);
        addCustomBtn(plus, gbc, 3,0);

        addCustomBtn(empat, gbc, 0,1);
        addCustomBtn(lima, gbc, 1,1);
        addCustomBtn(enam, gbc, 2,1);
        addCustomBtn(min, gbc, 3,1);

        addCustomBtn(tujuh, gbc, 0,2);
        addCustomBtn(delapan, gbc, 1,2);
        addCustomBtn(sembilan, gbc, 2,2);
        addCustomBtn(bagi, gbc, 3,2);

        addCustomBtn(hapus, gbc, 0,3);
        addCustomBtn(nol, gbc, 1,3);
        addCustomBtn(hasil, gbc, 2,3);
        addCustomBtn(kali, gbc, 3,3);


        listBtn = new JButton[]{nol, satu, dua, tiga, empat, lima, enam,
                tujuh, delapan, sembilan,plus, kali, min, bagi, hasil, hapus};

        btnAction();


    }

    private void btnAction(){
        for (JButton i : listBtn){
            i.addActionListener((e) -> {
                this.calcInterface.hasilCalc(i);
            });
        }

    }

    public void setCalcInterface(CalcInterface calcInterface){
        this.calcInterface = calcInterface;
    }

    private void addCustomBtn(JButton btn, GridBagConstraints gbc, int x , int y){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(5,0,0,10);

        btn.setPreferredSize(new Dimension(100, 100));
        btn.setFont(new Font("Arial", Font.BOLD, 40));
        add(btn, gbc);
    }
}
