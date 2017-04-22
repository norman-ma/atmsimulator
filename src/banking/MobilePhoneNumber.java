/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 *
 * @author namro_000
 */
public class MobilePhoneNumber {
    
    private String value; 
    private String areacode;
    private boolean valid;
    
    public MobilePhoneNumber(String number) {
       valid = number.length() == 10;
       if(valid){
           areacode = number.substring(0,3);
           value = number.substring(3);
       }else{
           value = number;
       }
    }
    
    public boolean isValid(){
        return valid;
    }    
    
    @Override
    public String toString(){
        if(valid){
            return String.format("(%s)%s-%s", areacode, value.substring(0, 3), value.substring(3));
        }else{
            return value;
        }
    }
}
