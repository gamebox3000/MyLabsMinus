package messages.usermenus.studentmenu;
import app.MyLabsMinusApp;
import messages.Message;
/**
 * Class MessageQuiz is a subclass of Message that implements the quizes for the students.
 * @author Stephen Hybeger
 */
public class MessageQuiz extends Message{
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageQuiz(MyLabsMinusApp app) {
        super("", "", app);
    }
    /**
     * An override of the runOverride method of the Message class. This class implements the quiz functionality based on a provided grade level.
     * @return Whether or not the program ran properly with valid input.
     */
    @Override
    public boolean runOverride() {
        return true;
    }
} 
