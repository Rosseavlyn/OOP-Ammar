package tugas4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Login extends JFrame{

    //DEKLARASI KOMPONEN
    JLabel lUser = new JLabel("Username: ");
    JTextField tfUser = new JTextField();
    JLabel lPass = new JLabel("Password: ");
    JPasswordField tfPass = new JPasswordField();
    JLabel lDaftar = new JLabel("Register dulu kalo belum punya akun");
    JButton btnLogin = new JButton("Login");
    JButton btnRegister = new JButton("Register");


    public Login() {

        //SET LAYOUT
        setTitle("LOGIN");
        setLayout(null);
        setSize(400,200);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(3);


        //ADD COMPONENT
        add(lUser);
        add(tfUser);
        add(lPass);
        add(tfPass);
        add(btnLogin);
        add(lDaftar);
        add(btnRegister);
        //LABEL
        lUser.setBounds(10, 35, 120, 25);
        lPass.setBounds(10, 60, 120, 25);
        lDaftar.setBounds(110, 95, 300, 25);

        //TEXTFIELD
        tfUser.setBounds(110, 35, 225, 25);
        tfPass.setBounds(110, 60, 225, 25);

        //BUTTON PANEL
        btnLogin.setBounds(110,120,90,25);
        btnRegister.setBounds(220,120,110,25);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Koneksi con = new Koneksi();
                String user = tfUser.getText();
                if(con.cekUsername(user) && user != "" && con.cekLogin(user ,String.valueOf(tfPass.getPassword()))){
                    JOptionPane.showMessageDialog(null, "Login Success");
                }else if(user.isEmpty() || String.valueOf(tfPass.getPassword()).isEmpty()){
                    JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
                }
                else if(!con.cekUsername(user)){
                    JOptionPane.showMessageDialog(null, "Username Salah");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password Salah");
                }
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Register register = new Register();
                    System.out.println("Berhasil Terhubung Form Register!");
                    register.setVisible(true);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }

        });
    }
}
