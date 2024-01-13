@sepetim
Feature: Sepetim
  Background:
    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır
    When Kullanıcı hesabım butonuna tıklar.

  Scenario: Gecmis siparislerim goruntulenebilmeli.
    And Acılan dropdown menuden siparislerime tiklar.
    And Gecmis siparislerimi gorur.
      #Then Gecmis siparislerin goruntulendigini dogrular.

  Scenario: Kullanıcı güncel fiyat ve ürün bilgileri ile sipariş tekrarlayabilmeli.
    And Acılan dropdown menuden siparislerime tiklar.
    And Gecmis siparislerimi gorur.
    And Siparisin detayina tiklar.
    And Siparis detayinin geldigini dogrular.
    And Tekrarla butonuna tiklar.
    Then Kullanıcı sepet sayfasına yönlendirildigini dogrular.