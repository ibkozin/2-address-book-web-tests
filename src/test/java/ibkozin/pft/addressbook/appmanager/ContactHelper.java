package ibkozin.pft.addressbook.appmanager;

import ibkozin.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreationForm() { wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactCreationForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"),contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
        if (isElementPresent(By.name("new_group"))){
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }
        type(By.name("address2"), contactData.getSecondaryAddress());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//html//div[2]/input[1]"));
    }

    public void editContact(int index) {
        wd.findElements(By.cssSelector("[name=entry] [title=Edit]")).get(index).click();
//        click(By.cssSelector("table#maintable [name=entry]:nth-child(2) img[title=Edit]"));

    }

    public void submitContactModification() {click(By.name("update"));
    }

    public void create(ContactData contactData) {
        initContactCreation();
        fillContactCreationForm(contactData);
        submitContactCreationForm();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));

    }

    public int contactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("[name=entry]"));
       for (WebElement element : elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String middleName = cells.get(3).getText();
            ContactData contact = new ContactData().withId(id).withLastName(lastName).withFirstName(firstName).withMiddleName(middleName);
            contacts.add(contact);
        }
        return contacts;
    }
    public void modify(int index, ContactData contact) {
        editContact(index);
        fillContactCreationForm(contact);
        submitContactModification();
    }

}
