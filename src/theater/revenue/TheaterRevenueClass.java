/**
 * Author: JOSE RAMIREZ - Misericordia University CPS 121
 * 
 * Instructor: Sylvia Appel
 * 
 * Assignment: Program Development #4
 * 
 * Program: Theater Revenue
 * 
 * Purpose: This program demonstrate the Theater Revenue class using a GUI.
 * 
 * Date: 12/02/2018
 */

package theater.revenue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;

/**
 * Theater Revenue Class
 * @author joseramirez
 */
public class TheaterRevenueClass extends JFrame
{
    private JFrame frame; // Frame object
    private JPanel panel; // Panel object
    private JLabel pricePerAdultTicketLabel; // Label object
    private JLabel adultTicketsSoldLabel;
    private JLabel pricePerChildTicketLabel; // Label object
    private JLabel childTicketsSoldLabel;
    private JTextField pricePerAdultTextField;
    private JTextField pricePerChildTextField;// Text Field object
    private JTextField adultTicketsSoldTextField;
    private JTextField childTicketsSoldTextField;
    private JButton calcButton; // Button object
    private JButton exitButton;
    private final int WINDOW_WIDTH = 225; // Width of the window
    private final int WINDOW_HEIGHT = 350; // Height of the window
    private DecimalFormat numFormat = new DecimalFormat("######.00"); // Number formatting
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int height = screenSize.height;
    private int width = screenSize.width;
    
    /**
     * Constructor
     */
    TheaterRevenueClass()
    {
        initialize();
    }
    
    /**
     * initialize method
     * Instantiates all the components for the program.
     */
    private void initialize()
    {
        // Frame instantiation
        frame = new JFrame(); 
        // Sets the window dimensions
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); 
        // Sets the title of the window
        frame.setTitle("Theater Revenue");
        // Makes sure the whole aplication is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sets the frame in the center of the screen regardless of the resolution
        frame.setLocation(screenSize.width/2-frame.getSize().width/2, screenSize.height/2-frame.getSize().height/2);
        
        // Panel instantiation
        panel = new JPanel();
        // Adds the panel to the frame
        frame.add(panel);     
        
        // Adding labels and text fields
        pricePerAdultTicketLabel= new JLabel("Price per adult ticket ");
        panel.add(pricePerAdultTicketLabel);
        
        pricePerAdultTextField = new JTextField(10);
        panel.add(pricePerAdultTextField);
        
        adultTicketsSoldLabel= new JLabel("Number of adult tickets sold ");
        panel.add(adultTicketsSoldLabel);
        
        adultTicketsSoldTextField = new JTextField(10);
        panel.add(adultTicketsSoldTextField);
        
        pricePerChildTicketLabel= new JLabel("Price per child ticket");
        panel.add(pricePerChildTicketLabel);
        
        pricePerChildTextField = new JTextField(10);
        panel.add(pricePerChildTextField);
        
        childTicketsSoldLabel= new JLabel("Number of child tickets sold");
        panel.add(childTicketsSoldLabel);
        
        childTicketsSoldTextField = new JTextField(10);
        panel.add(childTicketsSoldTextField);
        
        // Calculation button instantiation
        calcButton = new JButton("Calculate");
        
        panel.setVisible(true);
        
        /**
         * Calculation button event handler
         */
        calcButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                final double BOX_OFFICE_REVENUE_RATE = 0.20; // 20% Revenue
                
                String pricePerAdultInput = pricePerAdultTextField.getText();
                String adultTicketsSoldInput = adultTicketsSoldTextField.getText();
                String pricePerChildInput = pricePerChildTextField.getText();
                String childTicketsSoldInput = childTicketsSoldTextField.getText();
                
                double grossRevenueForAdultsTicketsSold;
                double netRevenueForAdultsForTicketsSold;
                double grossRevenueForChildTicketsSold;
                double netRevenueForChildTicketsSold;
                double totalGrossRevenue;
                double totalNetRevenue;
                
                if (pricePerAdultInput.equals("") || adultTicketsSoldInput.equals("") || pricePerChildInput.equals("") || childTicketsSoldInput.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "All values must be entered or enter zero for empty values.");
                }
                else
                {
                    // Revenue calculations
                    grossRevenueForAdultsTicketsSold = Double.parseDouble(pricePerAdultInput) * 
                                                       Double.parseDouble(adultTicketsSoldInput);

                    netRevenueForAdultsForTicketsSold = grossRevenueForAdultsTicketsSold * 
                                                        BOX_OFFICE_REVENUE_RATE;
                    grossRevenueForChildTicketsSold = Double.parseDouble(pricePerChildInput) * 
                                                      Double.parseDouble(childTicketsSoldInput);

                    netRevenueForChildTicketsSold = grossRevenueForChildTicketsSold * 
                                                    BOX_OFFICE_REVENUE_RATE;

                    totalGrossRevenue = grossRevenueForAdultsTicketsSold + 
                                        grossRevenueForChildTicketsSold;

                    totalNetRevenue = netRevenueForAdultsForTicketsSold + 
                                      netRevenueForChildTicketsSold;

                    // Displaying results to the screen
                    JOptionPane.showMessageDialog(null, "Gross revenue for adult tickets sold $" + numFormat.format(grossRevenueForAdultsTicketsSold) +
                                "\nNet revenue for adult tickets sold $" + numFormat.format(netRevenueForAdultsForTicketsSold) + 
                                "\nGross revenue for child tickets sold $" + numFormat.format(grossRevenueForChildTicketsSold)+
                                "\nNet revenue for child tickets sold $" + numFormat.format(netRevenueForChildTicketsSold)+
                                "\nTotal gross revenue $" + numFormat.format(totalGrossRevenue)+
                                "\nTotal net revenue $" + numFormat.format(totalNetRevenue));
                }        
            } // end of calc button actionPerformed
        }); // end of calc button actionListener
        
        // Adds calculation button
        panel.add(calcButton);
        
        // Exit button instantiation
        exitButton = new JButton("Exit");
        
        /**
         * Exit button event handler
         */
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            } // end of exit button actionPerformed
         }); // end of exit button eventListener
        
        // Adds exit button
        panel.add(exitButton);
        
        // Displays the frame
        frame.setVisible(true);
    }
    
    /**
     * main method 
     */
    public static void main(String[] args) 
    {
        // Property tax class instantiation
        new TheaterRevenueClass();
    } // end of main
} // end of Theater Revenue class
