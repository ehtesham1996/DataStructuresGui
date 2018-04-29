package Project;

public class Queue {
	public static final int maxlength=5;
	int rear;
	int front;
	int numitems;
	String[] queue;
	
	Queue(){
		queue=new String[maxlength];
		rear=maxlength-1;
		front=0;
		numitems=0;
	}
	
	boolean isEmpty(){
		return numitems==0;
	}
	
	boolean isFull(){
		return numitems==maxlength;
	}
	
	boolean Enqueue(String x){
		if(isFull()){
			return false;
		}
		else{
				rear++;
				if(rear>=maxlength){
					rear=0;
				}
			
			queue[rear]=x;
			numitems++;
			return true;
		}
	
}		
	
	boolean Dequeue(){
		
		if(isEmpty()){
			return false;
		}
		else{
			
			queue[front]="./";
			front++;
			if(front>=maxlength){
				front=0;
			}
			numitems--;
			return true;
		}
	
	}
	void makeEmpty(){
		rear=maxlength-1;
		front=0;
		numitems=0;
		for(int i=0;i<queue.length;i++){
			queue[i]=null;
		}
	}
	String printqueue(){
			String s="";
		    for(int i=0;i<queue.length;i++){
		    	if(queue[i]!=null){
		    	s+="---------------------------------------\n";
		    	if(front==rear && queue[i]!="./"){
		    		s+="Front/Last -->        "+queue[i]+"\n";
		    	}
		    	else if(rear==i && queue[i]!="./"){
		    		s+="Last       -->        "+queue[i]+"\n";
		    	}
		    	else if(front==i && queue[i]!="./"){
		    		s+="Front      -->        "+queue[i]+"\n";
		    	}
		    	else{
		    		if(queue[i]=="./"){
		    		s+="                         \n";
		    		}
		    		else
		    		s+="\t"+queue[i]+"\n";
		    	}
		    	}
		    }
		    return s;
		
	}
}
