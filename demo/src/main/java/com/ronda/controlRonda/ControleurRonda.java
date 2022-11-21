package com.ronda.controlRonda;

import com.ronda.modelRonda.ModelRonda;

public class ControleurRonda {
    private static ControleurRonda ctrRonda = null;
    private static ModelRonda instanceModelRonda = null;


    public ControleurRonda(){};
    public static ControleurRonda gControleurRonda() {
        if(ctrRonda == null){
            ctrRonda = new ControleurRonda();
            instanceModelRonda = ModelRonda.getModelRonda();
        }
        return ctrRonda;
    }
    public static ControleurRonda getCtrRonda() {
        return ctrRonda;
    }
    public static void setCtrRonda(ControleurRonda ctrRonda) {
        ControleurRonda.ctrRonda = ctrRonda;
    }
    public static ModelRonda getInstanceModelRonda() {
        return instanceModelRonda;
    }
    public static void setInstanceModelRonda(ModelRonda instanceModelRonda) {
        ControleurRonda.instanceModelRonda = instanceModelRonda;
    }
    
}
