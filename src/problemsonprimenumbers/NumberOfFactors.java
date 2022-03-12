package problemsonprimenumbers;

import java.util.*;
import java.io.*;

class NumberOfFactors {
	public static List<Integer> listOfPrimeFactors(int n) 
    {  
        Set<Integer> facs=new TreeSet<>();
		while (n%2==0) 
        { 
            facs.add(2); 
            n /= 2; 
        } 
   
        for (int i = 3; i <= Math.sqrt(n); i+= 2) 
        {  
            while (n%i == 0) 
            { 
                facs.add(i); 
                n /= i; 
            } 
        } 
   
        if (n > 2) 
            facs.add(n);
        List<Integer> list=new LinkedList<>();
        list.addAll(facs);
        return list;
    } 
    
	
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int t = Integer.parseInt(br.readLine()); 
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); 
            int[] arr=new int[n];
            String[] strs = br.readLine().trim().split("\\s+"); 
  
            for (int i = 0; i < n; i++) 
                arr[i]=Integer.parseInt(strs[i]);
                
            Map<Integer,Integer> facs=new LinkedHashMap<>();
            List<Integer> pfacs;
            int num,size,num2=0,count,j;
            for(int i=0;i<n;i++){
                num=arr[i];
                pfacs=listOfPrimeFactors(num);

                size=pfacs.size();
                count=0;
                j=0;
                
                while(num!=1 && j<size){
                    num2=pfacs.get(j);
                    count=0;
                    while(num%num2==0){
                        count++;
                        num=num/num2;
                    }
                    if(facs.containsKey(num2)){
                        facs.replace(num2,facs.get(num2)+count);
                    }else{
                        facs.put(num2,count);
                    }
                    j++;
                }
                
            }
            
            Iterator<Map.Entry<Integer,Integer>> it=facs.entrySet().iterator();
            Map.Entry<Integer,Integer> entry;
            int res=1;
            while(it.hasNext()){
                entry=it.next();
                res=res*(entry.getValue()+1);
            }
            System.out.println(res);
            
		}
		br.close();
	}
}