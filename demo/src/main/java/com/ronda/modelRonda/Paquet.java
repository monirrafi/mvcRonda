package com.ronda.modelRonda;

import java.util.ArrayList;

public class Paquet {
    private ArrayList<Carte> liste = new ArrayList<>();
    private String nom;

    

    public Paquet() {
    }

    public Paquet(String nom) {
        this.nom = nom;
    }


    public Paquet(ArrayList<Carte> liste, String nom) {
        this.liste = liste;
        this.nom = nom;
    }

    public ArrayList<Carte> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Carte> liste) {
        this.liste = liste;
    }
    public void moveCarte(Carte carte, Paquet autre) {
        this.liste.remove(carte);
        autre.liste.add(carte);
        carte.setOwner(autre.getNom());
   
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Integer> getListesNumero(){
        ArrayList<Integer> listeNumero = new ArrayList<>();
        for(Carte carte:this.liste){
            listeNumero.add(carte.getNombre());
        }
        return listeNumero;
    }
    public String toString() {
        int i=1;
        String strPaquet="";
        if(this.liste == null){
            strPaquet="vide";
        }else{    
            for(Carte card :this.liste){
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
                    autre.getListe().add(card);
                    this.getListe().remove(card);
                    card.setOwner(autre.getNom());
                    card.moveCarte(x, y);
                    if(autre.getNom().equalsIgnoreCase("o")){
                        card.setImage("dos");
                    }
   
                }
    }
    public void moveCartes(Paquet autre,boolean avecDouble,int nbreCarte,int x, int y){
            int i=0;
            if(avecDouble == true){
                while(autre.getListe().size() <= nbreCarte){
                    x=x+70*i;
                    changeOwner(this.getListe().get(0), autre, x, y);
                }

            }else{
                while(autre.getListe().size() <= nbreCarte){
                    Carte carte = this.getListe().get(i);
                    if(autre.getListesNumero().indexOf(carte.getNombre()) ==-1){
                        x=x+70*i;
                        changeOwner(carte, autre, x, y);
                    }else{
                        i++;
                    }
                }    
            }

    }


}
