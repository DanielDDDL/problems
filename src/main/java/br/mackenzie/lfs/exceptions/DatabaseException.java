package br.mackenzie.lfs.exceptions;

public class DatabaseException extends IllegalStateException {

    private int qnt;

    public DatabaseException () { }

    public DatabaseException (String message, int qnt) {
        super(message);
        this.qnt = qnt;
    }

    @Override
    public String toString() {
        String message = super.getMessage();
        if(message == null)
            return "This is a database exception. No message";
        else
            return "This is a database exception. With a message: " + message;
    }

    public int getQnt () {
        return this.qnt;
    }
}
