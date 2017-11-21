package Models;

import Controllers.FileTabPaneController;
import Controllers.MainPaneController;

/**
 * This class sets a global variable context for the main window and file tab pane
 * which can always be referenced while the application is running.
 * See MainPaneController or FileTabPaneController.
 */
public class Context {
    private final FileTabPaneController fileTabPaneController;
    private final MainPaneController mainPaneController;
    
    /**
     * Constructor for the class.
     * @param fileTabPaneController
     * @param mainPaneController 
     */
    public Context(FileTabPaneController fileTabPaneController, MainPaneController mainPaneController) {
        this.fileTabPaneController = fileTabPaneController;
        this.mainPaneController = mainPaneController;
    }
    
    /**
     * 
     * @return the FileTabPaneController.
     */
    public FileTabPaneController getFileTabPaneController() {
        return fileTabPaneController;
    }
    
    /**
     * 
     * @return the MainPaneController.
     */
    public MainPaneController getMainPaneController() {
        return mainPaneController;
    }
}
