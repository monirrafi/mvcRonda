package com;
 
class FenetrePrincipale implements Runnable
{
    public void affiche2(){
        for(int i=0; i<5;i++){
            System.out.println("th 2 "+i);
        }

    }

 
    @Override
    public void run() {
    
            try {
                Thread.sleep(5000);
                System.out.println("2 start");
                affiche2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                
    }
}