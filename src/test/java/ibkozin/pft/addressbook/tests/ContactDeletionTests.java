package ibkozin.pft.addressbook.tests;

import ibkozin.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void insurePreconditions(){
        app.goTo().home();
        if (app.contact().list().size() == 0){
            app.contact().create(new ContactData().withFirstName("TestFirstName").withMiddleName("TestMiddleName").withLastName("TestLastName").withNickName("TestNickname")
                    .withTitle("TestTitle").withCompany("TestCompany").withAddress("TestAdress").withMobilePhone("1123225").withWorkPhone("2453304").withtHomePhone("3480409")
                    .withEmail("ibkozin@gmail.com").withSecondaryAddress("TestSecondaryAddress").withGroup("Test Group Name"));
        }
    } 

    @Test
    public void testContactDeletion(){
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().selectContact(index);
        app.contact().deleteSelectedContacts();
        app.alertAccept();
        app.goTo().home();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }

}
