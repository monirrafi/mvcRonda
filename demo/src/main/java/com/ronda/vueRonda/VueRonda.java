package com.ronda.vueRonda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueRonda extends JFrame {

	private JPanel contentPane;
	public VueRonda() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1254, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOrdi1 = new JButton("ordi1");
		btnOrdi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrdi1.setBounds(5, 5, 65, 100);
		contentPane.add(btnOrdi1);
		
		JButton btnOrdi2 = new JButton("ordi2");
		btnOrdi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrdi2.setBounds(75, 5, 65, 100);
		contentPane.add(btnOrdi2);
		
		JButton btnOrdi3 = new JButton("ordi3");
		btnOrdi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrdi3.setBounds(145, 5, 65, 100);
		contentPane.add(btnOrdi3);
		
		JButton btnSource = new JButton("source");
		btnSource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSource.setBounds(1150, 200, 65, 100);
		contentPane.add(btnSource);
		
		JButton btnJoeur1 = new JButton("joeur1");
		btnJoeur1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJoeur1.setBounds(5, 485, 65, 100);
		contentPane.add(btnJoeur1);
		
		JButton btnJoeur2 = new JButton("joeur2");
		btnJoeur2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJoeur2.setBounds(75, 485, 65, 100);
		contentPane.add(btnJoeur2);
		
		JButton btnJoeur3 = new JButton("joeur3");
		btnJoeur3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJoeur3.setBounds(145, 485, 65, 100);
		contentPane.add(btnJoeur3);
	}

}
