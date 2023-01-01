package com.ronda;

import javax.swing.JFrame;

import main.java.com.ronda.vueRonda.VueRonda;

public class App extends JFrame {

//	private JPanel contentPane;
	public static void main(String[] args) {
		VueRonda vueRonda = new VueRonda();
		vueRonda.action();	
		vueRonda.setVisible(true);

	/**

		ControleurRonda ctr = ControleurRonda.gControleurRonda();
		ArrayList<Carte> liste = ctr.Ctr_GetPaquet().getListe();

		//System.out.println(liste.toString());

	}

	 
	public App() {
m		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		contentPane.add(btnSimple);*/
	}
}
