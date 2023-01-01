package com.ronda.modelRonda;

import java.util.ArrayList;
import java.util.Collections;

public class ModelRonda {

    final int W = 125;
    final int H = 155;
    private static ModelRonda instanceModel = null;
    private static Paquet paquet = new Paquet("p");
    private Paquet table = new Paquet("t");
    private static Main joeur = new Main();
    private static Main ordi = new Main();
    private int p_41_J=0;
	private int p_41_O=0;
    private String gagnanttDernierTour="";


    public ModelRonda(){ };

    public synchronized static ModelRonda getModelRonda(){
        if(instanceModel == null){
            instanceModel = new ModelRonda();
            chargerPaquet();
        }
        return instanceModel;
    }
    
    public int getP_41_O() {
        return p_41_O;
        
    }

    public int getP_41_J() {
        return p_41_J;
        
    }

    public void setP_41_J(int ajout) {
        p_41_J += ajout;
        
    }
    public void setP_41_O(int ajout) {
        p_41_O += ajout;
        
    }


    public Paquet getPaquet(String nomPaquet) {
        if(nomPaquet.equalsIgnoreCase("p")){
            return paquet;
        }else{
            return table;
        }
    }
    public void setPaquet(Paquet paquet) {
        this.paquet = paquet;
    }
    public Main getJoeur() {
        return joeur;
    }
    public void setJoeur(Main joeur) {
        this.joeur = joeur;
    }
    public Main getOrdi() {
        return ordi;
    }
    public void setOrdi(Main ordi) {
        this.ordi = ordi;
    }
    public Paquet getTable() {
        return table;
    }
    public void setTable(Paquet table) {
        this.table = table;
    }
    public static ModelRonda getInstanceModel() {
        return instanceModel;
    }

    public static void chargerPaquet() {
        joeur = new Main();
        ordi = new Main();
        int[] lesNombres = {1,2,3,4,5,6,7,10,11,12};
        String[] lesGenres = {"baton","coupe","denier","épée"};
        for(int i=0;i<lesGenres.length;i++){
            String genre = lesGenres[i];
            for(int j=0;j<lesNombres.length;j++){
                Carte carte = new Carte(lesNombres[j],genre,1150,200,"p",true);
                paquet.getListe().add(carte);
                
            }
        }
    }
    
    public void distribuer() {
        if(paquet.getListe().size()==0){
            chargerPaquet();
        }
        Collections.shuffle(paquet.getListe());
        //table.setNom("t");
        joeur.getListPaquet().setNom("j");
        ordi.getListPaquet().setNom("o");
        if (paquet.getListe().size() !=0){
            if(paquet.getListe().size()==40){
                  //tabImageTable= remplirTabImageTable(paquet);
                paquet.moveCartes(table, false, 4, 500, 200);
                //System.out.println(paquet.getListe().size());
            }
            paquet.moveCartes(joeur.getListPaquet(), true, 3, 800, 400);
            paquet.moveCartes(ordi.getListPaquet(),true, 3, 0, 520);
            for(Carte carte:table.getListe()){
                carte.setOwner("t");
            }
            //donner les points ronda et tiringa
            int p_J_avant = joeur.getPoints();
            int p_O_avant = ordi.getPoints();
            joeur.pointageRandaTringa(ordi);
            int p_J_apres = joeur.getPoints();
            int p_O_apres = ordi.getPoints();
            if(p_J_apres - p_J_avant >0){
                setP_41_J(p_J_apres - p_J_avant);
            }
            if(p_O_apres - p_O_avant >0){
                setP_41_O(p_O_apres - p_O_avant);
            }

        }
    
        
    }    


    public Paquet sequence(Carte carteEntrant) {
        Paquet paq = new Paquet();
        ArrayList<Carte> listSequenece = new ArrayList<Carte>();
        // verifier l'existance du numero de la carte dans la table 
        // retourne son index
        int existe = table.getListesNumero().indexOf(carteEntrant.getNombre());
        if(existe != -1){
        // sortir la carte semblable de la table
            Carte current = table.getListe().get(existe);
            //ordonner la table
            Collections.sort(table.getListe());    
            int indCurrent= table.getListe().indexOf(current);
            //table.getPaquet().get(indCurrent).setLabel(label);
            listSequenece.add(table.getListe().get(indCurrent));
           // table.moveUneCarte(table.getListe().get(indCurrent), paq);

            int suivant=0;
            for( int i=indCurrent+1;i<table.getListe().size();i++){
                    if(current.getNombre()==7){
                        suivant = current.getNombre()+3;
    
                    }else {
                        suivant = current.getNombre()+1;
    
                    }
                    if(suivant==table.getListe().get(i).getNombre()){
                        listSequenece.add(table.getListe().get(i));
                            current = table.getListe().get(i);
                    
                    }else{
                        break;
                    }
            }
        }
        paq.setListe(listSequenece);
        return paq;     
    }
    public ArrayList<Integer> tabDesX(Paquet pq) {
		ArrayList<Integer> listeX = new ArrayList<>();
		for(Carte carte:pq.getListe()){
			listeX.add(carte.getX());
		}
		return listeX;
	}
	public ArrayList<Integer> tabDesY(Paquet pq) {
		ArrayList<Integer> listeY = new ArrayList<>();
		for(Carte carte:pq.getListe()){
			listeY.add(carte.getY());
		}
		return listeY;
	}
    public int[] meilleurPosition() {
        int[] tabPos = new int[2];
        int x=5,y=200;
		ArrayList<Integer> compareListeX = new ArrayList<Integer>(){{add(0);
			add(0);
			add(135);
			add(270);
			add(415);
		}};
		ArrayList<Integer> compareListeY = new ArrayList<Integer>(){{add(0);
			add(5);
			add(205);
		}};
		for(Integer i:compareListeX){
			if(tabDesX(table).indexOf(i)==-1){
				x=i;
				for(Integer j:compareListeY){
					if(tabDesY(table).indexOf(j)==-1){
						y=j;
						break;
					}
				}
				break;
			
			}

		}

        tabPos[0]=x;
        tabPos[1]=y;
        return tabPos;
    }
    
	public void tour(Carte carte) {
		Paquet suiteJoeur = sequence(carte);
        // si il ya une suite des cartes dans la table 
		if(suiteJoeur.getListe().size() != 0){
	
			// cas de essti
            String o = "";
            o = suiteJoeur.getListe().get(0).getOwner();
			if(o.equalsIgnoreCase("o")){
				joeur.ajoutPoints(1);
                setP_41_J(1);
                
			}
            joeur.getListPaquet().moveCarteEtChangeOwner(carte, joeur.getGainCartes());
			for(Carte cart:suiteJoeur.getListe()){
				//joeur.getGainCartes().getListe().add(cart);
                table.moveCarteEtChangeOwner(cart, joeur.getGainCartes());

			}
			// cas de missa
			if(table.getListe().size() ==0){
				joeur.ajoutPoints(1);
                setP_41_J(1);
			}
			gagnanttDernierTour = "j";
		
		}else{
			joeur.getListPaquet().moveUneCarte(carte, table);
		}

	}
    public String getGagnanttDernierTour() {
        return gagnanttDernierTour;
    }
    public void tourOrdi() {
        int[] listeMeileur = indexMeilleurCarte();
        if(listeMeileur[0] != -1){
            Carte carte = ordi.getListPaquet().getListe().get(listeMeileur[0]);
            Paquet suiteOrdi = sequence(carte);
            for(Carte cart:suiteOrdi.getListe()){
                table.moveCarteEtChangeOwner(cart,ordi.getGainCartes());
            }
            // cas de missa
            if(table.getListe().size() ==0){
                listeMeileur[1]++;
            }
            ordi.ajoutPoints(listeMeileur[1]);
            setP_41_O(listeMeileur[1]);
            ordi.getListPaquet().moveCarteEtChangeOwner(carte, ordi.getGainCartes());
    
            gagnanttDernierTour = "o";
    
        }else{
            Carte carte = ordi.getListPaquet().getListe().get(0);
            ordi.getListPaquet().moveUneCarte(carte, table);
    
        }
        
    }   
    public int[] indexMeilleurCarte() {
        int totalPoint=0,totalCarte=0,plusPoints=0,plusCarte=2;
        //int ind =-1;
        int[] retourneIndex = new int[3];
        retourneIndex[0]= -1;
        retourneIndex[1]=totalPoint;
        retourneIndex[2]=totalCarte;
        Paquet gainTable=new Paquet();
        for(int i =0;i<ordi.getListPaquet().getListe().size();i++){
            gainTable = sequence(ordi.getListPaquet().getListe().get(i));
            if(gainTable.getListe().size() != 0){
                totalCarte = gainTable.getListe().size();
                // cas de essti
                if(gainTable.getListe().get(0).getOwner().equalsIgnoreCase("j")){
                    totalPoint++;
                }
                if(totalPoint>=plusPoints && totalCarte >=plusCarte){
                    plusPoints=totalPoint;
                    plusCarte = totalCarte;
                    retourneIndex[0]=i;
                    retourneIndex[1]=totalPoint;
                    retourneIndex[2]=totalCarte;
                    
                }else if(totalPoint == 1 &&  totalCarte>=plusCarte ){
                    plusCarte = totalCarte;
                    retourneIndex[0]=i;
                    retourneIndex[1]=totalPoint;
                    retourneIndex[2]=totalCarte;
    
                }else if(totalPoint>= plusPoints ){
                    plusPoints = totalPoint;
                    retourneIndex[0]=i;
                    retourneIndex[1]=totalPoint;
                    retourneIndex[2]=totalCarte;
    
                }else if(totalCarte>=5 ){
                    plusCarte = totalCarte;
                    retourneIndex[0]=i;
                    retourneIndex[1]=totalPoint;
                    retourneIndex[2]=totalCarte;
    
                }else if(totalPoint == 1 && totalCarte ==2){
                    retourneIndex[0]=i;
                    retourneIndex[1]=totalPoint;
                    retourneIndex[2]=totalCarte;
    
                }else if(totalCarte>= plusCarte ){
                    plusCarte = totalCarte;
                    retourneIndex[0]=i;
                    retourneIndex[1]=totalPoint;
                    retourneIndex[2]=totalCarte;
    
                }else{
                    retourneIndex[0]=i;
                    retourneIndex[1]=totalPoint;
                    retourneIndex[2]=totalCarte;
                }
            }  
        }
        return retourneIndex;
    }
     
}
