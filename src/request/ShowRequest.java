package request;

import benhan.BenhAn;

public class ShowRequest extends Request {
    public ShowRequest() {
        super();
    }

    @Override
    public void processRequest() {
        BenhAn.showAllBenhAn();
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
