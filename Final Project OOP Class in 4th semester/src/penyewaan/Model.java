package penyewaan;

import java.sql.*;
import javax.swing.*;

public class Model {
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/proyek_akhir";
    static final String DBusername = "root";
    static final String DBpassword = "";
    static Connection koneksi;
    Statement statement;
    ResultSet resultSet;
    
    public Model() {
        try {
            Class.forName(jdbcDriver);
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String getidBarangFromNama(String nama){
        String data = null;
        try {
            String query = "SELECT * FROM barang where namaBarang = '"+nama+"'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                data = resultSet.getString("idBarang");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public int getBanyakDataBarang(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from barang";
            ResultSet setResult = statement.executeQuery(query);
            while(setResult.next()){
                jmlData++;
            }
            return jmlData;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public int getBanyakDataPenyewa(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from penyewa";
            ResultSet setResult = statement.executeQuery(query);
            while(setResult.next()){
                jmlData++;
            }
            return jmlData;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    //Bagian Barang
    public String[][] readBarang(){
        String data[][] = new String[getBanyakDataBarang()][3];
        try {
            String query = "SELECT * from barang";
            resultSet = statement.executeQuery(query);
            int p=0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("idBarang");
                data[p][1] = resultSet.getString("namaBarang");
                data[p][2] = resultSet.getString("hargaBarang");
                p++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
    public void insertBarang(String idBarang, String namaBarang, String hargaBarang){
        try {
            System.out.println(idBarang+namaBarang+hargaBarang);
            String query = "INSERT INTO barang VALUES ('"+idBarang+"','"+namaBarang+"','"+hargaBarang+"')";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public String[] readBarangBox(){
        String data[] = new String[getBanyakDataBarang()];
        int i=0;
        try{
            String query = "Select namaBarang from barang";
            ResultSet setResult = statement.executeQuery(query);
            while(setResult.next()){
                data[i] = setResult.getString("namaBarang");
                i++;
            }
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
    public void editBarang(int baris,String idBarang,String namaBarang,String hargaBarang){
        try {
            String query = "UPDATE barang SET namaBarang ='"+namaBarang+"', hargaBarang = '"+hargaBarang+"' where idBarang = '"+idBarang+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dirubah");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Diedit!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteBarang(String idBarang){
        try {
            String query = "DELETE from barang where idBarang = '"+idBarang+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Bagian Penyewa
    
    public String[][] readPenyewa(){
        String data[][] = new String[getBanyakDataPenyewa()][7];
        try {
            String query = "SELECT * from penyewa";
            resultSet = statement.executeQuery(query);
            int p=0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("nama");
                data[p][1] = resultSet.getString("jenisKelamin");
                data[p][2] = resultSet.getString("alamat");
                data[p][3] = resultSet.getString("idBarang");
                data[p][4] = resultSet.getString("jaminan");
                data[p][5] = resultSet.getString("tanggal_sewa");
                data[p][6] = resultSet.getString("tanggal_kembali");
                p++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
    public void insertPenyewa(String nama, String jenisKelamin, String alamat, String namaBarang, String jaminan, String tgl_sewa, String tgl_kembali){
        try {
            if(nama.isEmpty() || alamat.isEmpty() || tgl_sewa.isEmpty() || tgl_kembali.isEmpty()){
                JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
            }else{
            System.out.println(nama+jenisKelamin+alamat+namaBarang+jaminan+tgl_sewa+tgl_kembali);
            String idBarang = getidBarangFromNama(namaBarang);
            System.out.println(idBarang);
            String query = "INSERT INTO penyewa VALUES ('"+nama+"','"+jenisKelamin+"','"+alamat+"','"+idBarang+"','"+jaminan+"','"+tgl_sewa+"','"+tgl_kembali+"')";
            statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePenyewa(String nama){
        try {
            String query = "DELETE from penyewa where nama = '"+nama+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
}
