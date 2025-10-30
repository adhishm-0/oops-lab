package exp10;

import javax.swing.*;
import java.awt.event.*;

public class exp10 extends JFrame implements ActionListener {

    JLabel userLabel, passLabel;
    JTextField userText;
    JPasswordField passText;
    JButton loginButton;

    public exp10() {
        setTitle("Swing Application");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(80, 50, 80, 25);
        add(userLabel);

        userText = new JTextField();
        userText.setBounds(170, 50, 150, 25);
        add(userText);

        passLabel = new JLabel("Password");
        passLabel.setBounds(80, 90, 80, 25);
        add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(170, 90, 150, 25);
        add(passText);

        loginButton = new JButton("Login");
        loginButton.setBounds(160, 130, 80, 30);
        add(loginButton);

        loginButton.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = new String(passText.getPassword());

        if (username.equals("Karunya") && password.equals("Karunya")) {
            JOptionPane.showMessageDialog(this, "Login Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Login Failed", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new exp10();
    }
}
