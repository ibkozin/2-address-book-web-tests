package ibkozin.pft.addressbook.tests;

import ibkozin.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends  TestBase{
    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactCreationForm(new ContactData("ModFirstName", "ModTestMiddleName", "ModTestLastName", "ModTestNickname", "ModTestTitle", "ModTestCompany", "ModTestAdress", "1123225", "2453304", "3480409", "ibkozin@gmail.com", "ModTestSecondaryAddress", null));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
    }


}
