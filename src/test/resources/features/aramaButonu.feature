@aramaButonu
  Feature: Arama Butonu
    Background:
      Given Ana sayfaya gidilir

    Scenario: Arama cubuguna küçük harf ile geçerli bir veri girilebilmeli.
      When Kullanici arama cubuguna tiklar
      And  Aranacak veriyi girer.
      And  Enter tusuna basar
      Then Urunlerin listelendigini dogrular.


   Scenario: Arama cubuguna büyük harf ile geçerli bir veri girilebilmeli.
    When Kullanici arama cubuguna tiklar
    And  Buyuk harflerle aranacak veriyi girer.
    And  Enter tusuna basar
    Then Urunlerin listelendigini dogrular.

   Scenario: Arama cubuguna yazim yanlışı ile geçerli bir veri girilebilmeli.
     When Kullanici arama cubuguna tiklar
     And  Yazim yanlisi yaparak aranacak veriyi girer.
     And  Enter tusuna basar
     Then Urunlerin listelendigini dogrular.
     ## Bu özellik henüz yapılmadı.

  Scenario: Arama cubuguna  geçersiz bir veri girildiğinde uyari mesaji almali.
    When Kullanici arama cubuguna tiklar
    And  Gecersiz bir veri girer.
    And  Enter tusuna basar
    Then Uyari mesajini gorur.


   Scenario: Arama cubugunu boş bırakarak arama yaptığında uyari mesaji almali.
     When Kullanici arama cubuguna tiklar
     And  Arama cubuguna veri girmez.
     And  Enter tusuna basar
     Then Uyari mesajinin geldigini dogrular.








