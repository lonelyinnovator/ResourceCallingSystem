package com.resourceCallingSystem.java;

import java.util.ArrayList;
import java.util.Iterator;

public class ResourceDisplayList implements Iterable<Display> {
	private ArrayList<Display>displays;
	public ResourceDisplayList() {
		this.displays = new ArrayList<Display>();
	}
	public void addDisplay(Display display) {
		this.displays.add(display);
	}
	public void removeDisplay(Display display) {
		this.displays.remove(display);
	}
	public Display getDisplay(Resource resource) {
		for(Display display : this.displays) {
			if(display.getResource().equals(resource)) {
				return display;
			} 
		}
		return null;
	}
	public Display getDisplay(int index) {
		return this.displays.get(index);
	}
	public int getNumberOfItems() {
		return this.displays.size();
	}
	public float getTotalCost() {
		float cost = 0;
		for(Display display : this.displays) {
			cost += display.getResource().getSize() * display.getQuantity();
		}
		return cost;
	}
	public Iterator<Display> iterator() {
		return this.displays.iterator();
	}
	
}
