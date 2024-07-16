package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.Book;

public interface BookService {
	public String upsertBook(Book book);
	public List<Book> getAllBooks();
	public String deleteBook(Integer bookId);

}
