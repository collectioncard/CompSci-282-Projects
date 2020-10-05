/**
 * This class creates a circular linked list according to the specification for Exercise three. PLEASE NOTE::: This class fails to
 * adhere to proper data encapsulation practices. The "Current" variable is only package private and we directly pass the "Link"
 * object to any classes using this one.
 */
public class CircularLinkList {

    //Keep track of the current Link
    Link current;
    //We should keep track of the current number of Links. Since we dont have a reference to the head and tail, there is no
    //  other way of telling if we have gone through the entire list
    private int numOfLinks;

//constructor

    /**
     * Sets the global variables to the default values.
     */
    CircularLinkList() {
        //by default, there is nothing in the list - set global defaults
        current = null;
        numOfLinks = 0;
    }

    //private methods
    private void iterate() {
        current = current.getNextLink();
    }

    private Link findPrev(int key) {
        //while we could just loop until we find the key, it might go forever if there is not anything matching.
        // we might as well put a limit in place to ensure that we stop eventually.
        for (int i = 0; i < numOfLinks; i++) {
            if (current.getNextLink().getKey() == key) {
                return current;
            } else {
                iterate();
            }
        }
        //if nothing ends up matching, just return null
        return null;
    }

//public methods

    /**
     * Inserts element into the list
     * <p>
     * <p/>The operation changes depending on the current number of elements in the list. If only one element exists,
     * then the new Link object is set to the "current" global variable. If more than one exists, A new "Link" object is created
     * and the next references are updated accordingly
     *
     * @param key   The index key of the "Link" object to be added to the list
     * @param value The value of the "Link" object to be added to the list
     */
    public void insert(int key, int value) {
        //first check to see if there is a value in the list
        if (current == null) {
            //create a link and set it to the global reference
            current = new Link(key, value);
            //set the links next reference to itself
            current.setNextLink(current);
        } else {
            //get a reference to the next Link in the list
            Link oldNext = current.getNextLink();
            //set a new next Link with the next pointing to the old next link
            current.setNextLink(new Link(key, value, oldNext));
        }
        numOfLinks++;
    }

    /**
     * Displays all elements in the list
     * <p>
     * <p/>Loops through the list and appends every element's values into a StringBuilder object. After looping is finished,
     * the StringBuilder object is printed to the outputStream.
     */
    public void display() {
        if (numOfLinks == 0) {
            System.out.println("\nThere are currently no items in the linked list!");
        } else {
            StringBuilder toOutput = new StringBuilder();
            for (int i = 0; i < numOfLinks; i++) {
                toOutput.append("Link ").append(i + 1).append("{Key: ").append(current.getKey()).append(" Value: ").append(current.getvalue()).append("}\n");
                current = current.getNextLink();
            }
            System.out.println("\nCurrent items in list:\n" + toOutput.toString());
        }
    }

    /**
     * Finds a Link
     * <p>
     * <p/>Finds a link in the list given its key value. If the key is not found, the method returns null.
     *
     * @param key The Key value that you wish to find
     * @return The first Link object with the specified key value
     */
    public Link find(int key) {
        //while we could just loop until we find the key, it might go forever if there is not anything matching.
        // we might as well put a limit in place to ensure that we stop eventually.
        for (int i = 0; i < numOfLinks; i++) {
            if (current.getKey() == key) {
                return current;
            } else {
                iterate();
            }
        }
        //if nothing ends up matching, just return null
        return null;
    }

    /**
     * Deletes a link
     * <p>
     * <p/>Finds a link in a list via a given key and removes it from the linked list. This method also corrects the next methods
     * within the Link to point to the new next Link object.
     *
     * @param key The value of the key you wish to delete
     * @return A Link Object used to create the link list in this class
     */
    public Link delete(int key) {
        //reference to the link that needs to be returned
        Link toReturn;

        //if there is only one item in the array, just delete it
        if (numOfLinks == 1) {
            toReturn = current;
            current = null;
        } else {
            //we need to loop find the previous link to that containing the key
            Link foundLink = findPrev(key);

            //ensure that the link is not null
            if (foundLink == null) {
                return null;
            }

            //at this point we should be able to proceed as usual
            toReturn = foundLink.getNextLink();
            foundLink.setNextLink(foundLink.getNextLink().getNextLink());
        }
        numOfLinks--;
        return toReturn;
    }
}
