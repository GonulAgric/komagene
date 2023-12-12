@smoke
Feature:Smoke Test

  Scenario: Hesaba giris yapma
    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır
   Then Hesabında oldugunu dogrular

Scenario:Sepete ürün ekleme
  Given Adres secimini yapar.
  When Kullanici Bi cift tatli menuye tiklar.
  And İkili durum menuye tiklar.
  And Opsiyon seçimlerini yapar.
  And Sepete ekle butonuna tıklar.
 # Then Kullanici urunun sepete eklendigini dogrular.

 Scenario: Odeme
    Given Kullanici sepetime tiklar.
    When Teslimat turunu Gel Al secer.
    And Sipariş ver butonuna tiklar.
    #Then Kullanici odeme sayfasinda oldugunu dogrular.
    And Kart bilgilerini girer.
    And Mesafeli satış sozlesmesini isaretler.
    And Siparisi tamamla butonuna tiklar.
    And Odeme için telefona gelen dogrulama kodunu girer.
    #Then Siparisin tamamlandıgını dogrular.

