package Model;

public class product
{


    private String product_name;
    private Integer product_quantity;
    private String experation_day;
    private boolean fridge = false;
    private boolean matched= false;


    public product(String product_name, Integer product_quantity, String experation_day) {
        this.product_name = product_name;
        this.product_quantity = product_quantity;
        this.experation_day = experation_day;
    }

    public String getProduct_name()
    {
        return product_name;
    }

    public void setProduct_name(String product_name)
    {
        this.product_name = product_name;
    }
}
