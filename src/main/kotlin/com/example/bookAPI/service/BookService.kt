package com.example.bookAPI.service

import com.example.bookAPI.model.Book
import com.example.bookAPI.persistence.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getBooks(): MutableList<Book> = bookRepository.findAll()

    fun getBookByID(bookID: Long): ResponseEntity<Book> = bookRepository.findById(bookID). map{ book ->
        ResponseEntity.ok(book) }.orElse(ResponseEntity.notFound().build())

    fun getBooksByAuthor(author: String): ResponseEntity<List<Book>> {
        val booksList: List<Book> = bookRepository.findAllByAuthorsContaining(author)

        if(booksList.isEmpty()) return ResponseEntity.notFound().build()

        return ResponseEntity.ok(booksList)
    }

    fun getBooksByRating(parameters: Map<String, String>): ResponseEntity<List<Book>?> {
        if (parameters.size == 1) {
            var booksList: List<Book>? = parameters["gte"]?.toFloat()?.let {
                bookRepository.findAllByAverageRatingIsGreaterThanEqual(it)
            }

            if (booksList != null) {
                return if (booksList.isEmpty()) ResponseEntity.notFound().build()
                else ResponseEntity.ok(booksList)
            }

            booksList = parameters["lte"]?.toFloat()?.let {
                bookRepository.findAllByAverageRatingIsLessThanEqual(it)
            }

            if (booksList != null) {
                return if (booksList.isEmpty()) ResponseEntity.notFound().build()
                else ResponseEntity.ok(booksList)
            }
        }
        else{
            var booksList: List<Book>? = parameters["gte"]?.toFloat()?.let {
                parameters["lte"]?.toFloat()?.let { it1 ->
                    bookRepository.findAllByAverageRatingIsBetween(it, it1)
                }
            }

            if (booksList != null) {
                return if (booksList.isEmpty()) ResponseEntity.notFound().build()
                else ResponseEntity.ok(booksList)
            }
        }

        return ResponseEntity.badRequest().build()
    }

    fun newBook(book: Book): ResponseEntity<Book> = ResponseEntity.ok(bookRepository.save(book))

    fun updateBook(bookID: Long, newBook: Book): ResponseEntity<Book> {
        assert(bookID == newBook.id)

        val book: Optional<Book> = bookRepository.findById(bookID)

        if(!book.isPresent) return ResponseEntity.notFound().build()

        return ResponseEntity.ok().body(bookRepository.save(newBook))
    }

    fun deleteBook(bookID: Long): ResponseEntity<Void> = bookRepository.findById(bookID).map { book ->
        bookRepository.delete(book)
        ResponseEntity<Void>(HttpStatus.ACCEPTED)
        }.orElse(ResponseEntity.notFound().build())
}