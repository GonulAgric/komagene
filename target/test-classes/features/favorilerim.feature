@favorilerim
Feature: Favorilerim
  Background:
    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır


  Scenario: Kullanıcı ürün kartında favori işaretine tıklayabilmeli.
    And Urun kartlarindan birine tiklar.
    And Acilan urun detayinda favori simgesine tiklar.
    Then Urunun favorilerine eklendigini dogrular.


  Scenario: Isaretlenen urun favori listesinde gorulmeli.
    When Kullanıcı hesabım butonuna tıklar.
    And Acılan dropdown menuden favori urunlerime tiklar.
    Then Favori urunlerimin otomatik geldigini dogrular.








