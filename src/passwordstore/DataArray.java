
package passwordstore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Cypher
 */
public class DataArray
{
    private ArrayList<Data> dataArray;
    private FileRW fileRW;
    
    public DataArray(String fileName)
    {
        dataArray = new ArrayList<>();
        fileRW = new FileRW(fileName);
    }
    
    public void addData(String site, String userName, String password) throws FileNotFoundException, IOException
    {
        if(!nameIsUsed(site))
        {
            Data d = new Data(site, userName, password);
            writeToFile(d);
            dataArray.add(d);
        }
    }
    
    public boolean delData(String site)
    {
        boolean deleted = false;
        for(Data d: dataArray)
        {
            if(d.getSite().equalsIgnoreCase(site))
            {
                deleted = true;
                dataArray.remove(d);
            }
        }
        return deleted;
    }
    
    public int getSize()
    {
        return dataArray.size();
    }
    
    private boolean nameIsUsed(String site)
    {
        //Ensure that site names are unique.
        boolean result = false;
        for(Data d: dataArray)
        {
            if(d.getSite().equalsIgnoreCase(site))
            {
                result = true;
            }
        }
        return result;
    }
    
    public void writeToFile(Data d) throws FileNotFoundException, IOException
    {
        fileRW.writeToFile(d.toString());
    }
    
    public void loadAllData() throws FileNotFoundException, IOException
    {
        ArrayList<String> rawData = fileRW.readFromFile();
        for (int i = 0; i < rawData.size(); i++)
        {
            String site, user, pass;
            if(rawData.get(i).startsWith("£$£$£"))
            {
                site = rawData.get(i).split("#&#&")[0].replace("£$£$£", "");
                user = rawData.get(i).split("#&#&")[1];
                pass = rawData.get(i).split("#&#&")[2];
                dataArray.add(new Data(site, user, pass));
            }
        }
        System.out.println(dataArray.size());
    }
    
    public void delAllData() throws IOException
    {
        fileRW.clearFile();
    }
    
    public Data findData(String site)
    {
        for(Data d: dataArray)
        {
            if(d.getSite().equalsIgnoreCase(site))
            {
                return d;
            }
        }
        return null;
    }
}
