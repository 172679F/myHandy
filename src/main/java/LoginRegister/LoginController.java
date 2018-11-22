package LoginRegister;

import Utilities.DbUtil;
import Utilities.SessionUtil;
import userStuff.UserBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    private DbUtil dbUtil;

    public LoginController() throws Exception {
        dbUtil = DbUtil.getInstance();
    }

    public String validateLogin() throws Exception {
        UserBean user = dbUtil.validateLogin(username,password);
        System.out.println("USER OBJECT HERE");
        if (user==null){
            // TODO Add some form of error here
            return "login?faces-redirect=true";
        } else {
            System.out.println(user);
            HttpSession session = SessionUtil.getSession();
            session.setAttribute("userInfo",user);
            session.setAttribute("logged",true);
            return "index?faces-redirect=true";
        }
    }

    public String logout(){
        HttpSession session = SessionUtil.getSession();
        session.invalidate();
        return "index?faces-redirect=true";
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
}