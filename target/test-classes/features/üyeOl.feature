@üyelik
Feature: Üyelik Oluşturma ve Doğrulama

  Scenario: Başarılı üyelik oluşturma ve doğrulama
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Ad, soyad, e-posta bilgileri girilir
    And "KVKK Metni" ve "Gizlilik Sözleşmesi" ve "Üyelik Sözleşmesi" checkbox'ları seçilir
    And "Üyeliği Tamamla" butonuna tıklanır
    And Telefonuna gelen doğrulama kodu girilir
    And "Giriş Yap" butonuna tekrar tıklanır
    Then "Hoş geldiniz" mesajı görüntülenir
    And Kullanıcı anasayfaya dön butonuna tıklar.

@negatif
  Scenario: Yanlış doğrulama kodu girişi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Eksik Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Ad, soyad, e-posta bilgileri girilir
    And "KVKK Metni" ve "Gizlilik Sözleşmesi" ve "Üyelik Sözleşmesi" checkbox'ları seçilir
    And "Üyeliği Tamamla" butonuna tıklanır
    And Telefonuna yanlış doğrulama kodu girilir
    And "Giriş Yap" butonuna tekrar tıklanır
    Then "Yanlış kod girdiniz" uyarısı görüntülenir
    And sayfa kapatılır