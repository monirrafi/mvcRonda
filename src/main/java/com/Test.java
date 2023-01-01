package com;

import javax.swing.border.EmptyBorder;

import com.ronda.vueRonda.actionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends JFrame implements actionEvent{
    private JLabel img = new JLabel(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
    private JLabel img2 = new JLabel(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\1baton.png"));
	private JButton btn = new JButton("clique");
    public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setDefaultLookAndFeelDecorated(true);
//		setExtendedState(this.MAXIMIZED_BOTH);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(102,51,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        img.setBounds(0,0,125,155);
        img2.setBounds(500,0,125,155);
        btn.setBounds(0,400,150,30);

        contentPane.add(img);
        contentPane.add(img2);
        contentPane.add(btn);
    }
    
    public void bouger(ActionEvent e){
        //faire une étape du mouvement
        img.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\baton1.png"));
        //if(lbl.equalsIgnoreCase("img")){
        img.setBounds(50,10,125,155);
        //}

    }
    public void actionBtn(ActionEvent e){
        //faire une étape du mouvement
        if(e.getSource()==btn){
            //System.exit(0);
            
            img.setBounds(10,10,125,155);
            int delay = 2000; // (5 fois par seconde)  
            new Timer(delay, this::bouger).start();

    
           
            
        }
    }

        //......
         
     public static void main(String[] args) {
        Test test = new Test();
        test.action();
        test.setVisible(true);
     }

    @Override
    public void action() {
        btn.addActionListener(this::actionBtn);
      
    }   
    
}
