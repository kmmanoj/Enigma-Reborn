public class Map
{
   Node[][] key=new Node[6][95];
   public Map()
   {
      for(int r=0;r<6;r++) for(int c=0;c<95;c++) key[r][c]=new Node('0');
      for(int r=0;r<6;r++) for(int c=0;c<94;c++) key[r][c].next=key[r][c+1];
      for(int r=0;r<6;r++)
      {
         for(int c=0;c<95;c++)
         {
            if(r!=5)key[r][c].down=key[r+1][c];
            if(r!=0)key[r][c].up=key[r-1][c];
         }
      }
      for(int i=32;i<127;i++) key[0][i-32].data=(char)i;
   }
   public void fill(int i,String seq)
   {
   		for(int x=0;x<95;x++)
   			this.key[i][x].data=seq.charAt(x);
   }	
}
