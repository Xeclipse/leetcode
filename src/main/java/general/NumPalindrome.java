package general;

import java.math.BigInteger;

/**
 * @Author: Alex.Z
 * @DATE: 2019/6/10
 * @Description:
 */
public class NumPalindrome {
    public String prev(String num){
        StringBuilder sb =new StringBuilder(num.length());
        int mid = num.length()/2;
        int even=num.length()%2;
        BigInteger forePart = new BigInteger(num.substring(0,mid+even));
        String foreStr = forePart.subtract(new BigInteger("1")).toString();
        if(foreStr.length()==(mid+even)){
            sb.append(foreStr);
            StringBuilder rsb = new StringBuilder(sb).reverse();
            if(even==1){
                sb.append(rsb.deleteCharAt(0));
            }
            else{
                if(sb.length()==1 && sb.charAt(0)=='0') return "9";
                sb.append(rsb);
            }
        }
        else{
            sb.append(foreStr);
            StringBuilder rsb = new StringBuilder(sb).reverse();
            if(even==1){
                sb.append(rsb);
            }
            else{
                sb.append('9').append(rsb);
            }
        }
        return sb.toString();
    }

    public String next(String num){
        StringBuilder sb =new StringBuilder(num.length());
        int mid = num.length()/2;
        int even=num.length()%2;
        BigInteger forePart = new BigInteger(num.substring(0,mid+even));
        String foreStr = forePart.add(new BigInteger("1")).toString();
        if(foreStr.length()==(mid+even)){
            sb.append(foreStr);
            StringBuilder rsb = new StringBuilder(sb).reverse();
            if(even==1){
                sb.append(rsb.deleteCharAt(0));
            }
            else{
                sb.append(rsb);
            }
        }
        else{
            sb.append(foreStr);
            StringBuilder rsb = new StringBuilder(sb).reverse();
            if(even==1){
                if(rsb.length()<=2) return "11";
                sb.append(rsb.deleteCharAt(0).deleteCharAt(0));
            }
            else{
                sb.append(rsb.deleteCharAt(0));
            }
        }
        return sb.toString();
    }

    public String format2PalindromeByForePart(String num){
        StringBuilder sb =new StringBuilder(num.length());
        int mid = num.length()/2;
        int even=num.length()%2;
        String forePart = num.substring(0,mid+even);
        sb.append(forePart);
        StringBuilder rsb = new StringBuilder(sb).reverse();
        if(even==1){
            sb.append(rsb.deleteCharAt(0));
        }
        else{
            sb.append(rsb);
        }
        return sb.toString();
    }
}
