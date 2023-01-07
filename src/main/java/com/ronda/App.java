package com.ronda;

import javax.swing.JFrame;

import main.java.com.ronda.vueRonda.VueRonda;

public class App extends JFrame {

	public static void main(String[] args) {
		VueRonda vueRonda = new VueRonda();
		vueRonda.action();	
		vueRonda.setVisible(true);

	}
}
