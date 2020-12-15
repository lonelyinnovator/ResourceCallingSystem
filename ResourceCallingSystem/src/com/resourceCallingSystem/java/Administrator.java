package com.resourceCallingSystem.java;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 沈佳军
 * @description Create an administrator to manage the callings for the ResourceCallingSystem.
 * @date 2020/11/14
 */

public class Administrator implements Iterable<Calling> {
    private ArrayList<Calling> callings;

    /**
     * @description The constructor of the administrator.
     */
    public Administrator() {
        this.callings = new ArrayList<Calling>();
    }

    /**
     * @param calling
     * @return void
     * @description Add a calling to the callings.
     */

    public void addCalling(Calling calling) {
        this.callings.add(calling);
    }

    /**
     * @param calling
     * @return void
     * @description remove a calling from the callings.
     */
    public void removeCalling(Calling calling) {
        this.callings.remove(calling);
    }

    /**
     * @param index
     * @description
     * @return Calling
     * @description Get a calling from the callings through index.
     */
    public Calling getCalling(int index) {
        return this.callings.get(index);
    }

    /**
     * @param
     * @return int
     * @description Get the number of the callings.
     */
    public int getNumberOfCallings() {
        return this.callings.size();
    }

    /**
     * @param
     * @return Iterator<Calling>
     * @description Return an iterator of the callings.
     */
    public Iterator<Calling> iterator() {
        return this.callings.iterator();
    }

}
