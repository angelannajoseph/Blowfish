package BlowFish;
import javax.crypto.*;
import java.util.*;
public class bf 
{
  public static void main(String[] args) throws Exception
  {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the message : ");
     String message=sc.nextLine();

     KeyGenerator keygen =KeyGenerator.getInstance("Blowfish");
     keygen.init(128);
     SecretKey seckey=keygen.generateKey();

     Cipher cipher=Cipher.getInstance("Blowfish");
     cipher.init(Cipher.ENCRYPT_MODE, seckey);
     byte[] Encrpted=cipher.doFinal(message.getBytes());
     String EncryptedMessage=Base64.getEncoder().encodeToString(Encrpted);

     cipher.init(Cipher.DECRYPT_MODE, seckey);
     byte[] decrypted=cipher.doFinal(Base64.getDecoder().decode(EncryptedMessage));
     String DecryptedMessage=new String(decrypted);

     System.out.println("Encypted Message : "+EncryptedMessage);
     System.out.println("Decypted Message : "+DecryptedMessage);
     sc.close();
  }   
}
