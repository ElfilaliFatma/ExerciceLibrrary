package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while(true){
            System.out.println("Menu:");
            System.out.println("1. Add book");
            System.out.println("2. Display books in the library");
            System.out.println("3. Get book by ISBN");
            System.out.println("4. Delete book");
            System.out.println("5. Sort books");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character
            switch (choice){
                case 1:
                    System.out.println("Enter how many books you want to add:");
                    int n = sc.nextInt();
                    sc.nextLine();  // Consume newline after nextInt()
                    for (int i = 1; i <= n; i++) {
                        System.out.println("Enter book title:");
                        String title = sc.nextLine();
                        System.out.println("Enter book author:");
                        String author = sc.nextLine();
                        System.out.println("Enter ISBN:");
                        int ISBN = sc.nextInt();
                        sc.nextLine();  // Consume the newline after nextInt()

                        Books book = new Books();
                        book.setTitle(title);
                        book.setAuthor(author);
                        book.setISBN(ISBN);
                        library.addNewBook(book);  // Add the book to the library
                    }
                    break;

                case 2:
                    library.displayAllBooks();
                    break;

                case 3:
                    System.out.println("Enter the ISBN of the book you want to search:");
                    int isbn = sc.nextInt();
                    library.getBookByISBN(isbn);
                    break;

                case 4:
                    sc.nextLine();  // Consume newline left by nextInt()
                    System.out.println("Enter the book title to delete:");
                    String entryKey = sc.nextLine();
                    System.out.println("Enter the book author to delete:");
                    String entryValue = sc.nextLine();
                    library.removeBook(entryKey, entryValue);
                    break;

                case 5:
                    library.sortBooks();
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
