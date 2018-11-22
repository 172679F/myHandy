package userStuff;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserBean {
    private int userId;
    private String fName;
    private String lName;
    private String username;
    private String password;
    private String email;
    private String gender; // M or F
    private String profileDesc;
    private String profileImg;
    private String accountStatus; // unverified ,normal, banned, admin
    // FK for handymanId

    public UserBean(){}

    public UserBean(int userId, String fName, String lName, String username, String password, String email, String gender, String profileDesc, String profileImg, String accountStatus){
        this.userId=userId;
        this.fName=fName;
        this.lName=lName;
        this.username=username;
        this.password=password;
        this.email=email;
        this.gender=gender;
        this.profileDesc=profileDesc;
        this.profileImg=profileImg;
        this.accountStatus=accountStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userId=" + userId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", profileDesc='" + profileDesc + '\'' +
                ", profileImg='" + profileImg + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}

