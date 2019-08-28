import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


/**
*	A generic linear data structure that enforces LIFO
*	(Last In, First Out).
*
*/
public class GenericStack<T>{
	
	
	public static void main(String [] args){
		GenericStack<String> stack = new GenericStack<String>();
		for(int x = 0; x <= 10; x++){
			stack.push("Stack " + x);
		}		
		stack.printStack();
		System.out.println("Pop the topmost item of stack:");
		stack.pop();
		stack.printStack();
		System.out.println("Swap the two topmost item of stack:");
		stack.swap();
		stack.printStack();
		System.out.println("Peek on the top. Value: " + stack.peek());
		System.out.println("Duplicate the topmost item of stack:");
		stack.duplicate();
		stack.printStack();
		System.out.println("Rotate to left the 5 topmost item of stack:");
		stack.rotate("left", 5);
		stack.printStack();
		System.out.println("Rotate to right the 5 topmost item of stack:");
		stack.rotate("right", 5);
		stack.printStack();
		
	}
	
	
	
		
	private List<T> stackList = Collections.emptyList();
	

	
	public GenericStack(){
			
	}
	
	/**
	*	Push an item to the stack.
	*	@param value A value to push on stack.	
	*/
	public void push(T value){
		if(stackList.isEmpty()){
			stackList = new ArrayList<T>();
		}
		stackList.add(0,value);
	}
	
	
	/**
	*	Remove the topmost item of the stack.
	*/
	public void pop(){
		if(!stackList.isEmpty()){
			stackList.remove(0);
			if(stackList.isEmpty()){
				stackList = Collections.emptyList();
			}
		}
		else{
			System.out.println("Error, stack is empty");
		}
		
	}
	
	/**
	*
	*	Inspect the topmost item of the stack.
	*
	*/
	public T peek(){
		if(!stackList.isEmpty()){
			return stackList.get(0);	
		}
		else{
			System.out.println("Error, stack is empty");
			return null;
		}
		
	}
	
	/**
	*	Swap the two topmost items of the stack.
	*
	*/
	public void swap(){
		
		if(!stackList.isEmpty() || stackList.size() >= 2){
			T buffer = stackList.get(0); 
			stackList.set(0,stackList.get(1));
			stackList.set(1,buffer);
			
		}
		else{
			System.out.println("Unable to swap. Stack is empty or stack size is less than 2");
		}
	}
	
	/**
	*	Pop the top of the stack, then push it two times.
	*
	*/
	public void duplicate(){
		
		T originalTop = peek();
		pop();
		push(originalTop);
		push(originalTop);
		
	}
	
	/**
	*	Rotate the stack from top to n.
	*	@param pos Rotates the stack on specified position.
	*			   whether left or right.
	*
	*	@param n Number of elements from top of the stack to be
	*			 rotated.
	*
	*/
	public void rotate(String pos, int n){
		
		
		if(n > stackList.size()){
			System.out.println("Error. Rotate boundary is higher than the stack itself");
		}
		else{
			// right rotate
			if(pos.toLowerCase().equals("right")){
				T buffer = peek(); 
				pop(); 
				stackList.add(n - 1, buffer);
			}
			// left rotate
			if(pos.toLowerCase().equals("left")){
				T buffer = stackList.get(n - 1);
				stackList.remove(n - 1);
				push(buffer);
			}
		}
		
	}
	
	
	
	
	//dummy
	public void printStack(){
		stackList.forEach(s -> System.out.println(s));
	}
	
	
	
	
}
