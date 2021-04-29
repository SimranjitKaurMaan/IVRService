import com.simran.models.ActionStatus;
import com.simran.models.Level;
import com.simran.models.Option;
import com.simran.services.IVRService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IVRServiceTest
{
    @Test
    public void defaultTest()
    {
        List<Level> levels = new ArrayList<>();
        List<Option> options1 = new ArrayList<>();
        Option option11 = new Option(1,"Please press 1 for Prepaid connection", ActionStatus.next_level);
        Option option12 = new Option(2,"Please press 2 for Postpaid connection", ActionStatus.next_level);
        Option option13 = new Option(3,"Please press 3 for Broadband",ActionStatus.next_level);
        options1.add(option11);
        options1.add(option12);
        options1.add(option13);
        Level level1 = new Level(1,options1);
        levels.add(level1);
        List<Option> options2 = new ArrayList<>();
        Option option21 = new Option(4,"Please press 1 for new Prepaid connection", ActionStatus.next_level);
        Option option22 = new Option(5,"Please press 2 to know your current Bill amount", ActionStatus.next_level);
        Option option23 = new Option(6,"Press 8 to go back to the previous menu",ActionStatus.prev_level);
        Option option24 = new Option(7,"Press 9 to go back to the main menu",ActionStatus.main_level);
        options2.add(option21);
        options2.add(option22);
        options2.add(option23);
        options2.add(option24);
        Level level2 = new Level(2,options2);
        levels.add(level2);
        IVRService ivrService = new IVRService(levels);
        List<Option> options = ivrService.getOptions(0);
        System.out.println(options);
        Level nextLevel1 = ivrService.chooseOption(0,options.get(0));
        System.out.println(nextLevel1);
        List<Option> options11 = ivrService.getOptions(1);
        System.out.println(options11);
        Level previousLevel = ivrService.chooseOption(1,options11.get(3));
        System.out.println(previousLevel);
    }
}
