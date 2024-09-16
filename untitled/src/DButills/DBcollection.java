
package DButills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBcollection{
        private String name;
        private String address;
        private String pass;
        private String email;
        private String birth;
        private String phone;

    public DBcollection() {
        this.phone="";
        this.name="";
        this.address="";
        this.pass="";
        this.email="";
        this.birth="";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void DBCreate()
        {
            try
            {
                System.out.println("Connecting to a selected database...");
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\hagai\\IdeaProjects\\Software-engineer-final-project\\untitled\\src\\DButills\\account.db");
                System.out.println("Connected database successfully...");
                Statement stm = connection.createStatement();
                stm.execute("CREATE TABLE IF NOT EXISTS accounts "+ "(username TEXT, pass TEXT, email TEXT, phone INTEGER, birth TEXT, address TEXT)");

                stm.close();
                connection.close();
            }
            catch(SQLException e)
            {
                System.out.println("something went wrong " + e.getMessage());
            }
        }

    public void DBregister(String name, String pass, String email, String phone, String birth, String address) throws SQLException {
        try {
            System.out.println("Connecting to a selected database...");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\hagai\\IdeaProjects\\Software-engineer-final-project\\untitled\\src\\DButills\\account.db");
            System.out.println("Connected database successfully...");
            Statement stm = connection.createStatement();
            stm.execute("INSERT INTO accounts" + "(name, pass, email, phone, birth, address)" +
                    "VALUES( '" + name + "', '" + pass + "', '" + email + "', '" + phone + "', '" + birth + "', '" + address + "')");
            stm.close();

            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't Connect To DB" + e.getMessage());
        }
    }
}
