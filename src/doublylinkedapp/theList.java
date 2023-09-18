/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedapp;

/* Name: Le Cong Hung
Student Code: SE161248
Purpose: Problem 3: Doubly Linked list
*/
public class theList {

   public long dData;                 // data item
   public theList next;                  // next link in list
   public theList previous;              // previous link in list
// -------------------------------------------------------------
   public theList(long d)                // constructor
      { dData = d; }
// -------------------------------------------------------------
   public void displayLink()          // display this link
      { System.out.print(dData + " "); }
// -------------------------------------------------------------
   }  // end class Link
////////////////////////////////////////////////////////////////
class DoublyLinkedList
   {
   private theList first;               // ref to first item
   private theList last;                // ref to last item
// -------------------------------------------------------------
   public DoublyLinkedList()         // constructor
      {
      first = null;                  // no items on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
    public void insertFirst(long dd) // insert at front of list
    {
        theList newLink = new theList(dd);
        if (isEmpty()) // If the list is empty, set both first and last to the new link
            last = newLink;
        else
            first.previous = newLink; // Otherwise, make the new link the previous of the current first link
        newLink.next = first; // Set the next of the new link to the current first link
        first = newLink; // Update first to the new link
    }
// -------------------------------------------------------------
    public void insertLast(long dd) // insert at end of list
    {
        theList newLink = new theList(dd);
        if (isEmpty()) // If the list is empty, set both first and last to the new link
            first = newLink;
        else
            last.next = newLink; // Otherwise, make the current last link point to the new link
        newLink.previous = last; // Set the previous of the new link to the current last link
        last = newLink; // Update last to the new link
    }
// -------------------------------------------------------------
    public theList deleteFirst() // delete first link
    {
        if (isEmpty()) // Check if the list is empty
            return null;

        theList temp = first;
        if (first.next == null) // If there is only one item in the list
            last = null; // Set last to null
        else
            first.next.previous = null; // Otherwise, update the previous reference of the next link
        first = first.next; // Update first to the next link
        return temp;
    }
// -------------------------------------------------------------
    public theList deleteLast() // delete last link
    {
        if (isEmpty()) // Check if the list is empty
            return null;

        theList temp = last;
        if (last.previous == null) // If there is only one item in the list
            first = null; // Set first to null
        else
            last.previous.next = null; // Otherwise, update the next reference of the previous link
        last = last.previous; // Update last to the previous link
        return temp;
    }
// -------------------------------------------------------------
                                     // insert dd just after key
   public boolean insertAfter(long key, long dd)
      {                              // (assumes non-empty list)
      theList current = first;          // start at beginning
      while(current.dData != key)    // until match is found,
         {
         current = current.next;     // move to next link
         if(current == null)
            return false;            // didn't find it
         }
      theList newLink = new theList(dd);   // make new link

      if(current==last)              // if last link,
         {
         newLink.next = null;        // newLink --> null
         last = newLink;             // newLink <-- last
         }
      else                           // not last link,
         {
         newLink.next = current.next; // newLink --> old next
                                      // newLink <-- old next
         current.next.previous = newLink;
         }
      newLink.previous = current;    // old current <-- newLink
      current.next = newLink;        // old current --> newLink
      return true;                   // found it, did insertion
      }
// -------------------------------------------------------------
    public theList deleteKey(long key) // delete item with given key
    {
        theList current = first;
        while (current != null && current.dData != key) {
            current = current.next;
        }
        if (current == null) // Key not found
            return null;

        if (current == first)
            first = current.next; // If it's the first element, update first
        else
            current.previous.next = current.next;

        if (current == last)
            last = current.previous; // If it's the last element, update last
        else
            current.next.previous = current.previous;

        return current;
    }
// -------------------------------------------------------------
    public void displayForward() {
        System.out.print("List (forward): ");
        theList current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
// -------------------------------------------------------------
    public void displayBackward() {
        System.out.print("List (backward): ");
        theList current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
    }
}