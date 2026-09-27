module com.dbclient.dbclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dbclient to javafx.fxml;
    exports com.dbclient;
}