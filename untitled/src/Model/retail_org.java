package Model;

import Model.branch;
import Model.company_id;

import java.util.ArrayList;

public class retail_org
{
    private company_id id;//id חדש של חברה
    private String retail_name;// שם החברה
    private ArrayList<branch> branch_list = new ArrayList<branch>();//מערך רשימה של הסניפים


    public retail_org(String retail_name)// בנאי
    {
        this.retail_name = retail_name;
    }


    public void add_brunch(branch welcome)// פונקציה שמוסיפה לנו סניף חדש לרשימת הסניפים של החברה
    {
        branch_list.add(welcome);

    }


    public String getRetail_name() {
        return retail_name;
    }
}

