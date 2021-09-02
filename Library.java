package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
   public ArrayList<String> book = new ArrayList<>();
   public ArrayList<String> issueBook = new ArrayList<>();
   Scanner scan = new Scanner(System.in);
   public void availableBook(){
       book.add("Math I");
       book.add("Math II");
       book.add("Account");
       book.add("DSA");
       book.add("SAD");
       book.add("CFA");
       book.add("Web");
       book.add("Java");
       book.add("Microprocessor");
       book.add("DL");
   }
   public void showAvailableBook(){
       for (int i = 0;i <book.size();i++){
           System.out.printf("Index[%d]:\t%s\n",i,book.get(i));
       }
   }
   public void addBook(){
       String book_name;
       System.out.printf("Enter Book name:\t");
       book_name = scan.next();
//       int i = book.size();
       book.add(book_name);
   }
   public void issueBook(){
       System.out.printf("Enter index of book for Issue:");
       int index_book =scan.nextInt();
       //get the name of this book
       String bookIssue =book.get(index_book);
//       store the book in issueBook Array
       issueBook.add(bookIssue);
       book.remove(index_book);
   }
   public void returnBook(){
       for (int i = 0; i<issueBook.size();i++){
           System.out.printf("%d. %s\t",i,issueBook.get(i));
       }
       System.out.print("\nEnter the index of return book according to IssueBook:");
       int returnIndex = scan.nextInt();
       // add the return book in available book
       book.add(book.size(),issueBook.get(returnIndex));
       // after received a issue book we need to remove that book from issueBook file.
       issueBook.remove(returnIndex);
   }
   public void issueBookList(){
       for (int i = 0;i<issueBook.size();i++){
           System.out.printf("Index[%d]:\t%s\n",i,issueBook.get(i));
       }
   }
   public void librarySystem(){
       int i =1;
       while (i>=1 && i<=5){
           System.out.println("\nOperation Menu:");
           System.out.println("1.\tShow book list.");
           System.out.println("2.\tAdd book.");
           System.out.println("3.\tIssue book.");
           System.out.println("4.\tReturn book.");
           System.out.println("5.\tShow issue book list.");
           System.out.println("6.\tExit.");
           System.out.printf("Choice:");
           int choice = scan.nextInt();
           i = choice;
           switch (choice){
               case 1:
                   showAvailableBook();
                   break;
               case 2:
                   addBook();
                   break;
               case 3:
                   issueBook();
                   break;
               case 4:
                   returnBook();
                   break;
               case 5:
                   issueBookList();
               case 6:
                   break;
               default:
                   System.out.println("Invalid operation.");
                   break;
           }
       }
   }
   public Library(){
       availableBook();
   }
    public static void main(String[] args) {
       Library objectOfLibrary = new Library();
       objectOfLibrary.librarySystem();
    }
}
