
package passwordstore;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Cypher
 */
public class EncDec
{
    /*
     * Basic encrypting and decrypting of text done here using a user specified
     * key. Salted AES and salted MD5 used.
     */
    private SecretKeySpec sks;
    private Cipher cipher;
    private final String MY_KEY = "whateveryouwant";
    
    public EncDec() throws NoSuchAlgorithmException, NoSuchPaddingException
    {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        createKey(MY_KEY);
    }
    
    public String encrypt(String inputText) throws InvalidKeyException, 
            IllegalBlockSizeException, 
            BadPaddingException
    {
        String output = null;
        cipher.init(Cipher.ENCRYPT_MODE, sks);
        output = Base64.encode(cipher.doFinal(inputText.getBytes()));
        return output;
    }
    
    public String decrypt(String inputText) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        String output = null;
        cipher.init(Cipher.DECRYPT_MODE, sks);
        output = new String(cipher.doFinal(Base64.decode(inputText)));
        return output;
    }
    
    private void createKey(String key)
    {
        sks = new SecretKeySpec(keyMaker(key), "AES");
    }
    
    private byte[] keyMaker(String phrase)
    {
        byte[] myKey = new byte[16];
        if(phrase != null)
        {
            int size = phrase.toCharArray().length;
            
        
            if(size >= 16)
            {
                for(int i = 0;  i < 16; i++)
                {
                    myKey[i] = (byte) phrase.charAt(i);
                }
            }if(size < 16)
            {
                for(int i = 0;  i < 16; i++)
                {
                    if(i < phrase.toCharArray().length)
                    {
                        myKey[i] = (byte) phrase.charAt(i);
                    }else
                    {
                        myKey[i] = (byte) i;
                    }
                }
            }
        }
        return myKey;
    }
}
