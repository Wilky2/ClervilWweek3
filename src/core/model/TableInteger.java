package core.model;

import java.util.Arrays;

public class TableInteger{
	
	private int size;
	private int[] values;

	public TableInteger(int size) {
		this.size = size;
		this.values = new int[size];
	}

	
	public int getSize() {
		return this.size;
	}

	public void setValue(int position,int value) {
		this.values[position] = value;
	}
	
	public int getValue(int position) {
		return this.values[position];
	}	

@Override
	public String toString() {
		return "TableInteger [size=" + size + ", values=" + Arrays.toString(values) + "]";
	}

	//******************************************************************************
//******************************************************************************
	public void permute(int position1,int position2) {
		int temp = this.values[position1];
		this.values[position1]=this.values[position2];
		this.values[position2]=temp;
	}
	
	private boolean comparison(int number1,int number2,Order order) {
		if(order == Order.ASC) {
			return number1>number2;
		}
		
		return number1<number2;
	}
//**************************Les algorithmes de tri******************************
//********************************Tri rapide************************************
	private int pivotPosition(int start, int end,Order order) {
		int pivotValue = this.values[start];
		int leftIndex = start;
		int rightIndex = end + 1;
		boolean noPlace=true;
		
		while(noPlace) {
			leftIndex++;
			while(leftIndex<end && comparison(pivotValue,this.values[leftIndex],order)) {
				leftIndex++;
			}
			
			rightIndex--;
			while(rightIndex>start && !comparison(pivotValue,this.values[rightIndex],order)) {
				rightIndex--;
			}
			
			if(leftIndex<rightIndex) {
				permute(leftIndex,rightIndex);
			}
			else {
				noPlace = false;;
			}
		}
		
		permute(start,rightIndex);
		return rightIndex;
	}
	
	private void fastSort(int start,int end,Order order) {
		if(start >= end) {
			return;
		}
		
		int pivot = pivotPosition(start,end,order);
		
		fastSort(start,pivot-1,order);
		fastSort(pivot+1,end,order);
	}
	
	public void fastSort(Order order) {
		fastSort(0,this.size-1,order);
	}
//****************************tri par insertion*********************************
	public void insertSort(Order order) {
		int valueToInsert;
		int index;
		for(int i = 1; i<this.size;i++) {
			valueToInsert = this.values[i];
			index = i-1;
			
			while(index>=0 && comparison(this.values[index],valueToInsert,order)) {
				this.values[index + 1] = this.values[index];
				index--;
			}
			
			this.values[index + 1] = valueToInsert;
		}
	}
//*********************************Tri a bulles*********************************
	public void bubbleSort(Order order) {
		int i;
		boolean unsorted = true;
		while(unsorted) {
			unsorted = false;
			for(i=0;i<this.size-1;i++) {
				if(comparison(this.values[i],this.values[i+1],order)) {
					permute(i,i+1);
					unsorted=true;
				}
			}
		}
	}
//*****************************tri par selection********************************
	public void selectionSort(Order order) {
		int index;
		int j;
		for(int i = 0;i<this.size-1;i++) {
			index=i;
			for(j=i+1;j<this.size;j++) {
				if(comparison(this.values[index],this.values[j],order)) {
					index = j;
				}
			}
			permute(i,index);
		}
	}
//******************************************************************************
//************************recherche Dichotomique********************************
	private boolean dichoSearch(int value,int left,int right,Order order) {
		int medium = (left + right)/2;
		
		if(this.values[medium]==value) {
			return true;
		}
		
		if(left >= right) {
			return false;
		}
		
		if(comparison(this.values[medium],value,order)) {
			return dichoSearch(value,left,medium-1,order);
		}
		
		return dichoSearch(value,medium+1,right,order);
		
	}
	
	public boolean dichoSearch(int value,Order order) {
		return dichoSearch(value,0,this.size-1,order);
	}
//****************************rechercher par saut*******************************
	public boolean jumpSearch(int value,Order order) {
		int jump = (int) Math.sqrt(this.size);
		int index1=0;
		int index2=1;
		while(comparison(value,this.values[Math.min(index2,this.size-1)],order)){
			index1=index2;
			index2+=jump;
			if(index1>=this.size) {
				return false;
			}
		}
		
		int min = Math.min(index2, this.size-1);
		
		for(int i = index1;i<=min;i++) {
			if(this.values[i]==value) {
				return true;
			}
		}
		
		return false;
	}
//*******************************recherche exponentielle************************
	public boolean exponentialSearch(int value,Order order) {
		int i = 0;
		if(this.values[i]==value) {
			return true;
		}
		
		i=1;
		
		while(i<this.size && comparison(value,this.values[i],order)) {
			i*=2;
		}
		
		return dichoSearch(value,i/2,Math.min(i,this.size-1),order);
	}
//*******************************recherche lineaire*****************************
	public boolean linearSearch(int value) {
		for(int i = 0;i<this.size;i++) {
			if(this.values[i]==value) {
				return true;
			}
		}
		
		return false;
	}
}	