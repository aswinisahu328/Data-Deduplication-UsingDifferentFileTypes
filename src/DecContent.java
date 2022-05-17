public class DecContent  implements Comparable<DecContent> {
    String content, bitvalue;

    public DecContent(String content, String bitvalue) {
        this.content = content;
        this.bitvalue = bitvalue;
    }

    public String getBitValue() {
        return this.bitvalue;
    }

    public String getContent() {
        return this.content;
    }

    public String toString() {
        return this.content + ":" + this.bitvalue;
    }

    @Override
    public int compareTo(DecContent n) {

        return bitvalue.length() > n.bitvalue.length() ? -1 : 1;
    }
}