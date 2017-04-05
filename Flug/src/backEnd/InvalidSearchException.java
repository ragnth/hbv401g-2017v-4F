package backEnd;

public class InvalidSearchException extends Exception {
	public InvalidSearchException(){
		super();
	}
	
	public InvalidSearchException(String message){
		super(message);
	}
}
