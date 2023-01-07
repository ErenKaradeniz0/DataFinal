package Heap;

public interface Queue<Type> {
	public void enqueue(Type data);
	public Type dequeue();
	public Type front();
	public boolean isEmpty();
}
