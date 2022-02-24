package com.company.booking;

public class LeftShiftAndRightShift {
    public static void main(String[] args) {
//        System.out.println(shiftArray("quick", 3, true)); // ckqui
//        System.out.println(shiftArray("quick", 3, false));
//        System.out.println(shiftArray("quick", 15, true));
//        System.out.println(shiftArray("quick", 18, true));
//
//        System.out.println(shiftArray("quick".toCharArray(), 3, true)); // ckqui
//        System.out.println(shiftArray("quick".toCharArray(), 3, false));
//        System.out.println(shiftArray("quick".toCharArray(), 15, true));
//        System.out.println(shiftArray("quick".toCharArray(), 18, true));
//
//        System.out.println( -1 * -3);

//        !bvnFirstName.trim().equalsIgnoreCase(requestFirstName.trim()) ||
//                !bvnLastName.trim().equalsIgnoreCase(requestLastName.trim()) ||
//                !bvnFullPhoneNumber.contains(requestMobileNumber) || !bvnDateOfBirth.equalsIgnoreCase(requestDob)

//        System.out.println("Oghenetega".equalsIgnoreCase("OGHENETEGA"));
//        System.out.println("Ebireri-Ojo".equalsIgnoreCase("EBIRERI-OJO"));
//        System.out.println("1997-09-04".equalsIgnoreCase("1997-09-04"));
//        System.out.println("2347068606551".concat("-").concat("").contains("2347068606551"));

//        System.out.println(Character.isUpperCase(ch));

//        if(Character.is)

//        System.out.println("abcde".substring(2));
//        System.out.println("abcde".substring(0,2));
//
//        String x = "ghijk";
//        System.out.println(x.substring(0,2));
//        System.out.println(x.substring(2));
//
//        System.out.println(x.substring(x.length()- 2));
//        System.out.println(x.substring(0,x.length() - 2));

        System.out.println(formatPhoneNumber("2347068606551"));
    }

    private static String formatPhoneNumber(String phoneNumber){
        if(phoneNumber!=null){
            if(phoneNumber.startsWith("234") && phoneNumber.length()==13)
                return phoneNumber.replaceFirst("234","0");
            else
                return phoneNumber;
        }
        return "";
    }

    public static String shiftArray(char [] str, int d, boolean left){
        int shift = (d > str.length) ? d % str.length : d;

        return left ? leftShiftArray(String.valueOf(str), shift) : rightShiftArray(String.valueOf(str), shift);
    }

    public static String shiftArray(String str, int d, boolean left){
        int shift = (d > str.length()) ? d % str.length() : d;
        return left ? leftShiftArray(str, shift) : rightShiftArray(str, shift);
    }

    public static String leftShiftArray(String str, int d){
        StringBuilder sb = new StringBuilder();
        return sb.append(str.substring(d)).append(str, 0, d).toString();
    }

    public static String rightShiftArray(String str, int d){
        return leftShiftArray(str, str.length()-d);
    }
}
