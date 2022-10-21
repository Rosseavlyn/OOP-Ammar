/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas2;

/**
 *
 * @author ammar
 */
public class Balok extends PersegiPanjang implements MenghitungRuang{
    private double tinggi, hasilVol, hasilLuasP;
    
    public Balok(double p, double l, double t){
        super(p,l);
        tinggi=t;
    }
    
    public void setTinggi(double tinggi){
        this.tinggi = tinggi;
    }
    
    public double getTinggi(){
        return tinggi;
    }
    
    @Override
    public double hitungVolume(){
        return super.hitungLuas()*tinggi;
    }
    
    @Override
    public double hitungLuasP(){
        return 2*(super.hitungLuas()+(super.getLebar()*tinggi)+(super.getPanjang()*tinggi));
    }
    
}
