$(document).ready(function () {
    // Sayfa yüklendiğinde çalışacak kodlar
    // Ad ve soyadı müşteri API'sinden getir
    $.ajax({
        url: "http://localhost:8080/api/musteri/1", // Müşteri API endpoint'i
        method: "GET",
        success: function (data) {
            // API'den gelen veriyi ad ve soyad alanlarına yerleştir
            $("#name").val(data.ad);
            $("#surname").val(data.soyad);
        },
        error: function (error) {
            console.log("Müşteri bilgileri getirilirken hata oluştu: ", error);
        }
    });

    // Kuaförleri getir
    $.ajax({
        url: "http://localhost:8080/api/kuaforler", // Kuaförler API endpoint'i
        method: "GET",
        success: function (data) {
            // API'den gelen veriyi kuaför seçimi dropdown listesine ekle
            var kuaforSelect = $("#kuaforSelect");
            kuaforSelect.empty(); // Dropdown listesini temizle

            // Option elemanlarını ekleyerek dropdown listesini doldur
            $.each(data, function (index, kuafor) {
                kuaforSelect.append('<option value="' + kuafor.id + '">' + kuafor.ad + '</option>');
            });
        },
        error: function (error) {
            console.log("Kuaför bilgileri getirilirken hata oluştu: ", error);
        }
    });

    // Kuaför mesai saatlerini getir
    $("#kuaforSelect").on("change", function () {
        var selectedKuaforId = $(this).val();

        // Kuaförün çalışma saatlerini getir
        $.ajax({
            url: "http://localhost:8080/api/kuafor/mesai/" + selectedKuaforId,
            method: "GET",
            success: function (mesaiSaatleri) {
                // Mesai saatlerini kullanarak randevu saatleri dropdown listesini güncelle
                updateRandevuSaatiDropdown(mesaiSaatleri);
            },
            error: function (error) {
                console.log("Kuaför mesai saatleri getirilirken hata oluştu: ", error);
            }
        });
    });

    function updateRandevuSaatiDropdown(mesaiSaatleri) {
        var randevuSaatiSelect = $("#randevuSaati");
        randevuSaatiSelect.empty(); // Dropdown listesini temizle

        // Mesai saatlerini kullanarak uygun randevu saatlerini oluştur
        // Bu örnekte basit bir şekilde, mesai saatlerini aynen randevu saatleri olarak ekliyorum.
        // Gerçek uygulamada iş mantığınıza göre güncellemeniz gerekebilir.
        $.each(mesaiSaatleri, function (index, mesaiSaati) {
            randevuSaatiSelect.append('<option value="' + mesaiSaati + '">' + mesaiSaati + '</option>');
        });
    }

    // Randevu Al butonuna tıklandığında çalışacak kod
    $("#randevuOlusturButton").on("click", function () {
        var selectedKuaforId = $("#kuaforSelect").val();
        var selectedHizmetId = $("#hizmetSelect").val();
        var selectedRandevuGunu = $("#randevuGunu").val();
        var selectedRandevuSaati = $("#randevuSaati").val();
        var note = $("#textAreaExample1").val();

        // Tarih değerini düzelt
        var formattedRandevuGunu = formatDate(selectedRandevuGunu);

        // Kullanıcıya randevu oluşturmak isteyip istemediğini sormak için confirm dialogu göster
        var confirmResult = confirm("Randevu oluşturmak istiyor musunuz?");
        if (confirmResult) {
            // Kullanıcı "Evet" seçeneğini seçtiyse, randevu oluşturma işlemini gerçekleştir

            // Hizmet bilgisini al
            var selectedHizmetText = $("#hizmetSelect option:selected").text();

            $.ajax({
                url: "http://localhost:8080/api/randevu",
                method: "POST",
                contentType: "application/json",
                data: JSON.stringify({
                    musteriId: 1, // Örnek müşteri ID
                    kuaforId: selectedKuaforId,
                    hizmetId: selectedHizmetId,
                    randevuGunu: formattedRandevuGunu,
                    randevuSaati: selectedRandevuSaati,
                    musteriNotu: note,
                    hizmetler: selectedHizmetText // Seçilen hizmetin adını API'ye ekleyin
                }),
                success: function (response) {
                    // Randevu başarıyla oluşturulduğunda alert göster
                    alert("Randevu başarıyla oluşturuldu!");
                    console.log("Randevu başarıyla oluşturuldu: ", response);
                    // İsteğe bağlı olarak başarılı bir şekilde randevu oluşturulduğuna dair bir mesaj gösterilebilir
                },
                error: function (error) {
                    console.log("Randevu oluşturulurken hata oluştu: ", error);
                    // İsteğe bağlı olarak hata durumunda kullanıcıya bir hata mesajı gösterilebilir
                }
            });
        } else {
            // Kullanıcı "Hayır" seçeneğini seçtiyse, işlemi iptal et
            console.log("Randevu oluşturma işlemi iptal edildi.");
        }
    });

    // Tarih formatını düzeltme fonksiyonu
    function formatDate(dateString) {
        var parts = dateString.split("-");
        return parts[2] + "-" + parts[1] + "-" + parts[0];
    }
});
