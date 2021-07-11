/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Rielly Donnell
 */

package ucf.assignments;

import java.time.LocalDate;
import java.util.Collection;

public class ToDoList {
    String title;
    Collection<ToDoItem> toDoItems;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void setToDoItems(Collection<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }

    public void addItem(String desc, LocalDate dueDate, boolean complete){
        //Create a new ToDoItem object
        //Use setDesc to set the new objects desc to the parameter desc
        //Use setDueDate to set the new objects dueDate to the parameter dueDate
        //Use setComplete to set the new objects complete to the parameter complete
        //Add the new ToDoItem to the ToDoItem Collection;
    }
    public void removeItem(String desc){
        //New Iterator<ToDoItem> i
        //Loop while i has values
        //New ToDoItem compare = next i
        //If compare desc = param desc
        //  remove i
    }
}
