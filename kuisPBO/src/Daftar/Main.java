
package Daftar;
import Seleksi.NilaiInput;
import Seleksi.AndroidDev;
import Seleksi.WebDev;
import java.util.Scanner;
/**
 *
 * @author ammar
 */

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("FORM PENDAFTARAN");
        System.out.println(" 1. Android Development");
        System.out.println(" 2. Web Development");
        System.out.print(" Pilih : ");
        
        int pilihForm = input.nextInt();
        System.out.println(" ");
        
        System.out.println("=== FORMULIR PELAMAR ===");
        Scanner data= new Scanner(System.in);
        
        System.out.print("NIK   : ");
        int NIK = data.nextInt();
        data.nextLine();
        
        System.out.print("Nama Lengkap : ");
        String nama = data.nextLine();
        
        if (pilihForm == 1){
            System.out.print("Input Nilai Tulis : ");
            int nilaiTulis = data.nextInt();
            
            System.out.print("Input Nilai Coding : ");
            int nilaiCoding = data.nextInt();
            
            System.out.print("Input Nilai Wawancara : ");
            int nilaiWawancara = data.nextInt();
            
            System.out.println("========================");
            AndroidDev android = new AndroidDev(NIK,nama,nilaiTulis,nilaiCoding,nilaiWawancara);
            do{
                System.out.println("Menu");
                System.out.println(" 1. Edit NIlai");
                System.out.println(" 2. Tampilkan Hasil");
                System.out.println(" 3. Exit");
                System.out.print(" Pilih Menu : ");
                int pilihMenu = input.nextInt();
                
                if (pilihMenu == 1){
                    System.out.print("Input Nilai Tulis : ");
                    android.NilaiInputTulis(input.nextInt());
                    
                    System.out.print("Input Nilai Coding : ");
                    android.NilaiInputCoding(input.nextInt());
                    
                    System.out.print("Input Nilai Wawancara : ");
                    android.NilaiInputWawancara(input.nextInt());
                }
                
                else if (pilihMenu == 2){
                    System.out.println("Nilai Akhir : " + android.NilaiTotal());
                    System.out.println("Keterangan : " + android.Keterangan());
                }
                else {
                    System.out.println("Terima kasih");
                    break;
                }
            }while(true);
        }
        else if (pilihForm == 2){
            System.out.print("Input Nilai Tulis : ");
            int nilaiTulis = data.nextInt();
            
            System.out.print("Input Nilai Coding : ");
            int nilaiCoding = data.nextInt();
            
            System.out.print("Input Nilai Wawancara : ");
            int nilaiWawancara = data.nextInt();
            System.out.println("========================");
            
            WebDev web = new WebDev(NIK,nama,nilaiTulis,nilaiCoding,nilaiWawancara);
            do{
                System.out.println("Menu");
                System.out.println(" 1. Edit NIlai");
                System.out.println(" 2. Tampilkan Hasil");
                System.out.println(" 3. Exit");
                System.out.print(" Pilih Menu : ");
                int pilihMenu = input.nextInt();
                
                if (pilihMenu == 1){
                    System.out.print("Input Nilai Tulis : ");
                    web.NilaiInputTulis(input.nextInt());
                    
                    System.out.print("Input Nilai Coding : ");
                    web.NilaiInputCoding(input.nextInt());
                    
                    System.out.print("Input Nilai Wawancara : ");
                    web.NilaiInputWawancara(input.nextInt());
                }
                else if (pilihMenu == 2){
                    System.out.println("Nilai Akhir : " + web.NilaiTotal());
                    System.out.println("Keterangan : " + web.Keterangan());
                }
                else {
                    System.out.println("Terima kasih");
                    break;
                }
            }while(true);
        }
        else{
            System.out.println("Error, INPUT ULANG!");
        }
       
    }
}