class Book {
    String title;
    String author;
    int pages;

    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    void printInfo() {
        System.out.println(title + " ដោយ " + author + " (" + pages + " ទំព័រ)");
    }

    boolean isLongBook() {
        return pages > 300;
    }
}

public class Answer {
    public static void main(String[] args) {
        Book first = new Book("Java មូលដ្ឋាន", "ដារ៉ា", 250);
        Book second = new Book("Java ជ្រៅ", "សុភា", 420);

        first.printInfo();
        second.printInfo();
        System.out.println("សៀវភៅទីពីរវែង? " + second.isLongBook());
    }
}
