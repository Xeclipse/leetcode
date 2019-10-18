package leetcode;

import java.util.regex.Pattern;

/**
 * @Author: Alex.Z
 * @DATE: 2019/4/4
 * @Description:
 */
public class ValidNumber {

//    private static final Pattern eNumber =Pattern.compile("[+\\-]?\\d+(\\.\\d+)?");
    private static final Pattern num =Pattern.compile("([+\\-]?((\\d+(\\.(\\d+)?)?)|((\\d+)?\\.\\d+))(e[+\\-]?\\d+)?)");

    public boolean isNumber(String s) {
         return num.matcher(s.trim()).matches();
    }
}
