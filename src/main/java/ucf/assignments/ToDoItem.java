/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Rielly Donnell
 */

package ucf.assignments;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public class ToDoItem {

    String desc;
    GregorianCalendar dueDate;
    boolean complete;

    public GregorianCalendar getGregNow() {
        return GregorianCalendar.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()));
    }

    public ToDoItem(String desc, GregorianCalendar dueDate, boolean complete) {
        this.desc = desc;
        this.dueDate = dueDate;
        this.complete = complete;
    }

    public ToDoItem(String desc) {
        this.desc = desc;
        this.dueDate = getGregNow();
        this.complete = false;

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public GregorianCalendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(GregorianCalendar dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean itemCompare(ToDoItem toCompare) {
        return this.desc.equals(toCompare.getDesc()) && this.dueDate.equals(toCompare.getDueDate()) && Boolean.compare(this.complete, toCompare.getComplete()) == 0;
    }
}
