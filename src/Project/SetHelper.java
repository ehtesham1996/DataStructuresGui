package Project;

import java.util.LinkedHashSet;
import java.util.Set;
public class SetHelper {

	Set<String> s;
	
	SetHelper(){
		s=new LinkedHashSet<String>();
	}
	
	boolean Add(String value ){
		if(s.contains(value)){
			return false;
		}
		else{
			s.add(value);
			return true;
		}
		
	}
	boolean remove(String value){
		if(s.contains(value)){
			s.remove(value);
			return true;
		}
		else
			return false;
	}
	
	boolean search(String value){
		if(s.contains(value))
			return true;
		else
			return false;
		
	}
	String print(){
		String r="\n\n";
		r+="The set is :\n";
		r+=s;
		return r;
	}
	void makeEmpty(){
		s.clear();
	}
	boolean isEmpty(){
		return s.isEmpty();
	}
}
