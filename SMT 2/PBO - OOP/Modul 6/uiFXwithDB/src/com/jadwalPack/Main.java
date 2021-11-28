package com.jadwalPack;

import com.dbPack.dbConn;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {

    TableView<TabelJadwal> tabell;

    public ObservableList<TabelJadwal> getJadwal() {
        String sql = "SELECT id, matKul, waktu, GKB, ruangan, dosen FROM jadwalTable";
        ObservableList<TabelJadwal> tabelJadwals = FXCollections.observableArrayList();
        try (Connection conn = dbConn.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tabelJadwals.add(new TabelJadwal(rs.getInt("id"), rs.getString("matKul"), rs.getString("waktu"), rs.getString("GKB"), rs.getString("ruangan"), rs.getString("dosen")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tabelJadwals;
    }

    public TableView<TabelJadwal> getTabel() {
        TableColumn<TabelJadwal, Integer> idCol = new TableColumn<>("Id");
        idCol.setMinWidth(20);
        idCol.setCellValueFactory(new PropertyValueFactory<>("idTab"));
        TableColumn<TabelJadwal, String> mkCol = new TableColumn<>("Matkul");
        mkCol.setMinWidth(20);
        mkCol.setCellValueFactory(new PropertyValueFactory<>("matKulTab"));
        TableColumn<TabelJadwal, String> waktuCol = new TableColumn<>("Waktu");
        waktuCol.setMinWidth(20);
        waktuCol.setCellValueFactory(new PropertyValueFactory<>("waktuTab"));
        TableColumn<TabelJadwal, String> gkbCol = new TableColumn<>("GKB");
        gkbCol.setMinWidth(20);
        gkbCol.setCellValueFactory(new PropertyValueFactory<>("GKBTab"));
        TableColumn<TabelJadwal, String> rgCol = new TableColumn<>("Ruangan");
        rgCol.setMinWidth(20);
        rgCol.setCellValueFactory(new PropertyValueFactory<>("ruanganTab"));
        TableColumn<TabelJadwal, String> dosenCol = new TableColumn<>("Dosen");
        dosenCol.setMinWidth(20);
        dosenCol.setCellValueFactory(new PropertyValueFactory<>("dosenTab"));
        tabell = new TableView<>();
        tabell.setItems(getJadwal());
        tabell.getColumns().add(idCol);
        tabell.getColumns().add(mkCol);
        tabell.getColumns().add(waktuCol);
        tabell.getColumns().add(gkbCol);
        tabell.getColumns().add(rgCol);
        tabell.getColumns().add(dosenCol);
        return tabell;
    }

    @Override
    public void start(Stage primaryStage) {
        //dbConnection
        dbConn.connect();
        System.out.println("Connection to SQLite database has been established.");

        //Scene1
        primaryStage.setTitle("Program Anjayy....");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene sceneInit = new Scene(grid, 500, 275);
        primaryStage.setScene(sceneInit);

        Text scenetitle = new Text("Velkommen");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Username:");
        Label pw = new Label("Password:");
        TextField userTextField = new TextField("admin");
        PasswordField pwField = new PasswordField();
        grid.add(userName, 0, 1);
        grid.add(userTextField, 1, 1);
        grid.add(pw, 0, 2);
        grid.add(pwField, 1, 2);

        //button
        Button signIn = new Button("Sign-In");
        Button quid = new Button("Exit");
        signIn.setPrefSize(65, 20);
        quid.setPrefSize(65, 20);
        grid.add(signIn, 1, 4);
        grid.add(quid, 1, 5);

        //acts
        quid.setOnAction(aa -> System.exit(0));
        signIn.setOnAction(e -> {
            if (userTextField.getText().equals("admin") && pwField.getText().equals("admin")) {
                //sceneMenu
                GridPane gridMenu = new GridPane();
                gridMenu.setAlignment(Pos.CENTER);
                gridMenu.setHgap(10);
                gridMenu.setVgap(10);
                gridMenu.setPadding(new Insets(25, 25, 25, 2));
                Scene sceneMenu = new Scene(gridMenu, 600, 220);
                primaryStage.setScene(sceneMenu);

                final Text backStat = new Text();
                gridMenu.add(backStat, 1, 6);

                Text menuTitle = new Text("Menu program ini...\nanu... Jadwal");
                menuTitle.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.ITALIC, 30));
                gridMenu.add(menuTitle, 1, 0, 4, 2);

                //menuButtons
                Button logOut = new Button("Log-Out");
                logOut.setPrefSize(120, 75);
                gridMenu.add(logOut, 4, 0);
                Button ow = new Button("Tambah Jadwal");
                gridMenu.add(ow, 1, 4);
                Button edit = new Button("Edit Jadwal");
                gridMenu.add(edit, 2, 4);
                Button lihat = new Button("Lihat Jadwal");
                gridMenu.add(lihat, 3, 4);
                Button Hapus = new Button("Hapus Jadwal");
                Hapus.setPrefSize(120, 45);
                gridMenu.add(Hapus, 4, 4);

                //logOut&exit
                logOut.setOnAction(aa -> {
                    pwField.clear();
                    userTextField.clear();
                    primaryStage.setScene(sceneInit);
                });
                Button keloar = new Button("Exit");
                keloar.setPrefSize(120, 75);
                gridMenu.add(keloar, 4, 1);
                keloar.setOnAction(aa -> System.exit(0));

                //tambahJadwal
                ow.setOnAction(f -> {
                    //SceneTambah
                    GridPane gridTambah = new GridPane();
                    gridTambah.setAlignment(Pos.CENTER);
                    gridTambah.setHgap(10);
                    gridTambah.setVgap(10);
                    gridTambah.setPadding(new Insets(25, 25, 25, 25));
                    Scene sceneTambah = new Scene(gridTambah, 350, 275);
                    primaryStage.setScene(sceneTambah);

                    Label matKul = new Label("MatKul:");
                    gridTambah.add(matKul, 0, 1);
                    TextField mkField = new TextField();
                    gridTambah.add(mkField, 1, 1);

                    Label waktu = new Label("Waktu:");
                    gridTambah.add(waktu, 0, 2);
                    ComboBox<String> waktuField = new ComboBox<>();
                    waktuField.getItems().addAll("JAM PERTAMA", "JAM KEDUA", "JAM KETIGA", "JAM KEEMPAT", "JAM KELIMA", "JAM KEENAM", "JAM KETUJUH");
                    gridTambah.add(waktuField, 1, 2);

                    Label GKB = new Label("GKB:");
                    gridTambah.add(GKB, 0, 3);
                    TextField GKBField = new TextField();
                    gridTambah.add(GKBField, 1, 3);

                    Label Ruangan = new Label("Ruangan:");
                    gridTambah.add(Ruangan, 0, 4);
                    TextField RgField = new TextField();
                    gridTambah.add(RgField, 1, 4);

                    Label namaDosen = new Label("Nama Dosen:");
                    gridTambah.add(namaDosen, 0, 5);
                    TextField nDosField = new TextField();
                    gridTambah.add(nDosField, 1, 5);

                    Button save = new Button("Save");
                    Button goBack = new Button("go Back");
                    HBox HBsave = new HBox(10);
                    HBsave.setAlignment(Pos.BOTTOM_RIGHT);
                    HBsave.getChildren().addAll(save, goBack);
                    gridTambah.add(HBsave, 1, 6);
                    save.setOnAction(g -> {
                        final Text saveStat = new Text();
                        gridTambah.add(saveStat, 1, 7);

                        String sql = "INSERT INTO jadwalTable(matKul,waktu,GKB,ruangan,dosen) VALUES(?,?,?,?,?)";
                        try (Connection conn = dbConn.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
                            pstmt.setString(5, (nDosField.getText()));
                            pstmt.setString(4, (RgField.getText()));
                            pstmt.setString(3, (GKBField.getText()));
                            pstmt.setString(2, (waktuField.getValue()));
                            pstmt.setString(1, (mkField.getText()));
                            pstmt.executeUpdate();
                        } catch (SQLException sqlException) {
                            sqlException.printStackTrace();
                        }
                        mkField.clear();
                        GKBField.clear();
                        RgField.clear();
                        nDosField.clear();
                        saveStat.setFill(Color.RED);
                        saveStat.setText("Save Successful!");
                    });
                    goBack.setOnAction(i -> primaryStage.setScene(sceneMenu));
                });

                //editJadwal
                edit.setOnAction(j -> {
                    GridPane gridEdit = new GridPane();
                    gridEdit.setAlignment(Pos.CENTER);
                    gridEdit.setHgap(10);
                    gridEdit.setVgap(10);
                    gridEdit.setPadding(new Insets(25, 25, 25, 25));
                    Scene sceneEdit = new Scene(gridEdit, 700, 700);
                    primaryStage.setScene(sceneEdit);
                    Button update = new Button("Update");
                    Button goBack = new Button("go Back");
                    gridEdit.add(update, 0, 2);
                    gridEdit.add(goBack, 0, 3);
                    goBack.setOnAction(l -> primaryStage.setScene(sceneMenu));

                    TableView<TabelJadwal> populatedTabel = getTabel();
                    VBox vBox = new VBox(0);
                    vBox.getChildren().add(populatedTabel);
                    gridEdit.add(vBox, 0, 0, 4, 1);

                    Label id = new Label("ID Yang ingin diubah:");
                    gridEdit.add(id, 1, 1);
                    Label matKul = new Label("MatKul:");
                    gridEdit.add(matKul, 2, 1);
                    Label waktu = new Label("Waktu:");
                    gridEdit.add(waktu, 3, 1);
                    Label GKB = new Label("GKB:");
                    gridEdit.add(GKB, 1, 3);
                    Label Ruangan = new Label("Ruangan:");
                    gridEdit.add(Ruangan, 2, 3);
                    Label namaDosen = new Label("Nama Dosen:");
                    gridEdit.add(namaDosen, 3, 3);

                    TextField idField = new TextField();
                    gridEdit.add(idField, 1, 2);
                    TextField mkField = new TextField();
                    gridEdit.add(mkField, 2, 2);
                    ComboBox<String> waktuField = new ComboBox<>();
                    waktuField.getItems().addAll("JAM PERTAMA", "JAM KEDUA", "JAM KETIGA", "JAM KEEMPAT", "JAM KELIMA", "JAM KEENAM", "JAM KETUJUH");
                    gridEdit.add(waktuField, 3, 2);
                    TextField GKBField = new TextField();
                    gridEdit.add(GKBField, 1, 4);
                    TextField RgField = new TextField();
                    gridEdit.add(RgField, 2, 4);
                    TextField nDosField = new TextField();
                    gridEdit.add(nDosField, 3, 4);

                    update.setOnAction(k -> {
                        String sql = "UPDATE jadwalTable SET matKul = ?, waktu = ?, GKB = ?, ruangan = ?, dosen = ? WHERE id = ?";
                        try (Connection conn = dbConn.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
                            pstmt.setString(1, (mkField.getText()));
                            pstmt.setString(2, (waktuField.getValue()));
                            pstmt.setString(3, (GKBField.getText()));
                            pstmt.setString(4, (RgField.getText()));
                            pstmt.setString(5, (nDosField.getText()));
                            pstmt.setInt(6, Integer.parseInt((idField.getText())));
                            pstmt.executeUpdate();
                            primaryStage.setScene(sceneMenu);
                        } catch (SQLException sqlException) {
                            sqlException.printStackTrace();
                        }
                        backStat.setFill(Color.RED);
                        backStat.setText("Database Updated!");
                    });
                });

                //lihatJadwal
                lihat.setOnAction(o -> {
                    GridPane gridShow = new GridPane();
                    gridShow.setAlignment(Pos.CENTER);
                    gridShow.setVgap(10);
                    gridShow.setHgap(10);
                    gridShow.setPadding(new Insets(25, 25, 25, 25));
                    Scene sceneEdit = new Scene(gridShow, 640, 700);
                    primaryStage.setScene(sceneEdit);

                    Label showerTitle = new Label("===Jadwal===");
                    gridShow.add(showerTitle, 0, 0);
                    TableView<TabelJadwal> populatedTabel = getTabel();
                    gridShow.add(populatedTabel, 0, 1);

                    Button goBack = new Button("go Back");
                    gridShow.add(goBack, 0, 3);
                    goBack.setOnAction(l -> primaryStage.setScene(sceneMenu));
                });

                //hapusJadwal
                Hapus.setOnAction(p -> {
                    GridPane gridHapus = new GridPane();
                    gridHapus.setAlignment(Pos.CENTER);
                    gridHapus.setPadding(new Insets(25, 25, 25, 25));
                    gridHapus.setHgap(10);
                    gridHapus.setVgap(10);
                    Scene sceneHapus = new Scene(gridHapus, 540, 300);
                    primaryStage.setScene(sceneHapus);

                    Label delTitle = new Label("ANDA AKAN MENGAHPUS JADWAL KULIAH YANG TELAH DISIMPAN\nSETELAH DIHAPUS, DATA TIDAK DAPAT DIKEMBALIKAN\nLANJUTKAN?");
                    gridHapus.setAlignment(Pos.CENTER);
                    gridHapus.add(delTitle, 0, 0);

                    TableView<TabelJadwal> populatedTabel = getTabel();
                    VBox vBox = new VBox(0);
                    vBox.getChildren().add(populatedTabel);
                    gridHapus.add(vBox, 0, 1, 2, 1);

                    Label id = new Label("ID Tabel:");
                    TextField idField = new TextField();
                    gridHapus.add(id, 1, 2);
                    gridHapus.add(idField, 1, 3);

                    Button beneran = new Button(("Ya, Saya Yakin\nHapus Jadwal Sekarang!"));
                    Button goBack = new Button("go Back");
                    gridHapus.add(beneran, 0, 2);
                    gridHapus.add(goBack, 0, 3);
                    beneran.setMinSize(180, 40);
                    goBack.setMinSize(180, 40);
                    beneran.setOnAction(q -> {
                        String sql = "DELETE FROM jadwalTable WHERE id = ?";
                        try (Connection conn = dbConn.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
                            pstmt.setInt(1, Integer.parseInt(idField.getText()));
                            pstmt.executeUpdate();
                        } catch (SQLException sqlException) {
                            sqlException.printStackTrace();
                        }
                        backStat.setFill(Color.RED);
                        backStat.setText("Deleted Successfuly!");
                        primaryStage.setScene(sceneMenu);
                    });
                    goBack.setOnAction(r -> primaryStage.setScene(sceneMenu));
                });
                System.out.println();
            } else {
                //failNotifs
                final Text loginFailed = new Text();
                grid.add(loginFailed, 1, 6);
                loginFailed.setFill(Color.RED);
                loginFailed.setText("User:Pass nya admin:admin ngab\nlu lupa ya?");
            }
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}