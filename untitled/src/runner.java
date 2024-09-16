import DButills.DBcollection;
import controller.mainFrameController;


public class runner
{

public static void main (String[] Args)
    {
        mainFrameController mainFrameController=new mainFrameController();
        mainFrameController.showHomeFrame();
        DBcollection DB = new DBcollection();
        DB.DBCreate();
    }
}

