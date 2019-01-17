package com.rajinder.LinkedList;



public class LinkedListImp {

	public static void main(String[] args) {
		
		LinkedList list=new LinkedList();
		list.insertAt(-1, 25);
		list.insert(5);
		list.insertAt(4, 25);
		list.insert(10);
		list.insert(15);
		list.insert(20);
		list.insertAtStart(50);
		list.insertAt(0, 35);
		
		list.deleteAt(0);
		list.deleteAt(3);
		list.show();
	}
}
