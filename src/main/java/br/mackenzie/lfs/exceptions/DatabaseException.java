package br.mackenzie.lfs.exceptions;

public class DatabaseException extends IllegalStateException {

    public DatabaseException () { }
    public DatabaseException (String message) {
        super(message);
    }

    @Override
    public String toString() {
        String message = super.getMessage();
        if(message == null)
            return "This is a database exception. No message";
        else
            return "This is a database exception. With a message: " + message;
    }
}
