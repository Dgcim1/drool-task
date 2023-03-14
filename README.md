# Simple Java SpringBoot Web Project with Drool

This Spring Boot Java Web Project contains a simple application that provides an endpoint to calculate promotional discounts for a product.

## Task

Our company sells products online, and we want to offer a promotional discount for customers who buy 
our products in bulk. Depending on the total amount of the user's purchase, a discount will be calculated 
for the user. The more the user spends, the higher the discount they will receive. The rules for calculating 
the discount based on the user's total spending are as follows:

* 10% discount for purchases over $5000
* 20% discount for purchases over $10000
* 100 discount for purchases over 10 items.

## Getting started

To get started with this project, you will need to clone the repository and install the necessary dependencies.

### Prerequisites

* Java 17
* Maven 3

### Installing

Clone the repository from GitHub:

```sh
git clone https://github.com/Dgcim1/drool-task.git
```

Build the project using Maven:

```sh
cd drool-task
mvn clean install -U -DskipTests
```

Start the application:

```sh
mvn spring-boot:start
```

The application will start on port 8080 by default. You can change this port in the **application.properties** file.

## API endpoints

The application provides one API endpoint:

### /api/promo/calc_amount

This endpoint accepts a JSON payload with two arguments:

* amount (decimal/integer): The total amount of the product
* quantity (integer): The number of products

The endpoint returns a JSON response with the following argument:

* discounted_amount (decimal/integer): The amount with promotion applied

The discount is calculated according to the following rules:

* 10% for amounts over 5000
* 20% for amounts over 10000
* 100 if the number of products is more than 10

###### Example request

```sh
curl -X POST \
  http://localhost:8080/api/promo/calc_amount \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -d '{
        "amount": 15000,
        "quantity": 5
    }'
```

###### Example response

```json
{
    "discounted_amount": 12000
}
```

You can also use **test.http** file to test this app using the **Intellij IDEA**.

## Authors

* Dmitriy Shulga

## Disclaimer

This project is provided as-is, without any warranties or guarantees. The authors are not responsible for any damage or loss caused by the use of this project