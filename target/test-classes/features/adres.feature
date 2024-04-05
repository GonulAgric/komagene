@Adres
Feature: Adres Bilgisi Ekleme

Background:
  Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır
    And Kullanici hesabim butonuna tiklar.
    When Acilan dropdown menuden adreslerime tiklar.
  @aaaa
  Scenario: : Kullanıcı yeni adres bilgisi ekler
    And  Kullanici Yeni Adres Ekle butonuna tiklar
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
    And sayfa kapatılır


Scenario: Başlık alanı boş bırakıldığında hata mesajı alınmalı.
  And  Kullanici Yeni Adres Ekle butonuna tiklar
   And  Başlik alanini boş birakir.
   Then Kullanici uyari mesaji almali.
   And sayfa kapatılır

  Scenario: Kullanıcı kayıtlı adresi silebilmeli.
    Given Kullanici sil butonuna tiklar.
    And sayfa kapatılır



Scenario: Adres tipi alanı boş bırakıldığında hata mesajı alınmalı.
  And  Kullanici Yeni Adres Ekle butonuna tiklar
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
  And sayfa kapatılır

  Scenario: Kullanıcı kayıtlı adresi güncelleyebilmeli.
    Given Kullanici test baslikli adresin duzenle butonuna tiklar.
    When  Bilgilerde degişiklik yapar.
    And   Adres bilgimi kaydet butonuna basar.
    And sayfa kapatılır


  Scenario:Ad alanina geçersiz veriler girildiğinde hata mesajı alınmalı
    And  Kullanici Yeni Adres Ekle butonuna tiklar
    Then Ad butonuna gecersiz veri girilir ve hata mesaji alinir.
    And sayfa kapatılır

  Scenario: Soyad alanina geçersiz veriler girildiğinde hata mesajı alınmalı
  And  Kullanici Yeni Adres Ekle butonuna tiklar
  Then Soyad butonuna gecersiz veri girilir ve hata mesaji alinir.
  And sayfa kapatılır

  Scenario: Telefon alanina geçersiz veriler girildiğinde hata mesajı alınmalı
    And  Kullanici Yeni Adres Ekle butonuna tiklar
    Then Telefon butonuna gecersiz veri girilir ve hata mesaji alinir.
    And sayfa kapatılır


  Scenario: Bina No alanina geçersiz veriler girildiğinde hata mesajı alınmalı
    And  Kullanici Yeni Adres Ekle butonuna tiklar
    Then Bina no butonuna gecersiz veri girilir ve hata mesaji alinir.
    And sayfa kapatılır








