package model;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;


public class About {
    private final JFrame myFrame;
    private final JMenuBar myMenuBar;
    private final JMenu myOwnerJMenu;
    private final JMenu myAboutJMenu;
    private final JMenuItem myNameItem;
    private final JMenuItem myEmailItem;
    private final JMenuItem myVersionItem;
    private final JMenuItem myDeveloperItem;

    public About() {
        myFrame = new JFrame("About");
        myMenuBar = new JMenuBar();
        myOwnerJMenu = new JMenu("Owner");
        myAboutJMenu = new JMenu("About");
        myNameItem = new JMenuItem("Name");
        myEmailItem = new JMenuItem("Email");
        myVersionItem = new JMenuItem("Version");
        myDeveloperItem = new JMenuItem("Developers");

        myOwnerJMenu.add(myNameItem);
        myOwnerJMenu.addSeparator();
        myOwnerJMenu.add(myEmailItem);

        myAboutJMenu.add(myVersionItem);
        myAboutJMenu.addSeparator();
        myAboutJMenu.add(myDeveloperItem);

        myMenuBar.add(myOwnerJMenu);
        myMenuBar.add(myAboutJMenu);

        myFrame.setJMenuBar(myMenuBar);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();

        final Toolkit kit = Toolkit.getDefaultToolkit();
        // position the frame in the center of the screen
        myFrame.setLocation((int) (kit.getScreenSize().getWidth() 
        / 2 - myFrame.getWidth() / 2),
        (int) (kit.getScreenSize().getHeight() / 2 - myFrame.getHeight() / 2));

        myFrame.setVisible(true); 

        setup();

   }
    
   private void setup() {
        myDeveloperItem.addActionListener(new AboutActionListener()); 
   }

   private class AboutActionListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            final Team team = new Team();
            Map<Integer, String> map = team.getDevelopers();
            JTable table = new JTable(map.size(), 2);
            int row = 0;
            for(Map.Entry<Integer, String> entry : map.entrySet()) {
                table.setValueAt(entry.getKey(),row,0);
                table.setValueAt(entry.getValue(),row,1);
                row++;
            }
        }
   }
}
