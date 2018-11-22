package Utilities;

import userStuff.UserBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil {
    private static DbUtil instance;
    private DataSource dataSource;
    private String jndiName= "jdbc/myhandydb";

    public static DbUtil getInstance() throws Exception{
        if (instance==null){
            instance = new DbUtil();
        }
        return instance;
    }

    private DbUtil() throws Exception {
        dataSource = getDataSource();
    }

    private DataSource getDataSource() throws NamingException {
        Context context  = new InitialContext();
        DataSource theDataSource = (DataSource) context.lookup(jndiName);
        return theDataSource;
    }

    private Connection getConnection() throws Exception {
        Connection theConn = dataSource.getConnection();
        return theConn;
    }

    private void close(Connection theConn, Statement theStmt) {

        close(theConn, theStmt, null);
    }

    private void close(Connection theConn, Statement theStmt, ResultSet theRs) {

        try {
            if (theRs != null) {
                theRs.close();
            }

            if (theStmt != null) {
                theStmt.close();
            }

            if (theConn != null) {
                theConn.close();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    // Login to website
    public UserBean validateLogin (String username, String password) throws Exception{
        UserBean checkedUser = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try{
            myConn = getConnection();

            String sql = "select * from users where username=? and password=?";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1,username);
            myStmt.setString(2,password);

            myRs = myStmt.executeQuery();

            while (myRs.next()){
                int id = myRs.getInt("userId");
                String fName = myRs.getString("fName");
                String lName = myRs.getString("lName");
                String email = myRs.getString("email");
                String gender = myRs.getString("gender");
                String profileDesc = myRs.getString("profileDesc");
                String profileImg = myRs.getString("profileImg");
                String accountStatus = myRs.getString("accountStatus");

                checkedUser = new UserBean(id,fName,lName,username,password,email,gender,profileDesc,profileImg,accountStatus);
            }
            return checkedUser;
        } finally {
            close(myConn,myStmt,myRs);
        }

    }

    // Register an account
    public void registerAccount (String fName, String lName, String username, String password, String email, String gender) throws Exception{
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try{
            myConn = getConnection();

            String sql = "insert into users(fName,lName,username,password,email,gender) values(?,?,?,?,?,?)";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1,fName);
            myStmt.setString(2,lName);
            myStmt.setString(3,username);
            myStmt.setString(4,password);
            myStmt.setString(5,email);
            myStmt.setString(6,gender);

            myStmt.executeUpdate();

        } finally {
            close(myConn,myStmt);
        }
    }
}
