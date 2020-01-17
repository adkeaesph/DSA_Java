package problemsonprimenumbers;

import java.util.LinkedList;
import java.util.List;

public class Primes {
	public static int findNthPrime(int n) {
		if (n == 1)
			return 2;
		List<Integer> primes = new LinkedList<>();
		primes.add(2);
		int i = 1;
		int num = 3;
		while (i <= n) {
			boolean isPrime = true;
			for (int j = 0; j < primes.size() && primes.get(j) <= Math.sqrt(num); j++) {
				if (num % primes.get(j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				i++;
				primes.add(num);
			}
			num++;
		}
		return primes.get(primes.size() - 1);
	}

	public static List<Integer> findPrimesInRange(int start, int end) {
		List<Integer> primes = new LinkedList<>();
		primes.add(2);
		int num = 3;
		int size;
		while (num <= end) {
			boolean isPrime = true;
			size = primes.size();
			for (int j = 0; j < size && primes.get(j) <= Math.sqrt(num); j++) {
				if (num % primes.get(j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(num);
			}
			num++;
		}

		while (!primes.isEmpty()) {
			if (primes.get(0) < start)
				primes.remove(0);
			else
				break;
		}
		return primes;
	}

	public static int largestPrimeFactor(int n) {
		List<Integer> primeFactors=new LinkedList<>();
		int size;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				size=primeFactors.size();
				boolean isPrimeFac=true;
				if(!primeFactors.isEmpty()) {	
					for(int j=0;j<size;j++) {
						if(i%primeFactors.get(j)==0) {
							isPrimeFac=false;
							break;
						}
					}
				}
				
				if(isPrimeFac)
					primeFactors.add(i);
			}
		}
		int b;
		if(n%2==0) {
			b=n/2;
			size=primeFactors.size();
			boolean isPrimeFac=true;
			if(!primeFactors.isEmpty()) {	
				for(int j=0;j<size;j++) {
					if(b%primeFactors.get(j)==0) {
						isPrimeFac=false;
						break;
					}
				}
			}	
			if(isPrimeFac)
				primeFactors.add(b);
		}
		
		if(!primeFactors.isEmpty()) {
			return primeFactors.get(primeFactors.size()-1);
		}
		return n;
	}
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(findNthPrime(n));
		int s = 12;
		int e = 100;

		System.out.println("List:");
		List<Integer> list = findPrimesInRange(s, e);
		for (Integer item : list)
			System.out.print(item + " ");
		
		n=16;
		System.out.println("\nLargest prime: ");
		System.out.println(largestPrimeFactor(n));
	
	}
}
