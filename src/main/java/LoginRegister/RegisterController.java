package LoginRegister;

import Utilities.DbUtil;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class RegisterController {

    private String fName;
    private String lName;
    private String username;
    private String password;
    private String confPassword;
    private String email;
    private String confEmail;
    private String gender;
    private DbUtil dbUtil;

    public RegisterController() throws Exception {
        dbUtil = DbUtil.getInstance();
    }

    public String registerAccount() throws Exception{
        // TODO 1. Validation | 2. Check username availability | 3. Send confirmation email
        System.out.println("VALUES HERE");
        System.out.println(toString());

        dbUtil.registerAccount(fName,lName,username,password,email,gender);

        return "login?faces-redirect=true";
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

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

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfEmail() {
        return confEmail;
    }

    public void setConfEmail(String confEmail) {
        this.confEmail = confEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "RegisterController{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confPassword='" + confPassword + '\'' +
                ", email='" + email + '\'' +
                ", confEmail='" + confEmail + '\'' +
                ", gender='" + gender + '\'' +
                ", dbUtil=" + dbUtil +
                '}';
    }
}
