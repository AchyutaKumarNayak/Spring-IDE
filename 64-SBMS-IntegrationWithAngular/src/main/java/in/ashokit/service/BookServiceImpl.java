package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.binding.Book;
import in.ashokit.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{
	private BookRepository repository;
	public BookServiceImpl(BookRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public String upsertBook(Book book) {
		Integer bookId = book.getBookId();
		repository.save(book);
		if (bookId==null) {
			return "Book added Successfully";
		}else {
			return "Book Updated Succesfully";
		}
		
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> all = repository.findAll();
		return all;
	}

	@Override
	public String deleteBook(Integer bookId) {
		repository.deleteById(bookId);
		return "Book having id "+bookId+" deleted Successfully"; 
	}

}
