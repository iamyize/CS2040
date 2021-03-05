public interface ListInterface {
	public int     size(); // Return number of items in the list

  //  access items in the list
	public String     getItemAtIndex(int index); // get item at index

  // add items to the list
  	public void    addAtIndex(int index, int item); // add item at position index, 
                                                  // shifting all current items from index onwards to the right by 1 
                                                  // add item to the back if index == size() 
	public void    addFront(int item); // add item to front of list
	public void    addBack(int item); // add item to back of list
}
