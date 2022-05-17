public class content implements Comparable<content> {
    private String value;
    private int count;
    private String bitvalue = "1";

    public content() {
    }

    public content(String value, int count) {
        this.value = value;
        this.count = count;
    }

    public void setBitValue(int n) {
        //for(int i=1;i<=n;i++)
        //bitvalue+="0";
        bitvalue = Integer.toBinaryString(n);
    }

    public String getBitValue() {
        return bitvalue + " ";
    }

    public String getValue() {
        return " " + this.value + " ";
    }

    public String toString() {
        return this.value + ":" + this.count + "," + bitvalue;
    }

    @Override
    public int compareTo(content n) {

        return count > n.count ? -1 :
                value.length() < n.value.length() ? -1 : 1;
    }
}