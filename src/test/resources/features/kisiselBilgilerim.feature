@kisiselBilgiler
Feature: Kısısel bılgılerın kontrol edılmesı ve dogrulanması
  Background:
    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır
    When Kullanıcı hesabım butonuna tıklar.
    And Acılan dropdown menüden kişisel bilgilerime tıklar.


  Scenario: Kisisel bilgilerim email alaninin duzenlenmesi
    Then Kişisel Bilgilerim'in  geldiğini dogrular.
    When Email de degisiklik yapar.
    Then Degisiklik yaptigini dogrular.


  Scenario:Kullanıcı ıletışım tercıhlerımden bırını seçebılmelı.
    Then Kişisel Bilgilerim'in  geldiğini dogrular.
    When İletişim tercıhlerımden E-Posta kutusunu işaretler
    And Kullanıcı kaydet butonuna tıklar.
    Then Iletisim tercihi dogrulamasini yapar.


  Scenario: Ad soyad alanı boş bırakıldığında uyarı mesaj almalı.
    Then Kişisel Bilgilerim'in  geldiğini dogrular.
    When Kullanici Ad soyad butonunu bos birakir
    Then Kullanici uyari mesaji almali

  Scenario Outline: Kisisel bilgilerim ad alaninin duzenlenmesi
    Then Kişisel Bilgilerim'in  geldiğini dogrular.
    When Kullanıcı "<Ad_Soyad>" butonuna veri girer.
    Then Ad Soyad alani "<hata_mesajı>" görüntülenir
    Examples:
      | Ad_Soyad | hata_mesajı |
      | a | Ad Soyad minimum 2, maksimum 30 karakter olması gerekiyor; girdiğiniz karekter sayısı 1. |

  Scenario: Ad soyad butonu 30 üstü karakter ile güncellendiğinde uyarı mesajı almalı.
    Then Kişisel Bilgilerim'in  geldiğini dogrular.
    When Kullanici Ad soyad butonuna sinirsiz karakter girer
    And Kullanıcı kaydet butonuna tıklar.
    Then Kullanici uyari mesajini almali


  Scenario: Email alanı boş bırakıldığında uyarı mesajı alınmalı
    Then Kişisel Bilgilerim'in  geldiğini dogrular.
    When Kullanici email alanini bos birakir
    Then Kullanici uyarı mesaji almalı


  Scenario: Email alanı format dışı bir mail ile güncellendiğinde uyarı mesajı alınmalı
    Then Kişisel Bilgilerim'in  geldiğini dogrular.
    When Kullanici format disi bir email girer
    Then Kullanici uyarı mesaji almalı


    Scenario: Kayıtlı adreslerin otomatik geldiği görülmeli.
      Given Kayitli adreslerin otomatik geldigini gorur.

    Scenario: Adres ekleyebilmeli
       Given Kullanici adres ekle butonuna tiklar.
       When  Kullanici adres sayfasinin geldigini dogrular.











