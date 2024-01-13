@kisiselBilgiler
Feature: Kısısel bılgılerın kontrol edılmesı ve dogrulanması

  Scenario Outline: Kisisel bilgilerim ad alaninin duzenlenmesi
    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır
    And Kullanıcı hesabım butonuna tıklar.
    And Acılan dropdown menüden kişisel bilgilerime tıklar.
    Then Kişisel Bilgilerim'in  geldiğini dogrular.
    When Kullanıcı "<Ad_Soyad>" butonuna veri girer.
    Then Ad Soyad alani "<hata_mesajı>" görüntülenir
    Examples:
      | Ad_Soyad | hata_mesajı |
      | a | hata_mesajı |


  Scenario : Kisisel bilgilerim email alaninin duzenlenmesi

    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır
    And Kullanıcı hesabım butonuna tıklar.
    And Acılan dropdown menüden kişisel bilgilerime tıklar.
    Then Kişisel Bilgilerim'in  geldiğini dogrular.
    When Email de degisiklik yapar.
    Then Degisiklik yaptigini dogrular.


  Scenario:Kullanıcı ıletışım tercıhlerımden bırını seçebılmelı.

    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır
    And Kullanıcı hesabım butonuna tıklar.
    And Acılan dropdown menüden kişisel bilgilerime tıklar.
    Then Kişisel Bilgilerim'in  geldiğini dogrular.
    When İletişim tercıhlerımden E-Posta kutusunu işaretler
    And Kullanıcı kaydet butonuna tıklar.
    Then Iletisim tercihi dogrulamasini yapar.


