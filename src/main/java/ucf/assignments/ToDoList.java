/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Rielly Donnell
 */

package ucf.assignments;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class ToDoList {
    String title;
    Collection<ToDoItem> toDoItems;

    public GregorianCalendar getGregNow() {
        return GregorianCalendar.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()));
    }

    public Collection<ToDoItem> getBlankList() {
        Collection<ToDoItem> blankList = new ArrayList<>();
        ToDoItem blankItem = new ToDoItem("NewItem",
                getGregNow(),
                false);
        blankList.add(blankItem);
        return blankList;
    }

    public ToDoList(){
        this.title = "NewList";
        this.toDoItems = getBlankList();
    }

    public ToDoList(String title) {
        this.title = title;
        this.toDoItems = getBlankList();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public Collection<ToDoItem> getCompletedToDoItems() {
        Collection<ToDoItem> completedItems = new ArrayList<>();
        //for each ToDoItem in toDoList
        //  if toDoList.getCompleted is true
        //      add ToDoItem to completedItems
        if (!toDoItems.isEmpty()){
            for (ToDoItem i :
                    toDoItems) {
                if (i.getComplete()) {
                    completedItems.add(i);
                }
            }
        }
        return completedItems;
    }

    public Collection<ToDoItem> getIncompleteToDoItems() {
        Collection<ToDoItem> incompleteItems = new ArrayList<>();
        //for each ToDoItem in toDoList
        //  if toDoList.getCompleted is false
        //      add ToDoItem to completedItems
        if (!toDoItems.isEmpty()){
            for (ToDoItem i :
                    toDoItems)
                if (!i.getComplete()) {
                    incompleteItems.add(i);
                }
            }
        return incompleteItems;
    }

    public void setToDoItems(Collection<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }

    public void addItem(String desc, GregorianCalendar dueDate, boolean complete){
        //Create a new ToDoItem object
        //Add the new ToDoItem to the ToDoItem Collection;
        ToDoItem item = new ToDoItem(desc, dueDate, complete);
        toDoItems.add(item);
    }
    public void removeItem(String desc){
        //Collection removeIf item desc equals parameter desc
        toDoItems.removeIf(i -> desc.equals(i.getDesc()));
    }
}
