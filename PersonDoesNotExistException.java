import java.io.IOException;

public class PersonDoesNotExistException extends IOException {
    public PersonDoesNotExistException(){}
    public PersonDoesNotExistException(String message){
        super(message);
    }
}

class PersonAlreadyExistsException extends IOException{
    public PersonAlreadyExistsException(){}
    public PersonAlreadyExistsException(String message){
        super(message);
    }
}
