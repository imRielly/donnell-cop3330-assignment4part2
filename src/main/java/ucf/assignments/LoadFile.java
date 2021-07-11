/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Rielly Donnell
 *
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadFile {

    @FXML
    private ListView<String> lvFilesItems;

    @FXML
    public void loadList(MouseEvent mouseEvent) {
        //New String fileToLoad as
        //Return to todolist
        //Parent parentLoadList = FXML Loader getResource("app.fxml")
        //Scene sceneLoadList = new Scene parentLoadList
        //Stage window = (Stage)actionEvent (Node)get Source -> get Scene -> get Window
        //window set scene sceneLoadList
        //show window
    }


    public void initialize(URL url, ResourceBundle rb) {
        //loadFiles()
        //for each title in files
        //  add item to lvFilesItems
    }

}
