package Main;

import Controllers.MainPaneController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * A simple tabbed text editor.
 * This is the application entry point. The application follow a MVC logic.
 * Initially, a scene is set up on MainPane.fxml. See MainPaneController.
 * @author jguitana
 */
public class SimpleTextEditor extends Application {
    private MainPaneController mainPaneController;
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/MainPane.fxml"));
        Parent root = fxmlLoader.load();
        mainPaneController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        
        String appName = "File Editor (c)Nelus.inc";
        stage.setOnCloseRequest(onCloseEvent());
        stage.setTitle(appName);
        stage.setScene(scene);
        stage.getIcons().add(new Image("/Styling/iconsmall.png"));
        stage.show();
    }
    
    // EVENT HANDLERS
    
    /**
     * 
     * @return an event handler used to override normal closing of the application
     * so that we can prompt save file tabs.
     */
    private EventHandler<WindowEvent> onCloseEvent() {
        return (WindowEvent event) -> {
            try {
                closeAllTabs();
            } catch (IOException ex) {
                Logger.getLogger(SimpleTextEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
            event.consume();
        };
    }
    
    /**
     * This helper method is called by onCloseEvent() event handler.
     * @throws IOException 
     */
    private void closeAllTabs() throws IOException {
        mainPaneController.getFileTabPaneController().closeTabsAndExit();
    }
    
    // MAIN
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
