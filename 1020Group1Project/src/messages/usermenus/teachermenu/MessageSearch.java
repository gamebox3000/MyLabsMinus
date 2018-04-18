package messages.usermenus.teachermenu;

import app.MyLabsMinusApp;
import messages.Message;

/**
 *
 * @author StephenAHyberger
 */
public class MessageSearch extends Message{
    public MessageSearch(MyLabsMinusApp app) {
        super("", "", app);
    }
    @Override
    public boolean runOverride() {
        return true;
    }
} 
