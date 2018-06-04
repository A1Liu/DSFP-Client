package data.queue;

public class ListNode<E> {
	
	private ListNode<E> next;
	private E data;
	
	ListNode(E data) {
		this(data,null);
	}
	
	ListNode(E data, ListNode<E> next) {
		this.data = data;this.next = next;
	}

	/**
	 * @return the next
	 */
	public ListNode<E> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(ListNode<E> next) {
		this.next = next;
	}

	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}
}
