package com.resourceCallingSystem.java;

/**
 * @author 沈佳军
 * @description A custom's calling has a resourceDisplayList.
 * @date 2020/11/14
 */
public class Calling {
    private ResourceDisplayList resourceDisplayList;
    private int total;

    /**
     * @param resourceDisplayList
     * @param total
     * @return
     * @description The constructor of the calling.
     */
    public Calling(ResourceDisplayList resourceDisplayList, int total) {
        this.resourceDisplayList = resourceDisplayList;
        this.total = total;
    }

    /**
     * @param
     * @return ResourceDisplayList
     * @description Return the ResourceDisplayList of the calling.
     */
    public ResourceDisplayList getResourceDisplayList() {
        return resourceDisplayList;
    }
    /**
     * @param
     * @return int
     * @description Get the total numbers of the calling.
     */
    public int getTotal() {
        return total;
    }
}
