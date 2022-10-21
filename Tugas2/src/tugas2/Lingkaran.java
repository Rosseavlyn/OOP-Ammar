/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas2;

/**
 *
 * @author ammar
 */
public class Lingkaran implements MenghitungBidang{
    private double jari2, hasilLuas, hasilKel;
    
    public Lingkaran(double r){
         jari2 = r;
    }
    
    public void setJari2(int r){
        jari2 = r;
    }
    
    public double getJari2(){
        return jari2;
    }
    
    public double getDiameter(){
        return 2*jari2;
    }
    
    @Override
    public double hitungLuas(){
        hasilLuas = PHI*(jari2*jari2);
        return hasilLuas;
    }
    
    @Override
    public double hitungKeliling(){
        return hasilKel = PHI*(2*jari2);
    }
}
