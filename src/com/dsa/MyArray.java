package src.com.dsa;

public class MyArray {

	// Arrays have constructor, get[i], push[i], pop, delete[i]

	Object[] data;
	int length;

	public MyArray() {
		this.length = 0;
		this.data = new Object[10];
	}

	public Object get(int index) {
		return this.data[index];
	}

	public void push(Object item) throws Exception {
		//We can also increase the capacity on the fly
		// check if valid index
			data[length] = item;
			length++;
	}

	public void add(Object item, int index) throws Exception {
			data[index] = item;
			length++;
	}
	
	public void pop() {
		// pop from the end of the array
		data[length-1] = null;
		length--;
		
	}
	
	public void delete(int index) {
		// shift all other items after this index to left by 1
		shiftItems(index);
		length--;
	}
	
	public void shiftItems(int index) {
		for(int i = index; i<length-1; i++) {
			data[i] = data[i+1];
		}
		// remove last index element
		data[length-1] = null;
	}

	public static void main(String args[]) throws Exception {
		MyArray myArray = new MyArray();
		myArray.push("hello");
		myArray.push("hi");
		myArray.push("world");
		myArray.pop();
		myArray.push("world2");
		myArray.push("world3");
		myArray.pop();
		myArray.push("world");
		myArray.push("world3");
		myArray.delete(1);
		
		System.out.println(myArray.length);
		for(int i = 0; i<myArray.length; i++) {
			System.out.println(myArray.data[i]);
			System.out.println(myArray.get(i));
			
		}
			
		/** Expected output
		 * 4
			hello
			hello
			world2
			world2
			world
			world
			world3
			world3
		 */

	}

}
