package com.example.bookAPI.model

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "books")
class Book {
    //Change Generation value strategy, because Postgres uses sequence tables.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "bookID")
    val id: Long? = null

    @Column(name = "title")
    val title: String? = ""

    @Column(name = "authors")
    val authors: String? = ""

    @Column(name = "average_rating")
    val averageRating: Float? = null

    @Column(name = "isbn")
    val isbn: String? = ""

    @Column(name = "isbn13")
    val isbn13: String? = ""

    @Column(name = "language_code")
    val languageCode: String? = ""

    @Column(name = "num_pages")
    val numPages: Int? = null

    @Column(name = "ratings_count")
    val ratingsCount: Long? = null

    @Column(name = "text_reviews_count")
    val textReviewsCount: Long? = null

    @Column(name = "publication_date")
    val publicationDate: Date? = null

    @Column(name = "publisher")
    val publisher: String? = ""
}