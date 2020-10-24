package com.example.bookAPI.persistence

import com.example.bookAPI.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookReposiroty: JpaRepository<Book, Long>