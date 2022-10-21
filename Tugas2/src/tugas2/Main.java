/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas2;
import java.util.Scanner;

/**
 *
 * @author ammar
 */
public class Main {
    public static void main(String[] args) {
        int ulangi;
        
        Scanner input = new Scanner(System.in);
        Scanner c = new Scanner(System.in);
        
        do{
            int pilihan;
            System.out.println("+++++++++++++++");
            System.out.println("      Menu");
            System.out.println("+++++++++++++++");
            System.out.println("1. Hitung Balok");
            System.out.println("2. Hitung Tabung");
            System.out.println("0. Keluar");
            System.out.println("----------------");
            System.out.println("Pilih menu : ");
            
            pilihan = input.nextInt();
            System.out.println("\n");
            switch(pilihan){
                case 1:
                    double p,l,t;
                    System.out.println("Menghitung Balok");
                    System.out.println("\n");
                    System.out.println("Input panjang\t:");
                    p = input.nextInt();
                    System.out.println("Input lebar\t:");
                    l = input.nextInt();
                    System.out.println("Input tinggi\t");
                    t = input.nextInt();
                    
                    Balok b = new Balok(p,l,t);
                    
                    System.out.println("Luas Persegi Panjang\t\t= " + b.hitungLuas());
                    System.out.println("Keliling Persegi Panjang\t= " + b.hitungKeliling());
                    System.out.println("Volume Balok\t\t\t= " + b.hitungVolume());
                    System.out.println("Luas Permukaan Balok\t\t= " + b.hitungLuasP());
                    break;
                    
                case 2:
                    double r;
                    System.out.println("Menghitung Tabung");
                    System.out.println("\n");
                    System.out.println("Input jari-jari\t:");
                    r = input.nextInt();
                    System.out.println("Input tinggi\t:");
                    t = input.nextInt();
                    
                    Tabung tbg = new Tabung(r,t);
                    
                    System.out.println("Luas Lingkaran\t\t= " + tbg.hitungLuas());
                    System.out.println("Keliling Lingkaran\t= " + tbg.hitungKeliling());
                    System.out.println("Volume Tabung\t\t= " + tbg.hitungVolume());
                    System.out.println("Luas Permukaan Tabung\t= " + tbg.hitungLuasP());
                    break;
                    
                default:
                    System.out.println("\n");
                    System.out.println("Pilihan Anda gak ada");
            }
            System.out.print("Hitung lagi? Ya = 1 || Tidak = 0  : ");
            ulangi = input.nextInt();
            System.out.println("\n");

        }
        while(ulangi==1);

    }
}
