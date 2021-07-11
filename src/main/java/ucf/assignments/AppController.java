/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Rielly Donnell
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import ucf.assignments.*;

public class AppController {

    @FXML
    ObservableList ToDoList = FXCollections.observableArrayList();

    @FXML
    private ListView<String> lvTitles;

    @FXML
    private TableView<ToDoList> tableView;
    @FXML
    private TableColumn<ToDoList, String> colDescription;
    @FXML
    private TableColumn<ToDoList, LocalDate> colDueDate;
    @FXML
    private TableColumn<ToDoList, Boolean> colCompleted;

    @FXML
    private TextField txtNewDescription;
    @FXML
    private DatePicker dtNewDueDate;
    @FXML
    private CheckBox chkbxNewCompleted;

    @FXML
    private ToDoList activeToDoList;
    @FXML
    private ToDoItem activeToDoItem;

    @FXML
    public void refreshTitleList() {
        //Remove all items from ToDoList
        //For all ToDoLists in appModel toDoList
        //  Add appModel toDoList title to ToDoList
        //Add all ToDoList items to lvTitles
    }

    @FXML
    public void refreshToDoItems() {
        //Clear tableView
        //Add All items to tableView from activeToDoList.getToDoItems
    }

    @FXML
    public void btnSaveClicked(ActionEvent actionEvent) {
        //appModel -> saveAll()
    }

    @FXML
    public void btnLoadClicked(ActionEvent actionEvent) {
        //appModel -> loadAll()
    }

    @FXML
    public void btnDeleteListClicked(ActionEvent actionEvent) {
        //appModel -> removeList(activeToDoList.getTitle)
    }

    @FXML
    public void btnDeleteToDoItemClicked(ActionEvent actionEvent) {
        //appModel -> removeToDoItem (activeToDoList.getTitle, activeToDoItem.getDesc)
    }

    @FXML
    public void btnMarkCompleteClicked(ActionEvent actionEvent) {
        //appModel -> markItemCompleted (activeToDoList.getTitle, activeToDoItem.getDesc)
    }

    @FXML
    public void btnNewItemClicked(ActionEvent actionEvent) {
        //appModel -> toDoList -> title contains activeToDoList title -> addItem(txtDescription, dtDueDate, chkboxCompleted)
        //Refresh to do items
    }

    @FXML
    public void listTitleClicked(MouseEvent mouseEvent) {
        //String clickedTitle = lvTitles selection
        //Set activeToDoList = appModel -> toDoList -> title contains clickedTitle
        //Refresh table view
    }

    @FXML
    public void btnCreateNewListClicked(ActionEvent actionEvent) {
        //appModel -> addList
    }

    @FXML
    public void btnSaveListClicked(ActionEvent actionEvent) {
        //appModel -> saveList(activeToDoList.getTitle)
    }


    public void initialize(URL url, ResourceBundle rb) {
        //New AppModel appModel
        //Initialize the tableview columns
        //<notes?>
        /////colDescription.setCellValueFactory(new PropertyValueFactory<ToDoItem, String>("desc"));
        /////colDueDate.setCellValueFactory(new PropertyValueFactory<ToDoItem, LocalDate>("dueDate"));
        /////colCompleted.setCellValueFactory(new PropertyValueFactory<ToDoItem, boolean>("completed"));
        //</notes?>
        //Refresh to do items
    }
}
