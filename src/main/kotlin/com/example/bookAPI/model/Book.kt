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
    var id: Long? = null

    @Column(name = "title")
    var title: String? = ""

    @Column(name = "authors")
    var authors: String? = ""

    @Column(name = "average_rating")
    var averageRating: Float? = null

    @Column(name = "isbn")
    var isbn: String? = ""

    @Column(name = "isbn13")
    var isbn13: String? = ""

    @Column(name = "language_code")
    var languageCode: String? = ""

    @Column(name = "num_pages")
    var numPages: Int? = null

    @Column(name = "ratings_count")
    var ratingsCount: Long? = null

    @Column(name = "text_reviews_count")
    var textReviewsCount: Long? = null

    @Column(name = "publication_date")
    var publicationDate: Date? = null

    @Column(name = "publisher")
    var publisher: String? = ""
}