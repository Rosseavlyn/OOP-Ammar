
package Seleksi;
import Daftar.DaftarPelamar;
/**
 *
 * @author ammar
 */
public class AndroidDev extends NilaiInput implements DaftarPelamar {
   public AndroidDev (int NIK, String nama, int nilaiTulis, int nilaiCoding, int nilaiWawancara){
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
         return (0.2 * super.nilaiTulis) + (0.5 * super.nilaiCoding) + (0.3 * super.nilaiWawancara);
    }
    
    @Override
    public String Keterangan() {
        if(this.NilaiTotal() >= 85) 
            return "LULUS\nSelamat kepada " + this.nama + " dengan NIK " + this.NIK + " telah DITERIMA pada divisi Android Development\n";
        else 
            return "GAGAL\nMohon maaf kepada  " + this.nama + " dengan NIK " + this.NIK + " telah DITOLAK pada divisi Android Development\n";
    }
    
}
