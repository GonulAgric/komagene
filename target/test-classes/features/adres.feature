@Adres
Feature: Adres Bilgisi Ekleme

  Scenario Outline: Kullanıcı yeni adres bilgisi ekler
    Given Verilen kullanıcı üyelik girişi yapar
    When Ve kullanıcı "Hesabım" dropdown'ından "Adreslerim" seçeneğini seçer
    And kullanıcı "Yeni Adres Ekle" butonuna tıklar
    And O zaman bir pop-up penceresi açılır
    And Kullanici <baslik> butonunu doldurur.
    And Kullanici <adres Tipi> butonunu doldurur.
    And Kullanici <ad> butonunu doldurur.
    And Kullanici <soyad> butonunu doldurur.
    And Kullanici <telefon> butonunu doldurur.
    And Kullanici <il> butonunu doldurur.
    And Kullanici <ilce> butonunu doldurur.
    And Kullanici <mahalle> butonunu doldurur.
    And Kullanici <sokak> butonunu doldurur.
    And Adres bilgimi kaydet butonuna tıklar
    Then Eğer sube yoksa "Subemiz Yoktur" alerti görünmelidir

    Examples:
      | baslik       | adres Tipi | ad    | soyad | telefon  | il       | ilce    | mahalle | sokak     |
      | Örnek Adres  | Ev        | John  | Doe   | 555-5555 | İstanbul | Beşiktaş | Levent  | Örnek Sokak |


@negativeadres
  Scenario: Kullanıcı tüm butonları boş bıraktığında hata mesajı görünmelidir (Olumsuz Senaryo)
    Given Verilen kullanıcı üyelik girişi yapar
    When Ve kullanıcı "Hesabım" dropdown'ından "Adreslerim" seçeneğini seçer
    And kullanıcı "Yeni Adres Ekle" butonuna tıklar
    And O zaman bir pop-up penceresi açılır
    And Kullanici tüm butonları boş bırakır
    And Adres bilgimi kaydet butonuna tıklar
    Then "Zorunlu alanları doldurun" hata mesajı görünmelidir



