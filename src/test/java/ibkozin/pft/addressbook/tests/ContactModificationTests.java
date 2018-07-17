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
            app.contact().createContact(new ContactData("TestFirstName", "TestMiddleName", "TestLastName", "TestNickname", "TestTitle", "TestCompany", "TestAdress", "1123225", "2453304", "3480409", "ibkozin@gmail.com", "TestSecondaryAddress", "Test Group Name"));
        }
    }

    @Test
    public void testContactModification(){
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        ContactData contact = new ContactData(before.get(index).getId(),"ModFirstName", "ModTestMiddleName", "ModTestLastName", "ModTestNickname", "ModTestTitle", "ModTestCompany", "ModTestAdress", "1123225", "2453304", "3480409", "ibkozin@gmail.com", "ModTestSecondaryAddress", null);
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
