package Model;

import java.util.ArrayList;

public class branch
{
    private company_id id;
    private String branch_name;
    private String branch_address;
    private Integer branch_phone;
    private ArrayList<product> product_list=new ArrayList<product>();



    public branch(String branch_name, String branch_address, Integer branch_phone)
    {
        this.branch_name = branch_name;
        this.branch_address = branch_address;
        this.branch_phone = branch_phone;
    }



    public void add_product (product item)
{
  product_list.add(item);
}



public void delete_product (String name)
{
    for(int i=0;i<product_list.size();i++)
        if(name==product_list.get(i).getProduct_name())
            product_list.remove(i);
}


    public String getBranch_name() {
        return branch_name;
    }


    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }


    public String getBranch_address() {
        return branch_address;
    }


    public void setBranch_address(String branch_address) {
        this.branch_address = branch_address;
    }


    public Integer getBranch_phone() {
        return branch_phone;
    }


    public void setBranch_phone(Integer branch_phone) {
        this.branch_phone = branch_phone;
    }

}

