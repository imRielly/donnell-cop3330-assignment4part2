/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Rielly Donnell
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import ucf.assignments.*;

public class AppController {

    @FXML
    private TableView<ToDoItem> tableView;
    @FXML
    private TableColumn<ToDoItem, String> colDescription;
    @FXML
    private TableColumn<ToDoItem, LocalDate> colDueDate;
    @FXML
    private TableColumn<ToDoItem, Boolean> colCompleted;

    @FXML
    private TextField txtNewDescription;
    @FXML
    private DatePicker dtNewDueDate;
    @FXML
    private CheckBox chkbxNewCompleted;

    @FXML
    private CheckBox chkbxShowCompleted;
    @FXML
    private CheckBox chkbxShowIncomplete;

    @FXML
    private boolean showCompleted = true;
    @FXML
    private boolean showIncomplete = true;

    @FXML
    public void refreshToDoItems() {
        //Clear tableView
        //New ToDoList filteredItems
        //if showCompleted && showIncomplete
        //  filteredItems = toDoList
        //else if showCompleted
        //  filteredItems.setToDoItems = toDoList.getCompleted
        //Add All items to tableView from filteredItems.getToDoItems
    }

    @FXML
    public void btnLoadClicked(ActionEvent actionEvent) throws IOException {
        //Parent parentLoadList = FXML Loader getResource("LoadFile.fxml")
        //Scene sceneLoadList = new Scene parentLoadList
        //Stage window = (Stage)actionEvent (Node)get Source -> get Scene -> get Window
        //window set scene sceneLoadList
        //show window

    }

    @FXML
    public void btnDeleteToDoItemClicked(ActionEvent actionEvent) {
        //toDoList -> removeItem (toDoItem.getDesc)
    }

    @FXML
    public void btnNewItemClicked(ActionEvent actionEvent) {
        //toDoList -> addItem(txtDescription, dtDueDate, chkboxCompleted)
        //Refresh to do items
    }

    @FXML
    public void btnCreateNewListClicked(ActionEvent actionEvent) {
        //Parent parentLoadList = FXML Loader getResource("NewFile.fxml")
        //Scene sceneLoadList = new Scene parentLoadList
        //Stage window = (Stage)actionEvent (Node)get Source -> get Scene -> get Window
        //window set scene sceneLoadList
        //show window
    }

    @FXML
    public void btnSaveListClicked(ActionEvent actionEvent) {
        //appModel -> saveList()
    }

    @FXML
    public void chkbxShowCompletedClicked(ActionEvent actionEvent) {
        //set showCompleted to chkbxShowCompleted.isSelected()
        //refreshToDoItems

    }

    public void chkbxShowIncompleteClicked(ActionEvent actionEvent) {
        //set showIncomplete to chkbxShowIncomplete.isSelected()
        //refreshToDoItems
    }

    public void colDescriptionUpdate(TableColumn.CellEditEvent<ToDoList, String> toDoListStringCellEditEvent) {
        //String edit = toDoListStringCellEditEvent.getNewValue();
        //ToDoItem selectedItem = tableView.getSelectionModel().getSelectedItem()
        //For each ToDoItem in toDoList
        // if ToDoItem itemCompare with selectedItem is true
        //      ToDoItem setDescription edit

    }

    public void colDueDateUpdate(TableColumn.CellEditEvent<ToDoList, LocalDate> toDoListLocalDateCellEditEvent) {
        //LocalDate edit = toDoListLocalDateCellEditEvent.getNewValue();
        //ToDoItem selectedItem = tableView.getSelectionModel().getSelectedItem()
        //For each ToDoItem in toDoList
        // if ToDoItem itemCompare with selectedItem is true
        //      ToDoItem setDueDate edit

    }

    public void colCompletedUpdate(TableColumn.CellEditEvent<ToDoList, Boolean> toDoListBooleanCellEditEvent) {
        //Boolean edit = toDoListBooleanCellEditEvent.getNewValue();
        //ToDoItem selectedItem = tableView.getSelectionModel().getSelectedItem()
        //For each ToDoItem in toDoList
        // if ToDoItem itemCompare with selectedItem is true
        //      ToDoItem setComplete edit

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
