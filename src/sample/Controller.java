package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import server.MyServer;
import server.Subscriber;

import java.awt.*;
import java.io.IOException;


public class Controller implements Subscriber {

    private String filePath;
    private StringBuilder console = new StringBuilder();

    @FXML
    private Label filename, errorstartserver;

    @FXML
    TextArea consoleoutput;


    public void uploadFile() throws IOException {
        String nameOfFile;

        FileDialog fileDialog = new FileDialog((Frame)null, "Select file with dataset");
        fileDialog.setMode(FileDialog.LOAD);
        fileDialog.setVisible(true);

        nameOfFile = fileDialog.getFile();
        filename.setText(nameOfFile);
        filePath = fileDialog.getDirectory() + fileDialog.getFile();

        runServer();

    }

    private void runServer() {
        try {
            MyServer server = new MyServer("localhost", 3000, this);
            server.startServer();
        } catch (IOException ex) {
            console.append(ex);
            consoleoutput.setText(console.toString());
        }

    }

    private void updateConsole(String msg) {
        console.append(msg + "\n");
        consoleoutput.setText(console.toString());
    }

    @Override
    public void notify(String msg) {
        updateConsole(msg);
    }
}
