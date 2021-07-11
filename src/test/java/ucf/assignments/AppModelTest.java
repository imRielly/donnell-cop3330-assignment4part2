/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Rielly Donnell
 *
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppModelTest {

    @Test
    void loadAll() {
        //Run addList() to create a list
        //Run saveList() for new list
        //Run removeList() for new list
        //Run loadAll()
        //New File file = new list filepath
        //AssertTrue(file.exists())
        //Delete file
    }

    @Test
    void loadList() {
        //Run addList() to create a list
        //Run saveList() for new list
        //Run removeList() for new list
        //Run loadList() for new list
        //New File file = new list filepath
        //AssertTrue(file.exists())
        //Delete file
    }

    @Test
    void saveAll() {
        //Run addList() to create a list
        //Run saveAll()
        //New File file = new list filepath
        //AssertTrue(file.exists())
        //Delete file
    }

    @Test
    void saveList() {
        //Run addList() to create a list
        //Run saveList() to save new list
        //New File file = new list filepath
        //AssertTrue(file.exists())
        //Delete file
    }

    @Test
    void addList() {
        //Clear toDoList
        //Run addList
        //New ToDoList expected
        //Set expected title = "NewList1"
        //AssertTrue(toDoList.contains(expected))
    }

    @Test
    void removeList() {
        //Clear toDoList
        //Run addList
        //New ToDoList expected
        //Set expected title = "NewList1"
        //removeList("NewList1")
        //AssertFalse(toDoList.contains(expected))
    }

    @Test
    void removeToDoItem() {
        //Clear toDoList
        //Run addList
        //Run addItem("NewItem1", "07/05/2021", true) for toDoList -> title contains "NewList1"
        //Run removeToDoItem("NewList1", "NewItem1")
        //AssertFalse(toDoItems contains("NewItem1")
    }

    @Test
    void markItemCompleted() {
        //Clear toDoList
        //Run addList
        //Run addItem("NewItem1", "07/05/2021", false) for toDoList -> title contains "NewList1"
        //Run markItemCompleted("NewList1", "NewItem1")
        //AssertTrue(toDoItem.getCompleted)
    }
}