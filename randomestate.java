
import java.util.*;
import java.awt.*;
import javax.swing.*;

class MyPanel extends JPanel
{
	int a[],count=0,xsize=0,ysize=0;
	int b[][];
	public void paint(Graphics g)
	{
		for(int i=0;i<xsize;i++)
		{
			for(int j=0;j<ysize;j++)
			{
				if(b[i][j]==1)
				{
					g.setColor(Color.red);
				}
				else if(b[i][j]==2)
				{
					g.setColor(Color.blue);
				}
				else if(b[i][j]==3)
				{
					g.setColor(Color.green);
				}
				else if(b[i][j]==4)
				{
					g.setColor(Color.black);
				}
				int temp1=i*50;
				int temp2=j*50;
				int temp11=temp1+50;
			    int temp22=temp2+50;
			
				g.fillRect(temp2,temp1,temp22,temp11);
			}
			
			
				
		}
		
		
	}
	
}

public class randomestate {
	
	public static int[][] a=new int[5][5];
	public static int[] check=new int[10];
	public static Scanner sc;
	public static int asize;
	public static int bsize;
	public static void crmatrix(int hk)
	{
		
		int onepresent=0;
		int twopresent=0;
		int threepresent=0;
		int fourpresent=0;
		for(int i=0;i<asize;i++)
		{
			for(int j=0;j<bsize;j++)
			{
				a[i][j]=0;
			}
		}
		for(int i=0;i<10;i++)
		{
			check[i]=0;
		}
		a[0][0]=hk;
		int count=0;
		for(int i=0;i<asize;i++)
		{
			for(int j=0;j<bsize;j++)
			{
				if(i==0 && j==0)
				{
					continue;
				}
				if((i-1)!=-1)
				{
					check[count]=a[i-1][j];
					count++;
				}
				if((j-1)!=-1)
				{
					check[count]=a[i][j-1];
					count++;
				}
				if((j+1)!=bsize)
				{
					check[count]=a[i][j+1];
					count++;
				}
				if((i+1)!=asize)
				{
					check[count]=a[i+1][j];
					count++;
				}
				if((i-1)!=-1 && (j-1)!=-1)
				{
					check[count]=a[i-1][j-1];
					count++;
				}
				if((i-1)!=-1 && (j+1)!=bsize)
				{
					check[count]=a[i-1][j+1];
					count++;
				}
				if((i+1)!=asize && (j-1)!=-1)
				{
					check[count]=a[i+1][j-1];
					count++;
				}
				if((i+1)!=asize && (j+1)!=bsize)
				{
					check[count]=a[i+1][j+1];
					count++;
				}
				for(int k=0;k<count;k++)
				{
					
					
					if(check[k]==1)
					{
						onepresent=1;
					}
					if(check[k]==2)
					{
						twopresent=1;
					}
					if(check[k]==3)
					{
						threepresent=1;
					}
				    if(check[k]==4)
					{
						fourpresent=1;
					}
				}
			
				
				if(onepresent==0)
				{
					a[i][j]=1;
				}
				if(twopresent==0)
				{
					a[i][j]=2;
				}
				if(threepresent==0)
				{
					a[i][j]=3;
				}
				if(fourpresent==0)
				{
					a[i][j]=4;
				}
				count=onepresent=twopresent=threepresent=fourpresent=0;
				for(int k=0;k<10;k++)
				{
					check[k]=0;
				}
				
				
			}
		}
	}
	public static int checkmatrix()
	{
		for(int i=0;i<asize;i++)
		{
			for(int j=0;j<bsize;j++)
			{
				if(a[i][j]==0)
				{
					return 1;
					
				}
			}
			
		}
		return 0;
	}


	public static void main(String args[])
	{
		
		int roll=1;
		int asize1,bsize1;
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter the matrix size of 1st array");
		asize1=sc1.nextInt();
		System.out.println("Enter the matrix size of 2nd array");
		bsize1=sc1.nextInt();
		
		MyPanel panel=new MyPanel();
	
		JFrame frame=new JFrame("JFrame colour example");
		frame.setSize(900,900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(false);
		panel.xsize=asize1;
		panel.ysize=bsize1;
		//panel.getsize(asize1, bsize1);
		asize=asize1;
		bsize=bsize1;
		a=new int[asize][bsize];
		crmatrix(roll);
		while(checkmatrix()==1)
		{
			if(roll<=4)
			{
			  roll++;
			  crmatrix(roll);
			}
			else
			{
				break;
			}
		}
	
		
		
	
	
			
		panel.b=a;
		frame.setVisible(true);
	
		
		
	}

}
