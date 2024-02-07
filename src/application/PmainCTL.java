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

public class PmainCTL implements Initializable {
	@FXML
	private StackPane Pmain_1;
	@FXML
	private Button Pmain_1_1, Pmain_1_2, Pmain_1_3, Pmain_1_4;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

/////////////////////////////////////////////////////////////////////////////////////////////////// Pmain_1
	public void Pmain_1_Fun1(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("Pmain_StudentList.fxml"));
		StackPane root = (StackPane) Pmain_1_1.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Pmain_1_Fun2(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("Pmain_Attendance.fxml"));
		StackPane root = (StackPane) Pmain_1_2.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Pmain_1_Fun3(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("passwordChange.fxml"));
		StackPane root = (StackPane) Pmain_1_3.getScene().getRoot();
		root.getChildren().add(login);
		StaticFunc.animation(login);
	}

	public void Pmain_1_Fun4(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Pmain_1_4.getScene().getRoot();
		root.getChildren().remove(Pmain_1);
	}

}
