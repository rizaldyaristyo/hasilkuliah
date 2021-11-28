package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Program Easy");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Scene sceneInit = new Scene(grid, 500 ,275);
        primaryStage.setScene(sceneInit);
        //bikin label & field
        Text welcomeTitle = new Text("Welcome");
        welcomeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Label labelUsername = new Label("Username:");
        TextField userField = new TextField("admin");
        Label labelPasswd = new Label("Password:");
        PasswordField passwdField = new PasswordField();
        Button signIn = new Button("Sign-In");
        signIn.setPrefSize(65,20);
        Button quid = new Button("Exit");
        quid.setPrefSize(65,20);
        quid.setOnAction(aa -> System.exit(0));
        //add to grid
        grid.add(welcomeTitle,0,0,2,1);
        grid.add(labelUsername,0,1);
        grid.add(userField,1,1);
        grid.add(labelPasswd,0,2);
        grid.add(passwdField,1,2);
        grid.add(signIn,1,4);
        grid.add(quid,1,5);
        signIn.setOnAction(e -> {
            if (userField.getText().equals("admin") && passwdField.getText().equals("admin")) {
                //bikin Grid & Scene Input
                GridPane gridInputan = new GridPane();
                gridInputan.setAlignment(Pos.CENTER);
                gridInputan.setPadding(new Insets(25, 25, 25, 25));
                gridInputan.setVgap(10);
                gridInputan.setHgap(10);
                Scene sceneInputan = new Scene(gridInputan, 500, 275);
                primaryStage.setScene(sceneInputan);
                // deklarasi label & textfield + button
                Label labelNim = new Label("NIM");
                Label labelNama = new Label("Nama");
                Label labelFakultas = new Label("Fakultas");
                Label labelJurusan = new Label("Jurusan");
                Label labelAlamat = new Label("Alamat");
                Label labelKota = new Label("Kota");
                Label labelHobby = new Label("Hobby");
                TextField nimTF = new TextField();
                TextField namaTF = new TextField();
                TextField fakultasTF = new TextField();
                TextField jurusanTF = new TextField();
                TextField alamatTF = new TextField();
                TextField kotaTF = new TextField();
                TextField hobbyTF = new TextField();
                Button createButton = new Button("Create");
                Button lihatData = new Button("Lihat Data");
                // add label
                gridInputan.add(labelNim,0,1);
                gridInputan.add(labelNama,0,2);
                gridInputan.add(labelJurusan,0,3);
                gridInputan.add(labelHobby,0,4);
                gridInputan.add(labelFakultas,0,5);
                gridInputan.add(labelAlamat,0,6);
                gridInputan.add(labelKota,0,7);
                // add textField
                gridInputan.add(nimTF,1,1);
                gridInputan.add(namaTF,1,2);
                gridInputan.add(jurusanTF,1,3);
                gridInputan.add(hobbyTF,1,4);
                gridInputan.add(fakultasTF,1,5);
                gridInputan.add(alamatTF,1,6);
                gridInputan.add(kotaTF,1,7);
                gridInputan.add(createButton, 2,1);
                gridInputan.add(lihatData,2,7);
                //action
                createButton.setOnAction(a -> {
                    try{
                        FileWriter menulis = new FileWriter("umm.txt",false);
                        menulis.write("===Data Diri===" +
                                "\nNIM: " + nimTF.getText() +
                                "\nNama: " + namaTF.getText() +
                                "\nFakultas: " + fakultasTF.getText() +
                                "\nJurusan: " + jurusanTF.getText() +
                                "\nAlamat: " + alamatTF.getText() +
                                "\nKota: " + kotaTF.getText() +
                                "\nHobby: " + hobbyTF.getText());
                        menulis.close();
                        Text statusNgesave = new Text();
                        gridInputan.add(statusNgesave,2,3);
                        statusNgesave.setText("Berhasil Memasukkan Data");
                    }catch(IOException ioException){
                        System.out.println("Save File Error!");
                    }
                });
                lihatData.setOnAction(c -> {
                    GridPane gridBaca = new GridPane();
                    gridBaca.setAlignment(Pos.CENTER);
                    gridBaca.setVgap(10);
                    gridBaca.setHgap(10);
                    gridBaca.setPadding(new Insets(25, 25, 25, 25));
                    Scene sceneBaca = new Scene(gridBaca, 500, 275);
                    primaryStage.setScene(sceneBaca);
                    try {
                        Scanner membaca = new Scanner(new File("umm.txt"));
                        TextArea kertasLihat = new TextArea();
                        while (membaca.hasNext())
                            kertasLihat.appendText(membaca.nextLine()+"\n");
                        kertasLihat.setEditable(false);
                        kertasLihat.setPrefSize(340,340);
                        gridBaca.add(kertasLihat,0,0);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    Button balikAwal = new Button("Balik");
                    gridBaca.add(balikAwal,1,1);
                    balikAwal.setOnAction(b -> primaryStage.setScene(sceneInputan));
                });
            } else {
                final Text actionTarget = new Text();
                grid.add(actionTarget,1,6);
                actionTarget.setFill(Color.RED);
                actionTarget.setText("Username dan/atau Password\ntidak ditemukan");
            }
        });
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}