@anaSayfa
Feature: Anasayfa
  Background:
    Given Ana sayfaya gidilir


  Scenario:  Ana Sayfada Kampanya  Kartlari Goruntulenmeli

    And  Kullanici ana sayfada kampanya kartlarinin görüntülendigini dogrular.
    When Kullanici herhangi bir kampanyaya tiklar.
    Then Kullanici ilgili kampanya sayfasina yonlendirilip yonlendirilmedigini dorular.

  Scenario:  Ana Sayfada Kategori  Kartları Görüntülenmeli
   Given Kullanici ana sayfada kategori kartlarinin  goruntulendigini dogrular.
   And  Kullanici herhangi bir kategori kartina tiklar.
   Then Kullanici ilgili kategorilere yonlendirilip yonlendirilmedigini dogrular.

  Scenario: Ana sayfada mobil uygulama ve sosyal medya ikonları görüntülenebilmeli,tıklanabilir olmalı.
  When Kullanici ana sayfada  mobil uygulama ikonlarının goruntulendigini dogrular.
  When Kullanici AppStore ikonuna tiklar.
  Then Kullanici ilgili sayfaya yonlendirilip yonlendirilmedigini dogrular.
  When Kullanici GooglePlay ikonuna tiklar.
  Then Kullanici GooglePlay sayfasina yonlendirilip yonlendirilmedigini dogrular.
  And  Kullanici AppGallery ikonuna tiklar.
  Then Kullanici AppGallery sayfasina yonlendirilip yonlendirilmedigini dogrular.
  When Kullanici Instagram ikonuna tiklar.
  Then Kullanici Instagram sayfasina yonlendirilip yonlendirilmedigini dogrular.
  And  Kullanici Twitter ikonuna tiklar.
  Then Kullanici Twitter sayfasina yonlendirilip yonlendirilmedigini dogrular.
  And  Kullanici Youtube ikonuna tiklar.
  Then Kullanici YouTube sayfasina yonlendirilip yonlendirilmedigini dogrular.
  And  Kullanici Facebook ikonuna tiklar.
  Then Kullanici Facebook sayfasina yonlendirilip yonlendirilmedigini dogrular.

    Scenario: Ana sayfada kurumsal sayfalar tıklanabilir olmalı
      When Kullanici ana sayfada kurumsal sayfalarin goruntulendigini dogrular.
      And Kullanici Gizlilik Sözleşmesi sekmesine tiklar.
      Then Kullanici Gizlilik Sözleşmesine yonlendirilip yonlendirilmedigini dogrular.
      When Kullanici Hakkimizda sekmesine tiklar.
      Then Kullanici Hakkimizda sekmesine yonlendirilip yonlendirilmedigini dogrular.
      And  Kullanici Sertifikalar sekmesine tiklar.
      Then Kullanici Sertifikalar sekmasine yonlendirilip yonlendirilmedigini dogrular.
      When Kullanici Kvkk Bilgilendirme Metni sekmesine tiklar.
      Then Kullanici Kvkk Bilgilendirme Metni sekmesine yonlendirilip yonlendirilmedigini dogrular.
      And  Kullanici Mesafeli Satis Sozlesmesi sekmesine tiklar.
      Then Kullanici Mesafeli Satis Sozlesmesi sekmesine yonlendirilip yonlendirilmedigini dogrular.
      And  Kullanici Uyelik kosullari sekmesine tiklar.
      Then Kullanici Uyelik kosullari sekmesine yonlendirilip yonlendirilmedigini dogrular.
      And  Kullanici Insan Kaynaklari sekmesine tiklar.
      Then Kullanici Insan Kaynaklari sekmesine yonlendirilip yonlendirilmedigini dogrular.
      And  Kullanici Franchise sekmesine tiklar.
      Then Kullanici Franchise sekmesine sekmesine yonlendirilip yonlendirilmedigini dogrular.
      And  Kullanici Iletisim sekmesine tiklar.
      Then Kullanici Iletisim sekmesine sekmesine yonlendirilip yonlendirilmedigini dogrular.


  Scenario: Gecerli verilerle Iletisim Formu doldurulabilmeli
    Given Kullanici anasayfada  iletisim sekmesine tiklar.
    When Acılan sayfada istek ve oneri formunun zorunlu alanlarina valid degerler girer.
    And Kvkk bilgi formunu okudum onayliyorum kutucugunu isaretler.
    And Acik riza metnini okudum onayliyorum kutucugunu isaretler.
    And Kullanici formu gonder butonuna tiklar.
    Then Formu gonderdigine dair bilgilendirme mesajı alir.

  Scenario Outline: Ad alanina girilen gecersiz verilerle iletisim formunu gönderme
    Given Kullanici anasayfada  iletisim sekmesine tiklar.
    When Ad alanina "<gecersiz_veri>" girilir.
    Then "<hata_mesaji>" goruntulenir

    Examples:
      | gecersiz_veri          | hata_mesaji                                               |
      |                        | Ad alanına özel karakter girmeyiniz.                     |
      | a                      | Ad minimum 2, maksimum 15 karakter olması gerekiyor; girdiğiniz karekter sayısı 1. |
      | aaaaaaaaaaaaaaaa       |                                                                                          |
      | ?                      | Ad alanına özel karakter girmeyiniz.                                                     |

  Scenario Outline: Soyad alanina girilen gecersiz verilerle iletisim formunu gönderme
    Given Kullanici anasayfada  iletisim sekmesine tiklar.
    When  Soyad alanina "<gecersiz_veri>" girilir.
    Then  Soyad alaninda "<hata_mesaji>" goruntulenir

    Examples:
      | gecersiz_veri          | hata_mesaji                                               |
      |                        | Soyad alanına özel karakter girmeyiniz.                     |
      | a                      | Soyad minimum 2, maksimum 15 karakter olması gerekiyor; girdiğiniz karekter sayısı 1. |
      | aaaaaaaaaaaaaaaa       |                                                                                          |
      | ?                      | Soyad alanına özel karakter girmeyiniz.                                                     |


  Scenario Outline: Telefon alanina girilen gecersiz verilerle iletisim formunu gönderme
    Given Kullanici anasayfada  iletisim sekmesine tiklar.
    When  Telefon alanina "<gecersiz_veri>" girilir.
    Then  Telefon alaninda "<hata_mesaji>" goruntulenir

    Examples:
      | gecersiz_veri          | hata_mesaji                                                  |
      |                        | Telefon alanına numara giriniz.                              |
      | 546112761              | Telefon alanı 10 karekter olması gerekiyor.Karakter sayısı:9 |
      | 55566622277788         |                                                                                          |



  Scenario Outline: Email alanina girilen gecersiz verilerle iletisim formunu gönderme
    Given Kullanici anasayfada  iletisim sekmesine tiklar.
    When  Email alanina "<gecersiz_veri>" girilir.
    Then  Email alaninda "<hata_mesaji>" goruntulenir

    Examples:
      | gecersiz_veri          | hata_mesaji                                    |
      |                        | Email alanına geçerli bir email adresi giriniz |
      |  agric.gnl             | Email alanına geçerli bir email adresi giriniz |


Scenario: Ana sayfada kurumsal sayfalar( iletişim)formunda yeni bir ülke seçerek başvuru yapabilmeli.
  Given Kullanici anasayfada  iletisim sekmesine tiklar.
  When Adiniz Soyadiniz alanina gecerli veri girer.
  And  Email alanina gecerli veri girer.
  And  Cep Telefonu alanina gecerli veri girer.
  And  Ulke alanini degistirir.
  And  Il alanina veri girer.
  And  Ilce alanina veri girer.
  And  Konu alanina veri girer.
  And  Aciklama alanina veri girer
  And Kvkk bilgi formunu okudum onayliyorum kutucugunu isaretler.
  And Acik riza metnini okudum onayliyorum kutucugunu isaretler.
  And Kullanici formu gonder butonuna tiklar.
  Then Formu gonderdigine dair bilgilendirme mesajı alir.

  Scenario: Ana sayfada kurumsal sayfalar, insan kaynaklarında kariyer.net ve LinkedIn logolari tiklanabilir olmali
    Given Kullanici anasayfada  iletisim sekmesine tiklar.
    And  Kullanici Insan Kaynaklari sekmesine tiklar.
    When Kariyer.net logosuna tiklar.
    And  Kariyer.net sayfasina yonlendirilir.
    When Linked In logosuna tiklar.
    And  Linked In sayfasina yonlendirilir.


Scenario: Ana sayfadaki banner görüntülenebilir,tiklanabilir olmalı.
    Given Anasayfada banner  goruntulenir
    When  Banner kaydirilabilir
    Then  Banner tiklanabilir ve ilgili sayfaya yonlendirilir








