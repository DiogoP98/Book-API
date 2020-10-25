# Book API

Basic REST API, built with Kotlin using Maven, Spring Boot, Flyway and PostgreSQL, with the goal of learning the basics of Kotlin. The database can be populated by uncommenting the last lines of the "src/main/resources/db/migration/V1__CreateTable.sql" file and changing the Flyway placeholder for the project base directory in the file "src/main/resources/application.properties". These lines will copy data from a csv file obtained from https://www.kaggle.com/jealousleopard/goodreadsbooks.

## Run 
Start postgresql server
```shell
brew services start postgresql
```

or

```shell
pg_ctl -D /usr/local/var/postgres -l logfile start
```

### GET Request

Get all the books in the database:
```shell
curl --location --request GET 'localhost:8080/v1/api/books/'
```

Get a specific book
```shell
curl --location --request GET 'localhost:8080/v1/api/books/{bookid}'
```

Get books based on average rating (e.g. ratings less or equal to 2.9):
```shell
curl --location --request GET 'localhost:8080/v1/api/books/average_rating?lte=2.9'
```

Get books per author:
```shell
curl --location --request GET 'localhost:8080/v1/api/books/authors/{author}'
```

### POST Request

```shell
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

### PUT Request

```shell
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

### DELETE Request
```shell
curl --location DELETE 'localhost:8080/v1/api/books/{bookid}'
```
