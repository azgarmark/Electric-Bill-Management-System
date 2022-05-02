package java_bill;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Electric_billing implements ActionListener {

    static TextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
    static TextArea ta, tb;
    static Button b1, b2, b3, b4;
    static Choice ch, ch1, ch2, ch3, ch4, ch5, ch6;
    static Frame f1, f2, f3;
    static String co_na, me_no, add, cty, st, ph, mail;
    static int EC;
    static double EC1, FC1, ED;
    

    public static void main(String[] args) {
        f1 = new Frame("Consumer Details");
        f1.setSize(500, 500);
        f1.setBackground(Color.LIGHT_GRAY);
        f1.setLayout(null);
        f1.setVisible(true);
        

        Label l1 = new Label("Consumer Name");
        l1.setBounds(20, 50, 150, 20);
        t1 = new TextField();
        t1.setBounds(180, 50, 200, 20);
        f1.add(l1);
        f1.add(t1);

        Label l2 = new Label("Meter Number");
        l2.setBounds(20, 80, 150, 20);
        t2 = new TextField();
        t2.setBounds(180, 80, 200, 20);
        f1.add(l2);
        f1.add(t2);

        Label l3 = new Label("Address");
        l3.setBounds(20, 110, 150, 20);
        ta = new TextArea();
        ta.setBounds(180, 110, 200, 100);
        f1.add(l3);
        f1.add(ta);

        Label l4 = new Label("City");
        l4.setBounds(20, 220, 150, 20);
        t3 = new TextField();
        t3.setBounds(180, 220, 200, 20);
        f1.add(l4);
        f1.add(t3);

        Label l5 = new Label("State");
        l5.setBounds(20, 250, 150, 20);
        t4 = new TextField();
        t4.setBounds(180, 250, 200, 20);
        f1.add(l5);
        f1.add(t4);

        Label l6 = new Label("E-mail");
        l6.setBounds(20, 280, 150, 20);
        t5 = new TextField();
        t5.setBounds(180, 280, 200, 20);
        f1.add(l6);
        f1.add(t5);

        Label l7 = new Label("Phone Number");
        l7.setBounds(20, 310, 150, 20);
        t6 = new TextField();
        t6.setBounds(180, 310, 200, 20);
        f1.add(l7);
        f1.add(t6);

        b1 = new Button("Next");
        b1.setBounds(80, 375, 100, 25);
        Electric_billing ob = new Electric_billing();
        b1.addActionListener(ob);
        f1.add(b1);

        b2 = new Button("Cancel");
        b2.setBounds(220, 375, 100, 25);
        b2.addActionListener(ob);
        f1.add(b2);

    }

    public void actionPerformed(ActionEvent e) {
        String fin = "";
        String path = "C:\\Users\\azgar\\OneDrive\\Documents\\data.txt";
        try {

            FileWriter f = new FileWriter(path, true);
            if (e.getSource() == b1) {
                co_na = t1.getText();
                me_no = t2.getText();
                add = ta.getText();
                cty = t3.getText();
                st = t4.getText();
                mail = t5.getText();
                ph = t6.getText();
                fin = "--- CONSUMER DETAILS ---\n" + "\nConsumer Name: " + co_na + "\nMeter No.: " + me_no + "\nAddress: " + add + "\nCity: " + cty + "\nState: " + st + "\nMail: " + mail + "\nPhone Number: " + ph;
                f1.dispose();
                generate_bill();

            }

            if (e.getSource() == b2) {
                f1.dispose();
            }

            if (e.getSource() == b3) {
                f2.dispose();
                bill();
                String amp = t8.getText();
                EC = Integer.parseInt(t8.getText());
                EC1 = EC * 1.5; //based on TNEB
                String s = String.valueOf(EC1);
                t9.setText("Rs. " + s);
                FC1 = 50; //based on TNEB
                ED = EC1 + FC1;
                String s1 = String.valueOf(ED);
                t10.setText("Rs. " + s1);
                Double EB = EC1 + FC1 + ED;
                String s2 = String.valueOf(EB);
                t11.setText("Rs. " + s2);
                fin = "\n\n--- UNIT DETAILS ---\n" + "\nUnits Consumed: " + amp + "\n\n--- BILL DETAILS ---\n" + "\nEnergy Charge: " + EC1 + "\nElectricity Duty: " + ED + "\nTotal Electricity Bill: " + EB;

            }

            if (e.getSource() == b4) {
                f2.dispose();
                f3.dispose();
            }
            f.write(fin);
            f.close();
        } catch (IOException ea) {
            System.out.println(ea);
        }

    }

    public static void generate_bill() {
        f2 = new Frame("Calculate Bill");
        f2.setBackground(Color.LIGHT_GRAY);
        f2.setSize(500, 500);
        f2.setLayout(null);
        f2.setVisible(true);

        Label l8 = new Label("Meter Number");
        l8.setBounds(20, 50, 150, 20);
        t6 = new TextField();
        t6.setText(me_no);
        t6.setEditable(false);
        t6.setBounds(180, 50, 150, 20);
        f2.add(l8);
        f2.add(t6);

        Label l9 = new Label("Name");
        l9.setBounds(20, 80, 150, 20);
        t7 = new TextField();
        t7.setText(co_na);
        t7.setEditable(false);
        t7.setBounds(180, 80, 200, 20);
        f2.add(l9);
        f2.add(t7);

        Label l10 = new Label("Address");
        l10.setBounds(20, 110, 150, 20);
        tb = new TextArea();
        tb.setText(add);
        tb.setEditable(false);
        tb.setBounds(180, 110, 200, 100);
        f2.add(l10);
        f2.add(tb);

        Label l11 = new Label("Units Consumed (in Amp)");
        l11.setBounds(20, 230, 150, 20);
        t8 = new TextField();
        t8.setBounds(180, 230, 200, 20);
        f2.add(l11);
        f2.add(t8);

        Label l12 = new Label("Month");
        l12.setBounds(20, 260, 150, 20);
        ch = new Choice();
        ch.add("January");
        ch.add("February");
        ch.add("March");
        ch.add("April");
        ch.add("May");
        ch.add("June");
        ch.add("July");
        ch.add("August");
        ch.add("September");
        ch.add("October");
        ch.add("November");
        ch.add("December");
        ch.setBounds(180, 260, 200, 20);
        f2.add(l12);
        f2.add(ch);

        b3 = new Button("Generate Bill");
        b3.setBounds(80, 330, 100, 25);
        Electric_billing ob = new Electric_billing();
        b3.addActionListener(ob);
        f2.add(b3);

        b4 = new Button("Cancel");
        b4.setBounds(220, 330, 100, 25);
        b4.addActionListener(ob);
        f2.add(b4);
    }

    public static void bill() {
        f3 = new Frame("Bill Details");
        f3.setSize(500, 300);
        f3.setBackground(Color.LIGHT_GRAY);
        f3.setLayout(null);
        f3.setVisible(true);

        Label l13 = new Label("Energy Charge");
        l13.setBounds(20, 50, 150, 20);
        t9 = new TextField();
        t9.setBounds(180, 50, 150, 20);
        t9.setEditable(false);
        f3.add(l13);
        f3.add(t9);

        Label l14 = new Label("Electricity Duty");
        l14.setBounds(20, 80, 150, 20);
        t10 = new TextField();
        t10.setBounds(180, 80, 150, 20);
        t10.setEditable(false);
        f3.add(l14);
        f3.add(t10);

        Label l15 = new Label("Total Electricity Bill");
        l15.setBounds(20, 110, 150, 20);
        t11 = new TextField();
        t11.setBounds(180, 110, 150, 20);
        t11.setEditable(false);
        f3.add(l15);
        f3.add(t11);

        b4 = new Button("Close");
        b4.setBounds(100, 170, 200, 25);
        Electric_billing ob = new Electric_billing();
        b4.addActionListener(ob);
        f3.add(b4);

    }

}
