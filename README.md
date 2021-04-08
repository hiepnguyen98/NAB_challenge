## Challenge-interview
```sh
PROJECT_FOLDER
│  README.md
│  pom.xml           
│  mvnw.cmd
└──[src]      
│  └──[main]      
│     └──[java] 
|        └──[com.challenge.eCommerce] #Contains start-class to run the application
|        └──[com.challenge.eCommerce.controller] # define api for application
|        └──[com.challenge.eCommerce.config] # config spring security
|        └──[com.challenge.eCommerce.entity] # include entities to generate database
|        └──[com.challenge.eCommerce.reponsitory] # define repository
|        └──[com.challenge.eCommerce.service] # define seevices
|        └──[com.challenge.eCommerce.util] # Contains functional utilities 
│     └──[resources]
│        │  application.properties #contains springboot cofigurations
│ └──[test]      
│    └──[java] 
│       └──[com.challenge.eCommerce]
|          └── BranchControllerUnitTest #Contains unit tests for BranchController (add, update, delete branch API)
|          └── CategoryControllerUnitTest #Contains unit tests for CategoryController (add, update, delete category API)
|          └── CustomerControllerUnitTest #Contains unit tests for order API 
|          └── ProductControllerUnitTest #Contains unit tests for ProductController (add, update, delete, getAll, filter, search, sort product API )
|          └── StaffControllerUnitTest #Contains unit tests for StaffController (add, update staff API)
└──[diagrams]  Contains images of the diagrams
   ```
## Key Java libraries and frameworks
 - java 11
 - maven
 - Spring Boot 2.2.4
 - JPA-Hibernate, Sql Server
 - Spring security
 - spring-social-facebook 2.0.3 

## Getting Started
 - To install this application, dowload soure code

###  Configure Database
   - Install MS Sql Server
   - Configure a username and password to login, by default the user and password should be root.
   - Create database in Sql Server
   - In ``` application.configure```  edit the parameters  ``` spring.datasource.url, spring.datasource.username, spring.datasource.password ```

###  Enabling Facebook
   - Create a Facebook Application (you can follow this blog ```https://magefan.com/blog/create-facebook-application```)
   - Get appId ,appSecret  
   - To set up the connection, open up the ```application.properties```, edit the parameters ```spring.social.facebook.appId = {your app id}, spring.social.facebook.appSecret= {your app secret}```
 
###  Run project
   - To run project right-click on the project, and select ``` Run As – > Spring Boot App ```
 
## Accessing Application

###  Delete product
     curl --location --request DELETE 'http://localhost:8080/product/manage/delete/28' --header 'Authorization: Basic aGllcG5ndXllbjI5MDExOTk4QGdtYWlsLmNvbToxMjM0' --header 'Content-Type: application/json' 

###  Update product
     curl --location --request POST 'http://localhost:8080/product/manage/add' --header 'Authorization: Basic aGllcG5ndXllbjI5MDExOTk4QGdtYWlsLmNvbToxMjM0' --header 'Content-Type: application/json' --data-raw '{"id":29, "productName":"Iphone 6", "price":7000000,"quantity":20,"decription":"demo","image":"demo.jpg","branch":{"id":11},"category":{"id":12}} '

###  Add product
     curl --location --request POST 'http://localhost:8080/product/manage/add' --header 'Authorization: Basic aGllcG5ndXllbjI5MDExOTk4QGdtYWlsLmNvbToxMjM0'--header 'Content-Type: application/json' 
     --data-raw '{
          "productName":"Samamsung galaxy s10",
          "price":12990000,
          "quantity":20,
          "decription":"beautifull",
          "color":"red",
          "image":"imgdemo.jpg",
          "branch":{
              "id":10
          },
          "category":{
              "id":12
          }
      }'
      
###  Get all product
     curl -X GET 'http://localhost:8080/product/all/'
     
###  Search product
     curl -X GET 'http://localhost:8080/product/search/{searchKey}'
     
###  Filter by category
     curl -X GET 'http://localhost:8080/product/filter/category/{categoryId}'
     
###  Filter by branch
     curl -X GET 'http://localhost:8080/product/filter/branch/{branchId}'
     
###  Sort by descending 
     curl -X GET 'http://localhost:8080/product/sort/descending/'
     
###  Sort by ascending 
     curl -X GET 'http://localhost:8080/product/sort/ascending/'
     
###  Order product 
     curl -X POST 'http://localhost:8080/order/' --header 'Content-Type: application/json' --data-raw {
    "order": { "totalPrice":"", "customerName":"hiep", "orderEmail":"test@gmail.com", "orderPhoneNumber":"12343241",  "orderAddress":"123/45/Hiep"  },  "orderDetails":[  { "orders":{   },  "product":{  "id":30  },  "unitPrice":0, "quantity":2  }, { "orders":{  }, "product":{ "id":28 }, "unitPrice":0,"quantity":3 }]} 
    
###  Add staff 
      curl --location --request POST 'http://localhost:8080/manage/staff/add/'  --header 'Authorization: Basic'  --header 'Content-Type: application/json'
      --data-raw '{
          "fullName":"Nguyễn Văn a",
          "email":"test@gmail.com",
          "userName":"user",
          "password":"12345",
          "role":{
              "id":2
          },
      }'
      
### Update staff
      curl --location --request PUT 'http://localhost:8080/manage/staff/update/' --header 'Authorization: Basic aGllcG5ndXllbjI5MDExOTk4QGdtYWlsLmNvbToxMjM0'
      --header 'Content-Type: application/json' 
      --data-raw '{
          "id":12,
          "fullName":"Nguyễn Văn a",
          "email":"test@gmail.com",
          "userName":"user",
          "password":"12345",
          "role":{
              "id":2
          },
      }'
      
### Add branch
      curl --location --request POST 'http://localhost:8080/branch/add/' --header 'Content-Type: application/json'
      --data-raw '{
          "branchName":"Apple"
      }'
     
### Update branch
      curl --location --request PUT 'http://localhost:8080/branch/update/' --header 'Content-Type: application/json' 
      --data-raw '{
          "id":1,
          "branchName":"Apple"
      }'
      
### delete branch
      curl --location --request DELETE 'http://localhost:8080/branch/delete/{id}' --header 'Content-Type: application/json' 
      
### Add category
      curl --location --request POST 'http://localhost:8080/category/add/' --header 'Content-Type: application/json'
      --data-raw '{
          "categoryName":"phone"
      }'
     
### Update category
      curl --location --request PUT 'http://localhost:8080/category/update/' --header 'Content-Type: application/json' 
      --data-raw '{
          "id":1,
          "categoryName":"laptop"
      }'
      
### Delete category
      curl --location --request DELETE 'http://localhost:8080/category/delete/{id}' --header 'Content-Type: application/json'
 
###  Get user information in Facebook
   - Generate Facebook authorize url:
  
      curl -X GET http://localhost:8080/GenerateFacebookAuthorizeUrl
      
   - Use authorize url to login to facebook account and get accessToken 
  
        ```https://www.facebook.com/v2.5/dialog/oauth?client_id={yourappid}&response_type=code&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Ffacebook&scope=email```
        
   - Once you have a accessToken you can get user information
 
      curl -X GET http://localhost:8080/facebook/getUserData/
