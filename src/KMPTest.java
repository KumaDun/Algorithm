import org.junit.Test;

import static org.junit.Assert.*;

public class KMPTest {
    KMP kmp = new KMP("abcdefgabcdefhabcde");
    @Test
    public void testOne(){
        String patternOne = "abcdefh";
        assertEquals(7,kmp.kmpSearch(patternOne));
    }
}