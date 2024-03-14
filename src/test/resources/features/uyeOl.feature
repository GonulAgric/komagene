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

@adAlani
  Scenario Outline: Ad alanina girilen gecersiz verilerle uyelik kaydi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Ad alanina "<gecersiz_ad>" girilir
    Then "<hata_mesajı>" görüntülenir
    Examples:
      | gecersiz_ad           | hata_mesajı                                                                        |
      |                       | Ad alanına özel karakter girmeyiniz.                                               |
      | a                     | Ad minimum 2, maksimum 15 karakter olması gerekiyor; girdiğiniz karekter sayısı 1. |
      | onbeskarakterdenfazla |                                                                                    |
      | /                     | Ad alanına özel karakter girmeyiniz.                                               |


  @soyadAlani
  Scenario Outline: Soyad alanina girilen gecersiz verilerle uyelik kaydi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Soyad alanina "<gecersiz_soyad>" girilir
    Then Soyad "<hata_mesajı>" görüntülenir
    Examples:
      | gecersiz_soyad                  | hata_mesajı                                                                           |
      |                                 | Soyad alanına özel karakter girmeyiniz.                                               |
      | a                               | Soyad minimum 2, maksimum 30 karakter olması gerekiyor; girdiğiniz karekter sayısı 1. |
      | otuzkarakterdenfazlagirilemezzz |                                                                                       |
      | /                               | Soyad alanına özel karakter girmeyiniz.                                               |


  @emailAlani
  Scenario Outline: Email alanina girilen gecersiz verilerle uyelik kaydi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Email alanina "<gecersiz_email>" girilir
    Then Email "<hata_mesajı>" görüntülenir
    Examples:
      | gecersiz_email  | hata_mesajı                                    |
      |                 | Email alanına geçerli bir email adresi giriniz |
      | a.gnlgmail.coma | Email alanına geçerli bir email adresi giriniz |

  @telAlani
  Scenario Outline: Telefon alanina girilen gecersiz verilerle uyelik kaydi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And "<Telefon>" numarasi girilir
    Then Telefon "<hata_mesajı>" görüntülenir
    Examples:
      | Telefon   | hata_mesajı                                 |
      |           | Lütfen telefon numaranızı giriniz           |
      | 543567554 | Lütfen telefon numaranızı 10 haneli giriniz |

  @kvkkTC14
  Scenario: KVKK metni isaretlenmeyince uyelik kaydi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Ad, soyad, e-posta bilgileri girilir
    And KVKK Metni checkbox i isaretlenmez
    And Gizlilik Sözleşmesi  checkbox'i isaretlenir
    And Üyelik Sözleşmesi checkbox'i isaretlenir
    And Üyeliği Tamamla butonuna tıklanır
    Then KVKK hata mesaji dogrulanir

  @kvkkTC15
  Scenario: KVKK metni isaretlenip digerleri isaretlenmeyince uyelik kaydi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Ad, soyad, e-posta bilgileri girilir
    And KVKK Metni checkbox i isaretlenir
    And Gizlilik Sözleşmesi  checkbox'i isaretlenmez
    And Üyelik Sözleşmesi checkbox'i isaretlenmez
    And Üyeliği Tamamla butonuna tıklanır
    Then KVKK hata mesaji dogrulanir

  @uyelikSozlesmesiTC16
  Scenario: Uyelik sozlesmesi isaretlenmeyince uyelik kaydi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Ad, soyad, e-posta bilgileri girilir
    And KVKK Metni checkbox i isaretlenir
    And Gizlilik Sözleşmesi  checkbox'i isaretlenir
    And Üyelik Sözleşmesi checkbox'i isaretlenmez
    And Üyeliği Tamamla butonuna tıklanır
    Then KVKK hata mesaji dogrulanir

  @uyelikSozlesmesiTC17
  Scenario: Uyelik sozlesmesi isaretlenip digerleri isaretlenmeyince uyelik kaydi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Ad, soyad, e-posta bilgileri girilir
    And KVKK Metni checkbox i isaretlenmez
    And Gizlilik Sözleşmesi  checkbox'i isaretlenmez
    And Üyelik Sözleşmesi checkbox'i isaretlenir
    And Üyeliği Tamamla butonuna tıklanır
    Then KVKK hata mesaji dogrulanir

  @gizlilikSozlesmesiTC18
  Scenario: Gizlilik sozlesmesi isaretlenmeyince uyelik kaydi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Ad, soyad, e-posta bilgileri girilir
    And KVKK Metni checkbox i isaretlenir
    And Gizlilik Sözleşmesi  checkbox'i isaretlenmez
    And Üyelik Sözleşmesi checkbox'i isaretlenir
    And Üyeliği Tamamla butonuna tıklanır
    Then KVKK hata mesaji dogrulanir

  @gizlilikSozlesmesiTC19
  Scenario: Gizlilik sozlesmesi isaretlenip digerleri isaretlenmeyince uyelik kaydi
    Given Ana sayfaya gidilir
    When "Üye Ol / Giriş Yap" butonuna tıklanır
    And Bir telefon numarası girilir
    And "Giriş Yap" butonuna tıklanır
    And Ad, soyad, e-posta bilgileri girilir
    And KVKK Metni checkbox i isaretlenmez
    And Gizlilik Sözleşmesi  checkbox'i isaretlenir
    And Üyelik Sözleşmesi checkbox'i isaretlenmez
    And Üyeliği Tamamla butonuna tıklanır
    Then KVKK hata mesaji dogrulanir