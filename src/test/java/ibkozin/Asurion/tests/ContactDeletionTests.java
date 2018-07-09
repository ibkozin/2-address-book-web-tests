package ibkozin.Asurion.tests;

import ibkozin.Asurion.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("TestFirstName", "TestMiddleName", "TestLastName", "TestNickname", "TestTitle", "TestCompany", "TestAdress", "1123225", "2453304", "3480409", "ibkozin@gmail.com", "TestSecondaryAddress", "Test Group Name"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(0);
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(0);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }

}
