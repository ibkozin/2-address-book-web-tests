package ibkozin.pft.addressbook.tests;

import ibkozin.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("Test Group Name", "Test Group Header", "Test Group Header"));
        app.getGroupHelper().submitGroupModification();


    }

}
