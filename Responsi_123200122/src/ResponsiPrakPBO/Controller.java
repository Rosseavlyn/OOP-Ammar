package ResponsiPrakPBO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
    ModelTransactions modelContact;
    ViewTransactions transView;
    public String data;
    public Controller(ModelTransactions modelContact, ViewTransactions transView){
        this.modelContact = modelContact;
        this.transView = transView;

        if (modelContact.getBanyakData()!=0) {
            String dataTrans[][] = modelContact.readContact();
            transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        transView.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ID = transView.getID();
                String Barang = transView.getnamabarang();
                String Kasir = transView.getnamakasir();
                int Qty = Integer.parseInt(transView.getkuantitas());
                double Harga = Double.parseDouble(transView.getharga());
                double Diskon = Double.parseDouble(transView.getdiscount());
                double Total = ((100-Diskon)/100*(Harga*Qty));

                modelContact.insertData(ID, Barang, Kasir, Qty, Harga, Diskon, Total);

                String dataTrans[][] = modelContact.readContact();
                transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
            }
        });

        transView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String ID = transView.getID();
                String Barang = transView.getnamabarang();
                String Kasir = transView.getnamakasir();
                int Qty = Integer.parseInt(transView.getkuantitas());
                double Harga = Double.parseDouble(transView.getharga());
                double Diskon = Double.parseDouble(transView.getdiscount());
                double Total = ((100-Diskon)/100*(Harga*Qty));

                modelContact.updateData(ID, Barang, Kasir, Qty, Harga, Diskon, Total);

                String dataTrans[][] = modelContact.readContact();
                transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
            }
        });

        transView.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                transView.tfID.setText("");
                transView.tfnamaBarang.setText("");
                transView.tfnamaKasir.setText("");
                transView.tfquantity.setText("");
                transView.tfharga.setText("");
                transView.tfdiskon.setText("");
            }
        });


        transView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = transView.tabel.getSelectedRow();
                data = transView.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[7];
                dataUpdate[0] = transView.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = transView.tabel.getValueAt(baris, 1).toString();
                dataUpdate[2] = transView.tabel.getValueAt(baris, 2).toString();
                dataUpdate[3] = transView.tabel.getValueAt(baris, 3).toString();
                dataUpdate[4] = transView.tabel.getValueAt(baris, 4).toString();
                dataUpdate[5] = transView.tabel.getValueAt(baris, 5).toString();
                dataUpdate[6] = transView.tabel.getValueAt(baris, 6).toString();

                System.out.println(data);



            }
        });

        transView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus ID " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelContact.deleteContact(data);
                    String dataTrans[][] = modelContact.readContact();
                    transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });

    }

}
