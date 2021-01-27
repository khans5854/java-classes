public class LinkedList {
	
	private class Node{
		int data;
		Node next;
	}
	private int size;
	private Node head;
	
	public void add(int value) {
		Node nn=new Node();
		nn.data=value;
		nn.next=null;
		this.size++;
		if(this.head==null) {
			this.head=nn;
			return;
		}
		Node temp=this.head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=nn;
	}
	public void display() throws Exception{
		if(this.head==null) {
			throw new Exception("Linked list is Empty");
		}
		Node temp=this.head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public void addFirst(int value) {
		Node nn=new Node();
		nn.data=value;
		nn.next=this.head;
		this.head=nn;
		this.size++;
	}
	public void addAt(int value,int i) throws Exception {
		if(i==0) {
			this.addFirst(value);
			return;
		}
		if(i==this.size) {
			this.add(value);
			return;
		}
		if(i>this.size||i<0) {
			throw new Exception("Invalid index");
		}
		Node nn=new Node();
		nn.data=value;
		nn.next=null;
		Node temp=this.head;
		for(int j=1;j<i;j++) {
			temp=temp.next;
		}
		nn.next=temp.next;
		temp.next=nn;
		this.size++;
		
	}
	public int getFirst() throws Exception{
		if(this.head==null) {
			throw new Exception("LinkedList is Empty");
		}
		return this.head.data;
		
	}
	public int getLast() {
		Node temp=this.head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		return temp.data;
		
	}
	public int getAt(int i) throws Exception{
		if(i==this.size||i<0) {
			throw new Exception("invalid index");
		}
		Node temp=this.head;
		for(int j=0;j<i;j++) {
			temp=temp.next;
		}
		return temp.data;
		
	}
	public void removeFirst() {
		this.head=this.head.next;
		this.size--;
	}
	public void removeLast() {
		if(this.size==1) {
			this.removeFirst();
			return;
		}
		Node temp=this.head.next;
		Node temp1=this.head;
		while(temp.next!=null) {
			temp=temp.next;
			this.head=this.head.next;
		}
		this.head.next=null;
		this.head=temp1;
		this.size--;
	}
	public void removeAt(int index) throws Exception{
		if(index<0||index>=this.size) {
			throw new Exception("invalid index");
		}
		if(index==0) {
			this.removeFirst();
		}
		else {
			Node temp=this.head;
			Node temp1=this.head.next;
			for(int i=1;i<index;i++) {
				this.head=this.head.next;
				temp1=temp1.next;
			}
			this.head.next=temp1.next;
			this.head=temp;
			this.size--;
		}
	}
	public int size() {
		return this.size;
	}
	public boolean isEmpty() {
		return (this.size==0);
	}


}
