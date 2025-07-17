# Criteria Non Query 
* Criteria juga bisa digunakan untuk membuat perintah yang non Query, seperti Update dan Delete, namun caranya sedikit berbeda
* Untuk membuat perintah Update, kita gunakan CriteriaBuilder.createCriteriaUpdate(class)
* Return nya adalah object CriteriaUpdate<T>
* https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/criteria/criteriaupdate
* Dan untuk membuat perintah Delete, kita gunakan CriteriaBuilder.createCriteriaDelete(class)
* Return nya adalah object CriteriaDelete<T>
* https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/criteria/criteriadelete 
> Malas bikin cotohnya
