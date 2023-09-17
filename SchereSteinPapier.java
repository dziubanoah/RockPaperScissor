package ProjektSpiel.SchereSteinPapier;

import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchereSteinPapier {

    private static String SE = "Schere";
    private static String ST = "Stein";
    private static String PA = "Papier";
    private static String zufallsVariable;
    private static String Wert;
    static JLabel text = new JLabel("Schere Stein Oder Papier ? ");
    static JLabel text2 = new JLabel("Der Computer wählt : ");
    static JFrame frame; // Klassenvariable für das JFrame

    public static void main(String[] args) {
        openUI();
    }

    public static void openUI() {
        frame = new JFrame("SESTPA"); // frame wird initialisiert
        frame.setSize(400, 300);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);

        text.setBounds(50, 30, 200, 30);
        text2.setBounds(50, 50, 200, 30);

        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 200, 30);

        JButton button = new JButton("Eingeben");
        button.setBounds(50, 150, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                Wert = textField.getText();
                output();
            }
        });

        frame.add(text2);
        frame.add(text);
        frame.add(textField);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void output() {
        Random randomgenerator = new Random();
        int zufallsIndex = randomgenerator.nextInt(3);

        if (zufallsIndex == 0) {
            zufallsVariable = SE;
        } else if (zufallsIndex == 1 ) {
            zufallsVariable = ST;
        } else {
            zufallsVariable = PA;
        }

        System.out.println("Der Computer wählt : " + zufallsVariable);
        text2.setText("Der Computer wählt : " + zufallsVariable);

        if ((zufallsVariable.equals(PA) && Wert.equals("Schere")) ||
            (zufallsVariable.equals(ST) && Wert.equals("Papier")) ||
            (zufallsVariable.equals(SE) && Wert.equals("Stein"))) {
            text.setText("Du hast gewonnen!");
        } else if ((zufallsVariable.equals(SE) && Wert.equals("Papier")) ||
                   (zufallsVariable.equals(ST) && Wert.equals("Schere")) ||
                   (zufallsVariable.equals(PA) && Wert.equals("Stein"))) {
            text.setText("Du hast verloren.");
        } else {
            text.setText("Unentschieden");
        }
        
        frame.repaint(); // Hier wird das Fenster manuell neu gezeichnet
    }
}

