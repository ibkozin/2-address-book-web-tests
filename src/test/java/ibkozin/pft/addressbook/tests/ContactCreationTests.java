package ibkozin.pft.addressbook.tests;

import ibkozin.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().home();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withFirstName("TestFirstName").withMiddleName("TestMiddleName").withLastName("TestLastName").withNickName("TestNickname")
                .withTitle("TestTitle").withCompany("TestCompany").withAddress("TestAdress").withMobilePhone("1123225").withWorkPhone("2453304").withtHomePhone("3480409")
                .withEmail("ibkozin@gmail.com").withSecondaryAddress("TestSecondaryAddress").withGroup("Test Group Name");
        app.contact().create(contact);
        app.goTo().home();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);


//        int max = 0;
//        for (ContactData c : after){
//            if (c.getId() > max){
//                max = c.getId();
//            }
//        }
        int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        contact.withId(max);
        before.add(contact);
//        Сравнение множеств:
//        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
