package com.ronda.modelRonda;



public class ModelRonda {
    private static Paquet paquet = new Paquet("p");
    private static ModelRonda instanceModel = null;
    private Main joeur = new Main();
    private Main ordi = new Main();
    private Main table = new Main();
    


    public static void chargerPaquet() {
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
    public ModelRonda(){ };

    public synchronized static ModelRonda getModelRonda(){
        if(instanceModel == null){
            instanceModel = new ModelRonda();
            chargerPaquet();
        }
        return instanceModel;
    }

    public void distribuer() {
        table.getListPaquet().setNom("t");
        joeur.getListPaquet().setNom("j");
        ordi.getListPaquet().setNom("o");
        if (paquet.getListe().size() !=0){
            if(paquet.getListe().size()==40){
                
                paquet.moveCartes(table.getListPaquet(), false, 4, 5, 485);
            }
            paquet.moveCartes(joeur.getListPaquet(), true, 3, 5, 485);
            paquet.moveCartes(ordi.getListPaquet(),true, 3, 5, 485);
    
            //donner les points ronda et tiringa
            joeur.pointageRandaTringa(ordi);
        }
    
        
    }    

    public static Paquet getPaquet() {
        return paquet;
    }
    public static void setPaquet(Paquet paquet) {
        ModelRonda.paquet = paquet;
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
    public Main getTable() {
        return table;
    }
    public void setTable(Main table) {
        this.table = table;
    }

}
