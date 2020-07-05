package Model;

import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl implements IUserRepository {

    private List<account> users;
    private FileManager<account> fileManager;

    //Singleton creation of this class(Lazy initialization):
    private static UserRepositoryImpl SoleInstance;
    public static UserRepositoryImpl getInstance() throws Exception
    {
        if (SoleInstance == null)
        {
            //if there is no instance available, create new one:
            SoleInstance = new UserRepositoryImpl();
        }
        return SoleInstance;
    }
    //private constructor for singleton purpose.
    private UserRepositoryImpl() throws Exception
    {
        this.fileManager = new FileManager<account>();
        this.users = this.fileManager.read("Users");
    }

    @Override
    public void add(account user) throws Exception
    {
        this.users.add(user);
        this.fileManager.write(this.users, "Users");
    }

    @Override
    public String GetType(String username) {
        for (account user : users)
        {
            String userNameInFile = user.getUsername();
            if( Objects.equals(userNameInFile, username))
                return user.getType();
        }
        return null;
    }

    @Override
    public boolean loginSuccess(String username, String password) {
        //account check =new account(username,password);
            for (account user : users)
            {
                System.out.println(user.getUsername()+ "==" + username);
                System.out.println(user.getPassword()+ "==" + password);
                if( Objects.equals(user.getUsername(), username) &&  Objects.equals(user.getPassword(), password)  )
                    return  true;
            }
        return false;
        }

    @Override
    public String[] getUserList()
    {
        int i=0;
        String[] UserArr=new String[users.size()];
        for (account user : users)
        {
            UserArr[i++]="User:" +user.getUsername()+ ", Name:"+ user.getFirstName()+" "+user.getLastName()
            +", Phone: " +user.getPhone();
        }
        return UserArr;
    }
}
