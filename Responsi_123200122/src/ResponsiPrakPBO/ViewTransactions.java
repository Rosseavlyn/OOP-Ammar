package ResponsiPrakPBO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ViewTransactions extends JFrame{
    JLabel lHeading = new JLabel("Riwayat Transaksi");
    JLabel lID = new JLabel("ID");
    JLabel lBarang = new JLabel("Nama Barang");
    JLabel lKasir = new JLabel("Nama Kasir");
    JLabel lQuantity = new JLabel("QTY");
    JLabel lHarga = new JLabel("Harga");
    JLabel lDiskon = new JLabel("Diskon (%)");

    public JTextField tfID = new JTextField();
    public JTextField tfnamaBarang = new JTextField();
    public JTextField tfnamaKasir = new JTextField();
    public JTextField tfquantity = new JTextField();
    public JTextField tfharga = new JTextField();
    public JTextField tfdiskon = new JTextField();


    //button
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"ID", "Nama Barang", "Nama Kasir", "Quantity", "Harga","Diskon","Total"};

    public ViewTransactions() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Transaksi dan Konsumen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,640);


        //tabel
        add(scrollPane);
        scrollPane.setBounds(50, 300, 600, 250);


        add(lHeading);
        lHeading.setBounds(300,20,300,60);

        //input data
        add(lID);
        lID.setBounds(100, 120, 90, 20);
        add(tfID);
        tfID.setBounds(200, 120, 120, 20);

        add(lBarang);
        lBarang.setBounds(100, 160, 90, 20);
        add(tfnamaBarang);
        tfnamaBarang.setBounds(200, 160, 120, 20);

        add(lKasir);
        lKasir.setBounds(100, 200, 90, 20);
        add(tfnamaKasir);
        tfnamaKasir.setBounds(200, 200, 120, 20);

        add(lQuantity);
        lQuantity.setBounds(380, 120, 90, 20);
        add(tfquantity);
        tfquantity.setBounds(480, 120, 120, 20);

        add(lHarga);
        lHarga.setBounds(380,160,90,20);
        add(tfharga);
        tfharga.setBounds(480,160,120,20);

        add(lDiskon);
        lDiskon.setBounds(380,200,90,20);
        add(tfdiskon);
        tfdiskon.setBounds(480,200,120,20);


        //button
        add(btnTambah);
        btnTambah.setBounds(150, 250, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(250, 250, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(350, 250, 90, 20);

        add(btnReset);
        btnReset.setBounds(450, 250, 90, 20);
    }

    public String getID(){

        return tfID.getText();
    }

    public String getnamabarang(){

        return tfnamaBarang.getText();
    }

    public String getnamakasir(){

        return tfnamaKasir.getText();
    }

    public String getkuantitas(){
        return tfquantity.getText();
    }

    public String getharga(){
        return tfharga.getText();
    }

    public String getdiscount(){
        return tfdiskon.getText();
    }
}
