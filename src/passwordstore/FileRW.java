
package passwordstore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

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
    private EncDec ed;
    
    public FileRW(String fileName) throws NoSuchAlgorithmException, NoSuchPaddingException
    {
        file = new File(fileName);
        ed = new EncDec();
    }
    
    public void writeToFile(String newEntry) throws FileNotFoundException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        fileWrite = new FileWriter(file, true);
        bufWrite = new BufferedWriter(fileWrite);
        
        bufWrite.write("\n" + ed.encrypt(newEntry));
        bufWrite.close();
    }
    
    public ArrayList<String> readFromFile() throws FileNotFoundException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        fileRead = new FileReader(file);
        bufRead = new BufferedReader(fileRead);
        ArrayList<String> results = new ArrayList<>();
        
        
        while(bufRead.ready())
        {
            results.add(ed.decrypt(bufRead.readLine()));
        }
        
        bufRead.close();
        return results;
    }
    
    public void clearFile() throws IOException
    {
        fileWrite = new FileWriter(file, false);
        bufWrite = new BufferedWriter(fileWrite);
        
        bufWrite.write("");
        bufWrite.close();
    }
}
