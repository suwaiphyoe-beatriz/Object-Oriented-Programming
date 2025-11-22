package controller;

import model.Dictionary;

public class DictionaryController {
    private Dictionary dictionary = new Dictionary();

    public DictionaryController() {
        dictionary.addWord("apple", "A sweet red or green fruit.");
        dictionary.addWord("Orange", "My fav fruit xD");
        dictionary.addWord("java", "A high-level object-oriented programming language.");
        dictionary.addWord("cat", "A small domesticated carnivorous mammal.");
        dictionary.addWord("Star", "A luminous point in the night sky that is a large satellite body.");
        dictionary.addWord("Mohinga", "A traditional Burmese rice noodle and fish soup, often considered the national dish of Myanmar.");
    }

    public String search(String word) {
        try {
            return dictionary.getMeaning(word);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}


