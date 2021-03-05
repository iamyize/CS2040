import java.util.*;

class TailedLinkedList implements ListInterface {
  // attributes
  public ListNode head;
  public ListNode tail;
  public int num_nodes;

  // interface methods

  // Return number of items in list
  public int size() { return num_nodes; }

  // get item at index
  public String getItemAtIndex(int index) {
    int counter = 0;
    String item=null;

    if (index < 0 || index > size()-1) {
      System.out.println("invalid index");
      System.exit(1);
    }
    if (index == size()-1)
      item = tail.getItem();
    else {
      for (ListNode cur = head; cur != null; cur = cur.getNext(), counter++) {
        if (counter == index) {
          item = cur.getItem();
          break;
        }
      }
    }
    return item;
  }

  // add item at position index, shifting all current items from index onwards to the right by 1 
  public void addAtIndex(int index, String item) {
    ListNode cur;
    ListNode newNode = new ListNode(item);

    if (index >= 0 && index <= size()) {
      if (index == 0) // insert in front
        insert(null,newNode);
      else if (index == size()) // insert at the back, don't have to move all the way to the back
        insert(tail,newNode);
      else {
        cur = getNodeAtIndex(index-1); // access node at index-1
        insert(cur,newNode);
      }
    }
    else { // index out of bounds
      System.out.println("invalid index");
      System.exit(1);
    }
  } 

 // non-interface helper methods
  public ListNode getHead() { return head; }
  public ListNode getTail() { return tail; }

  public ListNode getNodeAtIndex(int index) {
    int counter = 0;
    ListNode node = null;

    if (index < 0 || index > size()-1) {
      System.out.println("invalid index");
      System.exit(1);
    }
    if (index == size()-1) // return tail if index == size()-1
      return tail;
    for (ListNode cur = head; cur != null; cur = cur.getNext()) {
      if (counter == index) {
        node = cur;
        break;
      }
      counter++;
    }
    return node;
  }

  // Add item to front of list
  public void addFront(String item) { addAtIndex(0,item); }

  // Add item to back of list
  public void addBack(String item) { addAtIndex(size(),item); }

// insert newNode after the node referenced by cur 
  public void insert(ListNode cur, ListNode n) {
    // insert in front
    if (cur == null) {
      n.setNext(head);
      head = n; // update head
      if (tail == null) // update tail if list originally empty
        tail = head;
    }
    else { // insert anywhere else
      n.setNext(cur.getNext());
      cur.setNext(n);
      if (cur == tail) // update tail if inserted new last item
        tail = tail.getNext();
    }
    num_nodes++;
  }
}