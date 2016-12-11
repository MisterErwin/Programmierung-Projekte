public class List {
	public static final List EMPTY = new List(null,0);

	private final List next;

	private final int value;

	public List (List next, int value){
		this.next = next;
		this.value = value;
	} 

	public List getNext(){
		return this.next;
	}

	public int getValue(){
		return this.value;
	}

	public boolean isEmpty(){
		return this == EMPTY;
	}

	public int length(){
		if (this.isEmpty() || this.next == null)
			return 0;
		return this.next.length()+1; 
	}

	public List getSublist(int length){
		if (this.isEmpty() || this.next == null || length == 0)
			return EMPTY; 
		return new List(this.next.getSublist(length-1), this.value);
	}

	@Override
	public String toString(){
		String ts = _toString();
		return "List[" + (ts.isEmpty()?ts:ts.substring(0, ts.length()-2)) + "]";
	}

	private String _toString(){
		if (isEmpty() || this.next == null)
			return "";
		else return this.value + ", " + this.next._toString();
	}

	public static void main(String[] args) {
		List ll = new List(new List(new List(EMPTY,9), 99), 999);

		System.out.println(ll);
		System.out.println(ll.getSublist(0));
	}
}