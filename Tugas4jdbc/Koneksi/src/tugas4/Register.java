package tugas4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Register extends JFrame {

    //DEKLARASI KOMPONEN
    JLabel lUserr = new JLabel("Username: ");
    JTextField tfUserr = new JTextField();
    JLabel lPassr = new JLabel("Password: ");
    JPasswordField tfPassr = new JPasswordField();
    JLabel lRegister = new JLabel("Punya akun? Login");
    JButton btnLoginr = new JButton("Login");
    JButton btnRegisterr = new JButton("Register");

    public Register() {

        //SET LAYOUT
        setTitle("Register");
        setLayout(null);
        setSize(400,200);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(3);


        //ADD COMPONENT
        add(lUserr);
        add(tfUserr);
        add(lPassr);
        add(tfPassr);
        add(btnLoginr);
        add(lRegister);
        add(btnRegisterr);
        //LABEL
        lUserr.setBounds(10, 35, 120, 25);
        lPassr.setBounds(10, 60, 120, 25);
        lRegister.setBounds(160, 95, 200, 25);

        //TEXTFIELD
        tfUserr.setBounds(110, 35, 225, 25);
        tfPassr.setBounds(110, 60, 225, 25);

        //BUTTON PANEL
        btnLoginr.setBounds(110,120,90,25);
        btnRegisterr.setBounds(220,120,110,25);


        btnLoginr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Login login = new Login();
                    System.out.println("Berhasil Terhubung Form Login!");
                    login.setVisible(true);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });

        btnRegisterr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Koneksi con = new Koneksi();
                String user = tfUserr.getText();
                String pass = String.valueOf(tfPassr.getPassword());
                if(!user.isEmpty() && !pass.isEmpty()){
                    con.insertData(user, pass);
                }
                else if(user.isEmpty() || pass.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
            }

        });
    }
}
