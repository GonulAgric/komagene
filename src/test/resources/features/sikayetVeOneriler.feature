@SikayetVeOneri
Feature: Sikayet ve Oneriler

  Background:
    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır


  Scenario:Sikayet ve Oneriler görüntülenebilmeli
  Given Kullanici hesabim butonuna tiklar.
   When Acilan dropdown menuden sikayet ve oneriye tiklar.
   Then Sikayet ve onerilerim'in otomatik geldigini gorur.

    Scenario: Kullanıcı yeni şikayet ekleyebilmeli.
  Given  Kullanici hesabim butonuna tiklar.
  When  Acilan dropdown menuden sikayet ve oneriye tiklar.
  And Kullanici yeni butonuna tiklar.
  Then Yeni sikayetin goruntulendigini dogrular.




