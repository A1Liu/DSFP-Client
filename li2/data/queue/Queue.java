package data.queue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents an implementation of the queue interface, which is a first-in-first-out (FIFO) data storage system.
 * 
 * 
 * @author Alyer
 *
 * @param <T> The data type of the elements stored in the queue
 */
public class Queue<T> implements java.util.Queue<T> {
	
	private ListNode<T> front;
	private ListNode<T> back;
	private int size;
	
	public Queue() {
		front = null;
		back = null;
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		ListNode<T> node = front;
		
		while(node.getNext() != null) {
			if (node.getData().equals(o))
				return true;
			node = node.getNext();
		}
		return node.getData().equals(o);
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator<T>(front);
	}

	@Override
	public Object[] toArray() {
		Object[] a = new Object[size];
		ListNode<T> current = front;
		int index = 0;
		while (current != null) {
			a[index++] = current.getData();
			current = current.getNext();
		}
		return a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E[] toArray(E[] a) {
		Object[] array;
		try {
		array = (Object[]) a;
		} catch (Exception e) {throw new ArrayStoreException();}
		if (a.length < size) {
			array = Arrays.copyOf(array, size);
		}
		ListNode<T> current = front;
		int index = 0;
		while (current != null) {
			array[index++] = current.getData();
			current = current.getNext();
		}
		
		if (index < array.length)
			array[index] = null;
		try {
		return (E[]) array;} catch (Exception e) {throw new ArrayStoreException();}
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		Iterator<? extends T> iterator = c.iterator();
		while(iterator.hasNext()) {
			add(iterator.next());
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		front = null;
		back =  null;
	}

	@Override
	public boolean add(T e) {
		
		if (isEmpty()) {
			back = new ListNode<T>(e);
			front=back;
		}
		
		back.setNext(new ListNode<T>(e));
		back = back.getNext();
		size++;
		return true;
	}

	@Override
	public boolean offer(T e) {
		return add(e);
	}

	@Override
	public T remove() {
		if (front == null)
			throw new NoSuchElementException();
		T data = front.getData();
		front = front.getNext();
		size--;
		return data;
	}

	@Override
	public T poll() {
		if (front == null)
			return null;
		T data = front.getData();
		front = front.getNext();
		size--;
		return data;
	}

	@Override
	public T element() {
		try {
		return front.getData();
		} catch (NullPointerException e) {throw new NoSuchElementException();}
	}

	@Override
	public T peek() {
		return front==null ? null : front.getData();
	}
}
