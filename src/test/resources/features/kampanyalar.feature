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



