public class Roman {
    public static boolean isRoman(String str){
        return str.matches("[C|L|X|V|I]*");
    }
    public static int romanToDecimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        for (int x = romanNumeral.length() - 1; x >= 0; x--) {
            char convertToDecimal = romanNumeral.charAt(x);
            switch (convertToDecimal) {
                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;
                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;
                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;
                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;
                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return decimal;
    }
    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
    public static String decimalToRoman (int in) {
        StringBuffer a = new StringBuffer("");
        int c1 = in / 100;
        a.append(C(c1));
        int c2 = in % 100;
        int l1 = c2 / 50;
        a.append(L(l1));
        int l2 = c2 % 50;
        int x1 = l2 / 10;
        a.append(X(x1));
        int x2 = l2 % 10;
        a.append(basic(x2));
        return a.toString();
    }
    private static String C(int in) {
        if (in == 4) return "CD";
        else if ((in != 0) && (in < 4)) {
            StringBuffer a = new StringBuffer("");
            int i = 0;
            while (i < in) {
                a.append("C");
                i++;
            }
            return a.toString();
        }
        else return "";
    }
    private static String X(int in) {
        if (in == 4) return "XL";
        else if ((in != 0) && (in < 4)) {
            StringBuffer a = new StringBuffer("");
            int i = 0;
            while (i < in) {
                a.append("X");
                i++;
            }
            return a.toString();
        }
        else return "";
    }
    private static String L(int in) {
        if (in == 4) return "XC";
        else if ((in != 0) && (in < 4)) {
            StringBuffer a = new StringBuffer("");
            int i = 0;
            while (i < in) {
                a.append("L");
                i++;
            }
            return a.toString();
        }
        else return "";
    }
    private static String basic(int in) {
        String[] a = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return a[in];
    }
}
