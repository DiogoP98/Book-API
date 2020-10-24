package com.example.bookAPI.persistence

import com.example.bookAPI.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<Book, Long> {

    fun findAllByAverageRatingIsGreaterThanEqual(averageRating: Float):
            List<Book>

    fun findAllByAverageRatingIsLessThanEqual(averageRating: Float):
            List<Book>

    fun findAllByAverageRatingIsBetween(lowerBound: Float, upperBound: Float):
            List<Book>

    fun findAllByAuthorsContaining(author: String):
            List<Book>
}