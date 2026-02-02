package scanalyzer_test.bo;
import org.openqa.selenium.WebDriver;
import scanalyzer_test.po.EditProfilePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditProfileBO {

    private EditProfilePage editProfilePage;
    private static final Logger log = LoggerFactory.getLogger(EditProfileBO.class);

    public EditProfileBO(WebDriver driver) {
        this.editProfilePage = new EditProfilePage(driver);
    }

    public void openEditPage() {
        log.info("Opening edit profile page");
        editProfilePage.open();
    }

    public void updateProfile(String fullName, String location) {
        log.info("Editing profile information: {}, {}", fullName, location);
        editProfilePage.clickEditProfile();
        editProfilePage.clearAndTypeFullName(fullName);
        editProfilePage.clearAndTypeLocation(location);
        editProfilePage.clickSave();
    }

    public String getUpdatedFullName() {
        return editProfilePage.getFullNameValue();
    }

    public String getUpdatedLocation() {
        return editProfilePage.getLocationValue();
    }
}
