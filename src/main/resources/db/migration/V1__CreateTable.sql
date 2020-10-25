DROP TABLE IF EXISTS books;

CREATE TABLE books(
    BOOKID SERIAL PRIMARY KEY NOT NULL,
    TITLE   VARCHAR(255),
    AUTHORS TEXT,
    AVERAGE_RATING FLOAT,
    ISBN VARCHAR(10),
    ISBN13 VARCHAR(13),
    LANGUAGE_CODE VARCHAR(20),
    NUM_PAGES SMALLINT,
    RATINGS_COUNT BIGINT,
    TEXT_REVIEWS_COUNT BIGINT,
    PUBLICATION_DATE DATE,
    PUBLISHER VARCHAR(255)
);

--COPY books(bookid, title, authors, average_rating, isbn, isbn13, language_code, num_pages,
--ratings_count, text_reviews_count, publication_date,publisher)
--FROM '${project_basedir}/Book-API/src/main/resources/books.csv'
--DELIMITER ','
--CSV HEADER;