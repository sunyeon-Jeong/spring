# MySelectShopBeta
- - -
## π± myselectshop μλΉμ€ μκ°
1. ν€μλλ‘ μνκ²μ -> κ²°κ³Όλ₯Ό λͺ©λ‘μΌλ‘ λ³΄μ¬μ€
2. κ΄μ¬μν λ±λ‘νκΈ°
3. κ΄μ¬μν μ‘°ννκΈ°
4. κ΄μ¬μν μ΅μ κ° λ±λ‘νκΈ°
- - -
## π° μνκ²μ API λμμμ μ λ¦¬
![img.png](img.png)
- - -
## π¦ API λͺμΈμ
|κΈ°λ₯|Method|URL|Request|Response|
|---|---|---|---|---|
|λ©μΈνμ΄μ§|`GET`|/api/shop|-|index.html|
|ν€μλλ‘μνκ²μ->κ²°κ³Όλͺ©λ‘μΌλ‘λ³΄μ¬μ£ΌκΈ°|`GET`|/api/search?query=κ²μμ΄|-|[<br>{<br>"title":String,<br>"link":String,<br>"image":String,<br>"lprice":int<br>},<br>...<br>]|
|κ΄μ¬μν λ±λ‘νκΈ°|`POST`|/api/products|{<br>"title":String,<br>"link":String,<br>"image":String,<br>"lprice":int<br>}|{<br>"id":Long,<br>"title":String,<br>"link":String,<br>"image":String,<br>"lprice":int,<br>"myprice":int<br>}|
|κ΄μ¬μν μ‘°ννκΈ°|`GET`|/api/products|-|[<br>{<br>"id":Long,<br>"title":String,<br>"link":String,<br>"image":String,<br>"lprice":int,<br>"myprice":int<br>},<br>...<br>]|
|κ΄μ¬μν μ΅μ κ° λ±λ‘νκΈ°|PUT|/apiproducts/{id}|{<br>"myprice":int<br>}|id|
- - -