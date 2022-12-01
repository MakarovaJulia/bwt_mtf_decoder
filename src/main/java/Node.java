public class Node {
    String character;
    Integer freq;

    public Node(String character, Integer freq) {
        this.character = character;
        this.freq = freq;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    @Override
    public String toString(){
        return this.character + "=" + this.freq;
    }
}
