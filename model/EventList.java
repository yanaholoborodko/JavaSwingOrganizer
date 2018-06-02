package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

	    //???????
		@Override
		public void remove() {
			
		}
		
		public Event get(int i) {
			return list.get(i);
		}
	}


