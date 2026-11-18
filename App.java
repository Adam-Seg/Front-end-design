import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionModel;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    ObservableList<String> names = FXCollections.observableArrayList();
    ListView<String> nameListView;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage aStage) throws Exception {
        names.add("Fred");
        names.add("Wilma");

        VBox root = new VBox();
        Scene aScene = new Scene(root);

        root.getChildren().add(buildMenuBar());
        root.getChildren().add(buildNameListView());
        root.getChildren().add(buildListButtons());

        aStage.setScene(aScene);

        aStage.setTitle("Hello fx");
        aStage.show();

    }

    private HBox buildListButtons() {
        HBox row = new HBox();
        Button addButton = new Button("Add");
        addButton.setOnAction((event) -> handleAddToList());
        row.getChildren().add(addButton);

        Button removeButton = new Button("Remove");
        addButton.setOnAction((event) -> handleRemoveToList());
        row.getChildren().add(removeButton);
        return row;
    }

    private void handleFileMenu() {
        System.out.println("File menu was clicked");
    }

    private void handleAddToList() {
        names.add("Ima Pseudonym");
    }

    private void handleRemoveToList() {
        SelectionModel<String> selectionModel = nameListView.getSelectionModel();
        int selectionIndex = selectionModel.getSelectedIndex();
        if (selectionIndex == -1)
            return;
        names.remove(selectionIndex);
    }

    private MenuBar buildMenuBar() {
        MenuBar aMenuBar = new MenuBar();
        Menu aFileMenu = new Menu("File");
        MenuItem aSaveItem = new MenuItem("Save");
        aFileMenu.getItems().add(aSaveItem);
        aSaveItem.setOnAction((event) -> handleFileMenu());
        aMenuBar.getMenus().add(aFileMenu);
        Menu anEditMenu = new Menu("Edit");
        aMenuBar.getMenus().add(anEditMenu);
        return aMenuBar;
    }

    private ListView<String> buildNameListView() {
        nameListView = new ListView<>(names);
        return nameListView;
    }
}
