@Adres
Feature: Adres Bilgisi Ekleme
  Background:
    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır
    Given Kullanici hesabim butonuna tiklar.
    When Acilan dropdown menuden adreslerime tiklar.
    And  Kullanici Yeni Adres Ekle butonuna tiklar


  Scenario: : Kullanıcı yeni adres bilgisi ekler
    And  Kullanici baslik butonunu doldurur.
    And  Kullanici adres tipi butonunu doldurur.
    When Kullanici ad  butonunu doldurur.
    And  Kullanici soyad butonunu doldurur.
    And  Kullanici telefon alanini doldurur.
    And  Kullanici il secer.
    And  Kullanici ilce secer.
    And  Kullanici mahalle secer.
    And  Kullanici sokak secer.
    And  Kullanici bina no alanini doldurur.
    And  Kullanici kat alanini doldurur.
    And  Kullanici daire no alanini doldurur.
    And  Kullanici Adres bilgimi kaydet butonuna tıklar
    Then Kullanici yeni adresin listelendigini dogrular.


Scenario: Başlık alanı boş bırakıldığında hata mesajı alınmalı.
   And  Başlik alanini boş birakir.
   Then Kullanici uyari mesaji almali.

  Scenario: Kullanıcı kayıtlı adresi silebilmeli.
 Given Kullanici sil butonuna tiklar.



Scenario: Adres tipi alanı boş bırakıldığında hata mesajı alınmalı.
  And  Kullanici baslik butonunu doldurur.
  And  Adres tipi alanini boş birakir.
  When Kullanici ad  butonunu doldurur.
  And  Kullanici soyad butonunu doldurur.
  And  Kullanici telefon alanini doldurur.
  And  Kullanici il secer.
  And  Kullanici ilce secer.
  And  Kullanici mahalle secer.
  And  Kullanici sokak secer.
  And  Kullanici bina no alanini doldurur.
  And  Kullanici kat alanini doldurur.
  And  Kullanici daire no alanini doldurur.
  And  Kullanici Adres bilgimi kaydet butonuna tıklar
  Then Kullanici uyari mesaji alir.


  Scenario: Kullanıcı kayıtlı adresi güncelleyebilmeli.

    Given Kullanici test baslikli adresin duzenle butonuna tiklar.
    When  Bilgilerde degişiklik yapar.
    And   Adres bilgimi kaydet butonuna basar.



  Scenario Outline: Ad alanina geçersiz veriler girildiğinde hata mesajı alınmalı
  Given Ad butonuna "<gecersiz_veri>" girilir
  Then  Ve "<hata_mesaji>" görüntülenir
  Examples:
    | gecersiz_veri             | hata_mesaji |
    |                           | Ad alanına özel karakter girmeyiniz. |
    |      ?                    | Ad alanına özel karakter girmeyiniz. |
    |      a                    | Ad minimum 2, maksimum 15 karakter olması gerekiyor; girdiğiniz karekter sayısı 1. |
    |  onbeskarakterustu        |                                                                                    |



  Scenario Outline: Soyad alanina geçersiz veriler girildiğinde hata mesajı alınmalı
    Given Soyad butonuna "<gecersiz_veri>" girilir
    Then  Ve soyad "<hata_mesaji>" görüntülenir
    Examples:
      | gecersiz_veri             | hata_mesaji |
      |                           | Soyad alanına özel karakter girmeyiniz. |
      |      ?                    | Soyad alanına özel karakter girmeyiniz. |
      |      a                    | Soyad minimum 2, maksimum 15 karakter olması gerekiyor; girdiğiniz karekter sayısı 1. |
      |  onbeskarakterustu        |                                                                                       |



  Scenario Outline: Telefon alanina geçersiz veriler girildiğinde hata mesajı alınmalı
    Given Telefon butonuna "<gecersiz_veri>" girilir
    Then  Ve telefon alani "<hata_mesaji>" görüntülenir
    Examples:
      | gecersiz_veri             | hata_mesaji |
      |                           | Telefon alanı 10 karekter olması gerekiyor.Karakter sayısı:3 |
      |      5555                 | Soyad alanına özel karakter girmeyiniz. |
      |      5555555555555        |                                          |




  Scenario Outline: Bina No alanina geçersiz veriler girildiğinde hata mesajı alınmalı
    Given Bina No butonuna "<gecersiz_veri>" girilir
    Then  bina no"<hata_mesaji>" goruntulenir.
    Examples:
      | gecersiz_veri             | hata_mesaji |
      |                           | Bina No alanına sadece numara,harf veya "-" ve "/" karakteri girebilirsiniz. |
      |      ?                    | Bina No alanına sadece numara,harf veya "-" ve "/" karakteri girebilirsiniz. |
      |      5555555555555        | Bina No alanı maksimum 6 karekter olması gerekiyor                                       |










