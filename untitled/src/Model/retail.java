package Model;

import Model.product;

import java.util.ArrayList;

public class retail extends  account
{
    private user_id id; //קריאה לקלאס של user_id לקבלת id חדש
    private String retail_name; // שם החברה
    private Integer branch_num; //מספר הסניפים
    private Model.branch branch; //הגדרת הסניף של המשתמש החדש
    private retail_org retail_org; //שייוך המשתמש לחברה
    private static ArrayList<retail_org> retail_org_list = new ArrayList<retail_org>();//מערך רשימה של החברות הגדולות מתבצע פה כי כאן זו נקודת בניים לפני ואחרי שכל אירגון נוצר


    public static int find_Retail_org_list(String name) //פונקציה שבודקת אם קיים אירגון כזה במאגר או לא
    {
        int count=0;//counter שנועד לספור את כמות ההשוואות שלא הצליחו
        for(int i=0;i<retail_org_list.size();i++)
        {
            while(retail_org_list.get(i).getRetail_name()!=name)
                count++;
        }
        if(count==retail_org_list.size())
            return 1;
        else return 0;
    }


    public retail(String username, String password, String phone, String firstname, String lastname, String retail_name, Integer branch_num) {
        super(username, password, phone, firstname, lastname);
        this.retail_name = retail_name;// מקבלים בקונסטרקטור כאן שם חברה בשביל לבדוק אם היא קיימת כבר
        int count=0;//כאן מתחילה בדיקה שבודקת האם יש חברה כזו ולשייך את המשתמש לקלאס של החברה או שאין וליצור אחת חדשה ואז לשייך
        for(int i=0;i<retail_org_list.size();i++)
        {
            while(retail_org_list.get(i).getRetail_name()!=retail_name)
                count++;
            if(count==retail_org_list.size())
                this.retail_org=new retail_org(retail_name);
            else
                this.retail_org=retail_org_list.get(i);
        }
        this.branch_num = branch_num;
    }



    public void upload_product (product item)//  פונקציה שמעלה מוצר לרשימת המוצרים של הסניף
{
    branch.add_product(item);
}


     public void delete_product (String product_name)//פונקציה שמוחקת מוצר מהרשימת המוצרים של הסניף
     {
         branch.delete_product(product_name);
     }
}
