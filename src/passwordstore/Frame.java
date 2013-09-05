
package passwordstore;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cypher
 */
public class Frame extends JPanel
{
    private JFrame frame;
    private JTextField siteEntry, userEntry, passEntry, searchEntry;
    private JLabel siteLabel, userLabel, passLabel, searchLabel, orLabel;
    private JButton addButton, searchButton, delButton;
    private DataArray dataArray;
    
    public Frame()
    {
        frame = new JFrame();
        frame.setTitle("Password Store by Twiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(400, 200));
        
        siteLabel = new JLabel("Site:");
        siteLabel.setBounds(13, 10, 50, 20);
        this.add(siteLabel);
        siteEntry = new JTextField();
        siteEntry.setBounds(13, 30, 150, 20);
        this.add(siteEntry);
        
        userLabel = new JLabel("Username:");
        userLabel.setBounds(13, 50, 100, 20);
        this.add(userLabel);
        userEntry = new JTextField();
        userEntry.setBounds(13, 70, 150, 20);
        this.add(userEntry);
        
        passLabel = new JLabel("Password:");
        passLabel.setBounds(13, 90, 100, 20);
        this.add(passLabel);
        passEntry = new JTextField();
        passEntry.setBounds(13, 110, 150, 20);
        this.add(passEntry);
        
        addButton = new JButton("Add new");
        addButton.setBounds(35, 150, 100, 30);
        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });
        this.add(addButton);
        
        searchLabel = new JLabel("Search or Delete");
        searchLabel.setBounds(240, 10, 150, 20);
        this.add(searchLabel);
        searchEntry = new JTextField();
        searchEntry.setBounds(240, 30, 150, 20);
        this.add(searchEntry);
        
        searchButton = new JButton("Search");
        searchButton.setBounds(260, 90, 100, 30);
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });
        this.add(searchButton);
        
        orLabel =  new JLabel("or");
        orLabel.setBounds(303, 125, 50, 20);
        this.add(orLabel);
        
        delButton = new JButton("Delete");
        delButton.setBounds(260, 150, 100, 30);
        delButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });
        this.add(delButton);
        
        
        frame.add(Frame.this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.black);
        g.drawRect(8, 5, 160, 130);
        g.drawRect(233, 5, 160, 50);
    }
}
