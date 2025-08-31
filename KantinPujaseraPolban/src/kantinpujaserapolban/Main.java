/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kantinpujaserapolban;

/**
 *
 * @author Ryzen
 */



public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pembeli pembeli1 = new Pembeli("Andi", 20000);
        Pembeli pembeli2 = new Pembeli("Iki", 100000);
        Kantin nasiGoreng = new Kantin("Nasi Goreng", 15000);
        Kantin seblak = new Kantin("Seblak", 12000);
        Kantin cireng = new Kantin("Cireng Isi Ayam", 5000);
        Kantin josu = new Kantin("Extra Joss Susu", 7000);
        Kantin esTeh = new Kantin("Es Teh", 4000);
        

        pembeli1.beli(nasiGoreng);
        pembeli1.beli(esTeh);
        pembeli2.beli(josu);
        pembeli2.beli(seblak);
        
        System.out.println("Terimakasih sudah berbelanja di kantin baba rafi");
        }
    
}
