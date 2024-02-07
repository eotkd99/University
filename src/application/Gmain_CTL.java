package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Gmain_CTL implements Initializable {
	@FXML
	private StackPane Gmain_1;
	@FXML
	private Button Gmain_1_1, Gmain_1_2, Gmain_1_3, Gmain_1_4;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void Gmain_1_Fun1(ActionEvent event) throws IOException {	
		Parent login = FXMLLoader.load(getClass().getResource("Gmain_Table.fxml"));
		StackPane root = (StackPane) Gmain_1_1.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Gmain_1_Fun2(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("Gmain_Bill.fxml"));
		StackPane root = (StackPane) Gmain_1_2.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Gmain_1_Fun3(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("passwordChange.fxml"));
		StackPane root = (StackPane) Gmain_1_3.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Gmain_1_Fun4(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Gmain_1_4.getScene().getRoot();
		root.getChildren().remove(Gmain_1);
	}
}
