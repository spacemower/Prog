import java.util.*;
public class DivideAndConquer {
	public static void main(String[] args){
		int[] a = {0,1,2,4,5,6,7};
		int ares = IndexSearcher(a,0,6);
		System.out.println(ares);
		int b[] = {1, 2, 3, 6};
	    int c[] = {4, 6, 8, 10};
		int bres = medianFinder(b,c,4);
		System.out.println("Median is" + bres);
		int d[] = {-2,11,-4,13,-5,2};
		int bestsum = contiguesSubsequence(d);
		System.out.println("Best consecutive sum is" + bestsum);
		int f[] = {1,2,3,4,10,20,30,40};
		shuffleAlternate(f,0,f.length-1);
		for(int i=0;i<f.length;i++){
			System.out.println(f[i]);
		}
		int cres = stockStrategy(c,0,c.length-1);
		System.out.println(cres);
	}
	public static int IndexSearcher(int[] a,int l,int r){
		int mid = (r-l)/2 +1;
		if(r-l<=1){
			if(a[r]==r || a[l]==l){
				return 1;
			}
			else{
				return 0;
			}
		}
		System.out.println(mid);
		System.out.println("the middle number is" + a[mid]);
		if(a[mid]<mid){
			return IndexSearcher(a,mid+1,r);		
		}
		if(a[mid]>mid){
			return IndexSearcher(a,l,mid-1);
		}
		
		return mid;
	}
	
	public static void shuffleAlternate(int[] a, int l, int r){
		int mid = (l+r)/2;
		int leftmid = (l+mid/2) +1;
		if(l==r)
			return;
		int m=leftmid;
		int n=1;
		while(m<=mid){
			int temp = a[m];
			a[m] = a[mid+n];
			a[mid+n]=temp;
			m++;
			n++;
		}
		
		shuffleAlternate(a,l,mid);
		shuffleAlternate(a,mid+1,r);
	}
	
	
	public static int stockStrategy(int[] a,int l,int r){
		int mid=l+r/2;
		
//		int minleft = stockStrategy(a,l,mid);
//		int maxright = stockStrategy(a,mid,r);
		int[] left = Arrays.copyOfRange(a, l, mid+1);
		int[] right = Arrays.copyOfRange(a, mid,r+1);
		
		int leftsideprofit = stockStrategy(left,l,mid);
		int rightsideprofit = stockStrategy(right,mid,r);
		
		int middleprof = findMax(right) - findMin(left);
		
		return maxOfThree(leftsideprofit,rightsideprofit,middleprof);
		
		
	}
	
	public static int findMax(int[] a){
		int max=Integer.MIN_VALUE;
		for (int i = 1; i < a.length; i++) {
	        if (a[i]>max) {
	            max = a[i];
	        }
	    }
	    return max;
	}
	
	public static int findMin(int[] a){
		int min=Integer.MAX_VALUE;
		for (int i = 1; i < a.length; i++) {
	        if (a[i]<min) {
	            min = a[i];
	        }
	    }
	    return min;
	}
	
	
	public static int medianFinder(int[] a,int[] b,int n){
		int m1 = findMedian(a,n);
		int m2= findMedian(b,n);
		
		if(m1==m2){
			return m1;
		}
		if(n==2){
			return (Math.max(a[0],b[0])+Math.max(a[1], b[1]))/2;
		}
		
		if(m1>m2){
			int mid=n/2;
			int[] temp1 = new int[mid+1];
			int j=0;
			while(j<=mid){
				temp1[j]=a[j];
				j++;
			}
			int[] temp2 = new int[mid];
			int k=mid;
			while(k<n){
				temp2[k-mid]=b[k];
				k++;
			}
			if(n%2==0){
				if(n/2==2){
					return (Math.max(temp1[0],temp2[0])+Math.max(temp1[1], temp1[1]))/2;
				}
				medianFinder(temp1,temp2,n/2);
				
			}
			else{
				if(n/2==2){
					return (Math.max(temp1[0],temp2[0])+Math.max(temp1[1], temp1[1]))/2;
				}
				medianFinder(temp1,temp2,(n/2)+1);
			}
		}
		if(m1<m2){
			int mid=n/2;
			int[] temp1 = new int[mid];
			int[] temp2 = new int[mid+1];
			int k=mid;
			while(k<n){
				temp1[k-mid]=a[k];
				k++;
			}
			int j=0;
			while(j<=mid){
				temp2[j]=b[j];
				j++;
			}
			if(n%2==0){
				if(n/2==2){
					return (Math.max(temp1[0],temp2[0])+Math.max(temp1[1], temp1[1]))/2;
				}
				medianFinder(temp1,temp2,n/2);
			}
			else{
				if(n/2==2){
					return (Math.max(temp1[0],temp2[0])+Math.max(temp1[1], temp1[1]))/2;
				}
				medianFinder(temp1,temp2,(n/2)+1);
			}
		}
		return 0;
	}
	
	public static int findMedian(int[] x,int siz){
		
		if(siz%2==0)
			return x[(siz/2)-1];
		else
			return x[siz/2];
	}
	
	public static int contiguesSubsequence(int[] a){
		if(a.length==0)
			return 0;
		return contiguesSubsequence(a,0,a.length-1);
	}
	
	public static int contiguesSubsequence(int[] a,int l,int r){
		int leftmid = Integer.MIN_VALUE;
		int rightmid= Integer.MIN_VALUE;
		int sum=0;
		if(l==r){
			return a[0];
		}
		int mid = l + (r-l)/2;
		int sumleft = contiguesSubsequence(a,l,mid);
		int sumright = contiguesSubsequence(a,mid+1,r);
		
		for(int i=mid;i>=l;i--){
			sum = sum+a[i];
			if(sum>leftmid){
				leftmid=sum;
			}
		}
		sum=0;
		for(int j=mid+1;j<=r;j++){
			sum=sum+a[j];
			if(sum>rightmid){
				rightmid=sum;
			}
		}
		return maxOfThree(sumleft,sumright,rightmid+leftmid);
	
	}
	
	public static int maxOfThree(int leftside,int rightside,int midpart){
		return Math.max(Math.max(leftside,rightside),midpart);
	}
	
}
