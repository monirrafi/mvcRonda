package com.ronda.vueRonda;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import com.ronda.controlRonda.ControleurRonda;
import com.ronda.modelRonda.Carte;
import com.ronda.vueRonda.actionEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VueRonda extends JFrame implements actionEvent, Runnable{


/*============================================================================================================
 * 						Declaration
 *============================================================================================================ 						
 */

	private JPanel contentPane = new JPanel();
	private JPanel paneTable = new JPanel();
	private JLabel lblPointsOrdi = new JLabel();
	private JLabel lblPointsJoeur = new JLabel();
	private JLabel lblPointsOrdiTop = new JLabel();
	private JLabel lblPointsJoeurTop = new JLabel();
	private JButton btnCommencer = new JButton();
	private JLabel lblOrdi1 = new JLabel();
	private JLabel lblOrdi2 = new JLabel();
	private JLabel lblOrdi3 = new JLabel();
	private JButton btnJoeur1 = new JButton("joeur1");
	private JButton btnJoeur2 = new JButton("joeur2");
	private JButton btnJoeur3 = new JButton("joeur3");
	private JButton btnSimple = new JButton("Commencer");
	private JButton btnRecommanecer = new JButton("Recommencer");
	private JButton btnOrdi = new JButton("Cliquer pour ordi joue");
	private Carte carteJouee = new Carte();
	private JLabel lblJouee = new JLabel("JJouee");
	private Carte carteOrdiJouee = new Carte();
	private JLabel lblOrdiJouee = new JLabel("OJouee");
	private String aQuileTour = "j";
	JLabel lblFond = new JLabel(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\fondImage.jpg"));
	ControleurRonda ctr_Ronda = ControleurRonda.gControleurRonda();
	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int h = (int)dimension.getHeight();
	int w  = (int)dimension.getWidth();
	final int DELAY = 200;
	final int H = 155;
	final int W =125;


/*============================================================================================================
 * 						Consctructeur
 *============================================================================================================ 						
 */

	public VueRonda() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1500, 800);
		setDefaultLookAndFeelDecorated(true);
		setExtendedState(this.MAXIMIZED_BOTH);
		//contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(102,51,10));//102,51,10
		setContentPane(contentPane);
		contentPane.setLayout(null);
		paneTable.setLayout(null);
		paneTable.setBackground(new Color(0, 102, 0));

		lblFond.setBounds(0,0,  1500, 800);
		//paneTable.add(lblFond);

		paneTable.setBounds(0, 0, w, h);
		//btnComplet.setBounds(500, 250, 150, 50);
		//btnSimple.setBounds(300, 250, 150, 50);
		//paneTable.add(btnComplet);
		btnSimple.setBounds(w/(3),h-140,300,50);
		btnSimple.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));

		paneTable.add(btnSimple);
		paneTable.add(lblJouee);
		paneTable.add(lblOrdiJouee);


		//paneTable.setLayout(new GridLayout(3,2));
		contentPane.add(paneTable);
		
		lblOrdi1 = new JLabel();
		lblOrdi1.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
		lblOrdi1.setBounds(5, 645, W, H);
		contentPane.add(lblOrdi1);
		//btnOrdi.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
		btnOrdi.setBounds(580, 645, 125, 100);
		//contentPane.add(btnOrdi);
		
		lblOrdi2 = new JLabel();
		lblOrdi2.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
		lblOrdi2.setBounds(130, 645, W, H);
		contentPane.add(lblOrdi2);
		
		lblOrdi3 = new JLabel();
		lblOrdi3.setIcon(new ImageIcon("src\\main\\java\\com\\ronda\\rondaImages\\dos.png"));
		lblOrdi3.setBounds(260, 645,  W, H);
		contentPane.add(lblOrdi3);


		btnRecommanecer.setBounds(695, 680+(H-30), W, 20);
		contentPane.add(btnRecommanecer);

		btnCommencer = new JButton("Distribuer");
		btnCommencer.setBounds(695, 680,  W, H-30);
		contentPane.add(btnCommencer);
		
		btnJoeur1 = new JButton("joeur1");
		btnJoeur1.setBounds(w-385, 680,  W, H);
		contentPane.add(btnJoeur1);
		
		btnJoeur2 = new JButton("joeur2");
		btnJoeur2.setBounds(w-255, 680,  W, H);
		contentPane.add(btnJoeur2);
		
		btnJoeur3 = new JButton("joeur3");
		btnJoeur3.setBounds(w-125, 680,  W, H);
		contentPane.add(btnJoeur3);

		lblPointsOrdi.setBounds(510, 645,1000,100);
		lblPointsOrdi.setForeground(new Color(255, 255, 0));
		lblPointsOrdi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblPointsOrdi);

		lblPointsJoeur.setBounds(830,645,1000,100);
		lblPointsJoeur.setForeground(new Color(255, 255, 0));
		lblPointsJoeur.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblPointsJoeur);

		lblPointsOrdiTop.setBounds(0,0,1000,50);
		lblPointsOrdiTop.setForeground(new Color(255, 255, 0));
		lblPointsOrdiTop.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblPointsOrdiTop);

		lblPointsJoeurTop.setBounds(990,0,1000,50);
		lblPointsJoeurTop.setForeground(new Color(255, 255, 0));
		lblPointsJoeurTop.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblPointsJoeurTop);

		theNotVisible();

	}
/*============================================================================================================
 * 						Fonctions
 *============================================================================================================ 						
 */

	public void verifierGagnant() {
		if(ctr_Ronda.Ctr_Point_Total("j") >=41){
			JOptionPane.showMessageDialog(null, "Ordi points "+  ctr_Ronda.Ctr_Point_Total("o") + 
			"\nVos points " +  ctr_Ronda.Ctr_Point_Total("j") +
			"\n Bravo Vous avez gagné");
			initial();
		}else if(ctr_Ronda.Ctr_Point_Total("o") >=41){
			JOptionPane.showMessageDialog(null, "Ordi points "+  ctr_Ronda.Ctr_Point_Total("o") + 
			"\nVos points " +  ctr_Ronda.Ctr_Point_Total("j") +
			"\n Malheuresement Vous avez perdu");
			initial();
		}

	}
	public void score() {
		int c_Joeur=0,c_Ordi=0,p_o =0,p_j=0;
		
		if(ctr_Ronda.Ctr_GetPaquet("p").getListe().size()==0){
			if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==0 || ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().size()==0){
				c_Joeur = ctr_Ronda.Ctr_GetMain("j").getGainCartes().getListe().size();
				c_Ordi = ctr_Ronda.Ctr_GetMain("o").getGainCartes().getListe().size();
				if(ctr_Ronda.Ctr_GetGagnant().equalsIgnoreCase("o")){
					c_Ordi += ctr_Ronda.Ctr_GetPaquet("t").getListe().size();
				}
				if(ctr_Ronda.Ctr_GetGagnant().equalsIgnoreCase("j")){
					c_Joeur += ctr_Ronda.Ctr_GetPaquet("t").getListe().size();
				}
				p_j = ctr_Ronda.Ctr_GetMain("j").getPoints();
				p_o = ctr_Ronda.Ctr_GetMain("o").getPoints();

				if(c_Joeur>20){
					int plus = c_Joeur-20;
					p_j += plus;
					ctr_Ronda.Ctr_Set_Au_PT("j", plus);
				}else if(c_Ordi>20){
					int plus = c_Ordi-20;
					p_o += plus;
					ctr_Ronda.Ctr_Set_Au_PT("o", plus);

				}

				paneTable.removeAll();
				lblPointsJoeur.setText("<html>Vos points " + ctr_Ronda.Ctr_Point_Total("j")+"<html>");
				lblPointsOrdi.setText("<html>Ordi points " + ctr_Ronda.Ctr_Point_Total("o") + "<html>");
				lblPointsJoeurTop.setText("<html>Vos points de la partie " + p_j + "&emsp;&emsp;Vos Cartes "+ c_Joeur + "</html>");
				lblPointsOrdiTop.setText("<html>Ordi points de la partie " + p_o +  "&emsp;&emsp;Ordi Cartes "+ c_Ordi+ "</html>");
				contentPane.repaint();
				verifierGagnant();
				int rep = JOptionPane.showConfirmDialog(null, "Ordi points "+  ctr_Ronda.Ctr_Point_Total("o") + 
				"\nVos points " +  ctr_Ronda.Ctr_Point_Total("j") +
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
	public void initial() {
		paneTable.removeAll();
		paneTable.setBounds(0, 0, w, h-230);
		int pJ = 0,pO = 0,cJ =  0,cO =  0;
		ctr_Ronda.Ctr_Initial_PT();
		lblOrdi1.setVisible(false);
		lblOrdi2.setVisible(false);
		lblOrdi3.setVisible(false);
		btnOrdi.setVisible(false);
		btnJoeur1.setVisible(false);		
		btnJoeur2.setVisible(false);		
		btnJoeur3.setVisible(false);	
		btnCommencer.setVisible(true);
		btnCommencer.setText("<html>Cilquer pour distribuer<br> Cartes restantes<br>" + ctr_Ronda.Ctr_GetPaquet("p").getListe().size() + "</html>" );
		lblPointsJoeur.setVisible(true);
		lblPointsOrdi.setVisible(true);
		lblPointsJoeurTop.setVisible(true);
		lblPointsOrdiTop.setVisible(true);
		btnRecommanecer.setVisible(true);
		btnSimple.setVisible(false);
		lblPointsJoeur.setText("<html>Vos points " + ctr_Ronda.Ctr_Point_Total("j") + "<html>");
		lblPointsOrdi.setText("<html>Ordi points " + ctr_Ronda.Ctr_Point_Total("o") + "<html>");
		lblPointsJoeurTop.setText("<html>Vos points de la partie " + pJ + "&emsp;&emsp;Vos Cartes "+ cJ +"</html>");
		lblPointsOrdiTop.setText("<html>Ordi points de la partie " + pO +  "&emsp;&emsp;Ordi Cartes "+ cO+ "</html>");
		contentPane.repaint();

	}

	public void theNotVisible() {
		lblOrdi1.setVisible(false);
		lblOrdi2.setVisible(false);
		lblOrdi3.setVisible(false);
		btnOrdi.setVisible(false);
		btnJoeur1.setVisible(false);		
		btnJoeur2.setVisible(false);		
		btnJoeur3.setVisible(false);	
		btnCommencer.setVisible(false);	
		lblPointsJoeur.setVisible(false);
		lblPointsOrdi.setVisible(false);
		lblPointsJoeurTop.setVisible(false);
		lblPointsOrdiTop.setVisible(false);

		btnRecommanecer.setVisible(false);
		changeTableDistribue();
		btnSimple.setVisible(true);
		paneTable.add(btnSimple);
		paneTable.add(lblFond);
		contentPane.repaint();

	}
	public void theVisible() {
		paneTable.setBounds(0, 50, w, h-280);
		int pJ = 0,pO = 0,cJ =  0,cO =  0;
		btnCommencer.setVisible(true);	
		btnOrdi.setVisible(true);
		lblPointsJoeur.setVisible(true);
		lblPointsOrdi.setVisible(true);
		lblPointsJoeurTop.setVisible(true);
		lblPointsOrdiTop.setVisible(true);
		btnRecommanecer.setVisible(true);
		btnSimple.setVisible(false);
		changeTableDistribue();
		lblPointsJoeur.setText("<html>Vos points " + ctr_Ronda.Ctr_Point_Total("j") + "<html>");
		lblPointsOrdi.setText("<html>Ordi points " + ctr_Ronda.Ctr_Point_Total("o") + "<html>");
		lblPointsJoeurTop.setText("<html>Vos points de la partie " + pJ + "&emsp;&emsp;Vos Cartes "+ cJ +" <html>");
		lblPointsOrdiTop.setText("<html>Ordi points de la partie " + pO +  "&emsp;&emsp;Ordi Cartes "+ cO +" <html>");
		contentPane.repaint();

	}
	public ArrayList<Integer> tabDesX() {
		ArrayList<Integer> listeX = new ArrayList<Integer>();
		for(Component c:paneTable.getComponents()){
			if(c instanceof JLabel){
				listeX.add(c.getX());
			}
			
		}
		return listeX;
	}
	public ArrayList<Integer> tabDesY() {
		ArrayList<Integer> listeY = new ArrayList<Integer>();
		
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

	public void boujerOrdi() {
			int x=carteOrdiJouee.getX(),y=carteOrdiJouee.getY();
			if(lblOrdiJouee.getX() !=0){
					ArrayList<Carte> suiteListe = new ArrayList<Carte>();
					for(int i=0;i<ctr_Ronda.Ctr_GetPaquet("t").getListe().size()-1;i++){
						if(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i).getNombre()==carteOrdiJouee.getNombre()){
							if(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i).getNombre()==7){
								if(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i+1).getNombre()-ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i).getNombre()==3){
									suiteListe.add(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i+1));
								}
							}else{
								if(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i+1).getNombre()-ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i).getNombre()==1){
									suiteListe.add(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i+1));
								}
	
							}
						}
					}

				for(Component c:paneTable.getComponents()){
					if(c instanceof JLabel){
						if(c.getX() == carteOrdiJouee.getX()){
							paneTable.remove(c);
							paneTable.remove(lblOrdiJouee);

						}
						if(suiteListe.size()!=0){	
							for(Carte carte:suiteListe){
								if(c.getX() == carte.getX()){
									paneTable.remove(c);
		
								}
							}
						}	
					}
					
				}
			 contentPane.repaint();
			}else{
				lblOrdiJouee.setIcon(carteOrdiJouee.getImage());
				lblOrdiJouee.setBounds(x,y,125,155);
				contentPane.repaint();
			}
		}
		public void lblOrdiShow(){
			if(ctr_Ronda.Ctr_MeilleurCarteOrdi() != null){
				carteOrdiJouee = ctr_Ronda.Ctr_MeilleurCarteOrdi();
				if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==3){
					lblOrdi1.setIcon(carteOrdiJouee.getImage());
				}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==2){
					lblOrdi2.setIcon(carteOrdiJouee.getImage());
				}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==1){
					lblOrdi3.setIcon(carteOrdiJouee.getImage());
				}
			}
	
		}
		public void changeTableOrdi() {
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
		carteOrdiJouee.setX(x);
		carteOrdiJouee.setY(y);
		paneTable.add(lblOrdiJouee);
		if(x!=0){
			ArrayList<Carte> suiteListe = ramasser(carteJouee);
			if(suiteListe.size()!=0){
				for(Component c:paneTable.getComponents()){
					if(c instanceof JLabel){
							for(Carte carte:suiteListe){
								y+=20;
								if(c.getX() == carte.getX()){
									c.setBounds(x,y,125,155);
									carte.setX(x);
									carte.setY(y);
							
								}
							}
					}
					
				}
	   		}
		}

		contentPane.repaint();
		
	}
	public ArrayList<Carte> ramasser(Carte carte) {
		Collections.sort(ctr_Ronda.Ctr_GetPaquet("t").getListe());
		ArrayList<Carte> suiteListe = new ArrayList<Carte>();
		int existe = ctr_Ronda.Ctr_GetPaquet("t").getListesNumero().indexOf(carte.getNombre());
		if(existe != -1){
			int current = ctr_Ronda.Ctr_GetPaquet("t").getListesNumero().get(existe);
		for(int i=0;i<ctr_Ronda.Ctr_GetPaquet("t").getListe().size()-1;i++){
			if(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i).getNombre()== current){
				if(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i).getNombre()==7){
					if(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i+1).getNombre()-ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i).getNombre()==3){
						suiteListe.add(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i+1));
						current+=3;

					}
				}else{
					if(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i+1).getNombre()-ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i).getNombre()==1){
						suiteListe.add(ctr_Ronda.Ctr_GetPaquet("t").getListe().get(i+1));
						current+=1;
					}

				}
			}
		}
	}
	
		return suiteListe;
}
    public void bouger(){//ActionEvent e
		int x=carteJouee.getX(),y=carteJouee.getY();
		if(lblJouee.getX()!=1400){
			
			ArrayList<Carte> suiteListe = ramasser(carteJouee);

				for(Component c:paneTable.getComponents()){
					if(c instanceof JLabel){
						if(c.getX() == carteJouee.getX()){
							paneTable.remove(c);
							paneTable.remove(lblJouee);

						}
						if(suiteListe.size()!=0){	
							for(Carte carte:suiteListe){
								if(c.getX() == carte.getX()){
									paneTable.remove(c);
		
								}
							}
						}	
					}
					
				}
			 contentPane.repaint();
			}else{
			lblJouee.setBounds(x,y,125,155);
			contentPane.repaint();
			}
    }

	public void changeTableJoeur() {
		int x=1400,y=0;
		lblJouee.setIcon(carteJouee.getImage());
		for(Carte carte:ctr_Ronda.Ctr_GetPaquet("t").getListe()){
			if(carte.getNombre() == carteJouee.getNombre()){
				x=carte.getX();
				y=carte.getY()+100;
				break;
			}		

		}
		lblJouee.setBounds(x,y,125,155);
		carteJouee.setX(x);
		carteJouee.setY(y);
		paneTable.add(lblJouee);

		if(x!=1400){
			ArrayList<Carte> suiteListe = ramasser(carteJouee);
			if(suiteListe.size()!=0){
				for(Component c:paneTable.getComponents()){
					if(c instanceof JLabel){
							for(Carte carte:suiteListe){
								y+=20;
								if(c.getX() == carte.getX()){
									c.setBounds(x,y,125,155);
									carte.setX(x);
									carte.setY(y);
							
								}
							}
					}
					
				}
	   		}
		}

		contentPane.repaint();
		
	}

/*============================================================================================================
 * 						ActionListener
 *============================================================================================================ 						
 */

	public void actionBtn(ActionEvent ev) {
		
		Carte carte1 = new Carte();
		Carte carte2 = new Carte();
		Carte carte3 = new Carte();
		//Carte carteJouee = new Carte();
		if (ev.getSource() == btnCommencer) {
			if(ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().size()==0){
/*				if(JOptionPane.showConfirmDialog(null,"Est ce que vous allez commencer?")==JOptionPane.YES_OPTION){
					aQuileTour = "j";
				}else{
					aQuileTour = "o";

				}*/
				ctr_Ronda.Ctr_distribuer();
				btnCommencer.setText("<html>Cilquer pour distribuer<br> Cartes restantes<br>" + ctr_Ronda.Ctr_GetPaquet("p").getListe().size() + "</html>" );
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
				lblPointsJoeur.setText("<html>Vos points "+ ctr_Ronda.Ctr_Point_Total("j") + "<html>");
				lblPointsOrdi.setText("<html>Ordi points "+ ctr_Ronda.Ctr_Point_Total("o") + "<html>");
				lblPointsJoeurTop.setText("<html>Vos points de la partie "  + ctr_Ronda.Ctr_GetMain("j").getPoints() + "&emsp;&emsp;Vos Cartes "+ ctr_Ronda.Ctr_GetMain("j").getGainCartes().getListe().size()+"</html>");
				lblPointsOrdiTop.setText("<html>Ordi points de la partie "  + ctr_Ronda.Ctr_GetMain("o").getPoints() +  "&emsp;&emsp;Ordi Cartes "+ ctr_Ronda.Ctr_GetMain("o").getGainCartes().getListe().size()+"</html>");
				contentPane.repaint();
				score();
				verifierGagnant();
		
			}else{
				JOptionPane.showMessageDialog(null, "Vous avez encore des cartes a jouer");
				//passe=false;
			}
		}else  if(ev.getSource()== btnSimple){
			theVisible();
			//passe = false;
		}else  if(ev.getSource()== btnRecommanecer){
			initial();
			//passe = false;
		}else{
		 if (ev.getSource() == btnJoeur1) {
			carteJouee = ctr_Ronda.Ctr_GetMain("j").getListPaquet().getListe().get(0);
			btnJoeur1.setVisible(false);
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
			}
			new Thread(this).start();

		}

	}

	@Override
	public void action() {
		btnCommencer.addActionListener(this::actionBtn);;
		btnJoeur1.addActionListener(this::actionBtn);
		btnJoeur2.addActionListener(this::actionBtn);
		btnJoeur3.addActionListener(this::actionBtn);
		btnRecommanecer.addActionListener(this::actionBtn);
		btnSimple.addActionListener(this::actionBtn);
		btnOrdi.addActionListener(this::actionBtn);
	}

	@Override
	public void run() {
			try {
				if(aQuileTour.equalsIgnoreCase("o")){
					lblOrdiShow();
					Thread.sleep(DELAY);
					changeTableOrdi();
					if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==3){
						lblOrdi1.setIcon(null);
					}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==2){
						lblOrdi2.setIcon(null);
					}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==1){
						lblOrdi3.setIcon(null);
					}

					Thread.sleep(DELAY);
					boujerOrdi();
					Thread.sleep(DELAY);
					ctr_Ronda.Ctr_tourOrdi();
					changeTableDistribue();
					Thread.sleep(DELAY);
					changeTableJoeur();
					Thread.sleep(DELAY);
					bouger();
					Thread.sleep(DELAY);
					ctr_Ronda.Ctr_tour(carteJouee);
					Thread.sleep(DELAY);
					changeTableDistribue();
					Thread.sleep(DELAY);
	
				}else{	
					changeTableJoeur();
					Thread.sleep(DELAY);
					bouger();
					Thread.sleep(DELAY);
					ctr_Ronda.Ctr_tour(carteJouee);
					Thread.sleep(DELAY);
					changeTableDistribue();
					Thread.sleep(DELAY);
					lblOrdiShow();
					Thread.sleep(DELAY);
					changeTableOrdi();
					if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==3){
						lblOrdi1.setIcon(null);
					}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==2){
						lblOrdi2.setIcon(null);
					}else if(ctr_Ronda.Ctr_GetMain("o").getListPaquet().getListe().size()==1){
						lblOrdi3.setIcon(null);
					}

					Thread.sleep(DELAY);
					boujerOrdi();
					Thread.sleep(DELAY);
					ctr_Ronda.Ctr_tourOrdi();
					changeTableDistribue();
					Thread.sleep(DELAY);
				}
				
				lblPointsJoeur.setText("<html>Vos points "+ ctr_Ronda.Ctr_Point_Total("j") + "<html>");
				lblPointsOrdi.setText("<html>Ordi points "+ ctr_Ronda.Ctr_Point_Total("o") + "<html>");
				lblPointsJoeurTop.setText("<html>Vos points de la partie "  + ctr_Ronda.Ctr_GetMain("j").getPoints() + "&emsp;&emsp;Vos Cartes "+ ctr_Ronda.Ctr_GetMain("j").getGainCartes().getListe().size()+"</html>");
				lblPointsOrdiTop.setText("<html>Ordi points de la partie "  + ctr_Ronda.Ctr_GetMain("o").getPoints() +  "&emsp;&emsp;Ordi Cartes "+ ctr_Ronda.Ctr_GetMain("o").getGainCartes().getListe().size()+"</html>");
				contentPane.repaint();
				score();
				verifierGagnant();
					} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
		
	}


}
