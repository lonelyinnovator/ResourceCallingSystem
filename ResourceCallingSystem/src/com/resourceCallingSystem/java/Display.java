package com.resourceCallingSystem.java;

/**
 * @author 沈佳军
 * @description A display is a resource to display in the ResourceCallingSystem.
 * @date 2020/11/14
 */
public class Display {
    private Resource resource;
    private int quantity;

    /**
     * @param resource
     * @param quantity
     * @return
     * @description The constructor of the display
     */
    public Display(Resource resource, int quantity) {
        this.resource = resource;
        this.quantity = quantity;
    }

    /**
     * @param
     * @return int
     * @description Get the quantity of the display.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param
     * @return Resource
     * @description Get the resource that is related to the display.
     */
    public Resource getResource() {
        return this.resource;
    }

    /**
     * @param quantity
     * @return void
     * @description Set the quantity of the display.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
