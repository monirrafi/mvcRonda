package com.ronda.modelRonda;

import java.util.ArrayList;


public class ModelRonda {
    private static ArrayList<Carte> listePaquet = new ArrayList<Carte>();
    private static ModelRonda instanceModel = null;
    private static Paquet paquet = new Paquet();
    private Paquet joeur = new Paquet();
    private Paquet ordi = new Paquet();


    public static void chargerPaquet() {
        int[] lesNombres = {1,2,3,4,5,6,7,10,11,12};
        String[] lesGenres = {"baton","coupe","denier","épée"};
        for(int i=0;i<lesGenres.length;i++){
            String genre = lesGenres[i];
            for(int j=0;j<lesNombres.length;j++){
                Carte carte = new Carte(lesNombres[j],genre,1150,200,"source");
                listePaquet.add(carte);
                
            }
        }
        paquet.setListPaquet(listePaquet);
    }
    public ModelRonda(){ };

    public synchronized static ModelRonda getModelRonda(){
        if(instanceModel == null){
            instanceModel = new ModelRonda();
            chargerPaquet();
        }
        return instanceModel;
    }

    public void distribuer() {
        if (paquet.getPaquet().size() !=0){
            if(paquet.getPaquet().size()==40){
                paquet.moveCartes(joeur, false, 0, 5, 485);
            }
            paquet.moveCartes(joeur, true, 0, 5, 485);
            paquet.moveCartes(ordi,true, 0, 5, 485);
    
            //donner les points ronda et tiringa
            joeur.pointageRandaTringa(ordi);
        }
    
        
    }    







    public static ArrayList<Carte> getListePaquet() {
        return listePaquet;
    }
    public static void setListePaquet(ArrayList<Carte> listePaquet) {
        ModelRonda.listePaquet = listePaquet;
    }
    public static ModelRonda getInstanceModel() {
        return instanceModel;
    }
    public static void setInstanceModel(ModelRonda instanceModel) {
        ModelRonda.instanceModel = instanceModel;
    }

}
