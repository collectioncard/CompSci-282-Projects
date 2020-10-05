public class Link {
    public Integer key;
    private Integer value;
    private Link nextLink;

    //Constructors
    public Link(){
        key = null;
        value = null;
        setNextLink(null);
    }

    public Link(int key, int value){
        this.key = key;
        this.value = value;
        nextLink = null;
    }

    //Double Arg Constructor
    public Link(int key, int value, Link newNext){
        this.key = key;
        this.value = value;
        nextLink = newNext;
    }

    //methods
    public int getvalue(){
        return value;
    }

    public int getKey(){
        return key;
    }

    public Link getNextLink(){
        return nextLink;
    }

    public void setKey(int newKey){
        key = newKey;
    }

    public void setValue(int newValue){
        value = newValue;
    }

    public void setNextLink(Link newNext){
        nextLink = newNext;
    }

    public void displayLink() {
        System.out.print("{" + key + ", " + value + "}");
    }
}
