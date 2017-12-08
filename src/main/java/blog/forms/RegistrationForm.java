package blog.forms;


import com.sun.istack.internal.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm {
    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String username;

    @NotNull
    @Size(min=1, max=50, message = "Password size should be in the range [1...50]")
    private String password;

    @NotNull
    @Size(min=1, max=100, message = "Fullname size should be in the range [1...100]")
    private String fullName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
