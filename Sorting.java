//import java.util.*;
public class Sorting {
	public static void main(String[] args){
		int[] arr = {5,4,6,2,8,1};
		System.out.println("The bubble sort output is");
		int[] bubble = bubbleSort(arr);
		for(int i=0;i<bubble.length;i++){
			System.out.print(bubble[i]+ " ");
		}
		System.out.println();
		System.out.println("The selection sort output is");
		int[] select = selectionSort(arr);
		for(int i=0;i<select.length;i++){
			System.out.print(select[i] + " ");
		}
		
		System.out.println();
		int[] arrs = {5,4,6,2,8,1};
		System.out.println("The selection sort better output is");
		int[] selectx = selectionSortBetter(arrs);
		for(int i=0;i<selectx.length;i++){
			System.out.print(selectx[i] + " ");
		}
		
		System.out.println();
		int[] arri = {5,4,6,2,8,1};
		System.out.println();
		System.out.println("The insertion sort output is");
		int[] inserte = insertionSort(arri);
		for(int i=0;i<inserte.length;i++){
			System.out.print(inserte[i] + " ");
		}
		
		
		int[] arr1 = {700,800,900,700};
		System.out.println();
		System.out.println("The counting sort output is");
		int[] countsort = countingSort(arr1,900);
		for(int i=0;i<countsort.length;i++){
			System.out.print(countsort[i] + " ");
		}
		
		
		
		int[] arr2 = {5,4,6,2,8,1};
		System.out.println();
		System.out.println("The merge sort output is");
		mergeSort(arr2,0,arr2.length-1);
		for(int i=0;i<arr2.length;i++){
			System.out.print(arr2[i] + " ");
		}
		
	}
	
	public static int[] bubbleSort(int[] arr){
		for(int i=arr.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static int[] selectionSort(int[] arr){
		int min=0;
		for(int i=0;i<arr.length;i++){
			min=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[min]){
					min=j;
				}
				int temp = arr[min];
				arr[min]=arr[i];
				arr[i]=temp;
			}
		}
		return arr;
	}
	
	public static int[] selectionSortBetter(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(arr[j]>=arr[i]){
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
			}
			}
		}
		return arr;
	}
	
	
	public static int[] insertionSort(int[] a){
		for(int i=1;i<a.length;i++){
			int temp = a[i];
			int j=i;
			while(j>0 && temp<a[j-1]){
				a[j]=a[j-1];
				j--;
			}
			a[j]=temp;
		}
		return a;
	}
	
	public static void mergeSort(int[] a,int start,int end){
		if(start<end){
			int mid = (start+end)/2;
			mergeSort(a,start,mid);
			mergeSort(a,mid+1,end);
			merge(a,start,mid,end);
			}
	}

	public static void merge(int[] a,int start,int mid,int end){
		int[] combined = new int[end-start+1];
		int leftindex= start;
		int rightindex=mid+1;
		int combindex =0;
		while(leftindex<=mid && rightindex<=end){
			if(a[leftindex]<a[rightindex]){
				combined[combindex++] = a[leftindex++];
				
			}
			else{
				combined[combindex++] = a[rightindex++];
				
				}
		}
		while(leftindex<=mid){
				combined[combindex++] = a[leftindex++];
			}
		while(rightindex<=end){
				combined[combindex++] = a[rightindex++];
			}
		for(int p=0;p<combined.length;p++){
			a[start+p]= combined[p];
			}
	}
	
	public static int[] countingSort(int[] a, int k){
		int[] counts = new int[k+1];
		int[] res = new int[a.length];
		for(int i=0;i<=k;i++){
			counts[i]=0;
		}
		for(int j=0;j<a.length;j++){
			counts[a[j]]=counts[a[j]]+1;
		}
		for(int m=1;m<=k;m++){
			counts[m]=counts[m]+counts[m-1];
		}
//		for(int n=a.length-1;n>=0;n--){
//			res[counts[a[n]]] = a[n];
//			counts[a[n]]--;
//		}
		for(int n=0;n<a.length;n++){
			res[counts[a[n]]-1] = a[n];
			counts[a[n]]--; 
		}
		return res;
	}
	
}
