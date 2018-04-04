

import java.util.Scanner;

class palennum {
	public static int palcheck(long a)
	{
		long m,n=0,x;
		m=a;
		while(a>0)
		{
			x=a%10;
			n=n*10+x;
			a=a/10;
		}
		if(m==n)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public static long palnumber(long a)
	{
		long m,n=0,x;
		m=a;
		while(a!=0)
		{
			x=a%10;
			n=n*10+x;
			a=a/10;
		}
		if(n<0)
		{
			return 0;
		}
		return n;
	}
	public static void main(String[] args)
	{
		long n,temp=0,revn,sum,chk=0;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number");
		n=s.nextLong();
		while(palcheck(n)==0)
		{
			temp++;
			revn=palnumber(n);
			if(revn==0)
			{
				chk=1;
				break;
				
			}
			sum=n+revn;
			System.out.println(""+n+"+"+revn+"="+sum);
			n=sum;
			
		}
		if(chk==1)
		{
			System.out.println("this number maybe a Lychrel number!");
		}
		else
		{
		   System.out.println("We get the palandrome in "+temp+"th attempt");
		   System.out.println("The palandrome number is "+n);
		}
		
			
	}

}
