package request;

public abstract class Request {
    public Request() {
    }

    public abstract void processRequest();
    public abstract boolean isValid();
}
