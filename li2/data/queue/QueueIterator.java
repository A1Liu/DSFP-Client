package data.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueIterator<T> implements Iterator<T> {

	private ListNode<T> front;
	
	QueueIterator(ListNode<T> front) {
		this.front = front;
	}
	
	@Override
	public boolean hasNext() {
		return front == null;
	}

	@Override
	public T next() {
		if (front == null) {
			throw new NoSuchElementException();
		} else {
			T data = front.getData();
			front = front.getNext();
			return data;
		}
	}

}
