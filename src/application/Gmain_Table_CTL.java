package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.Lecture;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Gmain_Table_CTL implements Initializable { // fx:id값
	@FXML
	private StackPane Gmain_2;
	@FXML
	private Button Gmain_2_1, Gmain_2_2, Gmain_2_3, Gmain_2_4, Gmain_2_5, Gmain_2_6;
	@FXML
	private TableView<Lecture> tableView;
	@FXML
	private TableColumn<Lecture, String> LectureNum, LectureName, LectureDepartment, LectureSNum, LectureDes,
			LectureOPEN, LectureProfessor, LectureMIN, LectureMAX;
	@FXML
	private TableColumn<Lecture, CheckBox> check;
	@FXML
	private TextField inLectureNum, inLectureName, inLectureDepartment, inLectureSnum, inLectureDes, inSearch,
			 inLectureMIN, inLectureMAX;
	@FXML
    public ComboBox<String> combobox;

	public void renew() { // 테이블 갱신
		list.removeAll(list);
		for (int i = 0; i < DataList.lList.size(); i++) {
			list.add(DataList.lList.get(i));
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

	ObservableList<Lecture> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // 테이블 값 매칭
		renew();
		LectureNum.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureNum"));
		LectureName.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureName"));
		LectureDepartment.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureDepartment"));
		LectureSNum.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureSnum"));
		LectureDes.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureDes"));
		LectureProfessor.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureProfessor"));
		LectureOPEN.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureOPEN"));
		LectureMIN.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureMIN"));
		LectureMAX.setCellValueFactory(new PropertyValueFactory<Lecture, String>("LectureMAX"));
		check.setCellValueFactory(new PropertyValueFactory<Lecture, CheckBox>("check"));
		tableView.setItems(list);

		for(int i =0 ; i< DataList.pList.size(); i++)
		{
			combobox.getItems().add(DataList.pList.get(i).getProfessorName());
		}
	}

	public void Gmain_2_Fun1(ActionEvent event) throws IOException { // 강의리스트 추가

		if (inLectureDepartment.getText().equals("") || inLectureNum.getText().equals("")
				|| inLectureName.getText().equals("") || inLectureSnum.getText().equals("")) {
			popup("입력값을 확인해주세요.");
		} else {
			CheckBox cb = new CheckBox();
			Lecture s = new Lecture(inLectureNum.getText(), inLectureName.getText(), inLectureDepartment.getText(),
					inLectureSnum.getText(), inLectureDes.getText(), "", "", "", "", "", "", cb);
			DataList.lList.add(s);
			renew();
			popup("강의 등록 완료.");
		}
	}

	public void Gmain_2_Fun2(ActionEvent event) throws IOException { // 강의리스트 수정

		for (int i = 0; i < tableView.getItems().size(); i++) {
			if (tableView.getItems().get(i).getCheck().isSelected()) {
				if (tableView.getItems().get(i).getLectureOPEN() == "O") {
					System.out.println(tableView.getItems().get(i).getLectureOPEN());
					popup("개설된 강좌는 수정이 불가합니다.");
				} else if (inLectureDepartment.getText().equals("") || inLectureName.getText().equals("")
						|| inLectureSnum.getText().equals("")) {
					popup("입력값을 확인해주세요.");
				} else if (inLectureNum.getText() != "") {
					popup("강좌번호는 수정이 불가합니다.");
				} else {
					DataList.lList.get(i).setLectureName(inLectureName.getText());
					DataList.lList.get(i).setLectureDepartment(inLectureDepartment.getText());
					DataList.lList.get(i).setLectureSnum(inLectureSnum.getText());
					DataList.lList.get(i).setLectureDes(inLectureDes.getText());
					renew();
					popup("강의 수정 완료.");
				}
			}
		}
	}

	public void Gmain_2_Fun3(ActionEvent event) throws IOException { // 강의리스트 삭제
		for (int i = 0; i < tableView.getItems().size(); i++) {
			if (tableView.getItems().get(i).getCheck().isSelected()) {
				if (tableView.getItems().get(i).getLectureOPEN() == "O") {
					popup("개설된 강좌는 삭제가 불가합니다.");
				} else {
					DataList.lList.get(i).setLectureName("");
					DataList.lList.get(i).setLectureDepartment("");
					DataList.lList.get(i).setLectureSnum("");
					DataList.lList.get(i).setLectureDes("");
					renew();
					popup("강의 삭제 완료.");
				}
			}
		}
	}

	public void Gmain_2_Fun4(ActionEvent event) throws IOException { // StackPane 반환
		StackPane root = (StackPane) Gmain_2_4.getScene().getRoot();
		root.getChildren().remove(Gmain_2);
	}

	public void Gmain_2_Fun5(ActionEvent event) throws IOException { // 강의리스트 검색
		if (inSearch.getText().equals("")) {
			renew();
		} else {
			list.removeAll(list);
			for (int i = 0; i < DataList.lList.size(); i++) {
				if (DataList.lList.get(i).getLectureNum().equals(inSearch.getText())) {
					list.add(DataList.lList.get(i));
				}
			}
		}
	}

	public void Gmain_2_Fun6(ActionEvent event) throws IOException { // 개설
		try {
			Integer.parseInt(inLectureMAX.getText());
			Integer.parseInt(inLectureMIN.getText());
		} catch (Exception e) {
			popup("최대/최소의 입력값을 확인해주세요.");
		}
		
		for (int i = 0; i < tableView.getItems().size(); i++) {
			if (tableView.getItems().get(i).getCheck().isSelected()) {
				
				if(inLectureMAX.getText().equals("") || inLectureMIN.getText().equals("")|| combobox.getValue().equals("")) {
					popup("입력값을 확인해주세요.");
				}
				else if( Integer.parseInt(inLectureMAX.getText()) <= Integer.parseInt(inLectureMIN.getText()) ) {
					popup("최소수강인원은 최대수강인원보다 작아야 합니다.");
				}
				else if(tableView.getItems().get(i).getLectureOPEN() == "O"){
                                    popup("개설된 강의는 수정이 불가능합니다.");
				}else{
				DataList.lList.get(i).setLectureOPEN("O");
				DataList.lList.get(i).setLectureMAX(inLectureMAX.getText());
				DataList.lList.get(i).setLectureMIN(inLectureMIN.getText());
				DataList.lList.get(i).setLectureProfessor(combobox.getValue());

				for (int k = 0; k < DataList.pList.size(); k++) {
					if (DataList.pList.get(k).getProfessorName().equals(combobox.getValue())) {
						CheckBox cb = new CheckBox();
						DataList.pList.get(k).setMylList(new Lecture(DataList.lList.get(i).getLectureNum(),
								DataList.lList.get(i).getLectureName(), DataList.lList.get(i).getLectureDepartment(),
								DataList.lList.get(i).getLectureSnum(), DataList.lList.get(i).getLectureDes(),
								DataList.lList.get(i).getLectureProfessor(), DataList.lList.get(i).getLectureScore(),
								DataList.lList.get(i).getLectureMIN(), DataList.lList.get(i).getLectureMAX(),
								DataList.lList.get(i).getLectureOPEN(), DataList.lList.get(i).getLecturePersonNum(),
								cb));
						popup("강의 개설 완료.");
					}
				}
			}
		}
		}
		renew();
	}
}
