import java.util.TreeMap;

class ArabicToRoman {
    static String convert(int arabic) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");

        StringBuilder sb = new StringBuilder();
        while (arabic > 0) {
            int l =  map.floorKey(arabic);
            sb.append(map.get(l));
            arabic -= l;
        }
        return sb.toString();
    }
}