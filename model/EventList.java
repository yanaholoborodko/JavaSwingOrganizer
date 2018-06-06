package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Contains a list of planned events and methods for managing the list. 
 * Also, it implements Iterable and Iterator in order to be used in loops.
 * @author Yana Holoborodko 30379
 *	
 */
public class EventList implements Iterable<Event>, Iterator<Event> {
	  
	    /**
	     * Array list of Planned Events.
	     */
	    public ArrayList<Event> list;
		private int count;

	    /**
	     * A constructor that creates new ArrayList of Events.
	     */
	    public EventList() {
	        list = new ArrayList<Event>();
	    }

	    /**
	     * Adds a new event to the list.
	     * @param event - event to be added
	     */
	    public void add(Event event) {
	        list.add(event);
	    }

	    /**
	     * Returns list`s size
	     * @return size of the list
	     */
	    public int size() {
	        return list.size();
	    }

	    /**
	     * Removes an Event from the list.
	     * @param o - event to be removed
	     */
	    public void removed(Object o) {
	        list.remove(o);
	    }

	    /**
	     * Allows to iterate this class in loops.
	     */
	    @Override
	    public Iterator<Event> iterator() {
	        return this;
	    }

	    /**
	     * Returns true if there is one or more Events in the list.
	     */
	    @Override
	    public boolean hasNext() {
	        if (count < list.size()){
	            return true;
	        }
	        return false;
	    }

	    /**
	     * Returns an Event if there one or more Events in the list. 
	     */
	    @Override
	    public Event next() {
	        if (count == list.size())
	            throw new NoSuchElementException();

	        count++;
	        return list.get(count-1);
	    }
	    
	    
	    /**
	     * Returns the list of events
	     * @return list array list of the events
	     */
	    public ArrayList<Event> getList() {
	 			return list;
	 		}
	    
	    
	    /**
	     * setting the list of events
	     * @param list of the events
	     */
	    public void setList(ArrayList<Event> list) {
			this.list = list;
		}

		//???????
		@Override
		public void remove() {
			
		}
		
		/**
		 * 
		 * getting the element with 'i' index from the list
		 * @param i index of the element to get
		 * @return element with 'i' index from the list
		 */
		public Event get(int i) {
			return list.get(i);
		}
	}


