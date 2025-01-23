package org.example;

import lombok.*;

import java.awt.print.Book;
import java.util.*;

@EqualsAndHashCode
public class Library {

    private Map<String, Integer> bookMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);


    public void addNewBook(Books book) {

        if (!bookMap.containsKey(book.getTitle())) {
            bookMap.put(book.getTitle(), book.getISBN());
            System.out.println("Book added successfully.");
        } else {
            try {
                if (bookMap.containsKey(book.getTitle())) {
                    throw new BookExeptions("A book with the title \"" + book.getTitle() + "\" already exists.");
                }
            } catch (BookExeptions e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void sortBooks() {
        List<Map.Entry<String, Integer>> bookList = new ArrayList<>(bookMap.entrySet());

        bookList.sort(Map.Entry.comparingByKey());

        System.out.println("Books sorted by title:");
        for (Map.Entry<String, Integer> entry : bookList) {
            System.out.println("Book title: " + entry.getKey() + ", ISBN: " + entry.getValue());
        }
    }


    public void displayAllBooks() {
        if (bookMap.isEmpty()) {
            System.out.println("There are no books in the library.");
        } else {
            System.out.println("Here is a list of books in the library:");
            for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {
                System.out.println("Book title: " + entry.getKey() + ", ISBN: " + entry.getValue());
            }
        }
    }


    public void removeBook(String entryKey, String entryValue) {
        for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {

            if (entry.getKey().equals(entryKey) && entry.getValue().toString().equals(entryValue)) {
                bookMap.remove(entry.getKey());
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found, cannot be removed.");
    }


    public void getBookByISBN(int isbn) {

        for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {
            if (entry.getValue().equals(isbn)) {
                System.out.println("Book with title \"" + entry.getKey() + "\" and ISBN: " + entry.getValue());
                return;
            }
        }
        System.out.println("No book found with ISBN: " + isbn);
    }

    public Optional<Books> getBookByISBNOptional(int ISBN) {
        List<Books> bookList = new ArrayList<>();

        Books bk = new Books();
        bk.setISBN(ISBN);

        int index = bookList.indexOf(bk);

        if (index != -1) {
            return Optional.of(bookList.get(index));
        }

        return Optional.empty();
    }

}
