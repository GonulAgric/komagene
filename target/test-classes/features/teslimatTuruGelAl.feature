@tesliamatTuruGelAl
Feature: Teslimat Turu

  Background:
    Given Ana sayfaya gidilir
    When Üye Ol Giriş Yap butonuna tıklanır
    And Telefon numarası girilir
    And Gelen dogrulama kodu girilir
    And Giriş Yap butonuna tıklanır

  Scenario: Kullanici teslimat turu olarak GEL AL secebilmeli
    Given Kullanici sayfanin sol üst kösesindeki  teslimat turune tiklar.
    When Acilan sayfada Gel Al servis secenegine tiklar.
    And Secili teslimat turu ile devam et butonuna tiklar.


  Scenario: Seçilen adrese yakın subeler listelenmeli.
    Given Kullanici sayfanin sol üst kösesindeki  teslimat turune tiklar.
    When Acilan sayfada Gel Al servis secenegine tiklar.
    And  Secili teslimat turu ile devam et butonuna tiklar.
    And  Adres seçer.
    Then Seçilen adrese yakın şubelerin listelendiğini doğrular.

  Scenario: Şubelerin açık/kapalı durumu görüntülenmeli.
    Given Kullanici sayfanin sol üst kösesindeki  teslimat turune tiklar.
    When Acilan sayfada Gel Al servis secenegine tiklar.
    And  Secili teslimat turu ile devam et butonuna tiklar.
    And  Adres seçer.
    Then Subelerin acik kapali durumunun goruntulendigini dogrular.

  Scenario: Seçilen şube kapalı ise alert vermeli.
    Given Kullanici sayfanin sol üst kösesindeki  teslimat turune tiklar.
    When Acilan sayfada Gel Al servis secenegine tiklar.
    And  Secili teslimat turu ile devam et butonuna tiklar.
    And  Adres seçer.
    And  Kapali bir sube secer.
    And  Secili adresle devam et butonuna tiklar.
    Then Secilen sube kapali ise alert verdigini dogrular

