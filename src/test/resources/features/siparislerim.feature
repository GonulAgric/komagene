@siparişlerim
Feature: Siparişlerim
  Background:
    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır
    When Kullanıcı hesabım butonuna tıklar.
    And Acılan dropdown menuden siparislerime tiklar.

  Scenario: Gecmis siparislerim goruntulenebilmeli.
    Then Gecmis siparislerin goruntulendigini dogrular.

  Scenario: Kullanıcı güncel fiyat ve ürün bilgileri ile sipariş tekrarlayabilmeli.
    Given Adres secimini yapar.
    And Herhangi bir siparisin detayina tiklar.
    And Siparis detayinin geldigini dogrular.
    And Tekrarla butonuna tiklar.
    Then Kullanıcı sepet sayfasına yönlendirildigini dogrular.