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

public class Hmain_CTL implements Initializable {
	@FXML
	private StackPane Hmain_1;
	@FXML
	private Button Hmain_1_1, Hmain_1_2, Hmain_1_3, Hmain_1_4;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void Hmain_1_Fun1(ActionEvent event) throws IOException {	

		Parent login = FXMLLoader.load(getClass().getResource("Hmain_Table_S.fxml"));
		StackPane root = (StackPane) Hmain_1_1.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Hmain_1_Fun2(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("Hmain_Table_P.fxml"));
		StackPane root = (StackPane) Hmain_1_2.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Hmain_1_Fun3(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("passwordChange.fxml"));
		StackPane root = (StackPane) Hmain_1_3.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Hmain_1_Fun4(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Hmain_1_4.getScene().getRoot();
		root.getChildren().remove(Hmain_1);
	}

}
