package com.rajinder.LinkedList;

public class LinkedList {

	private Node head;
	
	public void insert(int data) {
		Node node=new Node(data, null);
		if(head==null) {
			head=node;
		}else {
			Node n=head;
			while(n.getNext()!=null){
				n=n.getNext();
			}
			n.setNext(node);
		}
	}
	
	public void insertAtStart(int data) {
		Node node = new Node(data,null);
		node.setNext(head);
		head=node;
	}
	public void insertAt(int index, int data) {
		Node newNode = new Node(data,null);
		if(index<0) {
			System.out.println("Position can't be negative.");
		}else if(index==0) {
			insertAtStart(data);
		}else {
			Node node= head;
			for(int i=0;i<index-1;i++) {
				if(node.getNext()==null) {
					i=index;
				}else {
					node=node.getNext();
				}
			}
			newNode.setNext(node.getNext());
			node.setNext(newNode);
		}
		
	}
	
	public void deleteAt(int index) {
		if(index==0){
			head=head.getNext();
		}else{
			Node node = head;
			for(int i=0;i<index-1;i++){
				if(node.getNext()==null){
					i=index;
				}else{
					node = node.getNext();
				}
			}
			Node temp=node.getNext();
			node.setNext(temp.getNext());
			System.out.println("Removed:"+temp.getData());
			temp=null;
		}
	}
	
	public void show() {
		Node node=head;
		while(node.getNext()!=null) {
			System.out.print(node.getData()+ " ");
			node=node.getNext();
		}
		System.out.println(node.getData());
	}
}
