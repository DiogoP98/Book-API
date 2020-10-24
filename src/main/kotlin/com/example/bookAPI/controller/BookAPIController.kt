package com.example.bookAPI.controller

import com.example.bookAPI.model.Book
import com.example.bookAPI.persistence.BookRepository
import org.hibernate.tool.schema.spi.ExceptionHandler
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/api/books")
class BookAPIController(val bookRepository: BookRepository) {

    @GetMapping
    fun getBooks(): MutableList<Book> = bookRepository.findAll()

    @GetMapping("/{bookID}")
    fun getBookByID(@PathVariable bookID: Long) = bookRepository.findByIdOrNull(bookID)

    @GetMapping("/average_rating")
    fun getBookByGreaterRating(@RequestParam parameters: Map<String, String>): List<ResponseEntity<Book>>? {
        if (parameters.size == 1) {
            if(parameters.containsKey("gte"))
                return parameters["gte"]?.toFloat()?.let {
                    bookRepository.findAllByAverageRatingIsGreaterThanEqual(it).map { book ->
                        ResponseEntity.ok(book)
                    }
                }
            else if(parameters.containsKey("lte"))
                return parameters["lte"]?.toFloat()?.let {
                    bookRepository.findAllByAverageRatingIsLessThanEqual(it).map { book ->
                        ResponseEntity.ok(book)
                    }
                }
        }
        else if(parameters.size == 2) {
            if(parameters.containsKey("gte") && parameters.containsKey("lte"))
                return parameters["gte"]?.toFloat()?.let {
                    parameters["lte"]?.toFloat()?.let { it1 ->
                        bookRepository.findAllByAverageRatingIsBetween(it, it1).map { book ->
                            ResponseEntity.ok(book)
                        }
                    }
                }
        }

        return listOf(ResponseEntity.badRequest().build<Book>())
    }

    @GetMapping("/authors/{author}")
    fun getBooksByAuthor(@PathVariable author: String) =
           bookRepository.findAllByAuthorsContaining(author)

    @PostMapping
    fun newBook(@RequestBody book: Book) = bookRepository.save(book)

    @PutMapping("/{id}")
    fun updateBook(@PathVariable bookID: Long, @RequestBody book: Book) {
        assert(bookID == book.id)
        bookRepository.save(book)
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable bookID: Long) = bookRepository.deleteById(bookID)

    

}