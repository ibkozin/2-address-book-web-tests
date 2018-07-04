package ibkozin.pft.addressbook.tests;

import ibkozin.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("TestFirstName", "TestMiddleName", "TestLastName", "TestNickname", "TestTitle", "TestCompany", "TestAdress", "1123225", "2453304", "3480409", "ibkozin@gmail.com", "TestSecondaryAddress", "Test Group Name");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

//        int max = 0;
//        for (ContactData c : after){
//            if (c.getId() > max){
//                max = c.getId();
//            }
//        }
        int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        contact.setId(max);
        before.add(contact);
//        Сравнение множеств:
//        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
