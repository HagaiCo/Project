package Model;

public class company_id
{
    private static Integer sum_id=0;//סטאטיק שיעזור לנו לעשות id
    private Integer id=0;// המשתנה שנשים באמת בid של כל אובייקט

    public company_id() {
        this.sum_id++;
        this.id+=sum_id;
    }

    public Integer getId() {
        return id;
    }

}
