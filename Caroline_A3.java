//Name: Caroline Tang 
//Tutorial group: T06; 
//Declaration: Is my own work 

import javax.swing.JFrame; 
import javax.swing.JButton; 
import javax.swing.JTextArea; 
import java.awt.FlowLayout;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.Icon; 
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Image; 
import java.util.Scanner; 
import javax.swing.JLabel; 

import java.util.Arrays; 
import java.awt.Color; 
import java.awt.Font; 

class Room extends JFrame
{
	private final JTextArea messageArea, hostArea; 
	private final JButton [] jbArray;
    private final String nameArray [] = {"Kid 1", "Kid 2", "Kid 3", "Kid 4"};
    private final JButton host, clear; 
	private final String anArray [] = {"Hi i am the first participant, nice to meet you",
	                                    "Hi i am the second participant, hope you have a lovely day", 
										"Hi i am the third participant, i need no introduction", 
	                                    "Hi i am the last participant, nice guy finish last"};
	private final String picArray [] = {"1.gif", "2.gif", "3.gif", "4.gif"}; 
	private final String names [] = { "Amy", "Benny", "Chelsea", "Daniel"}; 
	
	public Room()
	{
		super ("Q & A room"); 
		setLayout(new FlowLayout()); 
		
		//have a message 
		messageArea = new JTextArea (8,40); 
		messageArea.setBackground(Color.BLACK); 
		messageArea.setFont(new Font("Sans-serif", Font.PLAIN, 20)); 
		messageArea.setForeground(Color.WHITE);
		add(messageArea);
		
		//add JLabel
		JLabel jl = new JLabel ("Host Area");
		add(jl);
		
		//host area
		hostArea = new JTextArea(8,40); 
		hostArea.setBackground(Color.BLUE); 
		hostArea.setFont(new Font("Sans-serif", Font.PLAIN, 20)); 
		hostArea.setForeground(Color.WHITE);
		add(hostArea); 
		
		ImageIcon icon = new ImageIcon(new ImageIcon("kid1.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)); //set the rollover icon
		
		//create 4 buttons 
		jbArray = new JButton [nameArray.length]; 
		
		for (int i = 0; i < jbArray.length; i++)
		{
			Icon ic = new ImageIcon(new ImageIcon("kid.png").getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
			jbArray [i] = new JButton ("Kid " + (i+1), ic);  
			jbArray[i].setRolloverIcon(icon);
			add(jbArray[i]); 
		}
		
		ImageIcon ic1 = new ImageIcon(new ImageIcon("guy.gif").getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT)); 
		host = new JButton("Host", ic1); 
		host.setBackground(Color.YELLOW);
		add(host); 
		
		ImageIcon ic2 = new ImageIcon(new ImageIcon("clear.gif").getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
		clear = new JButton("Clear", ic2);
		add(clear);
		
		//add the second images 
		for (int i = 0; i < names.length; i++)
		{
		    Icon ic = new ImageIcon(new ImageIcon(picArray[i]).getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT)); 
			String str = names[i] + " \n" + anArray[i];
			jbArray[i].addActionListener (x -> { 
				    String s = String.format("%s%n%s", messageArea.getText(), str); 
				    JOptionPane.showMessageDialog(null, s, "Welcome to chat room", JOptionPane.PLAIN_MESSAGE, ic); });
		}

		//add in the host 
		ImageIcon ic3 = new ImageIcon(new ImageIcon("host.gif").getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT)); 
		host.addActionListener(x -> {
		String s = hostArea.getText(); 
		JOptionPane.showMessageDialog(null, s, "I am the host", JOptionPane.PLAIN_MESSAGE, ic3); });
			
		
		
		for(int i = 0; i < jbArray.length; i++)
		{
			jbArray[i].addActionListener(new Comments (anArray[i], names[i]));
		}
		
		//clear text 
		clear.addActionListener( x -> {
		    messageArea.setText(""); 
			hostArea.setText(""); }); 
		
	}
	
	
	private class Comments implements ActionListener
	{
		private String sentence; 
		private String name; 
		private ImageIcon ic; 
		
		public Comments(String sentence, String name) 
		{
			this.sentence = sentence;
            this.name = name; 			
		}
	
	    @Override
		public void actionPerformed(ActionEvent e)
		{
			
			Scanner input = new Scanner (messageArea.getText());

		}
	}

}

class Caroline_A3
{
	public static void main (String [] arg) 
	{
		Room r = new Room();
		r.setSize(200, 100); 
		r.setVisible(true); 
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
}