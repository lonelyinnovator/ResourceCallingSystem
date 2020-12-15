package com.resourceCallingSystem.java;

import java.util.ArrayList;
import java.util.Iterator;

public  class ResourceCatalog implements Iterable<Resource>{
	private ArrayList<Resource> resources;
	public ResourceCatalog() {
		this.resources = new ArrayList<Resource>();
	}
	public void addResource(Resource resource) {
		this.resources.add(resource);
	}
	public void removeResource(Resource resource) {
		this.resources.remove(resource);
	}
	public Resource getResource(String code) {
		for(Resource resource :this.resources) {
			if(resource.getCode() == code) {
				return resource;
			}
		}
		return null;
	}
	public int getNumberOfResources() {
		return this.resources.size();
	}
	public Resource getResource(int index) {
		return this.resources.get(index);
	}
	public Iterator<Resource> iterator() {
		return this.resources.iterator();
	}
}
