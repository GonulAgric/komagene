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