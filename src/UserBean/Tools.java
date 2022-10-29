package UserBean;

import java.nio.charset.StandardCharsets;

public class Tools {
    public static String getNewString(String input){
       String result = null;
       try{
            result = new String(input.getBytes("iso-8859-1"),"utf-8");
       }catch(Exception e){
           e.printStackTrace();
       }
       return result;
    }
}
