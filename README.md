# MyEcommerce

This application exposes a REST API and includes functionality manage Shopping Cart and generate a file in a local directory.

---

## Requirements
- Java 17+
- Gradle 8+
- Docker
---

### Run Container (Windows)

The application must create files in C:\temp. Make sure C:\temp exists before running.

***Build image:***

````bash
docker build -t myecommerce .
````

***Run container:***
```bash
docker run --rm -p 8080:8080 `
  -v C:\temp:/app/files `
  -e FILES_PATH=/app/files `
  myecommerce
```
---

### List Items

**GET** `http://localhost:8080/shopping/itms`

Returns all available products, use the `itemId` for the next operations.

#### Response
```json
[
  {
    "id": 1,
    "brand": "VANS",
    "name": "Sapatilhas em nobuck",
    "model": "Old skool",
    "price": 95.0
  },
  {
    "id": 2,
    "brand": "VANS",
    "name": "Sapatilhas subidas em nobuck",
    "model": "SK8-Hi",
    "price": 110.0
  },
  {
    "id": 3,
    "brand": "VANS",
    "name": "Sapatilhas em couro",
    "model": "Old Skool",
    "price": 90.0
  },
  {
    "id": 4,
    "brand": "VANS",
    "name": "Sapatilhas com plataforma",
    "model": "Old Skool Stackform",
    "price": 10.0
  },
  {
    "id": 5,
    "brand": "VANS",
    "name": "Sapatilhas em couro",
    "model": "Knu Skool",
    "price": 100.0
  }
]
```
---

### Create a Cart
Create a new Shopping Cart, **return** the `cartId` to use in next operations.

**POST** `http://localhost:8080/shopping/carts`

#### Response
```json
1
```
---

### Add Item to Cart

Add an item providing the `itemId` in the request body, to the specific cart providing the `cartId` in URL .

**POST** `http://localhost:8080/shopping/carts/{cartId}/add/item`

**Example** `POST http://localhost:8080/shopping/carts/1/add/item`

#### Request Body
```json
1
```

#### Response
```json
[
  {
    "id": 1,
    "brand": "VANS",
    "name": "Sapatilhas em nobuck",
    "model": "Old skool",
    "price": 95.0
  }
]
```
---

### Export Cart to JSON File
Export specific cart to a JSON file in the local directory configured in the application.

**POST** `POST http://localhost:8080/shopping/carts/{cartId}/export/file/json`

**Example** `POST http://localhost:8080/shopping/carts/1/export/file/json`

Create a JSON file with the content of the cart.

#### Response
```json
200 OK
```
---