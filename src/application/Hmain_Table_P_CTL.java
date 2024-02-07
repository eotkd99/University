package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.Professor;
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

public class Hmain_Table_P_CTL implements Initializable { // fx:id값

	@FXML
	private StackPane Hmain_3;
	@FXML
	private Button Hmain_3_1, Hmain_3_2, Hmain_3_3, Hmain_3_4, Hmain_3_5;
	@FXML
	private TableView<Professor> tableView;
	@FXML
	private TableColumn<Professor, String> ProfessorNum, ProfessorName, ProfessorClass, ProfessorRnum;
	@FXML
	private TableColumn<Professor, CheckBox> check;
	@FXML
	private TextField inSearch, inProfessorRnum, inProfessorName, inProfessorNum, inProfessorClass;

	public void renew() {
		list.removeAll(list);
		for (int i = 0; i < DataList.pList.size(); i++) {
			list.add(DataList.pList.get(i));
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

	ObservableList<Professor> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		renew();
		ProfessorNum.setCellValueFactory(new PropertyValueFactory<Professor, String>("ProfessorNum"));
		ProfessorName.setCellValueFactory(new PropertyValueFactory<Professor, String>("ProfessorName"));
		ProfessorClass.setCellValueFactory(new PropertyValueFactory<Professor, String>("ProfessorClass"));
		ProfessorRnum.setCellValueFactory(new PropertyValueFactory<Professor, String>("ProfessorRnum"));
		check.setCellValueFactory(new PropertyValueFactory<Professor, CheckBox>("check"));
		tableView.setItems(list);
	}

	public void Hmain_3_Fun1(ActionEvent event) throws IOException {
		if (inProfessorNum.getText().equals("") || inProfessorName.getText().equals("")
				|| inProfessorClass.getText().equals("") || inProfessorRnum.getText().equals("")) {
			popup("입력값을 확인해주세요.");
		} else if (inProfessorNum.getText().substring(0, 1).equals("P") == false
				|| inProfessorNum.getText().length() != 4) {
			popup("교수번호의 형식은 `P+3자리숫자` 입니다.");
		} else if (inProfessorRnum.getText().length() !=14
				|| inProfessorRnum.getText().substring(0, 6).length() != 6
				|| inProfessorRnum.getText().substring(7, 14).length() != 7
				|| inProfessorRnum.getText().substring(6, 7).equals("-") == false) {
			popup("주민번호의 형식은 `6자리숫자-7자리숫자` 입니다.");
		} else {
			CheckBox cb = new CheckBox();
			Professor s = new Professor(inProfessorNum.getText(), inProfessorName.getText(), inProfessorClass.getText(),
					inProfessorRnum.getText(), inProfessorNum.getText(), inProfessorRnum.getText().substring(7, 14),
					cb);
			DataList.pList.add(s);
			renew();
			popup("등록 완료.");
		}
	}

	public void Hmain_3_Fun2(ActionEvent event) throws IOException {
		for (int i = 0; i < tableView.getItems().size(); i++) {
			if (inProfessorNum.getText().equals("") || inProfessorName.getText().equals("")
					|| inProfessorClass.getText().equals("") || inProfessorRnum.getText().equals("")) {
				popup("입력값을 확인해주세요.");
			} else if (inProfessorNum.getText().substring(0, 1).equals("P") == false
					|| inProfessorNum.getText().length() != 4) {
				popup("교수번호의 형식은 `P+3자리숫자` 입니다.");
			} else if (inProfessorRnum.getText().length() != 14
					|| inProfessorRnum.getText().substring(0, 6).length() != 6
					|| inProfessorRnum.getText().substring(7, 14).length() != 7
					|| inProfessorRnum.getText().substring(6, 7).equals("-") == false) {
				popup("주민번호의 형식은 `6자리숫자-7자리숫자` 입니다.");
			} else {
			if (tableView.getItems().get(i).getCheck().isSelected()) {
				DataList.pList.get(i).setProfessorNum(inProfessorNum.getText());
				DataList.pList.get(i).setProfessorName(inProfessorName.getText());
				DataList.pList.get(i).setProfessorClass(inProfessorClass.getText());
				DataList.pList.get(i).setProfessorRnum(inProfessorRnum.getText());
				DataList.pList.get(i).setPassword(inProfessorRnum.getText().substring(7, 14));
				renew();
				popup("수정 완료.");
			}
			}
		}
	}

	public void Hmain_3_Fun3(ActionEvent event) throws IOException {
		for (int i = 0; i < tableView.getItems().size(); i++) {
			if (tableView.getItems().get(i).getCheck().isSelected()) {
				tableView.getItems().remove(tableView.getItems().get(i));
				DataList.pList.remove(i);
				popup("삭제 완료.");
			}
		}
	}

	public void Hmain_3_Fun4(ActionEvent event) throws IOException {
		StackPane root = (StackPane) Hmain_3_4.getScene().getRoot();
		root.getChildren().remove(Hmain_3);
	}

	public void Hmain_3_Fun5(ActionEvent event) throws IOException {
		if (inSearch.getText().equals("")) {
			renew();
		} else {
			list.removeAll(list);
			for (int i = 0; i < DataList.pList.size(); i++) {
				if (DataList.pList.get(i).getProfessorNum().equals(inSearch.getText())) {
					list.add(DataList.pList.get(i));
				}
			}
		}
	}
}
