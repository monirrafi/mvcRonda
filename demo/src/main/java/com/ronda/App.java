package com.ronda;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ronda.controlRonda.ControleurRonda;
import com.ronda.modelRonda.Carte;
import com.ronda.vueRonda.VueRonda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private JPanel contentPane;

	/**
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 */
	public static void main(String[] args) {
		ControleurRonda ctr = ControleurRonda.gControleurRonda();
		ArrayList<Carte> liste = ctr.getInstanceModelRonda().getListePaquet();

		System.out.println(liste.toString());

	}

	/**
	 * Create the frame.
	 */
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 550, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnComplet = new JButton("Complet");
		btnComplet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComplet.setBounds(181, 25, 150, 50);
		contentPane.add(btnComplet);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setBounds(339, 25, 150, 50);
		contentPane.add(btnQuitter);
		
		JButton btnSimple = new JButton("Simple");
		btnSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                VueRonda vueRonda = new VueRonda();
                vueRonda.setVisible(true);
			}
		});
		btnSimple.setBounds(23, 25, 150, 50);
		contentPane.add(btnSimple);
	}
}
