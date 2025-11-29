package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Note;
import model.Notebook;

public class NoteController {

    @FXML private TextField titleField;
    @FXML private TextArea contentArea;
    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button deleteButton;
    @FXML private ListView<Note> notesListView;

    private final Notebook notebook = new Notebook();

    @FXML
    public void initialize() {
        notesListView.setItems(notebook.getNotes());

        notesListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldNote, selectedNote) -> loadNoteIntoFields(selectedNote)
        );
    }

    private void loadNoteIntoFields(Note note) {
        if (note != null) {
            titleField.setText(note.getTitle());
            contentArea.setText(note.getContent());
        }
    }

    @FXML
    private void addNote() {
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();

        if (title.isEmpty() || content.isEmpty()) {
            showAlert("Both title and content are required.");
            return;
        }

        Note note = new Note(title, content);
        notebook.addNote(note);

        titleField.clear();
        contentArea.clear();
    }

    @FXML
    private void editNote() {
        Note selected = notesListView.getSelectionModel().getSelectedItem();
        if (selected == null) return;


        selected.setTitle(titleField.getText().trim());
        selected.setContent(contentArea.getText().trim());

        notesListView.refresh();

        titleField.clear();
        contentArea.clear();
    }

    @FXML
    private void deleteNote() {
        Note selected = notesListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            notebook.removeNote(selected);
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.show();
    }
}
