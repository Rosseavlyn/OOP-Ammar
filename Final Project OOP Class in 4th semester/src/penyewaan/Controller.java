package penyewaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class Controller {
    Model model;
    View view;

    public Controller(Model model,View view) {
        this.model = model;
        this.view = view;
        readDataBarang();
        readDataPenyewa();
        
        view.namaBarang = model.readBarangBox();
        view.tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.getContentPane().removeAll();
                view.refresh();
                new MVC();
            }
        });

        view.tombolDaftarBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.getContentPane().removeAll();
                view.refresh();
                showRequest(view.daftarBarang());
            }
        });
        view.tombolDaftarPenyewa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.namaBarang = model.readBarangBox();
                view.getContentPane().removeAll();
                view.refresh();
                showRequest(view.daftarPenyewa());
            }
        });
        
//        Bagian Barang

        view.tabelBarang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                String data[][] = model.readBarang();
                int row = view.tabelBarang.getSelectedRow();
                view.textIDBarang.setEditable(true);
                view.baris = row;
                view.textIDBarang.setText(data[row][0]);                
                view.textNamaBarang.setText(data[row][1]);
                view.textHargaBarang.setText(data[row][2]);
            }
        });

        view.tombolTambahBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String idBarang = view.getIDBarang();
                String namaBarang = view.getNamaBarang();
                String hargaBarang = view.getHargaBarang();
                model.insertBarang(idBarang,namaBarang,hargaBarang);
                readDataBarang();
            }
        });
        
        view.tombolEditBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Baris = "+view.getBaris());
                if(view.getBaris()<0){
                    JOptionPane.showMessageDialog(null, "Pilih Data yang mau diedit!");
                }
                else{
                    String idBarang = view.getIDBarang();
                    String namaBarang = view.getNamaBarang();
                    String hargaBarang = view.getHargaBarang();
                    model.editBarang(view.baris,idBarang,namaBarang,hargaBarang);
                    readDataBarang();
                }
            }
        });
        
        view.tombolHapusBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Baris = "+view.getBaris());
                if(view.getBaris()<0){
                    JOptionPane.showMessageDialog(null, "Pilih Data yang mau dihapus!");
                }
                else{
                    String data = view.getIDBarang();
                    model.deleteBarang(data);
                    readDataBarang();
                }
            }
        });
        
        view.tombolBatalBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearTextFieldBarang();
            }
        });
        
//        Bagian Penyewa

        view.tabelPenyewa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                String data[][] = model.readPenyewa();
                int row = view.tabelPenyewa.getSelectedRow();
                view.textNama.setEditable(true);
                view.baris = row;
                view.textNama.setText(data[row][0]);
                view.textAlamat.setText(data[row][2]);
                view.textTaggalSewa.setText(data[row][5]);
                view.textTaggalKembali.setText(data[row][6]);                                
            }
        });

        view.tombolTambahPenyewa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = view.getNama();
                String jenisKelamin = view.getKelamin();
                String alamat = view.getAlamat();
                String namaBarang = view.getBarang();
                String jaminan = view.getJaminan();
                String tgl_sewa = view.getTanggalSewa();
                String tgl_kembali = view.getTanggalKembali();
                model.insertPenyewa(nama, jenisKelamin, alamat, namaBarang, jaminan, tgl_sewa, tgl_kembali);
                readDataPenyewa();
            }
        });

        view.tombolBatalPenyewa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearTextFieldPenyewa();
            }
        });

        view.tombolHapusPenyewa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Baris = "+view.getBaris());
                if(view.getBaris()<0){
                    JOptionPane.showMessageDialog(null, "Pilih Data yang mau dihapus!");
                }
                else{
                    String data = view.getNama();
                    model.deletePenyewa(data);
                    readDataPenyewa();
                }
            }
        });

    }
    
    //Bagian Barang
    
    public void readDataBarang(){
        try {
            String data[][] = new String[model.getBanyakDataBarang()][3];
            data = model.readBarang();
            view.tabelBarang.setModel((new JTable(data,view.kolomBarang)).getModel());
        } catch (IllegalArgumentException i) {
            System.err.println(i); 
        }
    }
    
    //Bagian Penyewa
    
    public void readDataPenyewa(){
        try {
            String data[][] = new String[model.getBanyakDataPenyewa()][7];
            data = model.readPenyewa();
            view.tabelPenyewa.setModel((new JTable(data,view.kolomPenyewa)).getModel());
        } catch (IllegalArgumentException i) {
            System.err.println(i); 
        }
    }
    
    public void showRequest (JFrame frame) {
        frame.setVisible(true);
    }
    
    public void clearTextFieldPenyewa(){
        view.textNama.setEditable(true);
        view.textNama.setText("");
        view.textAlamat.setText("");
        view.textTaggalSewa.setText("");
        view.textTaggalKembali.setText("");
    }
    
    public void clearTextFieldBarang(){
        view.baris = -1;
        view.textIDBarang.setEditable(true);
        view.textIDBarang.setText("");
        view.textNamaBarang.setText("");
        view.textHargaBarang.setText("");
    }
}
