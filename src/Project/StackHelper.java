package Project;

import java.util.Stack;

public class StackHelper {
	Stack<String> s=new Stack<String>();
	int numItems;

	StackHelper(){
		
		numItems=0;
	}
	void push(String data){
		s.push(data);
		
	}
	String pop(){
		
		return s.pop();
	}
	boolean empty(){
		return s.empty();
	}
	String peek(){
		return s.peek();
	}
	
	String print(){
		@SuppressWarnings("unchecked")
		Stack<String> temp=(Stack<String>) s.clone();
		String returner="Top->\t";
		while(!temp.empty()){
			returner=returner+temp.pop()+"\n----------------------------------\n\t";
			
		}
		return returner;
	}
	
	void makeEmpty(){
		while(!s.empty()){
			s.pop();
		}
	}
}
