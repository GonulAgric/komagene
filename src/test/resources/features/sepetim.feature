@sepetim
Feature: Sepetim
Background:
  Given Ana sayfaya gidilir
  When Üye Ol Giriş Yap butonuna tıklanır
  And Telefon numarası girilir
  And Gelen dogrulama kodu girilir
  And Giriş Yap butonuna tıklanır
  Then Hesabında oldugunu dogrular
  Given Adres secimini yapar.
  When Kullanici Dürümler kategorisine tiklar.
  And Cigkofte durume menuye tiklar.
  And Opsiyon seçimlerini yapar.
  And Sepete ekle butonuna tıklar.

  Scenario: Kullanıcı sepetine urun ekleyebilmeli

   # Then Ürünün sepete eklendiğini doğrular

  Scenario: Siparis detay bilgileri goruntulenmeli
    Given Kullanici sepetime tiklar.
    Then  Adres bilgileri ve sipariş detay bilgilerini görüntüler.


  Scenario:Sepetteki siparis iptal edilebilmeli
    Given Kullanici sepetime tiklar.
    When  Sepetteki urunun iptal Et butonuna tiklar.
    Then  Urunun sepetten çikarildiğini dogrular.

   Scenario: Siparis detayında urunle ilgili degisiklikler yapılabilmeli
     Given Kullanici sepetime tiklar.
     When  Degisiklik yapmak istedigi opsiyonu secer.
     And   Sectigi opsiyonu degiştirir.
     And   Degisiklikleri kaydet butonuna tiklar.

   Scenario: Secilen teslimat turu ile birlikte fiyatlar guncellenmeli
     Given Kullanici sepetime tiklar.
     When Sol ust kosedeki teslimat turunu degistirir ve degisiklikgin sepet tutarini yansidigini dogrular.


   Scenario: Sepette siparis ver butonuna tıklandıgında odeme safasına gecmeli
     Given Kullanici sepetime tiklar.
     And Sipariş ver butonuna tiklar.
     Then  Odeme sayfasinda oldugunu dogrular.

  Scenario: Sepette urun adedi artirilabilmeli
    Given Kullanici sepetime tiklar.
    When  Ekledigi urunun adet sayisini arttirir.
    Then  Adet sayisinin arttirildigini dogrular.

  Scenario: Sepette urun adedi azaltılabilmeli
    Given Kullanici sepetime tiklar.
    When  Ekledigi urunun adet sayisini azaltir.
    Then  Adet sayisinin azaldigini dogrular.