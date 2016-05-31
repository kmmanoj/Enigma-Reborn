import java.util.*;
import java.io.*;
public class Tester
{
   public static void main(String args[])
   {
      EncryptFile enc=new EncryptFile();
      DecryptFile dec=new DecryptFile();
      try{
      enc.encryptFile();
      dec.decryptFile();}
      catch(Exception e){  System.out.println("FILE NOT FOUND!!");}
      }
}