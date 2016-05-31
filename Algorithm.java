import java.util.*;
class Algorithm
{
	String s;
	char[] seq;
	public Algorithm()
	{
		s=null;
		seq=null;
	}
	public String encrypt(String d,String keys)
	{
	    s=d;
		keys=keys.replaceAll("//s","");
		char[] s1=new char[keys.length()];
		for(int i=0;i<keys.length();++i)
			s1[i]=keys.charAt(i);
		seq=new char[5];
		for(int i=0;i<5;i++)
			seq[i]=s1[i];
		
		String enc="";
		Map m=new Map();
		
      	Seqc sqc=new Seqc();
		for(int i=0;i<5;i++)
      	{ int z=0;   while(sqc.s[z].key!=seq[i]) z++;   //search for matching key to obtain sequence corresponding to that char
      		m.fill(i+1,sqc.s[z].sequence);   }             //fill the ith row of map by sequence defined by char
      
		int i=0;
      	int slen=s.length();       
      	while(i<slen-1)         // till last character but not the last character
		{
			int x=f(s.charAt(i+1));   // function on char
			Node tmp=m.key[0][0];     
			while(tmp.data!=s.charAt(i)) tmp=tmp.next;      //search for char
         	for(int q=1;q<x;q++) tmp=tmp.down;
			for(int q=1;q<=x;q++){ tmp=tmp.down; enc=enc+tmp.data; }         // update enc
			i++;
		}
     
		char last=s.charAt(i);     //last char
		i=0;
		Node tmp=m.key[0][0];
		while(tmp.data!=last){ tmp=tmp.next; i++; }      //search for char 
      	for(int q=1;q<2;q++) tmp=tmp.down;
		for(int q=1;q<=2;q++){ tmp=tmp.down; enc=enc+tmp.data;}             //update enc for last time
     	s=enc;
		return enc;                                        
	}           
   
	public String decrypt(String d,String keys)
	{    
	    s=d;
		keys=keys.replaceAll("//s","");
		char[] s1=new char[keys.length()];
		for(int i=0;i<keys.length();++i)
			s1[i]=keys.charAt(i);
		seq=new char[5];
		for(int i=0;i<5;i++)
			seq[i]=s1[i];
	  	String dec="";
      	StringBuilder str=new StringBuilder(s);
      	str=str.reverse();
		Map m=new Map();
     	Seqc sqc=new Seqc();
		for(int i=0;i<5;i++)
      	{ int z=0;   while(sqc.s[z].key!=seq[i]) z++;   //search for matching key to obtain sequence corresponding to that char
      		m.fill(i+1,sqc.s[z].sequence);   }             //fill the ith row of map by sequence defined by char
      	Node tmp=m.key[2][0];
	  	while(tmp.data!=str.charAt(1)) tmp=tmp.next;
		
		for(int z=2;z>0;z--)tmp=tmp.up;
		dec=dec+tmp.data;
		char prev=tmp.data;          
      	int strlen=str.length();
      	int i=2;
	  	while(i<strlen)
		{
			int x=f(prev);
			tmp=m.key[2*x-1][0];
        	while(tmp.data!=str.charAt(i)) tmp=tmp.next;
			for(int q=2*x-1;q>0;q--) tmp=tmp.up;
			dec=dec+tmp.data;
			prev=tmp.data;
         	i=i+x;
		}
		StringBuilder decsb=new StringBuilder(dec);
      	decsb=decsb.reverse();
		dec=decsb.toString();
      	s=dec;
	 	return dec;
	}
		
	int f(char a)
	{
		return (int)a%3+1;
	}
}		
