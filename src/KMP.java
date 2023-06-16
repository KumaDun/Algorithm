public class KMP {
    private String str;

    public KMP(String str) {
        this.str = str;
    }
    public int kmpSearch (String patt){
        int[] next = buildNext(patt);
        int i = 0; // pointer of the text string
        int j = 0; // pointer of the pattern string
        char[] strChar = str.toCharArray();
        char[] pattChar = patt.toCharArray();
        // pointer i never back up
        while (i<this.str.length()){
            if (j==patt.length()){
                return i-j;
            }
            // if pointers of text and pattern match, move forward both pointers
            if (strChar[i] == pattChar[j]){
                i = i + 1;
                j = j + 1;
            }
            // if not match, compare pattern string starting from next[j-1]
            // this will skip first next[j-1] chars in pattern string
            else if (j>0) {
                j = next[j-1];
            }
            else{
            // if the first is not matched, move forward text pointer
                i = i +1;
            }
        }
        return -1;
    }

    private int[] buildNext(String patt){
        int[] next = new int[patt.length()];
        next[0] = 0;
        int commonLen = 0;
        int i = 1;
        char[] pattChar = patt.toCharArray();
        while (i<next.length){
            // common length + 1 if next char same
            if (pattChar[commonLen] == pattChar[i]){
                commonLen = commonLen + 1;
                next[i] = commonLen;
                i = i + 1;
            }
            else{
                // if common length is zero, it's either just beginning of the function
                // or no common chars at all
                if (commonLen == 0) {
                    next[i] = 0;
                    i = i + 1;
                }
                // if common length is > 0, we reuse the memorization of common length stored
                // in the current next[commonLen-1], -1 to transform length to index
                else{
                    commonLen = next[commonLen-1];
                }
            }
        }
        return next;
    }
}
