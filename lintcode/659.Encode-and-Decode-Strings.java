import java.util.stream.*;
public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> str) {
        // write your code here
        return str.stream().map(s -> s.replaceAll(":", "::") + ":;").reduce("", (s1, s2) -> s1 + s2);
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        return Arrays.stream(str.split(":;")).map(s -> s.replaceAll("::", ":")).collect(Collectors.toList());
    }
}
