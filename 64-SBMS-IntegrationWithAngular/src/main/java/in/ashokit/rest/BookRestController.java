package in.ashokit.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Book;
import in.ashokit.service.BookService;

@RestController
public class BookRestController {
	private BookService service;

	public BookRestController(BookService service) {
		super();
		this.service = service;
	}
	@PostMapping("/addBook")
	public ResponseEntity<String> insertBook(@RequestBody Book book){
		String upsertBook = service.upsertBook(book);
		return new ResponseEntity<>(upsertBook,HttpStatus.OK);
	}
	@PutMapping("/addBook")
	public ResponseEntity<String> updateBook(@RequestBody Book book){
		String upsertBook = service.upsertBook(book);
		return new ResponseEntity<>(upsertBook,HttpStatus.OK);
	}
	@DeleteMapping("/deleteBook/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId){
		String deleteBook = service.deleteBook(bookId);
		return new ResponseEntity<>(deleteBook,HttpStatus.OK);
	}
	@GetMapping("/getBooks")
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> allBooks = service.getAllBooks();
		return new ResponseEntity<>(allBooks,HttpStatus.OK);
	}

}
