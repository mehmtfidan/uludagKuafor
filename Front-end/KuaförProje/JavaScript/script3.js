$('#kayitButton').on('click', function(e) {
    e.preventDefault();

    var ad = $('#name').val();
    var soyad = $('#surname').val();
    var kullaniciAdi = $('#username').val();
    var sifre = $('#password').val();

    if (ad === '' || soyad === '' || kullaniciAdi === '' || sifre === '') {
        alert('Lütfen tüm alanları doldurun.');
    } else {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/musteri',
            contentType: 'application/json',
            data: JSON.stringify({
                ad: ad,
                soyad: soyad,
                kullanici_adi: kullaniciAdi,
                sifre: sifre
            }),
            success: function(response) {
                console.log('Kayıt başarıyla tamamlandı:', response);
                alert('Kayıt işleminiz başarıyla gerçekleşti!');
                $('#name').val('');
                $('#surname').val('');
                $('#username').val('');
                $('#password').val('');
            },
            error: function(error) {
                console.error('Kayıt sırasında hata oluştu:', error);
            }
        });
    }
});
