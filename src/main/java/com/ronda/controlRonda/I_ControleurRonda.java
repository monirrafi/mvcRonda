package com.ronda.controlRonda;

import javax.swing.JLabel;

import com.ronda.modelRonda.Carte;
import com.ronda.modelRonda.Main;
import com.ronda.modelRonda.Paquet;

public interface I_ControleurRonda {
    void Ctr_distribuer();
    Paquet Ctr_GetPaquet(String nomPaquet);
    Main Ctr_GetMain(String main);
    void Ctr_tour(Carte carte);
    void Ctr_tourOrdi();
    String Ctr_GetGagnant();
    Carte Ctr_MeilleurCarteOrdi();
    int Ctr_Point_Total(String main);
    void Ctr_Set_Au_PT(String main,int ajout);



}
