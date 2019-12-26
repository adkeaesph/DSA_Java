package greedyalgo;

import java.util.Scanner;

import customexceptions.InvalidProperFractionException;

public class EgyptianProblem {

	public static long lcmOfTwo(long n1, long n2) {
		int i=2;
		long lcm;
		if(n1>n2)
			lcm=n1;
		else
			lcm=n2;
		  
		long b=lcm;
		while(lcm%n1!=0 || lcm%n2!=0)
		{
			lcm=b*i;
			i++;
		}
		return lcm;
	}
	
	public static void main(String[] args) throws InvalidProperFractionException {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long d=sc.nextLong();
		long D,N,num=1,den;
		if(n>=d) {
			try {
				throw new InvalidProperFractionException("Denominator should be strictly greater than numerator");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally {
				sc.close();
			}
		}else {
			System.out.print(n+"/"+d+" = ");
			while(true) {
				if(d%n!=0) 
					den=d/n+1;
				else
					den=d/n;
				
				System.out.print(num+"/"+den+" ");
				D=lcmOfTwo(den, d);
				N=D/d*n-D/den*num;
				if(N==0)
					break;
				
				d=D;
				n=N;
			}
		}
		sc.close();
	}
}
