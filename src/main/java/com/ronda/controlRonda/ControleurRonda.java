package com.ronda.controlRonda;


import com.ronda.modelRonda.Carte;
import com.ronda.modelRonda.Main;
import com.ronda.modelRonda.ModelRonda;
import com.ronda.modelRonda.Paquet;

public class ControleurRonda implements I_ControleurRonda{
    private static ControleurRonda ctrRonda = null;
    public static ModelRonda instanceModelRonda = null;


    public ControleurRonda(){};
    public static ControleurRonda gControleurRonda() {
        if(ctrRonda == null){
            ctrRonda = new ControleurRonda();
            instanceModelRonda = ModelRonda.getModelRonda();
        }
        return ctrRonda;
    }
    @Override
    public void Ctr_distribuer() {
        instanceModelRonda.distribuer();
    }
    @Override
    public Paquet Ctr_GetPaquet(String nomPaquet) {
        return instanceModelRonda.getPaquet(nomPaquet);
    }
    @Override
    public Main Ctr_GetMain(String main) {
        Main retour = new Main();
        if(main.equalsIgnoreCase("j")){
            retour = instanceModelRonda.getJoeur();
        }else if(main.equalsIgnoreCase("o")){
            retour =instanceModelRonda.getOrdi();
        }
        return retour;
    }
    
    @Override
    public void Ctr_Initial_PT(){
        instanceModelRonda.initial_PT();
    }
    @Override
    public void Ctr_tour(Carte carte) {
        instanceModelRonda.tour(carte);
        
    }
    @Override
    public void Ctr_tourOrdi() {
       instanceModelRonda.tourOrdi();
        
    }
    @Override
    public String Ctr_GetGagnant() {
        return instanceModelRonda.getGagnanttDernierTour();
    }
    @Override
    public Carte Ctr_MeilleurCarteOrdi() {
        if(instanceModelRonda.getOrdi().getListPaquet().getListe().size()!=0){
            if(instanceModelRonda.indexMeilleurCarte().length!=0){
                int index = instanceModelRonda.indexMeilleurCarte()[0];
                if(index != -1){
                    return instanceModelRonda.getOrdi().getListPaquet().getListe().get(index);
                }else{
                    return instanceModelRonda.getOrdi().getListPaquet().getListe().get(0);
                }
            }else{
                return null;
            }
        }else{
            return null;
        }
    
         
      }
    @Override
    public int Ctr_Point_Total(String main) {
        int retour=0;
        if(main.equalsIgnoreCase("j")){
             retour = instanceModelRonda.getP_41_J();
        }else if(main.equalsIgnoreCase("o")){
            retour = instanceModelRonda.getP_41_O();
        }
        return retour;
    }
    @Override
    public void Ctr_Set_Au_PT(String main,int ajout){
        if(main.equalsIgnoreCase("j")){
            instanceModelRonda.setP_41_J(ajout);
       }else if(main.equalsIgnoreCase("o")){
        instanceModelRonda.setP_41_O(ajout);
    }

    }
    
}
