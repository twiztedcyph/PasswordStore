
package passwordstore;

import java.io.File;
import java.io.IOException;

/**
 * This method will ensure that the correct file exists or is created.
 * 
 * @author Cypher
 */
public class FileCreate
{
    private final String fileName = "super_secret_password_store.ian";
    private File myFile;
    
    public FileCreate() throws IOException
    {
        /*
         * If the file already exists then this method does nothing.
         * If the file does not exist then this method creates a new file
         * with the specified file name.
         */
        myFile = new File(fileName);
        
        if(!myFile.exists())
        {
            if(myFile.createNewFile())
            {
                System.out.println("File created");
            }
        }
    }
    
    public String getFileName()
    {
        return fileName;
    }
}
