package pl.wipb.ztp.ps4;

import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class PS4 {
	
	private static Logger LOGGER = Logger.getLogger(PS4.class.getName());

    public static void main(String[] args) {
    	try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        	LOGGER.log(Level.SEVERE, null, ex);
        }

        final Baza baza = new Baza();
        Adapter adapter =new Adapter();
        final JFrame frame = new JFrame("Zadanie 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane splitPane = new JSplitPane();

        final JList<Data> list = new JList<>(baza);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Tablice: "));
        splitPane.setLeftComponent(scrollPane);
        JTable table = new JTable(/* ... tutaj dodaj adapter: TableModel ...*/adapter);
        scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Zawartość: "));
        splitPane.setRightComponent(scrollPane);

        frame.getContentPane().add(splitPane);

        JMenuBar bar = new JMenuBar();
        JButton add = new JButton("Dodaj tablicę");
        JButton del = new JButton("Usuń tablicę");
        bar.add(add);
        bar.add(del);

        frame.setJMenuBar(bar);

        frame.setSize(600, 450);
        frame.setVisible(true);

        splitPane.setDividerLocation(0.5);

        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String value = JOptionPane.showInputDialog(frame,
                        "Podaj rozmiar tablicy",
                        "Dodaj",
                        JOptionPane.INFORMATION_MESSAGE);
                try{
                    int size = Integer.parseInt(value);
                    baza.add(new Proxy(size));
                    adapter.newData((Data)baza.getElementAt(baza.getSize()-1));
                } catch(Exception ex) {
                    LOGGER.log(null, "Exception happened", ex);
                };
            }
        });
        del.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int idx = list.getSelectedIndex();
                try{
                    baza.remove(idx);
                } catch(Exception ex) { 
                	LOGGER.log(null, "Exception happened", ex);
                };
            }
        });

        // zmiana wyboru na liście powoduje odświeżenie tabeli
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int idx = list.getSelectedIndex();
                if (idx >= 0) {
                    adapter.newData((Data)baza.getElementAt(idx));
                }
            }
        });
    }
}
