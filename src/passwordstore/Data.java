
package passwordstore;

/**
 *
 * @author Cypher
 */
public class Data
{
    private String site, userName, password;
    
    public Data(String site, String userName, String password)
    {
        this.site = site;
        this.userName = userName;
        this.password = password;
    }

    public String getSite()
    {
        return site;
    }

    public void setSite(String site)
    {
        this.site = site;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    @Override
    public String toString()
    {
        return this.site + "#&#&" + this.userName + "#&#&" + this.password;
    }
}
