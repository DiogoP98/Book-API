package com.example.bookAPI.controller

import com.example.bookAPI.service.BookService
import com.example.bookAPI.model.Book
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/api")
class BookAPIController(private val bookService: BookService) {

    @GetMapping("/books")
    fun getBooks(): MutableList<Book> = bookService.getBooks()

    @GetMapping("/books/{bookID}")
    fun getBookByID(@PathVariable bookID: Long) = bookService.getBookByID(bookID)

    @GetMapping("/books/average-rating")
    fun getBookByRating(@RequestParam(required = true) parameters: Map<String, String>) = bookService.getBooksByRating(parameters)

    @GetMapping("/authors/{author}/books")
    fun getBooksByAuthor(@PathVariable author: String) = bookService.getBooksByAuthor(author)

    @PostMapping
    fun newBook(@RequestBody book: Book) = bookService.newBook(book)

    @PutMapping("/books/{bookID}")
    fun updateBook(@PathVariable bookID: Long, @RequestBody book: Book) = bookService.updateBook(bookID, book)

    @DeleteMapping("/books/{bookID}")
    fun deleteBook(@PathVariable bookID: Long) = bookService.deleteBook(bookID)

    

}
