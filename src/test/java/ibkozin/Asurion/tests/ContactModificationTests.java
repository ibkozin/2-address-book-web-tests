package ibkozin.Asurion.tests;

import ibkozin.Asurion.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("TestFirstName", "TestMiddleName", "TestLastName", "TestNickname", "TestTitle", "TestCompany", "TestAdress", "1123225", "2453304", "3480409", "ibkozin@gmail.com", "TestSecondaryAddress", "Test Group Name"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"ModFirstName", "ModTestMiddleName", "ModTestLastName", "ModTestNickname", "ModTestTitle", "ModTestCompany", "ModTestAdress", "1123225", "2453304", "3480409", "ibkozin@gmail.com", "ModTestSecondaryAddress", null);
        app.getContactHelper().fillContactCreationForm(contact);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(contact);
//        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
