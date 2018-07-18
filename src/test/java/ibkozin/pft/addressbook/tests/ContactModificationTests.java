package ibkozin.pft.addressbook.tests;

import ibkozin.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends  TestBase{
    @BeforeMethod
    private void insurePreconditions() {
        app.goTo().home();
        if (app.contact().list().size() == 0){
            app.contact().create(new ContactData().withFirstName("TestFirstName").withMiddleName("TestMiddleName").withLastName("TestLastName").withNickName("TestNickname")
                    .withTitle("TestTitle").withCompany("TestCompany").withAddress("TestAdress").withMobilePhone("1123225").withWorkPhone("2453304").withtHomePhone("3480409")
                    .withEmail("ibkozin@gmail.com").withSecondaryAddress("TestSecondaryAddress").withGroup("Test Group Name"));
        }
    }

    @Test
    public void testContactModification(){
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("ModFirstName").withMiddleName("ModMiddleName").withLastName("ModLastName");
        app.contact().modify(index, contact);
        app.goTo().home();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
//        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }



}
