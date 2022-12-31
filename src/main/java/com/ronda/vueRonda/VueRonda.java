package com.ronda.vueRonda;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import com.ronda.controlRonda.ControleurRonda;
import com.ronda.modelRonda.Carte;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VueRonda extends JFrame implements actionEvent, Runnable{

	private JPanel contentPane = new JPanel();
	private JPanel paneTable = new JPanel();
	private JLabel lblPointsOrdi = new JLabel();//"<html>Ordi points<br>Total carte</html>"
	private JLabel lblPointsJoeur = new JLabel();//"<html>vos points<br>Total carte</html>"
	private JButton btnSource = new JButton();
	private JLabel lblOrdi1 = new JLabel();
	private JLabel lblOrdi2 = new JLabel();
	private JLabel lblOrdi3 = new JLabel();
	private JButton btnJoeur1 = new JButton("joeur1");
	private JButton btnJoeur2 = new JButton("joeur2");
	private JButton btnJoeur3 = new JButton("joeur3");
	private JButton btnSimple = new JButton("Commencer");
	private JButton btnOrdi = new JButton("Cliquer pour ordi joue");
	private Carte carteJouee = new Carte();
	private JLabel lblJouee = new JLabel("JJouee");
	private Carte carteOrdiJouee = new Carte();
	private JLabel lblOrdiJouee = new JLabel("OJouee");
	//private JButton btnComplet = new JButton("Jeu Complet");
	//static boolean jeuComplet = false;
	//static int p_41_J=0;
	//static int p_41_O=0;
	ControleurRonda ctr_Ronda = ControleurRonda.gControleurRonda();
	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int h = (int)dimension.getHeight();
	int w  = (int)dimension.getWidth();
	final int DELAY = 1000;



	public VueRonda() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1500, 800);
		setDefaultLookAndFeelDecorated(true);
		setExtendedState(this.MAXIMIZED_BOTH);
		//contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0));//102,51,10
		setContentPane(contentPane);
		contentPane.setLayout(null);
		paneTable.setLayout(null);
		paneTable.setBackground(new Color(102, 61, 0));


		paneTable.setBounds(0, 0, w, h-230);
		//btnComplet.setBounds(500, 250, 150, 50);
		btnSimple.setBounds(300, 250, 150, 50);
		//paneTable.add(btnComplet);
		btnSimple.setBounds(w/3,h/2,300,100);
		btnSimple.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));

		paneTable.add(btnSimple);
		paneTable.add(lblJouee);
		paneTable.add(lblOrdiJouee);


		//paneTable.setLayout(new GridLayout(3,2));
		contentPane.add(paneTable);
		
		lblOrdi1 = new JLabel();
		lblOrdi1.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
		lblOrdi1.setBounds(5, 645, 65, 100);
		contentPane.add(lblOrdi1);
		//btnOrdi.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
		btnOrdi.setBounds(580, 645, 65, 100);
		//contentPane.add(btnOrdi);
		
		lblOrdi2 = new JLabel();
		lblOrdi2.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
		lblOrdi2.setBounds(75, 645, 65, 100);
		contentPane.add(lblOrdi2);
		
		lblOrdi3 = new JLabel();
		lblOrdi3.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
		lblOrdi3.setBounds(145, 645, 65, 100);
		contentPane.add(lblOrdi3);

		
		btnSource = new JButton("Distribuer");
		btnSource.setBounds(685, 645, 125, 150);
		contentPane.add(btnSource);
		
		btnJoeur1 = new JButton("joeur1");
		btnJoeur1.setBounds(w-385, 645, 125, 150);
		contentPane.add(btnJoeur1);
		
		btnJoeur2 = new JButton("joeur2");
		btnJoeur2.setBounds(w-255, 645, 125, 150);
		contentPane.add(btnJoeur2);
		
		btnJoeur3 = new JButton("joeur3");
		btnJoeur3.setBounds(w-125, 645, 125, 150);
		contentPane.add(btnJoeur3);

		lblPointsOrdi.setBounds(280,645,1000,100);
		lblPointsOrdi.setForeground(new Color(255, 255, 0));
		lblPointsOrdi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblPointsOrdi);

		lblPointsJoeur.setBounds(830,645,1000,100);
		lblPointsJoeur.setForeground(new Color(255, 255, 0));
		lblPointsJoeur.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblPointsJoeur);

		theNotVisible();

	}

	public void verifierGagnant() {
		if(ctr_Ronda.Ctr_Point_Total("j") >=41){
			JOptionPane.showMessageDialog(null, "Ordi points "+  ctr_Ronda.Ctr_Point_Total("o") + 
			"\nVos points " +  ctr_Ronda.Ctr_Point_Total("j") +
			"\n Bravo Vous avez gagné");
			System.exit(0);
		}else if(ctr_Ronda.Ctr_Point_Total("o") >=41){
			JOptionPane.showMessageDialog(null, "Ordi points "+  ctr_Ronda.Ctr_Point_Total("o") + 
			"\nVos points " +  ctr_Ronda.Ctr_Point_Total("j") +
			"\n Malheuresement Vous avez perdu");
			System.exit(0);
		}

	}
	public void score() {
		int c_Joeur=0,c_Ordi=0,p_o =0,p_j=0;
		
		if(ctr_Ronda.Ctr_GetPaquet("p").getListe().size()==0){
			if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==0){
				c_Joeur = ctr_Ronda.Ctr_GetMain("j").getGainCartes().getListe().size();
				c_Ordi = ctr_Ronda.Ctr_GetMain("o").getGainCartes().getListe().size();
				if(ctr_Ronda.Ctr_GetGagnant().equalsIgnoreCase("o")){
					c_Ordi += ctr_Ronda.Ctr_GetPaquet("t").getListe().size();
				}else{
					c_Joeur += ctr_Ronda.Ctr_GetPaquet("t").getListe().size();
				}
				p_j = ctr_Ronda.Ctr_GetMain("j").getPoints();
				p_o = ctr_Ronda.Ctr_GetMain("o").getPoints();

				if(c_Joeur>20){
					int plus = c_Joeur-20;
					p_j += plus;
				}else if(c_Ordi>20){
					int plus = c_Ordi-20;
					p_o += plus;

				}
				verifierGagnant();
				int rep = JOptionPane.showConfirmDialog(null, "Ordi points "+  ctr_Ronda.Ctr_Point_Total("o") + 
				//"\nOrdi Cartes " + c_Ordi +
				"\nVos points " +  ctr_Ronda.Ctr_Point_Total("j") +
				//"\nVos Cartes " + c_Joeur +
				"\nVoulez_vous Continuer?","RONDA",JOptionPane.YES_NO_OPTION );
					ctr_Ronda.Ctr_GetPaquet("t").getListe().clear();
					if(rep == JOptionPane.YES_OPTION){
						theVisible();
					}else{
						System.exit(0);
					}

			}
		}
	}

	public void theNotVisible() {
		lblOrdi1.setVisible(false);
		lblOrdi2.setVisible(false);
		lblOrdi3.setVisible(false);
		btnOrdi.setVisible(false);
		btnJoeur1.setVisible(false);		
		btnJoeur2.setVisible(false);		
		btnJoeur3.setVisible(false);	
		btnSource.setVisible(false);	
		lblPointsJoeur.setVisible(false);
		lblPointsOrdi.setVisible(false);
		//ctr_Ronda.Ctr_GetPaquet("t").getListe().clear();

		changeTableDistribue();
		//paneTable.removeAll();
		//btnComplet.setVisible(true);
		btnSimple.setVisible(true);
//		paneTable.add(btnComplet);
		paneTable.add(btnSimple);
		contentPane.repaint();

	}
	public void theVisible() {

		int pJ = 0;//ctr_Ronda.Ctr_GetMain("j").getPoints();
		int pO = 0;//ctr_Ronda.Ctr_GetMain("o").getPoints();
		int cJ =  0;//ctr_Ronda.Ctr_GetMain("j").getGainCartes().getListe().size();
		int cO =  0;//ctr_Ronda.Ctr_GetMain("o").getGainCartes().getListe().size();
		btnSource.setVisible(true);	
		btnOrdi.setVisible(true);
		lblPointsJoeur.setVisible(true);
		lblPointsOrdi.setVisible(true);
		//btnComplet.setVisible(false);
		btnSimple.setVisible(false);
		changeTableDistribue();
		//p_41_J += pJ;
		//p_41_O += pO;
		lblPointsJoeur.setText("<html>Vos points " + ctr_Ronda.Ctr_Point_Total("j") + "<br>les points de ce partie " + pJ + "<br>Total Carte "+ cJ +" </br><html>");
		lblPointsOrdi.setText("<html>Ordi points " + ctr_Ronda.Ctr_Point_Total("o") + "<br>les points de ce partie " + pO +  "<br>Total Carte "+ cO +" </br><html>");
		contentPane.repaint();

	}
	public ArrayList<Integer> tabDesX() {
		ArrayList<Integer> listeX = new ArrayList<Integer>();/*{{
			add(0);
			add(130);
			add(260);
			add(390);
			add(520);
			add(650);
			add(780);
			add(910);

		}};*/
		
		for(Component c:paneTable.getComponents()){
			if(c instanceof JLabel){
				listeX.add(c.getX());
			}
			
		}
		return listeX;
	}
	public ArrayList<Integer> tabDesY() {
		ArrayList<Integer> listeY = new ArrayList<Integer>();/*{{
			add(0);
			add(160);
			add(320);
			add(480);

		}};*/
		
		for(Component c:paneTable.getComponents()){
			if(c instanceof JLabel){
				listeY.add(c.getY());
			}
			
		}
		return listeY;
	}
	public boolean trouveXLabel(int x){
		for(int i=260;i<1400;i=i+130){
			if(x==i){
				return true;
			}
		}
		return false;

	}
	public boolean trouveYLabel(int y){
		for(int i=20;i<800;i=i+200){
			if(y==i){
				return true;
			}
		}
		return false;

	}
	public void changeTableDistribue() {

		paneTable.removeAll();
		for(Carte carte:ctr_Ronda.Ctr_GetPaquet("t").getListe()){
			int x=carte.getX(),y=carte.getY()-200;
			
			for(int i=260;i<1400;i=i+130){
				int indX = tabDesX().indexOf(i);
				if(indX ==-1){
					x=i;
					break;
				}
			}
			if(carte.getOwner().equalsIgnoreCase("j")){
				y=120;
			}else if(carte.getOwner().equalsIgnoreCase("o")){
				y=320;
			}else{
				
				for(int i=20;i<800;i=i+160){
					int indY = tabDesY().indexOf(y);
					if(indY ==-1){
						y=i;
						break;
					}
				}
			}
			JLabel label = new JLabel();
				label.setIcon(carte.getImage());
				label.setBounds(x,y,125,155);
				carte.setX(x);
				carte.setY(y);
				paneTable.add(label);
		}
		
	}

	public void boujerOrdi(ActionEvent e) {
		
			carteOrdiJouee = ctr_Ronda.Ctr_MeilleurCarteOrdi();
			int x=carteOrdiJouee.getX(),y=carteOrdiJouee.getY();
			/*
			int indX = tabDesX().indexOf(x);
			if(indX !=-1){
				y+=200;
			}
			int indY = tabDesY().indexOf(y);
			if(indY !=-1){
				x+=130;
			}*/
			int indX = ctr_Ronda.Ctr_GetPaquet("t").getListesNumero().indexOf(carteOrdiJouee.getNombre());
			if(indX != -1){
				for(Carte carte:ctr_Ronda.Ctr_GetPaquet("t").getListe()){
					if(carte.getNombre()==carteOrdiJouee.getNombre()){
						x=carte.getX();
						y=carte.getY()-50;
						break;
					}
				}
			}
				lblOrdiJouee.setIcon(carteOrdiJouee.getImage());
				lblOrdiJouee.setBounds(x,y,125,155);
				contentPane.repaint();
				changeTableDistribue();
		}
		public void changeTableOrdi() {
		carteOrdiJouee = ctr_Ronda.Ctr_MeilleurCarteOrdi();
		int x=0,y=0;
		lblOrdiJouee.setIcon(carteOrdiJouee.getImage());
		for(Carte carte:ctr_Ronda.Ctr_GetPaquet("t").getListe()){
			if(carte.getNombre() == carteOrdiJouee.getNombre()){
	
				x=carte.getX();
				y=carte.getY()+100;
				break;
			}		

		}
		lblOrdiJouee.setBounds(x,y,125,155);
		paneTable.add(lblOrdiJouee);
		contentPane.repaint();
		
		new Timer(2*DELAY, this::boujerOrdi).start();
/*
		for(Carte carte:ctr_Ronda.Ctr_GetPaquet("t").getListe()){
			JLabel label = new JLabel();
			if(carte == carteOrdiJouee){
			
			}else{
				label.setIcon(carte.getImage());
				label.setBounds(carte.getX(),carte.getY()-200,125,155);
				paneTable.add(label);
			}
		}*/
//		contentPane.repaint();
	}
    public void bouger(ActionEvent e){
		int x=carteJouee.getX(),y=carteJouee.getY();
/*		int indX = tabDesX().indexOf(x);
		if(indX !=-1){
			y+=200;
		}
		int indY = tabDesY().indexOf(y);
		if(indY !=-1){
			x+=130;
		}*/
		int indX = ctr_Ronda.Ctr_GetPaquet("t").getListesNumero().indexOf(carteJouee.getNombre());
			if(indX != -1){
				for(Carte carte:ctr_Ronda.Ctr_GetPaquet("t").getListe()){
					if(carte.getNombre()==carteJouee.getNombre()){
						x=carte.getX();
						y=carte.getY()-50;
						break;
					}
				}
			}

			lblJouee.setIcon(carteJouee.getImage());
			lblJouee.setBounds(x,y,125,155);
			contentPane.repaint();
			changeTableDistribue();
    }

	public void changeTableJoeur() {
		int x=0,y=0;
		lblJouee.setIcon(carteJouee.getImage());
		for(Carte carte:ctr_Ronda.Ctr_GetPaquet("t").getListe()){
			if(carte.getNombre() == carteJouee.getNombre()){
				x=carte.getX();
				y=carte.getY()+100;
				break;
			}		

		}
		lblJouee.setBounds(x,y,125,155);
		paneTable.add(lblJouee);
		contentPane.repaint();
		 
		new Timer(DELAY, this::bouger).start();
		
	}
	public void dors(ActionEvent e){
		if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==3){
			lblOrdi1.setIcon(null);
		}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==2){
			lblOrdi2.setIcon(null);
		}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==1){
			lblOrdi3.setIcon(null);
		}
	contentPane.repaint();
	}


	public void actionBtn(ActionEvent ev) {
		boolean passe=true;
		Carte carte1 = new Carte();
		Carte carte2 = new Carte();
		Carte carte3 = new Carte();
		//Carte carteJouee = new Carte();
		if (ev.getSource() == btnSource) {
			if(ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().size()==0){
				ctr_Ronda.Ctr_distribuer();
				btnSource.setText("<html>Distribution<br>" + ctr_Ronda.Ctr_GetPaquet("p").getListe().size() + "</html>" );
				carte1 = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(0);
				carte2 = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(1);
				carte3 = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(2);
				btnJoeur1.setIcon(carte1.getImage());
				btnJoeur2.setIcon(carte2.getImage());
				btnJoeur3.setIcon(carte3.getImage());
				btnJoeur1.setVisible(true);
				btnJoeur2.setVisible(true);
				btnJoeur3.setVisible(true);
				lblOrdi1.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));			lblOrdi2.setIcon(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().get(1).getImage());
				lblOrdi2.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
				lblOrdi3.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
				lblOrdi1.setVisible(true);
				lblOrdi2.setVisible(true);
				lblOrdi3.setVisible(true);
				changeTableDistribue();
				//p_41_J += ctr_Ronda.Ctr_GetMain("j").getPoints();
				//p_41_O += ctr_Ronda.Ctr_GetMain("o").getPoints();
				lblPointsJoeur.setText("<html>Vos points "+ ctr_Ronda.Ctr_Point_Total("j") + "<br>les points de ce partie "  + ctr_Ronda.Ctr_GetMain("j").getPoints() + "<br>Total Carte "+ ctr_Ronda.Ctr_GetMain("j").getGainCartes().getListe().size() +" </br><html>");
				lblPointsOrdi.setText("<html>Ordi points "+ ctr_Ronda.Ctr_Point_Total("o") + "<br>les points de ce partie "  + ctr_Ronda.Ctr_GetMain("o").getPoints() +  "<br>Total Carte "+ ctr_Ronda.Ctr_GetMain("o").getGainCartes().getListe().size() +" </br><html>");
				contentPane.repaint();
				score();
				verifierGagnant();
		
			}else{
				JOptionPane.showMessageDialog(null, "Vous avez encore des cartes a jouer");
				passe=false;
			}
		}else  if(ev.getSource()== btnSimple){
			theVisible();
			passe = false;
		}else  if(ev.getSource()== btnOrdi){
			if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==3){
				lblOrdi1.setIcon(null);
			}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==2){
				lblOrdi2.setIcon(null);
			}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==1){
				lblOrdi3.setIcon(null);
			}
			changeTableOrdi();
			ctr_Ronda.Ctr_tourOrdi();

//			changeTableDistribue();
		}else{
		 if (ev.getSource() == btnJoeur1) {
			carteJouee = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(0);
			btnJoeur1.setVisible(false);
			//lblOrdi1.setIcon(null);
		} else if (ev.getSource() == btnJoeur2) {
				if(ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().size()==3){
					carteJouee = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(1);
				}else if(ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().size()==2){
					if(btnJoeur1.isVisible()){
						carteJouee = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(1);
					}else if(btnJoeur3.isDisplayable()){
						carteJouee = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(0);
					}    

				}else{
					carteJouee = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(0);

				}
				btnJoeur2.setVisible(false);
				//lblOrdi2.setIcon(null);

			} else if (ev.getSource() == btnJoeur3) {
				if(ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().size()==3){
					carteJouee = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(2);
				}
				else if(ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().size()==2){
					carteJouee = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(1);
				}
				else{
					carteJouee = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(0);
				}
				btnJoeur3.setVisible(false);
				//lblOrdi3.setIcon(null);
			}
			new Thread(this).start();

		}
/*		if(passe){
			

		}*/

	}

	@Override
	public void action() {
		btnSource.addActionListener(this::actionBtn);;
		btnJoeur1.addActionListener(this::actionBtn);
		btnJoeur2.addActionListener(this::actionBtn);
		btnJoeur3.addActionListener(this::actionBtn);
		//btnComplet.addActionListener(this::actionBtn);
		btnSimple.addActionListener(this::actionBtn);
		btnOrdi.addActionListener(this::actionBtn);
	}

	@Override
	public void run() {
			try {
				changeTableJoeur();
				ctr_Ronda.Ctr_tour(carteJouee);
				Thread.sleep(DELAY);
				if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==3){
					lblOrdi1.setIcon(null);
				}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==2){
					lblOrdi2.setIcon(null);
				}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==1){
					lblOrdi3.setIcon(null);
				}
				changeTableOrdi();
				ctr_Ronda.Ctr_tourOrdi();
				lblPointsJoeur.setText("<html>Vos points "+ ctr_Ronda.Ctr_Point_Total("j") + "<br>les points de ce partie "  + ctr_Ronda.Ctr_GetMain("j").getPoints() + "<br>Total Carte "+ ctr_Ronda.Ctr_GetMain("j").getGainCartes().getListe().size() +" </br><html>");
				lblPointsOrdi.setText("<html>Ordi points "+ ctr_Ronda.Ctr_Point_Total("o") + "<br>les points de ce partie "  + ctr_Ronda.Ctr_GetMain("o").getPoints() +  "<br>Total Carte "+ ctr_Ronda.Ctr_GetMain("o").getGainCartes().getListe().size() +" </br><html>");
				contentPane.repaint();
				score();
				verifierGagnant();
					} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
		
	}


}
