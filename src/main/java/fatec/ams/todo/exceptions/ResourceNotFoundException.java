package fatec.ams.todo.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String statement) {
        super(statement);
    }
}