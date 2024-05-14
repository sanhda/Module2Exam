package request;

public class FactoryRequest {

    public FactoryRequest() {
    }

    public static Request getRequest(int action) {
        switch (action) {
            case 1:
                return new AddRequest();
            case 2:
                return new RemoveRequest();
            case 3:
                return new ShowRequest();
            default:
                return null;
        }
    }
}
