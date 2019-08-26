package esi.atl.g44422.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Represents the box with all the menus in the application.
 */
public class MenuBox extends MenuBar {

    private final Menu file;
    private final Menu edit;
    private final MenuItem history;
    private final Menu help;

    /**
     * Creates a new menu box.
     */
    MenuBox() {
        this.file = new Menu("File");

        this.edit = new Menu("Edit");
        this.history = new MenuItem("History");
        this.edit.getItems().addAll(this.history);

        this.help = new Menu("Help");

        this.getMenus().addAll(this.file, this.edit, this.help);
    }

    /**
     * Returns the file menu button.
     *
     * @return the file menu button
     */
    public Menu getFile() {
        return file;
    }

    /**
     * Returns the edit menu button.
     *
     * @return the edit menu button
     */
    public Menu getEdit() {
        return edit;
    }

    /**
     * Returns the history menu button.
     *
     * @return the history menu button
     */
    public MenuItem getHistory() {
        return history;
    }

    /**
     * Returns the help menu button.
     *
     * @return the help menu button
     */
    public Menu getHelp() {
        return help;
    }
}
