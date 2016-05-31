import java.util.*;
import java.io.*;
public class DecryptFile 
{
    public void decryptFile() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter original Filename:");
        String file=s.nextLine();
        System.out.println("Enter key:");
        String key=s.nextLine();
        while(key.length()<5){System.out.println("Cannot create such a key. re-enter key:");
        key=s.nextLine();}
        for(int i=0;i<5;i++) key=key.substring(0,5);
        
        try
    	{
	        FileReader filedec = new FileReader(file+"x.txt");
	        BufferedReader br = new BufferedReader(filedec);
        	String line;
          	FileWriter fileenc = new FileWriter(file+"xx.txt");
          	while((line = br.readLine()) != null)
          	{  	
          		Algorithm c=new Algorithm();
             	String write=c.decrypt(line,key);
             	char buffer[] = new char[write.length()];
             	write.getChars(0, write.length(), buffer, 0);
             	fileenc.write(buffer);
          	}
          	filedec.close(); 
          	fileenc.close();
          	System.out.println("DECRYPTED SUCCESSFULLY.FILE:"+file+".txt");      
        }
       	catch(Exception e)
       	{
        	System.out.println("File not Found!!");
        }
    }
} 