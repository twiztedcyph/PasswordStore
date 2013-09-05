
package passwordstore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles all file reading and writing.
 * 
 * @author Cypher
 */
public class FileRW
{
    private BufferedReader bufRead;
    private FileReader fileRead;
    private BufferedWriter bufWrite;
    private FileWriter fileWrite;
    private File file;
    
    public FileRW(String fileName)
    {
        file = new File(fileName);
    }
    
    public void writeToFile(String newEntry) throws FileNotFoundException, IOException
    {
        fileWrite = new FileWriter(file, true);
        bufWrite = new BufferedWriter(fileWrite);
        
        bufWrite.write("\n"+newEntry);
        bufWrite.close();
    }
    
    public String readFromFile() throws FileNotFoundException, IOException
    {
        fileRead = new FileReader(file);
        bufRead = new BufferedReader(fileRead);
        StringBuilder sb = new StringBuilder();
        
        
        while(bufRead.ready())
        {
            sb.append(bufRead.readLine());
            sb.append("\n");
        }
        
        bufRead.close();
        return sb.toString();
    }
    
    public void clearFile() throws IOException
    {
        fileWrite = new FileWriter(file, false);
        bufWrite = new BufferedWriter(fileWrite);
        
        bufWrite.write("");
        bufWrite.close();
    }
}
