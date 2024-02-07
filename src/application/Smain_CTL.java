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

public class Smain_CTL implements Initializable {
	@FXML
	private StackPane Smain_1;
	@FXML
	private Button Smain_1_1, Smain_1_2, Smain_1_3, Smain_1_4;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////// Smain_1
	public void Smain_1_Fun1(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("Smain_SignUp.fxml"));
		StackPane root = (StackPane) Smain_1_1.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Smain_1_Fun2(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("Smain_ClassList.fxml"));
		StackPane root = (StackPane) Smain_1_2.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Smain_1_Fun3(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("passwordChange.fxml"));
		StackPane root = (StackPane) Smain_1_3.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Smain_1_Fun4(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Smain_1_4.getScene().getRoot();
		root.getChildren().remove(Smain_1);
	}
}