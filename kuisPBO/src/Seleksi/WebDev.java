
package Seleksi;
import Daftar.DaftarPelamar;

/**
 *
 * @author ammar
 */
public class WebDev extends NilaiInput implements DaftarPelamar {
   public WebDev (int NIK, String nama, int nilaiTulis, int nilaiCoding, int nilaiWawancara){
        super(NIK, nama, nilaiTulis, nilaiCoding, nilaiWawancara);
    }
    
    public void NilaiInputTulis(int nilaiTulis) {
        this.nilaiTulis = nilaiTulis;
    }

     public void NilaiInputCoding(int nilaiCoding) {
        this.nilaiCoding = nilaiCoding;
    }

     public void NilaiInputWawancara(int nilaiWawancara) {
        this.nilaiWawancara = nilaiWawancara;
    }
     
    @Override
    public double NilaiTotal() {
         return (0.4 * super.nilaiTulis) + (0.35 * super.nilaiCoding) + (0.25 * super.nilaiWawancara);
    }
    
    @Override
    public String Keterangan() {
        if(this.NilaiTotal() >= 85) 
            return "LULUS\nSelamat kepada " + this.nama + " dengan NIK " + this.NIK + " telah DITERIMA pada divisi Web Development\n";
        else 
            return "GAGAL\nMohon maaf kepada  " + this.nama + " dengan NIK " + this.NIK + " telah DITOLAK pada divisi Web Development\n";
    }
    
}