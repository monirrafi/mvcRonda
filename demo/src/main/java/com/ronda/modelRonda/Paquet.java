package com.ronda.modelRonda;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Paquet {
    private ArrayList<Carte> listPaquet= new ArrayList<Carte>();
    private int points=0;
    private ArrayList<Carte> gainCartes = new ArrayList<Carte>(); 
    private String nom; 

    public Paquet(){

    }
    public Paquet(String nom){
        this.setNom(nom);
    }    
    public Paquet(ArrayList<Carte> listPaquet){
        this.setPaquet(listPaquet);
    }
    public ArrayList<Carte> getGainCartes() {
            return gainCartes;
    }
    public int getPoints() {
        return points;
    }
    public void setGainCartes(ArrayList<Carte> gainCartes) {
        this.gainCartes = gainCartes;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public ArrayList<Carte> getPaquet() {
        return listPaquet;
    }
    public void setPaquet(ArrayList<Carte> listPaquet) {
        this.listPaquet = listPaquet;
    }
    public String toString() {
        int i=1;
        String strPaquet="";
        if(this.listPaquet == null){
            strPaquet="vide";
        }else{    
            for(Carte card :this.listPaquet){
                if(i%10 != 0){
                    strPaquet += "\t"+ card.toString(); 
                }else{
                    strPaquet += "\t"+ card.toString() + "\n";
                }
                i++;
            }
        }
        return strPaquet;
    }

    public void changeOwner(Carte card, Paquet autre,int x, int y){
        if(this.getNom().equalsIgnoreCase(card.getOwner())){
                    autre.listPaquet.add(card);
                    this.listPaquet.remove(card);
                    card.setOwner(autre.getNom());
                    card.moveCarte(x, y);
   
                }
    }
    public void moveCartes(Paquet autre,boolean avecDouble,int nbreCarte,int x, int y){
            int i=0;
            if(avecDouble == true){
                while(autre.listPaquet.size() <= nbreCarte){
                    x=x+70*i;
                    changeOwner(this.listPaquet.get(0), autre, x, y);
                }

            }else{
                while(autre.listPaquet.size() <= nbreCarte){
                    Carte carte = this.listPaquet.get(i);
                    if(autre.trouveIndexNombre(carte) ==-1){
                        x=x+70*i;
                        changeOwner(carte, autre, x, y);
                    }else{
                        i++;
                    }
                }    
            }

    }
    public int trouveIndexCarte(Carte card) {
        int index=-1;
        for(Carte c:this.getPaquet()){
            if (c.toString().equals(card.toString())) {
                index = this.getPaquet().indexOf(c);
                
            }
        }
        return index;
        
    }
    public int trouveIndexNombre(Carte card) {
        int index=-1;
        for(Carte c:this.getPaquet()){
            if (c.getNombre() == card.getNombre()) {
                index = this.getPaquet().indexOf(c);
                
            }
        }
        return index;
    }    

    // fonction pour verifier le ronda et tringa
    public int[] verification() {
        int[] tab = new int[2];
        Carte c0, c1, c2;
        c0=this.getPaquet().get(0);
        c1=this.getPaquet().get(1);
        c2=this.getPaquet().get(2);
        
        if (c0.memeNombre(c1) && (c0.memeNombre(c2))) {
            tab[0]=3;
            tab[1]= this.getPaquet().get(0).getNombre();
        }
        else if (c0.memeNombre(c1) || (c0.memeNombre(c2))) {
            tab[0]=2;
            tab[1]= this.getPaquet().get(0).getNombre();
        }
        else if (c1.memeNombre(c2)) {
            tab[0]=2;
            tab[1]= this.getPaquet().get(1).getNombre();
        }
        return tab;
    }
    public void ajoutPoints(int points) {
        this.points +=points;
    }
    public void pointageRandaTringa(Paquet autre){
        int[] paq1 = this.verification();
        int[] paq2 = autre.verification();
        int c1 = paq1[0], n1 = paq1[1],c2 = paq2[0], n2 = paq2[1];

        if(c1==2 && c2==0){
            this.points += 1;
        }else if( c1==0 && c2==2){
            autre.points += 1;
        }else if(c1== 2 && c2==2){
            if(n1 > n2){
                this.points += 2;
            }else if(n2 > n1){
                autre.points += 2;
            }else{
                this.points += 1;
                autre.points += 1;
            }
        }
        if(c1==3 && c2==0){
            this.points += 5;
        }else if( c1==3 && c2==2){
            this.points +=6;
        }else if( c1==0 && c2==3){
            autre.points += 5;
        }else if( c1==2 && c2==3){
            autre.points += 6;
        }else if(c1== 3 && c2==3){
            if(n1 > n2){
                this.points += 10;
            }else if(n2 > n1){
                autre.points += 10;
            }else{
                this.points += 5;
                autre.points += 5;
            }
        }
    }
    public ArrayList<Carte> getListPaquet() {
        return listPaquet;
    }
    public void setListPaquet(ArrayList<Carte> listPaquet) {
        this.listPaquet = listPaquet;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
        

}
