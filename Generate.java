import java.util.*;
public class Generate
{
   public static void main(String args[])
   {
      int[] v=new int[95];
      for(int i=0;i<95;i++)
      {
         int count=0;
          for(int j=0;j<95;j++)v[j]=0;
          int x=0;
          String pattern="";
          while(count!=95)
          {
            x=(int)Math.floor(Math.random()*95);
              if(v[x]==0){if((char)(x+32)=='\'' || (char)(x+32)=='\"' || (char)(x+32)=='\\') pattern+='\\'; pattern+=(char)(x+32); v[x]=1; count++; }
          }
          System.out.println("s["+i+"]=new Sequence(\'"+(char)(i+32)+"\',\""+pattern+"\");");
      }
  }
}