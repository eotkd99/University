package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.Lecture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class Smain_ClassList_CTL implements Initializable {

	@FXML
	private StackPane Smain_3;
	@FXML
	private Button Smain_3_1, Smain_3_2, Smain_3_3;
	@FXML
	private TableView<Lecture> tableView;
	@FXML
	private TableColumn<Lecture, String> LectureNum, LectureName, LectureDepartment, LectureSnum, LectureDes, LectureProfessor, LectureScore;
	@FXML
	private TableColumn<Lecture, CheckBox> check;

	public void renew() {
		list.removeAll(list);
		for (int i = 0; i < DataList.sList.get(LoginCTL.userIndex).getMylList().size(); i++) {
			list.add(DataList.sList.get(LoginCTL.userIndex).getMylList().get(i));
		}
	}

	ObservableList<Lecture> list = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		renew();
		LectureNum.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureNum"));
		LectureName.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureName"));
		LectureDepartment.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureDepartment"));
		LectureSnum.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureSnum"));
		LectureProfessor.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureProfessor"));
		LectureScore.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureScore"));
		tableView.setItems(list);
	}

	public void Smain_3_Fun1(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Smain_3_1.getScene().getRoot();
		root.getChildren().remove(Smain_3);
	}
}
