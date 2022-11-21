package com.ronda.modelRonda;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Carte {
    private int nombre;
    private String genre;
    private int x;
    private int y;
    private String owner;
    private ImageIcon image;
    public final String IMAGE_DOS = "src\\main\\java\\com\\ronda\\dos.png";
    public final String IMAGE ="src\\main\\java\\com\\ronda\\";


    public Carte() {
    }
    
    public Carte(int nombre, String genre, int x, int y, String owner) {
        this.setNombre(nombre);
        this.setGenre(genre);
        this.setX(x);
        this.setY(y);
        this.setOwner(owner);
        this.setImage(new ImageIcon(IMAGE_DOS));
    }

    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public ImageIcon getImage() {
        return image;
    }
    public void setImage(ImageIcon image) {
        this.image = image;
    }
    public void moveCarte(int x,int y) {
        setX(x);
        setY(y);
        
    }
    @Override
    public String toString() {
        return nombre + genre;
    }
    public boolean memeNombre(Carte autre) {
        if(this.getNombre() == autre.getNombre()){
            return true;
        }
        return false;
        
    }
    public void changeDos(boolean change) {
        if(change == true){
            this.setImage(new ImageIcon(IMAGE  + this.getGenre() + this.getNombre() + ".png"));
        }else{
            this.setImage(new ImageIcon(IMAGE_DOS));

        }
        
    }
    
}
