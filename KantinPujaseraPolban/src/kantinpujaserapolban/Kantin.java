/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kantinpujaserapolban;

/**
 *
 * @author Ryzen
 */



public class Kantin {
    private String menu;
    private double harga;
    
    public Kantin(String menu, double harga){
        this.menu = menu;
        this.harga = harga;
    }
    public String getMenu(){
     return menu;
    }
    
    public Double getHarga(){
    return harga;
    }
    
    public void setMakanan(String menu){
        this.menu = menu;
    }
    
    public void setHarga(double harga){
        this.harga = harga;
    }
    
    
}
