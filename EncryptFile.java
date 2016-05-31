import java.util.*;
import java.io.*;
public class EncryptFile 
{
    public void encryptFile() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Filename:");
        String file=s.nextLine();
        System.out.println("Enter key:");
        String key=s.nextLine();
        while(key.length()<5){System.out.println("Cannot create such a key. re-enter key:");
        key=s.nextLine();}
        for(int i=0;i<5;i++) key=key.substring(0,5);
        
        try{
        	FileReader filedec = new FileReader(file+".txt");
        	BufferedReader br = new BufferedReader(filedec);
        	String line;
        	FileWriter fileenc = new FileWriter(file+"x.txt");
        	while((line = br.readLine()) != null)
        	{
          		Algorithm c=new Algorithm();
          		String write=c.encrypt(line+" | ",key);
          		char buffer[] = new char[write.length()];
          		write.getChars(0, write.length(), buffer, 0);
          		fileenc.write(buffer);
          		fileenc.write("\n");
        	}
	       	filedec.close(); 
	       	fileenc.close(); 
	    	System.out.println("ENCRYPTED SUCCESSFULLY.FILE: "+file+"x.txt");      
        }
	    catch(Exception e)
	    {
	      	System.out.println("File not Found!!");
	    }
    }
} 