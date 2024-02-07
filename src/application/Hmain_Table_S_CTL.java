package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Hmain_Table_S_CTL implements Initializable {

	@FXML
	private StackPane Hmain_2;
	@FXML
	private Button Hmain_2_1, Hmain_2_2, Hmain_2_3, Hmain_2_4, Hmain_2_5;
	@FXML
	private TableView<Student> tableView;
	@FXML
	private TableColumn<Student, String> studentNum, studentName, studentClass, studentRnum;
	@FXML
	private TableColumn<Student, CheckBox> check;
	@FXML
	private TextField inSearch, inStudentRnum, inStudentName, inStudentNum, inStudentClass;

	public void renew() {
		list.removeAll(list);
		for (int i = 0; i < DataList.sList.size(); i++) {
			list.add(DataList.sList.get(i));
		}
	}

	public void popup(String txt) throws IOException {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		Parent p = FXMLLoader.load(getClass().getResource("popup.fxml"));
		Label txtTitle = (Label) p.lookup("#txt");
		txtTitle.setText(txt);
		Button buttok = (Button) p.lookup("#OK");
		buttok.setOnAction(ee -> dialog.close());
		Scene s = new Scene(p);
		dialog.setScene(s);
		dialog.setResizable(false);
		dialog.show();
	}

	ObservableList<Student> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		renew();
		studentNum.setCellValueFactory(new PropertyValueFactory<Student, String>("studentNum"));
		studentName.setCellValueFactory(new PropertyValueFactory<Student, String>("studentName"));
		studentClass.setCellValueFactory(new PropertyValueFactory<Student, String>("studentClass"));
		studentRnum.setCellValueFactory(new PropertyValueFactory<Student, String>("studentRnum"));
		check.setCellValueFactory(new PropertyValueFactory<Student, CheckBox>("check"));
		tableView.setItems(list);
	}

	public void Hmain_2_Fun1(ActionEvent event) throws IOException {
		if (inStudentNum.getText().equals("") || inStudentName.getText().equals("")
				|| inStudentClass.getText().equals("") || inStudentRnum.getText().equals("")) {
			popup("입력값을 확인해주세요.");
		} else if (inStudentNum.getText().substring(0, 1).equals("S") == false
				|| inStudentNum.getText().length() != 4) {
			popup("학생번호의 형식은 `S+3자리숫자` 입니다.");
		} else if (inStudentRnum.getText().length() != 14 || inStudentRnum.getText().substring(0, 6).length() != 6
				|| inStudentRnum.getText().substring(7, 14).length() != 7
				|| inStudentRnum.getText().substring(6, 7).equals("-") == false) {
			popup("주민번호의 형식은 `6자리숫자-7자리숫자` 입니다.");
		} else {
			CheckBox cb = new CheckBox();
			Student s = new Student(inStudentNum.getText(), inStudentName.getText(), inStudentClass.getText(),
					inStudentRnum.getText(), inStudentNum.getText(), inStudentRnum.getText().substring(7, 14), cb);
			DataList.sList.add(s);
			renew();
			popup("등록 완료.");
		}
	}

	public void Hmain_2_Fun2(ActionEvent event) throws IOException {
		if (inStudentNum.getText().equals("") || inStudentName.getText().equals("")
				|| inStudentClass.getText().equals("") || inStudentRnum.getText().equals("")) {
			popup("입력값을 확인해주세요.");
		} else if (inStudentNum.getText().substring(0, 1).equals("S") == false
				|| inStudentNum.getText().length() != 4) {
			popup("학생번호의 형식은 `S+3자리숫자` 입니다.");
		} else if (inStudentRnum.getText().length() != 14 || inStudentRnum.getText().substring(0, 6).length() != 6
				|| inStudentRnum.getText().substring(7, 14).length() != 7
				|| inStudentRnum.getText().substring(6, 7).equals("-") == false) {
			popup("주민번호의 형식은 `6자리숫자-7자리숫자` 입니다.");
		} else {
			for (int i = 0; i < tableView.getItems().size(); i++) {
				if (tableView.getItems().get(i).getCheck().isSelected()) {

					DataList.sList.get(i).setStudentNum(inStudentNum.getText());
					DataList.sList.get(i).setStudentName(inStudentName.getText());
					DataList.sList.get(i).setStudentClass(inStudentClass.getText());
					DataList.sList.get(i).setStudentRnum(inStudentRnum.getText());
					DataList.sList.get(i).setPassword(inStudentRnum.getText().substring(7, 14));
					renew();
					popup("수정 완료.");
				}
			}
		}
	}

	public void Hmain_2_Fun3(ActionEvent event) throws IOException {
		for (int i = 0; i < tableView.getItems().size(); i++) {
			if (tableView.getItems().get(i).getCheck().isSelected()) {
				tableView.getItems().remove(tableView.getItems().get(i));
				DataList.sList.remove(i);
				popup("삭제 완료.");
			}
		}
	}

	public void Hmain_2_Fun4(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Hmain_2_4.getScene().getRoot();
		root.getChildren().remove(Hmain_2);
	}

	public void Hmain_2_Fun5(ActionEvent event) throws IOException {
		if (inSearch.getText().equals("")) {
			renew();
		} else {
			list.removeAll(list);
			for (int i = 0; i < DataList.sList.size(); i++) {
				if (DataList.sList.get(i).getStudentNum().equals(inSearch.getText())) {
					list.add(DataList.sList.get(i));
				}
			}
		}
	}
}
