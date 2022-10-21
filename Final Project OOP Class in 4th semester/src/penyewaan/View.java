package penyewaan;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    JFrame currentFrame;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    
    JPanel panelAwal = new JPanel();
    JLabel titleLabel = new JLabel("Jasa Penyewaan Alat Camping");
    JButton tombolDaftarBarang = new JButton("Daftar Barang");
    JButton tombolDaftarPenyewa = new JButton("Daftar Penyewa");
    JButton tombolKembali = new JButton("Kembali");
    
    public View() {
        tableModel = new DefaultTableModel(kolomBarang,0);
        tabelBarang = new JTable(tableModel);
        tableModel = new DefaultTableModel(kolomPenyewa,0);
        tabelPenyewa = new JTable(tableModel);
        mainView();
    }
    
    public JFrame mainView(){
        setVisible(true);
        setSize(850, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        add(panelAwal);
        panelAwal.setVisible(true);
        panelAwal.setSize(850, 650);
        panelAwal.setLayout(null);
        panelAwal.setBorder(BorderFactory.createLineBorder(Color.black));
        panelAwal.add(titleLabel); titleLabel.setBounds(280,30,300,300); 
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,22));
        panelAwal.add(tombolDaftarBarang); tombolDaftarBarang.setBounds(190,280,200,200);
        tombolDaftarBarang.setFont(new Font("Monaco",Font.BOLD,20));
        panelAwal.add(tombolDaftarPenyewa); tombolDaftarPenyewa.setBounds(440,280,200,200);
        tombolDaftarPenyewa.setFont(new Font("Monaco",Font.BOLD,20));
        return currentFrame;
    }
    
    //Bagian Daftar Penyewa
    JPanel panelPenyewa = new JPanel();
    JLabel labelNama = new JLabel("Nama : ");
    JLabel labelJK = new JLabel("Jenis Kelamin : ");
    JLabel labelAlamat = new JLabel("Alamat : ");
    JLabel labelBarang = new JLabel("Barang : ");
    JLabel labelJaminan = new JLabel("Jaminan : ");
    JLabel labelTaggalSewa = new JLabel("Tanggal Sewa : ");
    JLabel labelTaggalKembali = new JLabel("Tanggal Kembali : ");
    JTextField textNama = new JTextField();
    JTextField textAlamat = new JTextField();
    String kelamin[] = {"Laki-laki","Perempuan"};
    JComboBox<String> jenisKelamin = new JComboBox<>(kelamin);
    String jaminan[] = {"KTP","Kartu Pelajar"};
    JComboBox<String> listJaminan = new JComboBox<>(jaminan);
    String namaBarang[];
    JComboBox<String> listBarang;
    JTextField textTaggalSewa = new JTextField();
    JTextField textTaggalKembali = new JTextField();


    //Table Daftar Penyewa
    JTable tabelPenyewa;
    String[] kolomPenyewa = {"Nama","Jenis Kelamin","Alamat","Barang","Jaminan", "Tanggal Sewa","Tanggal Kembali"};
    JButton tombolTambahPenyewa = new JButton("Tambah");
    JButton tombolHapusPenyewa = new JButton("Hapus");
    JButton tombolBatalPenyewa = new JButton("Batal");

    
    public JFrame daftarPenyewa(){
        setVisible(true);
        setSize(850, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(panelPenyewa);
        listBarang = new JComboBox<>(namaBarang);
        panelPenyewa.setLayout(null);
        panelPenyewa.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelPenyewa.setSize(850, 650);
        panelPenyewa.add(tombolKembali); tombolKembali.setBounds(10,10,100,20);
        panelPenyewa.add(labelNama); labelNama.setBounds(60,50,50,20);
        panelPenyewa.add(labelJK);labelJK.setBounds(60,70,120,20);
        panelPenyewa.add(labelAlamat);labelAlamat.setBounds(60,90,120,20);
        panelPenyewa.add(labelBarang);labelBarang.setBounds(60,110,120,20);
        panelPenyewa.add(labelJaminan);labelJaminan.setBounds(60,130,120,20);
        panelPenyewa.add(labelTaggalSewa);labelTaggalSewa.setBounds(60,150,120,20);
        panelPenyewa.add(labelTaggalKembali);labelTaggalKembali.setBounds(60,170,120,20);
        panelPenyewa.add(textNama); textNama.setBounds(180,50,140,20);
        panelPenyewa.add(jenisKelamin); jenisKelamin.setBounds(180,70,140,20);
        panelPenyewa.add(textAlamat); textAlamat.setBounds(180,90,140,20);
        panelPenyewa.add(listBarang); listBarang.setBounds(180,110,140,20);
        panelPenyewa.add(listJaminan); listJaminan.setBounds(180,130,140,20);
        panelPenyewa.add(textTaggalSewa); textTaggalSewa.setBounds(180,150,140,20);
        panelPenyewa.add(textTaggalKembali); textTaggalKembali.setBounds(180,170,140,20);
        panelPenyewa.add(tombolTambahPenyewa);tombolTambahPenyewa.setBounds(350,50,100,20);
        panelPenyewa.add(tombolBatalPenyewa);tombolBatalPenyewa.setBounds(350,70,100,20);
        panelPenyewa.add(tombolHapusPenyewa);tombolHapusPenyewa.setBounds(350,90,100,20);
        scrollPane = new JScrollPane(tabelPenyewa);
        panelPenyewa.add(scrollPane);
        scrollPane.setBounds(40,200,400,400);
        scrollPane.setSize(750, 350);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return currentFrame;
    }


        //Bagian Daftar Barang
    JPanel panelBarang = new JPanel();
    JLabel labelIDBarang = new JLabel("ID Barang : ");
    JLabel labelNamaBarang = new JLabel("Nama Barang : ");
    JLabel labelHargaBarang = new JLabel("Harga Sewa : ");
    JTextField textIDBarang = new JTextField();
    JTextField textNamaBarang = new JTextField();
    JTextField textHargaBarang = new JTextField();
    JButton tombolTambahBarang = new JButton("Tambah");
    JButton tombolEditBarang = new JButton("Edit");
    JButton tombolHapusBarang = new JButton("Hapus");
    JButton tombolBatalBarang = new JButton("Batal");
    int baris=-1;
    
    JTable tabelBarang;
    String[] kolomBarang = {"ID Barang","Nama Barang","Harga Sewa"};
    
    public JFrame daftarBarang(){
        setVisible(true);
        setSize(850, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(panelBarang);
        panelBarang.setLayout(null);
        panelBarang.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelBarang.setSize(850, 650);
        panelBarang.add(tombolKembali); tombolKembali.setBounds(10,10,100,20);
        panelBarang.add(tombolKembali); tombolKembali.setBounds(10,10,100,20);
        panelBarang.add(labelIDBarang); labelIDBarang.setBounds(60,50,100,20);
        panelBarang.add(labelNamaBarang);labelNamaBarang.setBounds(60,70,120,20);
        panelBarang.add(labelHargaBarang);labelHargaBarang.setBounds(60,90,120,20);
        panelBarang.add(textIDBarang); textIDBarang.setBounds(180,50,140,20);
        panelBarang.add(textNamaBarang); textNamaBarang.setBounds(180,70,140,20);
        panelBarang.add(textHargaBarang); textHargaBarang.setBounds(180,90,140,20);
        panelBarang.add(tombolTambahBarang);tombolTambahBarang.setBounds(350,50,100,20);
        panelBarang.add(tombolEditBarang);tombolEditBarang.setBounds(350,70,100,20);
        panelBarang.add(tombolHapusBarang);tombolHapusBarang.setBounds(350,90,100,20);
        panelBarang.add(tombolBatalBarang);tombolBatalBarang.setBounds(350,110,100,20);
        scrollPane = new JScrollPane(tabelBarang);
        panelBarang.add(scrollPane);
        scrollPane.setBounds(40,200,400,400);
        scrollPane.setSize(750, 350);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        return currentFrame;
    }
    
    public void refresh(){
        dispose();
    }
    
    public int getBaris(){
        return baris;
    }
    
    public String getNama(){
        return textNama.getText();
    }

    public String getAlamat(){
        return textAlamat.getText();
    }
    
    public String getKelamin(){
        return jenisKelamin.getSelectedItem().toString();
    }
    
    public String getBarang(){
        return listBarang.getSelectedItem().toString();
    }

    public String getJaminan(){
        return listJaminan.getSelectedItem().toString();
    }

    public String getTanggalSewa(){
        return textTaggalSewa.getText();
    }

    public String getTanggalKembali(){
        return textTaggalKembali.getText();
    }
    
    public String getIDBarang(){
        return textIDBarang.getText();
    }
    
    public String getNamaBarang(){
        return textNamaBarang.getText();
    }
    
    public String getHargaBarang(){
        return textHargaBarang.getText();
    }
    
}
