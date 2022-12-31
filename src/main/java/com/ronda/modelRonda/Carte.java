package com.ronda.modelRonda;
import javax.swing.ImageIcon;

public class Carte {
    private int nombre;
    private String genre;
    private int x;
    private int y;
    private String owner;
    private ImageIcon image;
    public final String IMAGE_DOS = "src\\main\\java\\com\\ronda\\rondaImages\\dos.png";
    public final String IMAGE ="src\\main\\java\\com\\ronda\\rondaImages";


    public Carte() {
    }
    public Carte(int nombre, String genre, int x, int y, String owner,Boolean avecImage) {
        this.setNombre(nombre);
        this.setGenre(genre);
        this.setX(x);
        this.setY(y);
        this.setOwner(owner);
        if(avecImage){
            this.setImage(genre + nombre);
        }else{
            this.setImage("dos");

        }
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
    public void setImage(String nomImage) {
        ImageIcon image = new ImageIcon(IMAGE+ nomImage+ ".png");
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
    
}
