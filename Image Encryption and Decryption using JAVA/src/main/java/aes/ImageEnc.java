package aes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class ImageEnc
{
    public static void EncryptImage(String imagePath,String secretKey)
    {
    	try
    	{
            FileInputStream file= new FileInputStream(imagePath); 
            FileOutputStream outStream = new FileOutputStream("C:/Users/ROHIT/OneDrive/Desktop/EncDecImages/Encrypt.jpg");
            byte k[]= secretKey.getBytes();
            SecretKeySpec key= new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream cos= new CipherOutputStream(outStream, enc);
            byte[] buf= new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf,0,read);
            }
            file.close();
            outStream.flush();
            cos.close();
            
        } catch (Exception ex)
    	{
            System.out.println(ex);
        }
    }
    
    public static void DecryptImage(String imagePath,String secretKey)
    {
    	try
    	{
            FileInputStream file= new FileInputStream(imagePath);
            FileOutputStream outStream = new FileOutputStream("C:/Users/ROHIT/OneDrive/Desktop/EncDecImages/Decrypt.jpg");
            byte k[]= secretKey.getBytes();
            SecretKeySpec key= new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.DECRYPT_MODE, key);
            CipherOutputStream cos= new CipherOutputStream(outStream, enc);
            byte[] buf= new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf,0,read);
            }
            file.close();
            outStream.flush();
            cos.close();

        } catch (Exception ex)
    	{
           System.out.println(ex);
        }
    }
    
}
