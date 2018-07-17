package ibkozin.pft.addressbook.tests;

import ibkozin.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void insurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupData().withName("Test Group Name").withHeader("Test Group Header").withFooter("Test Group Footer"));
        }

    }

    @Test
    public void testGroupModification(){
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        GroupData group = new GroupData().withId(before.get(index).getId()).withName("Mod Group Name").withHeader("Mod Group Header").withFooter("Mod Group Footer");

        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
//        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);



    }


}
