package tugas1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         float celcius;
         int pilihan;
        
        Scanner inputCelcius = new Scanner(System.in);
        Scanner inputPilihMenu = new Scanner(System.in);

        System.out.println("  PROGRAM KONVERSI SUHU AIR  ");
        System.out.println("=============================");
        System.out.println("\n");
    
        System.out.print("Input suhu dalam celcius\t: ");
        celcius = inputCelcius.nextFloat();    
        
        do{
            Konversi data = new Konversi(celcius);
            System.out.println("\n");
            
            System.out.println(" Menu ");
            System.out.println("======");
            System.out.println("1. Lihat Data Konversi");
            System.out.println("2. Edit Data Konversi");
            System.out.println("3. Exit");
            System.out.print("Pilih\t: ");
            pilihan = inputPilihMenu.nextInt();
            switch(pilihan){
                case 1:
                    data.hasilKonversi();
                    break;
                
                case 2:
                    System.out.println("\n");
                    System.out.println(" Input Suhu ");
                    System.out.println("============");
                    System.out.print("Suhu dalam Celcius : ");
                    celcius = inputCelcius.nextFloat();
                    break;
                
                case 3:
                    System.out.println("\n");
                    System.out.println("++ Keluar ++");
                    break;
                    
                default:
                    System.out.println("\n");
                    System.out.println("Pilihan Anda gak ada");
            }
        } while(pilihan!=3);
    }   
}
