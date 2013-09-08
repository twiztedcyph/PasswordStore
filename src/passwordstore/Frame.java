
package passwordstore;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        try
        {
            FileCreate fileCreate = new FileCreate();
            dataArray = new DataArray(fileCreate.getFileName());
            dataArray.loadAllData();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        
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
                try
                {
                    if(siteEntry.getText().length() > 0 && userEntry.getText().length() > 0 && passEntry.getText().length() > 0)
                    {
                        dataArray.addData(siteEntry.getText(), userEntry.getText(), passEntry.getText());
                        siteEntry.setText("");
                        userEntry.setText("");
                        passEntry.setText("");
                        searchEntry.setText("");
                        JOptionPane.showMessageDialog(frame, "New entry added");
                    }else
                    {
                        JOptionPane.showMessageDialog(frame, "All three fields must be filled in.");
                    }
                } catch (Exception ex)
                {
                    System.out.println(ex);
                }
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
                if(searchEntry.getText().length() > 0)
                {
                    Data d = dataArray.findData(searchEntry.getText());
                    if(d != null)
                    {
                        JOptionPane.showMessageDialog(frame, "<html>" 
                                + d.getSite() + "<br />" 
                                + d.getUserName() + "<br />" 
                                + d.getPassword() + "<br />" 
                                + "</html>");
                        searchEntry.setText("");
                    }else
                    {
                        JOptionPane.showMessageDialog(frame, "No record found");
                    }
                }
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
                if(searchEntry.getText().equalsIgnoreCase("clearall"))
                {
                    try
                    {
                        dataArray.delAllData();
                    } catch (Exception ex)
                    {
                    }
                }
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
        g.drawRect(234, 5, 160, 50);
    }
}
