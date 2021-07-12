/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Rielly Donnell
 */

package ucf.assignments;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AppModel {
    private ToDoList toDoList = new ToDoList();

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

public void loadList(String fileName) {
    //Try
    //String fullPath = System.getProperty("user.home") + File.separator + "ToDoListApp" + File.separator + fileName + ".csv"
    //New Scanner file = Scanner(fullPath)
    //New ToDoList loadedList
    //setTitle loadedList to fileName
    //While file has next
        //New String data = file next
        //New String[] lineValues = data.split(",")
        //loadedList.addItem(lineValues[0], lineValues[1], lineValues[2])
    //setToDoList(loadedList)
    //Catch

    String path = System.getenv("APPDATA") + File.separator + "ToDoListApp" + File.separator;
    String fullPath = path + fileName + ".csv";
    checkForDir(path);
    checkForFile(fullPath, fileName);
    Scanner file = new Scanner(fullPath);
    ToDoList loadedList = new ToDoList();
    loadedList.setTitle(fileName);
    while(file.hasNext()){
        String data = file.next();
        String[] lineValues = data.split(",");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if (lineValues.length >= 3) {
            try {
                date = dateFormat.parse(lineValues[1]);
                GregorianCalendar gregDate = new GregorianCalendar();
                gregDate = (GregorianCalendar) GregorianCalendar.getInstance();
                gregDate.setTime(date);
                loadedList.addItem(lineValues[0], gregDate, Boolean.parseBoolean(lineValues[2]));
            } catch (ParseException e) {
            }
        }
    }
    toDoList = loadedList;
}

    private void checkForDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    private void checkForFile(String fullPath, String fileName) {
        File file = new File(fullPath);
        System.out.println(fullPath);
        if (!file.exists()) {
            ToDoList missingList = new ToDoList(fileName);
            ToDoItem missingItem = new ToDoItem("Sample Item");
            missingList.addItem(missingItem.getDesc(), missingItem.getDueDate(), missingItem.getComplete());
            toDoList = missingList;
            try {
                saveList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveList() throws IOException {
    //String fileName = System.getenv("APPDATA") + File.separator + "ToDoListApp" + File.separator + toDoList.getTitle + ".csv"
    //New File listToSave
    //if listToSave file exists
    //  delete listToSave
    //Create listToSave file
    //New FileWriter as file using fileName as parameter
    //For each ToDoItem in toDoItems
    //  Append to file getDesc, ",", getDueDate, ",", getCompleted, & "\n"
    String fileName = System.getenv("APPDATA") + File.separator + "ToDoListApp" + File.separator + toDoList.getTitle() + ".csv";
    File listToSave = new File(fileName);
    if (listToSave.exists()) {
        listToSave.delete();
    }
    listToSave.createNewFile();
    try {
        FileWriter fileWriter = new FileWriter(listToSave);
        for (ToDoItem e :
                toDoList.getToDoItems()) {
            StringBuilder s = new StringBuilder(e.getDesc() + "," + String.valueOf(e.getDueDate()) + "," + String.valueOf(e.getComplete()) + "\n");
            fileWriter.append(s);
        }
    } catch (IOException e) {
    }

}

}
