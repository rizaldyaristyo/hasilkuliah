package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        //Scene1
        primaryStage.setTitle("Program Anjayy....");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Scene sceneInit = new Scene(grid, 500 ,275);
        primaryStage.setScene(sceneInit);

        Text welcomeTitle = new Text("Velkommen");
        welcomeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(welcomeTitle,0,0,2,1);

        Label userName = new Label("Username:");
        grid.add(userName,0,1);
        TextField userTextField = new TextField("admin");
        grid.add(userTextField,1,1);

        Label pw = new Label("Password:");
        grid.add(pw,0,2);
        PasswordField pwField = new PasswordField();
        grid.add(pwField,1,2);

        //button and action
        Button signIn = new Button("Sign-In");
        signIn.setPrefSize(65,20);
        grid.add(signIn,1,4);
        final Text actionTarget = new Text();
        grid.add(actionTarget,1,6);
        Button quid = new Button("Exit");
        quid.setPrefSize(65,20);
        grid.add(quid,1,5);
        quid.setOnAction(aa -> System.exit(0));

        signIn.setOnAction(e -> {
            if (userTextField.getText().equals("admin")&&pwField.getText().equals("admin")){
                //sceneMenu
                GridPane gridMenu = new GridPane();
                gridMenu.setAlignment(Pos.CENTER);
                gridMenu.setHgap(10);
                gridMenu.setVgap(10);
                gridMenu.setPadding(new Insets(25,25,25,2));
                Scene sceneMenu = new Scene(gridMenu, 600 ,220);
                primaryStage.setScene(sceneMenu);

                Text menuTitle = new Text("Menu program ini apalah gatau");
                menuTitle.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.ITALIC,30));
                gridMenu.add(menuTitle,1,2,2,1);

                //logOut&exit
                Button logOut = new Button("Log-Out");
                logOut.setPrefSize(75,75);
                gridMenu.add(logOut,6,0);
                logOut.setOnAction(aa -> {
                    pwField.clear();
                    userTextField.clear();
                    primaryStage.setScene(sceneInit);
                });
                Button keloar = new Button("Exit");
                keloar.setPrefSize(75,75);
                gridMenu.add(keloar,6,1);
                keloar.setOnAction(aa -> System.exit(0));


                //tambahJadwal
                Button ow = new Button("Tambah Jadwal");
                gridMenu.add(ow,1,4);
                ow.setOnAction(f -> {
                    //SceneTambah
                    GridPane gridTambah = new GridPane();
                    gridTambah.setAlignment(Pos.CENTER);
                    gridTambah.setHgap(10);
                    gridTambah.setVgap(10);
                    gridTambah.setPadding(new Insets(25,25,25,25));
                    Scene sceneTambah = new Scene(gridTambah, 350 ,275);
                    primaryStage.setScene(sceneTambah);

                    Label matKul = new Label("MatKul:");
                    gridTambah.add(matKul,0,1);
                    TextField mkField = new TextField();
                    gridTambah.add(mkField,1,1);

                    Label waktu = new Label("Waktu:");
                    gridTambah.add(waktu,0,2);

                    ComboBox<String> waktuField = new ComboBox<>();
                    waktuField.getItems().addAll("JAM PERTAMA","JAM KEDUA","JAM KETIGA","JAM KEEMPAT","JAM KELIMA","JAM KEENAM","JAM KETUJUH");
                    gridTambah.add(waktuField,1,2);

                    Label GKB = new Label("GKB:");
                    gridTambah.add(GKB,0,3);
                    TextField GKBField = new TextField();
                    gridTambah.add(GKBField,1,3);

                    Label Ruangan = new Label("Ruangan:");
                    gridTambah.add(Ruangan,0,4);
                    TextField RgField = new TextField();
                    gridTambah.add(RgField,1,4);

                    Label namaDosen = new Label("Nama Dosen:");
                    gridTambah.add(namaDosen,0,5);
                    TextField nDosField = new TextField();
                    gridTambah.add(nDosField,1,5);

                    Button save = new Button("Save");
                    //gridTambah.add(save,1,6);
                    Button goBack = new Button("go Back");
                    //gridTambah.add(goBack,2,6);
                    HBox HBsave = new HBox(10);
                    HBsave.setAlignment(Pos.BOTTOM_RIGHT);
                    HBsave.getChildren().addAll(save,goBack);
                    gridTambah.add(HBsave,1,6);
                    save.setOnAction(g -> {
                        final Text saveStat = new Text();
                        gridTambah.add(saveStat,1,7);
                        try{
                            FileWriter tulisOut = new FileWriter("jadwal.txt", true);
                            tulisOut.write("\n==================\nMatkul  : " + mkField.getText() + "\n" + "Waktu: " + waktuField.getValue() + "\n" + "GKB : " + GKBField.getText() + "\n" + "Ruangan : " + RgField.getText() + "\n" + "Nama Dosen : " + nDosField.getText() + "\n");
                            tulisOut.close();
                            mkField.clear();
                            GKBField.clear();
                            RgField.clear();
                            nDosField.clear();
                            saveStat.setFill(Color.RED);
                            saveStat.setText("Save Successful!");
                        }catch(IOException h){
                            System.out.println("IO Error!");
                            saveStat.setFill(Color.RED);
                            saveStat.setText("ERROR: Save Failed!");
                            mkField.clear();
                            GKBField.clear();
                            RgField.clear();
                            nDosField.clear();
                        }
                    });
                    goBack.setOnAction(i -> primaryStage.setScene(sceneMenu));
                });

                //editJadwal
                Button edit = new Button("Edit Jadwal");
                gridMenu.add(edit,2,4);
                edit.setOnAction(j -> {
                    try {
                        Scanner tulisMasuk = new Scanner(new File("jadwal.txt"));
                        final Text fileStat = new Text();
                        if(tulisMasuk.hasNextLine()){
                            GridPane gridEdit = new GridPane();
                            gridEdit.setAlignment(Pos.CENTER);
                            gridEdit.setHgap(10);
                            gridEdit.setVgap(10);
                            gridEdit.setPadding(new Insets(25,25,25,25));
                            Scene sceneEdit = new Scene(gridEdit, 640 ,700);
                            primaryStage.setScene(sceneEdit);

                            Label editorTitle = new Label("===Editor Jadwal===");
                            gridEdit.add(editorTitle,0,0);
                            TextArea editorJadwal = new TextArea();
                            while (tulisMasuk.hasNext()) editorJadwal.appendText(tulisMasuk.nextLine()+"\n");
                            editorJadwal.setPrefSize(630,690);
                            gridEdit.add(editorJadwal,0,1);
                            Button update = new Button("Update");
                            Button goBack = new Button("go Back");
                            gridEdit.add(update,0,2);
                            gridEdit.add(goBack, 0,3);
                            update.setOnAction(k -> {
                                final Text saveStat = new Text();
                                gridEdit.add(saveStat,0,4);
                                try {
                                    FileWriter tulisOut = new FileWriter("jadwal.txt", false);
                                    tulisOut.write(editorJadwal.getText());
                                    tulisOut.close();
                                    saveStat.setFill(Color.RED);
                                    saveStat.setText("Updated Successfuly!");
                                } catch (IOException ioException) {
                                    System.out.println("IO Error!");
                                    saveStat.setFill(Color.RED);
                                    saveStat.setText("ERROR: Save Failed!");
                                }
                            });
                            goBack.setOnAction(l -> primaryStage.setScene(sceneMenu));
                        }else{
                            GridPane gridElse = new GridPane();
                            gridElse.setHgap(10);
                            gridElse.setVgap(10);
                            gridElse.setPadding(new Insets(25,25,25,25));
                            Scene sceneElse = new Scene(gridElse, 1280 ,720);
                            primaryStage.setScene(sceneElse);
                            System.out.println("---File Empty!---");
                            fileStat.setFill(Color.RED);
                            fileStat.setText("File Empty!");
                            Button goBack = new Button("go Back");
                            gridElse.add(goBack, 2,4);
                            goBack.setOnAction(m -> primaryStage.setScene(sceneMenu));
                        }
                    } catch (FileNotFoundException n) {
                        final Text fileStat = new Text();
                        gridMenu.add(fileStat,1,5);
                        System.out.println("File not Found!");
                        fileStat.setFill(Color.RED);
                        fileStat.setText("File not Found!");
                    }
                });

                //lihatJadwal
                Button lihat = new Button("Lihat Jadwal");
                gridMenu.add(lihat,3,4);
                lihat.setOnAction(o -> {
                    try {
                        Scanner tulisMasuk = new Scanner(new File("jadwal.txt"));
                        final Text fileStat = new Text();
                        if(tulisMasuk.hasNextLine()){
                            GridPane gridShow = new GridPane();
                            gridShow.setAlignment(Pos.CENTER);
                            gridShow.setVgap(10);
                            gridShow.setHgap(10);
                            gridShow.setPadding(new Insets(25,25,25,25));
                            Scene sceneEdit = new Scene(gridShow, 640 ,700);
                            primaryStage.setScene(sceneEdit);

                            Label editorTitle = new Label("===Jadwal===");
                            gridShow.add(editorTitle,0,0);
                            TextArea showerJadwal = new TextArea();
                            while (tulisMasuk.hasNext()) showerJadwal.appendText(tulisMasuk.nextLine()+"\n");
                            showerJadwal.setEditable(false);
                            //showerJadwal.setStyle("-fx-opacity: 1;");
                            showerJadwal.setPrefSize(630,690);
                            gridShow.add(showerJadwal,0,1);
                            Button goBack = new Button("go Back");
                            gridShow.add(goBack, 0,3);
                            goBack.setOnAction(l -> primaryStage.setScene(sceneMenu));
                        }else{
                            GridPane gridElseS = new GridPane();
                            gridElseS.setVgap(10);
                            gridElseS.setHgap(10);
                            gridElseS.setPadding(new Insets(25,25,25,25));
                            Scene sceneElse = new Scene(gridElseS, 1280 ,720);
                            primaryStage.setScene(sceneElse);
                            Button goBack = new Button("go Back");
                            gridElseS.add(goBack, 2,4);
                            System.out.println("---File Empty!---");
                            fileStat.setFill(Color.RED);
                            fileStat.setText("File Empty!");
                            goBack.setOnAction(m -> primaryStage.setScene(sceneMenu));
                        }
                    } catch (FileNotFoundException n) {
                        final Text fileStat = new Text();
                        gridMenu.add(fileStat,1,5);
                        System.out.println("File not Found!");
                        fileStat.setFill(Color.RED);
                        fileStat.setText("File not Found!");
                    }
                });

                //hapusJadwal
                Button Hapus = new Button("Hapus Jadwal");
                gridMenu.add(Hapus,4,4);
                Hapus.setOnAction(p -> {
                    GridPane gridHapus = new GridPane();
                    gridHapus.setAlignment(Pos.CENTER);
                    gridHapus.setPadding(new Insets(25,25,25,25));
                    gridHapus.setHgap(10);
                    gridHapus.setVgap(10);
                    Scene sceneHapus = new Scene(gridHapus, 540 ,300);
                    primaryStage.setScene(sceneHapus);

                    Label delTitle = new Label("ANDA AKAN MENGAHPUS JADWAL KULIAH YANG TELAH DISIMPAN\nSETELAH DIHAPUS, DATA TIDAK DAPAT DIKEMBALIKAN\nLANJUTKAN?");
                    gridHapus.setAlignment(Pos.CENTER);
                    gridHapus.add(delTitle,0,0);
                    Button beneran = new Button(("Ya, Saya Yakin\nHapus Jadwal Sekarang!"));
                    Button goBack = new Button("go Back");
                    gridHapus.add(beneran,0,1);
                    gridHapus.add(goBack,0,2);
                    beneran.setMinSize(180,40);
                    goBack.setMinSize(180,40);
                    beneran.setOnAction(q -> {
                        File injak = new File("jadwal.txt");
                        System.out.println("Delete File: " + injak.delete());
                        final Text delStat = new Text();
                        gridHapus.add(delStat,0,3);
                        System.out.println("File Deleted");
                        delStat.setFill(Color.RED);
                        delStat.setText("File Deleted Successfuly!");
                    });
                    goBack.setOnAction(r -> primaryStage.setScene(sceneMenu));
                });
                System.out.println();
            }else{
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