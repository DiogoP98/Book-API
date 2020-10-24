Start postgresql server
```
brew services start postgresql
```

or

```
pg_ctl -D /usr/local/var/postgres -l logfile start
```

PUT request

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