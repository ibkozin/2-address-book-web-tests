package ibkozin.pft.addressbook.tests;

import ibkozin.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void insurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupData().withName("Test Group Name").withHeader("Test Group Header"));
        }

    }

    @Test
    public void testGroupDeletion(){
        List<GroupData> before = app.group().list();
        app.group().selectGroup(0);
        app.group().deleteSelectedGroups();
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(0);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }
}
