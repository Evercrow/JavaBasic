package Lesson8.Ex006.Interface;

import Lesson8.Ex006.Document.TextDocument;

public interface Saveable {
    void SaveAs(TextDocument document, String path);
}
