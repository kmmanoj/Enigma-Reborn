import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
import java.util.*;
import java.io.*;

    
class MainFrame extends JFrame implements EventListener
{
	JFrame l;
	JPanel[][] panel;
	GridLayout a;
	static int clicks=0; 
	JButton b;
	public JTextField text=new JTextField("",30);
	public JTextField text1=new JTextField("",30); 
	JButton c;
	JTextArea title=new JTextArea("E N I G M A    R E B O R N",10,5);
	public JTextField result=new JTextField("",60);
	public JLabel label1=new JLabel("");
	public JFileChooser fileopen;
	public File selfile;
	public MainFrame()
	{
	  	super();
	  	l=new JFrame();
	  	panel= new JPanel[10][1];
	    l.setLayout(new GridLayout(10,1,10,0)); 
	    for(int m=0; m<10; ++m)
	     	for(int n=0; n<1; ++n)
	     	{
	     		panel[m][n] = new JPanel();
	     		l.add(panel[m][n]);
				panel[m][n].setBackground(Color.BLACK);
	     	}
	    a= new GridLayout();
	    result.setFont(new Font("Bradley Hand ITC",Font.BOLD,20));
	    result.setBackground(Color.BLACK);
	    result.setForeground(Color.BLUE);
	    title.setFont(new Font("Bradley Hand ITC",Font.BOLD,30));
	    text.setText(" Text to be encrypted  ");
	  
	    text1.setText("Key");
	      
	    result.setBackground(Color.BLACK);
	    title.setForeground(Color.BLUE);
	    title.setBackground(Color.BLACK);
	    b=new JButton("Encrypt"); 
	    b.addActionListener(new clicked());  
	    b.setActionCommand("Encrypt");
	   
	    c=new JButton("Decrypt");
	    c.addActionListener(new clicked()); 
	    c.setActionCommand("Decrypt"); 
	      
	    b.setBackground(Color.WHITE);
	    c.setBackground(Color.WHITE);
	    b.setForeground(Color.RED);
	    c.setForeground(Color.RED);
	    panel[0][0].add(title);  
	    panel[1][0].add(text);
	    panel[2][0].add(text1);
	    panel[3][0].add(b); 
	    panel[4][0].add(c); 
	    panel[6][0].add(result);
	    panel[7][0].add(label1);
	    
	      
	    l.setSize(1800,1500);   
	    l.setVisible(true);  
	    l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	class clicked implements ActionListener
	{

	    Algorithm call1;
		Algorithm call=new Algorithm();
	    String value;
	    String value1;
		public void actionPerformed(ActionEvent e)
		{
	   		String action=e.getActionCommand();
	   		/*if(action.equals("File"))
	   		{
	   			System.out.println("calling fil open");
	    		fileopen=new JFileChooser();
				int ft=fileopen.showOpenDialog(l);
				if(ft==fileopen.APPROVE_OPTION)
	    		selfile=fileopen.getSelectedFile();
		   	}    
		   	if(action.equals("Text"))
		   	{
		   
		   	}*/ 
		 
		   	if(action.equals("Decrypt"))
		   	{
		   		value=text.getText();
				value1=text1.getText();
			    if(value1.length()<5)
				{
					result.setForeground(Color.RED);
			   		result.setText("please enter the key of at least 5 characters");
					value1=text1.getText();
				}
			
				String decryptval=call.decrypt(value,value1);
				result.setForeground(Color.RED);
				result.setText(decryptval);
		   	}
		 
		   	if(action.equals("Encrypt"))
		   	{
			   	value=text.getText();
		   		value1=text1.getText();
		    	if(value1.length()<5)
				{
				result.setForeground(Color.RED);
				result.setText("please enter the key of at least 5 characters");
				value1=text1.getText();
				}
		     
			    call1 = new Algorithm();
			    String encryptval=call1.encrypt(value,value1);
			    result.setForeground(Color.RED);
				result.setText(encryptval);
		    }
		}
	}
}

