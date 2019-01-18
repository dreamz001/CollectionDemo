package com.rajinder.stackdemo;

public class Stack {

	private int[] arr=new int[2];
	private int top=0;
	private int capacity=2;
	
	public void push(int data) {
		if(arr.length==top) {
		//	System.out.println("Stack is full.");
			expand();
		}
		//else {
			arr[top]=data;
			top++;
		//}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty.");
		}else {
			top--;
			int temp=arr[top];
			arr[top]=0;
			if(top <= capacity/2){
				shrink();
			} 
			
			
			return temp;
		}
		return -1;
	}
	
	public int peek() {
		return arr[top-1];
	}
	
	public void show() {
		for(int data:arr) {
			System.out.print(data+" ");
		}
		System.out.println();
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top==0;
	}
	
	public void expand(){
		this.capacity=2*this.capacity;
		int[] newArr=new int[capacity];
		System.arraycopy(this.arr, 0, newArr, 0, size());
		this.arr=newArr;
	}
	
	public void shrink() {
		this.capacity=this.capacity/2;
		int[] newArr=new int[capacity];
		System.arraycopy(this.arr, 0, newArr, 0, size());
		this.arr=newArr;
	}
}
