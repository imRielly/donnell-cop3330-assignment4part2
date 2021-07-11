/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Rielly Donnell
 */

package ucf.assignments;

import java.time.LocalDate;

public class ToDoItem {

    String desc;
    LocalDate dueDate;
    boolean complete;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean itemCompare(ToDoItem toCompare) {
        if (this.desc == toCompare.getDesc() && this.dueDate == toCompare.getDueDate() && Boolean.compare(this.complete, toCompare.getComplete()) == 0)
            return true;
        else return false;
    }
}
