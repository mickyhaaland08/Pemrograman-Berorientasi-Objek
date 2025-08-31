/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kantinpujaserapolban;

/**
 *
 * @author Ryzen
 */
public class Pembeli {
    private String nama;
    private double budget;    
    
    public Pembeli(String nama, double budget){
        this.nama = nama;
        this.budget = budget;
    }
    public void setNama(String nama){
      this.nama = nama;
    }
    
    public void setBudget(double budget){
        this.budget = budget;
    }
    
    public String getNama(){
        return nama;
    }
    
    public double getBudget(){
        return budget;
    }
    
    public void beli(Kantin item){
        if (budget >= item.getHarga()){
            budget -= item.getHarga();
            System.out.println(nama + " membeli " + item.getMenu());
            System.out.println("Saldo anda tersisa Rp "+ budget);
        }
        else
            System.out.println("Saldo anda tidak cukup untuk menambah menu makanan dan minuman, minta ke mamah kalian!");
    }
}
