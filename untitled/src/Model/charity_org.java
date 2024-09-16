package Model;

public class charity_org extends account
{
    private company_id id;//id מזהה חדש של חברה
    private String Charity_name;//שם של ארגון הצדקה

    public String getCharity_name() {//getter הגדרה של
        return Charity_name;
    }

    public void setCharity_name(String charity_name) {// קונסטרקטור
        Charity_name = charity_name;
    }

    public charity_org(String username, String password, String phone, String firstname, String lastname, String charity_name) {
        super(username, password, phone, firstname, lastname);
        Charity_name = charity_name;
    }// כאן נגמר הקונסטרקטור הsuper זה התכונות של מי שירשנו ממנו (account)

}
