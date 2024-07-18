@kampanyalar
Feature: Kampanyalar

  Background:
    Given Ana sayfaya gidilir

  Scenario:  Kampanyaların resimleri ve başlıkları görüntülenmeli
    When Anasayfada kampanyalarin goruntulendigini dogrular.

  Scenario: Kampanya detayları görüntülenmeli.
    When Kullanici ana sayfada herhangi bir kampanyaya tiklar.
    Then Detaylarin goruntulendigini dogrular.

  Scenario: Kampanyalı ürün sepete eklenebilmeli.
    When Kullanici ana sayfada herhangi bir kampanyaya tiklar.
    And  Sepete ekle butonuna tiklar.
    And  Urun opsiyonlarini secer.
    Then Urunun sepete eklendigini dogrular.

    Scenario:
    When Kullanıcı ana sayfada herhangi bir kampanyaya tıklar.
    And  Kullanıcı opsiyonları seçer.
    And  Sepete ekle butonuna tıklar.
    And  Sepette teslimat türünü değiştirir.
    Then Değişen teslimat türü ile birlikte fiyatın değiştiğini doğrular


