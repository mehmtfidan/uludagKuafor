$(document).ready(function () {
    window.saatleriGuncelle = function () {
        var baslangicSaati = $('#baslangicSaati').val();
        var bitisSaati = $('#bitisSaati').val();

        if (confirm("Çalışma saatlerini güncellemek istediğinizden emin misiniz?")) {
            $.ajax({
                url: 'http://localhost:8080/api/kuafor/1',
                method: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    baslangic_saati: baslangicSaati,
                    bitis_saati: bitisSaati
                }),
                success: function (response) {
                    tabloyuGuncelle(); // Güncelleme başarılıysa tabloyu güncelle
                },
                error: function (err) {
                    console.error('Hata:', err);
                }
            });
        }
    }

    function tabloyuGuncelle() {
        $('#saatlerTablosuBody').empty(); // Tabloyu temizle

        $.ajax({
            url: 'http://localhost:8080/api/kuafor/1',
            method: 'GET',
            success: function (response) {
                var newRow = `
                    <tr>
                        <td>${response.baslangic_saati}</td>
                        <td>${response.bitis_saati}</td>
                    </tr>
                `;
                $('#saatlerTablosuBody').append(newRow); // Yeni verileri tabloya ekle
            },
            error: function (err) {
                console.error('Hata:', err);
            }
        });
    }

    function tabloyuGuncelle1() {
        $('#randevuTablosu tbody').empty();

        $.ajax({
            url: 'http://localhost:8080/api/kuafor/randevular/1',
            method: 'GET',
            success: function (randevular) {
                console.log('Randevular:', randevular);

                for (const randevu of randevular) {
                    const formattedGunu = new Date(randevu.randevuGunu).toLocaleDateString('tr-TR');
                    const formattedSaati = new Date(`1970-01-01T${randevu.randevuSaati}Z`).toLocaleTimeString('tr-TR');

                    var newRow = `
                        <tr>
                            <td>${randevu.musteri.ad}</td>
                            <td>${randevu.musteri.soyad}</td>
                            <td>${randevu.hizmetler}</td>
                            <td>${formattedGunu}</td>
                            <td>${formattedSaati}</td>
                            <td>${randevu.musteriNotu}</td>
                            <td>${randevu.randevuDurumu}</td>
                            <td>
                                <button class="btn btn-primary btn-goruntule" data-randevu-id="${randevu.id}">Görüntüle</button>
                                <button class="btn btn-success btn-onayla" data-randevu-id="${randevu.id}">Onayla</button>
                                <button class="btn btn-danger btn-reddet" data-randevu-id="${randevu.id}">Reddet</button>
                            </td>
                        </tr>
                    `;
                    $('#randevuTablosu tbody').append(newRow);
                }
            },
            error: function (err) {
                console.error('Randevu Bilgileri Getirilemedi:', err);
            }
        });
    }

    // Çalışma saatlerini dropdown listesine yükleme fonksiyonu
    function calismaSaatleriniYukle() {
        $.ajax({
            url: 'http://localhost:8080/api/kuafor/mesai/1',
            method: 'GET',
            success: function(response) {
                // Başlangıç ve bitiş saatlerini alarak dropdown listesini doldur
                var baslangicSaat = response.baslangic_saati;
                var bitisSaat = response.bitis_saati;

                // Örnek olarak basit bir dropdown listesi oluşturuldu, ihtiyaca göre düzenleyebilirsiniz
                var dropdownList = $('#kuaforSelect');
                dropdownList.empty();
                for (var i = baslangicSaat; i <= bitisSaat; i++) {
                    var option = $('<option>', { value: i, text: i });
                    dropdownList.append(option);
                }
            },
            error: function(err) {
                console.error('Hata:', err);
            }
        });
    }

    // Görüntüle butonlarına tıklama işlevi
    $(document).on('click', '.btn-goruntule', function() {
        const row = $(this).closest('tr');
        const ad = row.find('td:eq(0)').text();
        const soyad = row.find('td:eq(1)').text();
        const islem = row.find('td:eq(2)').text();
        const gun = row.find('td:eq(3)').text();
        const saat = row.find('td:eq(4)').text();
        const not = row.find('td:eq(5)').text();
        const randevuDurumu = row.find('td:eq(6)').text();

        $('#ad').val(ad);
        $('#soyad').val(soyad);
        $('#islem').val(islem);
        $('#gun').val(gun);
        $('#saat').val(saat);
        $('#not').val(not);
        $('#randevuDurumu').val(randevuDurumu);

        $('#randevuDetaylari').show();
    });

 // "Onayla" butonuna tıklanma işlevi
 $(document).on('click', '.btn-onayla', function () {
    const row = $(this).closest('tr');
    const randevuId = row.find('.btn-goruntule').data('randevu-id');
    const randevuDurumuCell = row.find('td:eq(6)');

    // Önce kullanıcıya onayını alalım
    if (confirm("Randevuyu onaylamak istediğinizden emin misiniz?")) {
        // Kullanıcı onayladıysa, onaylama işlemini gerçekleştir
        $.ajax({
            url: `http://localhost:8080/api/kuafor/durum/${randevuId}`,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify({
                randevuDurumu: 'Onaylandı'
            }),
            success: function (response) {
                console.log('Randevu onaylandı:', response);
                randevuDurumuCell.text('Onaylandı'); // Tablodaki hücreyi güncelle
            },
            error: function (err) {
                console.error('Hata:', err);
                // Hata durumunda konsola hatayı yazdır
                alert('Randevu onaylama işlemi sırasında bir hata oluştu. Lütfen konsolu kontrol edin.');
            }
        });
    } else {
        // Kullanıcı onaylamazsa ve randevuDurumu null ise, hücreye "Beklemede" değerini atayın
        if (randevuDurumuCell.text().trim() === '') {
            randevuDurumuCell.text('Beklemede'); // Tablodaki hücreyi güncelle
        }
    }
});

// "Reddet" butonuna tıklanma işlevi
$(document).on('click', '.btn-reddet', function () {
    const row = $(this).closest('tr');
    const randevuId = row.find('.btn-goruntule').data('randevu-id');

    // AJAX isteği ile randevu durumu güncelleniyor
    $.ajax({
        url: `http://localhost:8080/api/kuafor/durum/${randevuId}`,
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({
            randevuDurumu: 'Reddedildi'
        }),
        success: function (data) {
            console.log('Randevu Reddedildi');
        },
        error: function (error) {
            console.error('Randevu Reddetme Hatası:', error);
        }
    });
});
    tabloyuGuncelle();
    tabloyuGuncelle1();
});
