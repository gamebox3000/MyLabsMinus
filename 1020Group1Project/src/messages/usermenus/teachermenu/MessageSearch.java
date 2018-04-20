package messages.usermenus.teachermenu;
import app.MyLabsMinusApp;
import messages.Message;
/**
 * Class MessageSearch is a subclass of Message that implements the search option for the teacher users.
 * @author Stephen Hybeger
 */
public class MessageSearch extends Message{
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageSearch(MyLabsMinusApp app) {
        super("", "", app);
    }
    /**
     * An override of the runOverride method of the Message class. This class implements the search functionality across the teacher's students using criteria provided as input.
     * @return Whether or not the program ran properly with valid input.
     */
    @Override
    public boolean runOverride() {
        return true;
    }
} 
