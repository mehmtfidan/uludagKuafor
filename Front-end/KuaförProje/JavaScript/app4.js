$(document).ready(function() {
    $('#kullaniciAdiGuncelleButton').on('click', function() {
        var eskiKullaniciAdi = $('#eskiKullaniciAdiInput').val();
        var yeniKullaniciAdi = $('#yeniKullaniciAdiInput').val();
        var eskiSifre = $('#eskiSifreInput').val();

        // Müşteri API'sinden eski kullanıcı bilgilerini kontrol etme
        $.ajax({
            url: 'http://localhost:8080/api/musteri',
            type: 'GET',
            success: function(response) {
                var isBilgilerDogru = response.some(function(user) {
                    return user.kullanici_adi === eskiKullaniciAdi && user.sifre === eskiSifre;
                });

                if (isBilgilerDogru) {
                    // Eski bilgiler doğruysa yeni kullanıcı adını kaydet
                    $.ajax({
                        url: 'http://localhost:8080/api/musteri/' + eskiKullaniciAdi,
                        method: 'PUT',
                        contentType: 'application/json',
                        data: JSON.stringify({
                            kullanici_adi: yeniKullaniciAdi,
                            sifre: eskiSifre // Eski şifre aynen kalacak
                        }),
                        success: function(updateResponse) {
                            alert('Kullanıcı adı başarıyla güncellendi!');
                        },
                        error: function(updateError) {
                            console.error('Güncelleme hatası:', updateError);
                        }
                    });
                } else {
                    alert('Eski kullanıcı adı veya şifre hatalı!');
                }
            },
            error: function(error) {
                console.error('API hatası:', error);
            }
        });
    });

    $('#sifreGuncelleButton').on('click', function() {
        var eskiKullaniciAdi = $('#eskiKullaniciAdiInput').val();
        var yeniSifre = $('#yeniSifreInput').val();
        var eskiSifre = $('#eskiSifreInput').val();

        // Müşteri API'sinden eski kullanıcı bilgilerini kontrol etme
        $.ajax({
            url: 'http://localhost:8080/api/musteri',
            type: 'GET',
            success: function(response) {
                var isBilgilerDogru = response.some(function(user) {
                    return user.kullanici_adi === eskiKullaniciAdi && user.sifre === eskiSifre;
                });

                if (isBilgilerDogru) {
                    // Eski bilgiler doğruysa yeni şifreyi kaydet
                    $.ajax({
                        url: 'http://localhost:8080/api/musteri/' + eskiKullaniciAdi,
                        method: 'PUT',
                        contentType: 'application/json',
                        data: JSON.stringify({
                            kullanici_adi: eskiKullaniciAdi, // Eski kullanıcı adı aynen kalacak
                            sifre: yeniSifre
                        }),
                        success: function(updateResponse) {
                            alert('Şifre başarıyla güncellendi!');
                        },
                        error: function(updateError) {
                            console.error('Güncelleme hatası:', updateError);
                        }
                    });
                } else {
                    alert('Eski kullanıcı adı veya şifre hatalı!');
                }
            },
            error: function(error) {
                console.error('API hatası:', error);
            }
        });
    });
});
