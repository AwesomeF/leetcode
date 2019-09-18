import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastSubstringTest {

    @Test
    void getLastSubStringTest() {
//        getLastSubString("abab", "bab");
//        getLastSubString("leetcode", "tcode");
        getLastSubString("vnhfleqyxj", "yxj");
//        String input = "";
//        for (int i = 0; i < 10000; i++) {
//            if (i % 2 == 0) {
//                input = input + "a";
//                continue;
//            }
//            input = input + "b";
//        }
//        getLastSubString(input, "zrziy");
//        getLastSubString("jlidhumidloagrlvvxdqscegbeaybfhhyaeilzxdpyvvxixrjytdalknkospradmumysbkizziltzjwsxkteykblcvkfivzmtvnsyrfgvojhyzkouscymixrdfmehiwijntzqptqaxgalygtzvwxnsgcnygbjzeqmbactgmckvssvkentpxcnznrbbnkttnzpvlzfmdvvsozaiycumzlizbfxvyucyagclrifczcvzvrkiqiajindjjyxgxflnjcgckruujsbppxtwgwvrrxgniqplynvboqyvrsxnmbjhgoybqophbxmjhhrznezstujjuucvrrvofktxldxfaioyijoayggmvjmgzjflzxmkwxmxnyizampdcfntdfkxxprgfxjduiwrmgdfuprpljgnbzbedqbzhqsbmohbhlszvdzcgbimfurmkwqaignxbeevevonmdgupugcjxvqglqkwqzrlqequliwmfrvidtpprodcbhgkt", "tcode");
    }

    void getLastSubString(String input, String expected) {
        LastSubstring lastSubstring = new LastSubstring();
        String output = lastSubstring.getLastSubString(input);
        System.out.println(output);
        assertEquals(expected, output);
    }
}