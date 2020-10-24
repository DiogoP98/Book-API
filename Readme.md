#Book API

Basic REST API, built with Kotlin using Spring Boot, Flyway and PostgreSQL, with the goal of learning the basics of Kotlin.

##Run 
Start postgresql server
```
brew services start postgresql
```

or

```
pg_ctl -D /usr/local/var/postgres -l logfile start
```

###GET Request

Get all the books in the database:
```
curl --location --request GET 'localhost:8080/v1/api/books/'
```

Get a specific book
```
curl --location --request GET 'localhost:8080/v1/api/books/{bookid}'
```

Get books based on average rating (e.g. ratings less or equal to 2.9):
```
curl --location --request GET 'localhost:8080/v1/api/books/average_rating?lte=2.9'
```

Get books per author:
```
curl --location --request GET 'localhost:8080/v1/api/books/authors/Diogo'
```

###POST Request

```
curl --location --request POST 'localhost:8080/v1/api/books/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "Harry Potter and the Order of the Phoenix",
    "authors": "J. K. Rowling/Mary GrandPré",
    "averageRating": 4.9,
    "isbn": "0439358078",
    "isbn13": "9780439358071",
    "languageCode": "eng",
    "numPages": 100,
    "ratingsCount": 1000,
    "textReviewsCount": 10,
    "publicationDate": "2004-01-09",
    "publisher": "Scholastic Inc."
}'
```

###PUT Request

```
curl --location --request PUT 'localhost:8080/v1/api/books/{bookid}' \                                                                                              ‹system›
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "Harry Potter and the Order of the Phoenix",
    "authors": "J. K. Rowling/Mary GrandPré",
    "averageRating": 4.95,
    "isbn": "0439358078",
    "isbn13": "9780439358071",
    "languageCode": "eng",
    "numPages": 100,
    "ratingsCount": 1200,
    "textReviewsCount": 20,
    "publicationDate": "2004-01-09",
    "publisher": "Scholastic Inc."
}'
```

###DELETE Request
```
curl --location DELETE 'localhost:8080/v1/api/books/{bookid)'
```
