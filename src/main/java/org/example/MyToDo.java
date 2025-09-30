package org.example;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyToDo{
    public static void main(String[] args) {
        JFrame f = new JFrame("ToDo App");
        f.setSize(400, 400);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField tf = new JTextField(20);
        JButton add = new JButton("Add");
        JButton del = new JButton("Delete");

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        JScrollPane sp = new JScrollPane(list);
        sp.setPreferredSize(new Dimension(350, 200));

        f.add(tf);
        f.add(add);
        f.add(del);
        f.add(sp);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = tf.getText();
                if (!t.equals("")) {
                    model.addElement(t);
                    tf.setText("");
                } else {
                    JOptionPane.showMessageDialog(f, "Type something!");
                }
            }
        });

        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = list.getSelectedIndex();
                if (i != -1) {
                    model.remove(i);
                } else {
                    JOptionPane.showMessageDialog(f, "Select a task first!");
                }
            }
        });

        f.setVisible(true);
    }
}
