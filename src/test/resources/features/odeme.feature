@odeme
Feature: Odeme

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

  Scenario: Kullanıcı ödeme seçeneklerini görebilmeli ve seçebilmeli
    Given Kullanici sepetime tiklar.
    And   Sipariş ver butonuna tiklar.
    And   Odeme seceneklerini goruntuler ve secer.

  Scenario: Kart bilgileri saklanabilmeli.
    Given Kullanici sepetime tiklar.
    And   Sipariş ver butonuna tiklar.
    And   Kart bilgilerini girer
    And   Bu kart bilgilerimi saklamak istiyorum checkbox tiklar.
    Then  Kart bilgilerinin saklandigini dogrular.

  Scenario: Geçersiz kart bilgileri girilince uyarı mesajı gelmeli
    Given Kullanici sepetime tiklar.
    And   Sipariş ver butonuna tiklar.
    And   Gecersiz kart bilgileri girer
    And Siparisi tamamla butonuna tiklar.
    Then  Uyari mesaji alir.

  Scenario: Sipariş notu bölümüne 100 karakterden az sipariş notu girilmeli.
    Given Kullanici sepetime tiklar.
    And   Sipariş ver butonuna tiklar.
    And   Siparis notu bolumune yuz karakterden az bir not yazar.

  Scenario: Sipariş notu bölümüne 100 karakterden fazla sipariş notu girilmemeli.
    Given Kullanici sepetime tiklar.
    And   Sipariş ver butonuna tiklar.
    And   Siparis notu bolumune yuz karakterden fazla bir not yazar.
    Then  Uyari mesajini alir

   Scenario: Kayıtlı kart bilgisi ile yeni işlem yapabilmeli.
     Given Kullanici sepetime tiklar.
     And   Sipariş ver butonuna tiklar.
     And   Sakli kart bilgilerimi kullanmak istiyorum kutusunu isaretler.
     And   Kayitli kartlarindan birini secer.
     And   Mesafeli satış sozlesmesini isaretler.
     And   Siparis tamamla butonuna tiklar.


  Scenario: Kayıtlı kart bilgisi silinebilmeli.
    Given Kullanici sepetime tiklar.
    And   Sipariş ver butonuna tiklar.
    And   Sakli kart bilgilerimi kullanmak istiyorum kutusunu isaretler.
    And   Kayitli kartlarindan birini secer.
    And   Kart bilgimi sil kutusunu isaretler.


  Scenario: Yeni kart bilgisi eklenebilmeli.
   Given Kullanici sepetime tiklar.
   And   Sipariş ver butonuna tiklar.
   And   Sakli kart bilgilerimi kullanmak istiyorum kutusunu isaretler.
   And   Yeni kart ekle butonuna tiklar.
   And   Yeni kart bilgilerini girer.
   And   Kart bilgilerimi kaydet butonuna tıklar.

  Scenario: Kullanıcı kapıda nakit ödeme yapabilmeli.
    Given Kullanici sepetime tiklar.
    And   Sipariş ver butonuna tiklar.
    When  Kapıda odeme secenegine tiklar.
    And   Odeme yontemi seciniz dropdown menuden nakit odemeye tiklar.
    And   Mesafeli satış sozlesmesini isaretler.
    And   Siparis tamamla butonuna tiklar.
    Then  Siparisin tamamlandigini dogrular.








