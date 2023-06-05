package org.koreait.commons.validators;

public interface MobileValidator {
    default boolean mobileCheck(String mobile) {
        /*
        숫자만 남긴다
        패턴
         */
        mobile = mobile.replaceAll("\\D", ""); // 숫자만

        String pattern = "^01[016]\\d{3,4}\\d{4}$";

        boolean matched = pattern.matches(pattern);

        return matched;
    }
}
