package com.ronda.vueRonda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ronda.controlRonda.ControleurRonda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueRonda extends JFrame implements actionEvent{

	private JPanel contentPane;
	private JButton btnSource = new JButton();
	private JButton btnOrdi1 = new JButton("ordi1");
	private JButton btnOrdi2 = new JButton("ordi2");
	private JButton btnOrdi3 = new JButton("ordi3");
	private JButton btnJoeur1 = new JButton("joeur1");
	private JButton btnJoeur2 = new JButton("joeur2");
	private JButton btnJoeur3 = new JButton("joeur3");
	ControleurRonda ctr_Ronda = ControleurRonda.gControleurRonda();



	public VueRonda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1254, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOrdi1 = new JButton("ordi1");
		btnOrdi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrdi1.setBounds(5, 5, 65, 100);
		contentPane.add(btnOrdi1);
		
		btnOrdi2 = new JButton("ordi2");
		btnOrdi2.setBounds(75, 5, 65, 100);
		contentPane.add(btnOrdi2);
		
		btnOrdi3 = new JButton("ordi3");
		btnOrdi3.setBounds(145, 5, 65, 100);
		contentPane.add(btnOrdi3);
		
		btnSource = new JButton("Distribuer");
		btnSource.setBounds(1150, 200, 65, 100);
		contentPane.add(btnSource);
		
		btnJoeur1 = new JButton("joeur1");
		btnJoeur1.setBounds(5, 485, 65, 100);
		contentPane.add(btnJoeur1);
		
		btnJoeur2 = new JButton("joeur2");
		btnJoeur2.setBounds(75, 485, 65, 100);
		contentPane.add(btnJoeur2);
		
		btnJoeur3 = new JButton("joeur3");
		btnJoeur3.setBounds(145, 485, 65, 100);
		contentPane.add(btnJoeur3);
	}
	public void actionBtn(ActionEvent ev) {
		if (ev.getSource() == btnSource) {

		} else if (ev.getSource() == btnOrdi1) {

		} else if (ev.getSource() == btnOrdi2) {

		} else if (ev.getSource() == btnOrdi3) {

		}else if (ev.getSource() == btnJoeur1) {

		} else if (ev.getSource() == btnJoeur2) {

		} else if (ev.getSource() == btnJoeur3) {

		}
	}

	@Override
	public void action() {
		btnSource.addActionListener(this::actionBtn);;
		btnJoeur1.addActionListener(this::actionBtn);
		btnJoeur2.addActionListener(this::actionBtn);
		btnJoeur3.addActionListener(this::actionBtn);
	}

}
