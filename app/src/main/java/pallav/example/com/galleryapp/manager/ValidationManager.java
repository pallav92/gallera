package pallav.example.com.galleryapp.manager;


import android.text.TextUtils;

import java.util.regex.Pattern;

public class ValidationManager {

    private static final String PHONE_REGEX = "[789]{1}\\d{9}";
    private static final String OTP_REGEX = "^[0-9]{6}";
    private static final String EMAIL_REGEX = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    // call this method when you need to check phone number validation
    public static boolean isPhoneNumber(String phoneNumber) {
        return isValueValid(PHONE_REGEX, phoneNumber);
    }

    //call this method when you need to check otp validation
    public static boolean isOTPNumber(String otp) {
        return isValueValid(OTP_REGEX, otp);
    }

    //call this method when you need to check email validation
    public static boolean isEmail(String email) {
        return isValueValid(EMAIL_REGEX, email);
    }

    public static boolean isValueValid(String regex, String text) {

        return Pattern.matches(regex, text);
    }

    public static boolean isPostalCode(String postalcode){
        if (!TextUtils.isEmpty(postalcode) && postalcode.length() ==6)
            return true;
        else
            return false;
    }
}
