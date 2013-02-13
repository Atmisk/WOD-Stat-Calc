/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Mike
 */
public class CharacterSheetGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createAndShowGUI();
    }
    
    public static void createAndShowGUI(){
        JFrame mainFrame = new JFrame("Character Sheet");
        GridBagLayout mainLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem newFile = new JMenuItem("New");
        
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField(10);
        JLabel breedLabel = new JLabel("Breed");
        JTextField breedField = new JTextField(10);
        JLabel playerLabel = new JLabel("Player");
        JTextField playerField = new JTextField(10);
        JLabel tribeLabel = new JLabel("Tribe");
        JTextField tribeField = new JTextField(10);
        JLabel auspiceLabel = new JLabel("Auspice");
        JTextField auspiceField = new JTextField(10);
        JLabel campLabel = new JLabel("Camp");
        JTextField campField = new JTextField(10);
        JLabel packLabel = new JLabel("Pack");
        JTextField packField = new JTextField(10);
        JLabel totemLabel = new JLabel("Totem");
        JTextField totemField = new JTextField(10);
        
        menuBar.add(fileMenu);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(new Dimension(800, 600));
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setLayout(mainLayout); //READ MORE ON THIS        
        
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        mainFrame.add(nameLabel, c);
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        mainFrame.add(nameField, c);
        
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        mainFrame.add(playerLabel, c);
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        mainFrame.add(playerField, c);
        
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(tribeLabel, c);
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(tribeField, c);
        
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(breedLabel, c);
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 3;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(breedField, c);
        
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 2;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(auspiceLabel, c);
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 3;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(auspiceField, c);
        
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 2;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(campLabel, c);
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 3;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(campField, c);
        
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 4;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(packLabel, c);
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 5;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(packField, c);
        
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 4;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        
        
        mainFrame.add(totemLabel, c);
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        c.gridx = 5;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        mainFrame.add(totemField, c);
        
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null); // set frame to center of screen
        mainFrame.setVisible(true);
    }
    
}
