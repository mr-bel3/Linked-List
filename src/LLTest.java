
public class LLTest 
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.addLast(5);
		list.addLast(6);
		list.addFirst(4);
		list.addLast(7);
		list.addLast(8);
		System.out.println(list.toString());
		list.remove(6);
		System.out.println(list.toString());
	}
}
