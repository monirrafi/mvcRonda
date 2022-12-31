package com;


public class PauseThread {

    public void affiche1(){
        for(int i=0; i<5;i++){
            System.out.println("th 1 "+i);
        }

    }
    public static void main(String[] args)
    {
        PauseThread p = new PauseThread();
        p.affiche1();
    FenetrePrincipale test = new FenetrePrincipale ();
    Thread th = new Thread(test);
    th.start();
    

    
    }

    
}
