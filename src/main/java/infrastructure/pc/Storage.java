package infrastructure.pc;

/**
 * @Author: Alex.Z
 * @DATE: 2019/10/14
 * @Description:
 */
public class  Storage<T> {

	T[] buffer;
	int capacity;
	int head;
	int end;
	int size;
	int rear;

	public Storage(int capacity) {
		this.capacity = capacity;
		buffer = (T[]) new Object[capacity];
		size = 0;
		head = 0;
		end = 0;
	}

	public void put(T obj){
		synchronized (this){
			while(full()){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (!full()){
				try {
					buffer[end++] = obj;
					if(end>=capacity) rear=1-rear;
					end = end%capacity;
					System.out.println("放入"+obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			this.notify();
		}
	}

	public T get(){
		synchronized (this){
			while (empty()){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(!empty()){
				try {
					T ret = buffer[head++];
					if(head>=capacity) rear=1-rear;
					head = head%capacity;
					System.out.println("拿出"+ret);
					this.notify();
					return ret;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}


	public boolean full() {
		return (end==head && rear==1);
	}

	public boolean empty(){
		return (end==head && rear==0);
	}
}
