module com.antreanfx.antreanfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.antreanfx.antreanfx to javafx.fxml;
    exports com.antreanfx.antreanfx;
}