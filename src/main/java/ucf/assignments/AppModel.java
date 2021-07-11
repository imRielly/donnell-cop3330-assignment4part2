/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Rielly Donnell
 */

package ucf.assignments;

import java.util.ArrayList;
import java.util.Collection;

public class AppModel {
    ToDoList toDoList = new ToDoList();

    public ArrayList<String> files = new ArrayList();

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

public void loadList(String fileName) {
    //Try
    //String fullPath = System.getenv("APPDATA") + File.separator + "ToDoListApp" + File.separator + fileName + ".csv"
    //New Scanner file = Scanner(fullPath)
    //New ToDoList loadedList
    //setTitle loadedList to fileName
    //While file has next
        //New String data = file next
        //New String[] lineValues = data.split(",")
        //loadedList.addItem(lineValues[0], lineValues[1], lineValues[2])
    //setToDoList(loadedList)
    //Catch
}

public void saveList() {
    //String fileName = System.getenv("APPDATA") + File.separator + "ToDoListApp" + File.separator + toDoList.getTitle + ".csv"
    //New File listToSave
    //if listToSave file exists
    //  delete listToSave
    //Create listToSave file
    //New FileWriter as file using fileName as parameter
    //For each ToDoItem in toDoItems
    //  Append to file getDesc, ",", getDueDate, ",", getCompleted, & "\n"
}

    public void loadFiles() {
        //New File savedLists (System.getenv("APPDATA") + File.separator + "ToDoListApp" + File.separator)
        //New File[] lists = savedLists listFiles
        //For all of lists array
        //If lists is a file
        //files.add(lists.getName())

    }

}
