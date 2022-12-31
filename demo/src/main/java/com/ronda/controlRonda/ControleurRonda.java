package com.ronda.controlRonda;

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
    public Paquet Ctr_GetPaquet() {
        return ModelRonda.getPaquet();
    }
    
}
