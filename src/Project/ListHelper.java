package Project;

import java.util.LinkedList;
import java.util.List;


public class ListHelper {
	List<Integer> l;
	
	ListHelper(){
		l=new LinkedList<Integer>();
	}
	void insert(int value){
		
		int i=getindex(value);
		l.add(i,value);
	}
	
	int getindex(int value){
		if(l.isEmpty()){
			return 0;
		}
		else {
			int temp = 0;
			for(int i=0;i<l.size();i++){
				if(value>l.get(i))
					temp=i+1;

			}
			return temp;
		}
	}
	
	void makeEmpty(){
		int temp=l.size();
		int loop=0;
		while(loop<temp){
			remove(0);
			loop++;
		}
	}
	
	boolean remove(int index){
		int temp=-1;
		if(index>=l.size())
			return false;
		else{
		temp=l.remove(index);}
		if(temp==-1)
			return false;
		else 
			return true;
		
	}
	
	boolean search(int value){
		if(l.contains(value))
			return true;
		else
			return false;
		
	}
	
	String print(){
		String s="";
		s+="Index\t\tValue\n----------------------------------------------------------------------------\n";
		for(int i=0;i<l.size();i++){
			s+=i+"\t\t\""+l.get(i)+"\"\n";
		}
		return s;
	}
	
	boolean isEmpty(){
		return l.size()==0;
	}

}

