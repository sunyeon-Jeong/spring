# MySelectShop
- - -
## π± myselectshop μλΉμ€ μκ°
1. ν€μλλ‘ μνκ²μ -> κ²°κ³Όλ₯Ό λͺ©λ‘μΌλ‘ λ³΄μ¬μ€
2. κ΄μ¬μν λ±λ‘νκΈ°
3. κ΄μ¬μν μ‘°ννκΈ°
4. κ΄μ¬μν μ΅μ κ° λ±λ‘νκΈ°
5. νμκ°μ
6. λ‘κ·ΈμΈ
7. λ‘κ·ΈμΈ μ±κ³΅ μ, ν ν°λ°κΈ
8. λ‘κ·Έμμ
9. λ‘κ·ΈμΈ ν μ μ λ§ κ΄μ¬μν λ±λ‘/μ‘°ν/μ΅μ κ° λ±λ‘ κ°λ₯
10. ADMIN κ³μ μ λͺ¨λ  μνμ‘°ν κ°λ₯
- - -
## π¦ API λͺμΈμ
|κΈ°λ₯|Method|URL|Request|Response|
|---|---|---|---|---|
|λ©μΈνμ΄μ§|`GET`|/api/shop|-|index.html|
|ν€μλλ‘μνκ²μ->κ²°κ³Όλͺ©λ‘μΌλ‘λ³΄μ¬μ£ΌκΈ°|`GET`|/api/search?query=κ²μμ΄|-|[<br>{<br>"title":String,<br>"link":String,<br>"image":String,<br>"lprice":int<br>},<br>...<br>]|
|κ΄μ¬μν λ±λ‘νκΈ°|`POST`|/api/products|{<br>"title":String,<br>"link":String,<br>"image":String,<br>"lprice":int<br>}|{<br>"id":Long,<br>"title":String,<br>"link":String,<br>"image":String,<br>"lprice":int,<br>"myprice":int<br>}|
|κ΄μ¬μν μ‘°ννκΈ°|`GET`|/api/products|-|[<br>{<br>"id":Long,<br>"title":String,<br>"link":String,<br>"image":String,<br>"lprice":int,<br>"myprice":int<br>},<br>...<br>]|
|κ΄μ¬μν μ΅μ κ° λ±λ‘νκΈ°|`PUT`|/apiproducts/{id}|{<br>"myprice":int<br>}|id|
|νμκ°μ νμ΄μ§|`GET`|/api/user/signup|-|signup.html|
|νμκ°μ|`POST`|/api/user/signup|POST Form νκ·Έ<br>{<br>"username":String,<br>"password":String,<br>"email":String,<br>"admin":boolean,<br>"adminToken":String<br>}|redirect:/api/user/login|
|λ‘κ·ΈμΈ νμ΄μ§|`GET`|/api/user/login|-|login.html|
|λ‘κ·ΈμΈ|`POST`|/api/user/login|POST Form νκ·Έ<br>{<br>"username":String,<br>"password":String<br>}|redirect:/api/shop|

* JWT μ μ©μ User API

|κΈ°λ₯|Method|URL|Request|Response|
|---|---|---|---|---|
|νμκ°μ νμ΄μ§|`GET`|/api/user/signup|-|signup.html|
|νμκ°μ|`POST`|/api/user/signup|POST Form νκ·Έ<br>{<br>"username":String,<br>"password":String,<br>"email":String,<br>"admin":boolean,<br>"adminToken":String<br>}|redirect:/api/user/login|
|λ‘κ·ΈμΈ νμ΄μ§|`GET`|/api/user/login|-|login.html|
|λ‘κ·ΈμΈ|`POST`|/api/user/login|{<br>"username":String,<br>"password":String<br>}|Header<br>Authorization:Bearer<br><JWT><br>success|

- - -
## π£ AllInOneController κ΄μ¬μ¬ λΆλ¦¬νκΈ°
[AllInOneController]
![img.png](img.png)
1. Controller μ­ν  κ΅¬λΆ
![img_1.png](img_1.png)
2. Service μ­ν  κ΅¬λΆ
![img_2.png](img_2.png)
3. Repository μ­ν  κ΅¬λΆ
![img_3.png](img_3.png)
- - -
## π³ Refactoring ν, κ°μ μ 
(AllInOneController νκ³μ κ³Ό λΉκ΅)
* ν κ°μ ν΄λμ€μ λλ¬΄ λ§μ μμ μ½λ μ‘΄μ¬
  * μ½λ μ΄ν΄κ° μ΄λ €μ
  * -> 3κ°μ ν΄λμ€μ μ­ν λ³λ‘ μ½λ μ λ¦¬ μλ£

* μ½λ μΆκ°/λ³κ²½ μμ²­μ λν λμ
  * κ΄μ¬μν λ±λ‘ -> Client Responseνλ κ° λ³κ²½
  * (λ±λ‘λ Product μ μ²΄ μ λ³΄ -> λ±λ‘λ Product id)
  * -> Controller μ­ν 
  
  * μ΅μ κ° Myprice μλ°μ΄νΈ μ‘°κ±΄ λ³κ²½
  * (Clientκ° μ΅μ κ°λ₯Ό 0 μ΄νλ‘ μλ ₯ -> Error!)
  * -> Service μ­ν 
  
  * DB νμ΄λΈ μ΄λ¦ λ³κ²½
  * (Product νμ΄λΈ lprice -> lowpriceλ‘ λ³κ²½)
  * -> Repository μ­ν 