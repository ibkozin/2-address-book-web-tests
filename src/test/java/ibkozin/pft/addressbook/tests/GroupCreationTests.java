package ibkozin.pft.addressbook.tests;

import ibkozin.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("Test Group Name", "Test Group Header", null));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}
