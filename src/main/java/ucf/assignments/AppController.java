/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Rielly Donnell
 */

package ucf.assignments;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    static AppModel appModel = new AppModel();

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
    private TextArea txtError;

    @FXML
    public void refreshToDoItems() {
        //New ToDoList filteredItems
        //if showCompleted && showIncomplete
        //  filteredItems = toDoList
        //else if showCompleted
        //  filteredItems.setToDoItems = toDoList.getCompleted
        //Add All items to tableView from filteredItems
        ToDoList filteredItems = new ToDoList();
        ToDoList fullList;
        fullList = appModel.getToDoList();

        if (showCompleted && showIncomplete) {
            filteredItems = fullList;
        } else if (showCompleted && !showIncomplete) {
            filteredItems.setToDoItems(fullList.getCompletedToDoItems());
        } else if (!showCompleted && showIncomplete) {
            filteredItems.setToDoItems(fullList.getIncompleteToDoItems());
        }

        txtNewDescription.setText("");
        dtNewDueDate.setValue(null);
        chkbxNewCompleted.setSelected(false);

        tableView.setItems(getItemsToDisplay(filteredItems));
        tableView.refresh();

        txtError.appendText("Refreshed List\n");
        txtError.appendText(appModel.getToDoList().getTitle() + "\n");
    }

    public ObservableList<ToDoItem> getItemsToDisplay(ToDoList list) {
        //Create ObservableList items
        //addAll ToDoItems from list to the ObservableList items
        //return ObservableList items
        ObservableList<ToDoItem> items = FXCollections.observableArrayList();
        if (list.getToDoItems() != null){
            items.addAll(list.getToDoItems());
        }
        return items;
    }

    public DateFormat dateFormat = DateFormat.getDateInstance();

    @FXML
    public void btnLoadClicked(ActionEvent actionEvent) throws IOException {
        //Parent parentLoadList = FXML Loader getResource("LoadFile.fxml")
        //Scene sceneLoadList = new Scene parentLoadList
        //Stage window = (Stage)actionEvent (Node)get Source -> get Scene -> get Window
        //window set scene sceneLoadList
        //show window

        Parent parentLoadList = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoadFile.fxml")));
        Scene sceneLoadList = new Scene(parentLoadList);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(sceneLoadList);
        window.show();
        txtError.appendText("btnLoadClicked\n");
    }

    @FXML
    public void btnDeleteToDoItemClicked() {
        //toDoList -> removeItem (toDoItem.getDesc)
        appModel.getToDoList().removeItem(tableView.getSelectionModel().getSelectedItem().desc.get());
        refreshToDoItems();
        txtError.appendText("btnDeleteToDoItemClicked\n");
    }

    @FXML
    public void btnNewItemClicked() {
        //toDoList -> addItem(txtDescription, dtDueDate, chkboxCompleted)
        //Refresh to do items
        appModel.getToDoList().addItem(txtNewDescription.getText(), dtNewDueDate.getValue(), chkbxNewCompleted.isSelected());
        txtError.appendText("btnNewItemClicked\n");
        txtError.appendText("NewDesc: " + txtNewDescription.getText() + "\n");
        txtError.appendText("NewDate: " + dtNewDueDate.getValue() + "\n");
        txtError.appendText("NewComplete: " + chkbxNewCompleted.isSelected());
        refreshToDoItems();
    }

    @FXML
    public void btnCreateNewListClicked(ActionEvent actionEvent) throws IOException {
        //Parent parentLoadList = FXML Loader getResource("NewFile.fxml")
        //Scene sceneLoadList = new Scene parentLoadList
        //Stage window = (Stage)actionEvent (Node)get Source -> get Scene -> get Window
        //window set scene sceneLoadList
        //show window
        Parent parentNewList = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewFile.fxml")));
        Scene sceneNewList = new Scene(parentNewList);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(sceneNewList);
        window.show();
        txtError.appendText("btnCreateNewListClicked\n");
    }

    @FXML
    public void btnSaveListClicked() {
        //appModel -> saveList()
        try {
            appModel.saveList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        txtError.appendText("btnSaveListClicked\n");
    }

    @FXML
    public void chkbxShowCompletedClicked() {
        //set showCompleted to chkbxShowCompleted.isSelected()
        //refreshToDoItems
        showCompleted = chkbxShowCompleted.isSelected();
        refreshToDoItems();
        txtError.appendText("chkbxShowCompletedClicked\n");
        txtError.appendText(showCompleted + "\n");
    }

    public void chkbxShowIncompleteClicked() {
        //set showIncomplete to chkbxShowIncomplete.isSelected()
        //refreshToDoItems
        showIncomplete = chkbxShowIncomplete.isSelected();
        refreshToDoItems();
        txtError.appendText("chkbxShowIncompleteClicked\n");
        txtError.appendText(showIncomplete + "\n");
    }
/*
    public void colDescriptionUpdate(TableColumn.CellEditEvent<ToDoList, String> toDoListStringCellEditEvent) {
        //String edit = toDoListStringCellEditEvent.getNewValue();
        //ToDoItem selectedItem = tableView.getSelectionModel().getSelectedItem()
        //For each ToDoItem in toDoList
        // if ToDoItem itemCompare with selectedItem is true
        //      ToDoItem setDescription edit
        String edit = toDoListStringCellEditEvent.getNewValue();
        edit = edit.substring(0, Math.min(edit.length(), 255));
        ToDoItem selectedItem = tableView.getSelectionModel().getSelectedItem();
        for (ToDoItem i :
                appModel.getToDoList().getToDoItems()) {
            if (i.itemCompare(selectedItem)) {
                i.setDesc(edit);
                txtError.appendText("DescriptionUpdated\n");
                txtError.appendText("OldValue: " + toDoListStringCellEditEvent.getOldValue() + "\n");
                txtError.appendText("NewValue: " + edit + "\n");
                txtError.appendText("CurrentValue: " + i.getDesc() + "\n");
            }
        }
    }

    public void colDueDateUpdate(TableColumn.CellEditEvent<ToDoList, LocalDate> toDoListLocalDateCellEditEvent) {
        //LocalDate edit = toDoListLocalDateCellEditEvent.getNewValue();
        //ToDoItem selectedItem = tableView.getSelectionModel().getSelectedItem()
        //For each ToDoItem in toDoList
        // if ToDoItem itemCompare with selectedItem is true
        //      ToDoItem setDueDate edit
        LocalDate edit = toDoListLocalDateCellEditEvent.getNewValue();
        ToDoItem selectedItem = tableView.getSelectionModel().getSelectedItem();
        for (ToDoItem i :
                appModel.getToDoList().getToDoItems()) {
            if (i.itemCompare(selectedItem)) {
                i.setDueDate(edit);
                txtError.appendText("DescriptionUpdated\n");
                txtError.appendText("OldValue: " + toDoListLocalDateCellEditEvent.getOldValue() + "\n");
                txtError.appendText("NewValue: " + edit + "\n");
                txtError.appendText("CurrentValue: " + i.getDueDate().toString() + "\n");
            }
        }
    }

    public void colCompletedUpdate(TableColumn.CellEditEvent<ToDoList, Boolean> toDoListBooleanCellEditEvent) {
        //Boolean edit = toDoListBooleanCellEditEvent.getNewValue();
        //ToDoItem selectedItem = tableView.getSelectionModel().getSelectedItem()
        //For each ToDoItem in toDoList
        // if ToDoItem itemCompare with selectedItem is true
        //      ToDoItem setComplete edit
        Boolean edit = toDoListBooleanCellEditEvent.getNewValue();
        ToDoItem selectedItem = tableView.getSelectionModel().getSelectedItem();
        for (ToDoItem i :
                appModel.getToDoList().getToDoItems()) {
            if (i.itemCompare(selectedItem)) {
                i.setComplete(edit);
                txtError.appendText("DescriptionUpdated\n");
                txtError.appendText("OldValue: " + toDoListBooleanCellEditEvent.getOldValue() + "\n");
                txtError.appendText("NewValue: " + edit + "\n");
                txtError.appendText("CurrentValue: " + (i.getComplete() + "\n"));
            }
        }
    }

    public GregorianCalendar convertLocalDateToGreg(LocalDate localDate) {
        if (!(localDate == null)) {
            return GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        }
        return GregorianCalendar.from(LocalDate.of(1900, 1, 1).atStartOfDay(ZoneId.systemDefault()));
    }
*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initialize the tableview columns
        //<notes?>
        /////colDescription.setCellValueFactory(new PropertyValueFactory<ToDoItem, String>("desc"));
        /////colDueDate.setCellValueFactory(new PropertyValueFactory<ToDoItem, LocalDate>("dueDate"));
        /////colCompleted.setCellValueFactory(new PropertyValueFactory<ToDoItem, boolean>("completed"));
        //</notes?>
        //Refresh to do items
        colDescription.setCellValueFactory(new PropertyValueFactory<>("desc"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colCompleted.setCellValueFactory(param -> {
            ToDoItem item = param.getValue();

            SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(item.getComplete());

            booleanProperty.addListener((observable, oldValue, newValue) -> item.setComplete(newValue));

            return booleanProperty;
        });
        colCompleted.setCellFactory(t -> {
            CheckBoxTableCell<ToDoItem, Boolean> cell = new CheckBoxTableCell<>();
            cell.setAlignment(Pos.BASELINE_CENTER);
            return cell;
        });
        tableView.setEditable(true);
        refreshToDoItems();
    }
}
