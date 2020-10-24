package com.example.bookAPI.service

import com.example.bookAPI.model.Book
import com.example.bookAPI.persistence.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getBooks(): List<Book> = bookRepository.findAll()

    fun addBook(book: Book): ResponseEntity<Book> =
            ResponseEntity.ok(bookRepository.save(book))

    fun getBookById(bookID: Long): ResponseEntity<Book> =
            bookRepository.findById(bookID).map { book ->
                ResponseEntity.ok(book)
            }.orElse(ResponseEntity.notFound().build())

    fun deleteBook(bookID: Long): ResponseEntity<Void> =
            bookRepository.findById(bookID).map { book ->
                bookRepository.delete(book)
                ResponseEntity<Void>(HttpStatus.ACCEPTED)
            }.orElse(ResponseEntity.notFound().build())
}