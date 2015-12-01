public class LinkedList 
{
	private Node head;

	public LinkedList()
	{
		this.head = null;
	}

	public LinkedList(int d)
	{	
		Node nodeToAdd = new Node(d);
		this.head = nodeToAdd;
	}

	public void addLast(int d)
	{	
		Node nodeToAdd = new Node(d);
		if(head == null)
		{
			head = nodeToAdd;
		}
		else
		{
			Node current = head;
			while(current.next != null)
			{
				current = current.next;// current = current.getNext();
			}
			current.next = nodeToAdd;
		}
	}

	public void addFirst(int d)
	{
		Node nodeToAdd = new Node(d);
		if(head == null)
		{
			head = nodeToAdd;
		}
		else
		{
			Node current = nodeToAdd;
			current.next = head;
			head = current;
		}
	}

	public Node getFirst()
	{
		//System.out.println(head.data);
		return head;
	}

	public Node getLast()
	{
		Node current = head;

		while(current.next != null)
		{
			current = current.next;
		}
		//System.out.println(current.data);
		return current;
	}

	public String toString()
	{
		String s = "";// this string is going to be used to store all the data. Then we can use it and display the data in a string
		Node current = head;
		while( current != null)
		{
			s = s + current.data + ",";
			current = current.next;
		}

		if(s.length() - 1 > 0 && s.charAt(s.length()-1) == ',')
		{
			s = s.substring(0, s.length() - 1);//this line eliminates the last comma (',') in the string
		}

		return s;
	}

	public Node removeFirst()
	{
		return head = head.next;
	}

	public Node removeLast()
	{
		Node current = head;
		while(current.next.next != null)
		{
			current = current.next;
		}
		return current.next = null;
	}
	
	public void emptyList()
	{
		head = null;
	}
	
	public boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void addAfter(int find, int add)
	{
		Node nodeToAdd = new Node(add);
		Node current = head;
		while(current.data != find && current.next != null)
		{
			current = current.next;
		}
		
		if(current.next == null && current.data == find)
		{
			addLast(add);
		}
		else if(current.next == null)
		{
			System.out.println("we couldn't find your data to add after");
		}
		else
		{
			Node temp = nodeToAdd;
			temp.next = current.next;
			current.next = temp;
		}
	}
	
	public void addBefore(int find, int add)
	{
		Node nodeToAdd = new Node(add);
		Node current = head;
		if(find == current.data)
		{
			addFirst(add);
			return;
		}
		
		while(current.next != null  && current.next.data != find)
		{
			current = current.next;
		}
		if(find != current.data && current.next == null)
		{
			System.out.println("we couldn't find your data to add after");
		}
		else
		{
			Node temp = nodeToAdd;
			temp.next = current.next;
			current.next = temp;
		}
	}

	public Node remove(int find)
	{
		Node returnNode = null;
		if(find == head.data)
		{
			returnNode = removeFirst();
		}
		Node current = head;
		while(current.next != null && find != current.next.data)
		{
			current = current.next;
			System.out.println(current.data);
		}
		if(current.next == null && find == current.data)
		{
			returnNode = removeLast();
		}
		else if(current.next != null && current.next.data == find)
		{
			Node temp = current.next.next;
			current.next = temp;
			returnNode = current.next; //return current.next = temp;?
		}
		else
		{
			System.out.println("Since we couldnt find the data you asked us to look for, we couldnt remove it");
		}
		return returnNode;
	}
	
	/**
	 * @author abeltre
	 * The following class helps us create a node that we can use to store data in to reference a following node in the linkedlist
	 */
	private class Node
	{
		private Node next;
		private int data;

		public Node(int d)
		{
			this.data = d;
			this.next = null;
		}
	}
}
