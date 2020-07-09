package GUI.General;

/**
 * This class <b>GUIRunner</b> is the class used to instantiate the GUIInfo class
 * to run the project.
 * 
 */
public class GUIRunner {
    
    /**
     * Don't let anyone instantiate this class.
     */
    private GUIRunner() {}
    
    /**
     * This is the main method.
     * 
     * @throws ClassNotFoundException - if the GUIInfo class is not located.
     */
    public static void main(String[] args) throws ClassNotFoundException {
        new GUIInfo();
    }

}
