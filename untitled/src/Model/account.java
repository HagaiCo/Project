
package Model;
public class account
{

    private String username;//שם משתמש
    private String password;//סיסמא
    private String phone;//מספר טלפון
    private String firstname;//שם פרטי
    private String lastname;//שם משפחה

    public account(String username, String password, String phone, String firstname, String lastname) {// בנאי
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;//

    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
