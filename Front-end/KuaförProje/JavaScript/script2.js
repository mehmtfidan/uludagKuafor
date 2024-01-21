$('#loginButton').on('click', function(event) {
    event.preventDefault(); // Formun doğrudan submit olmasını engeller

    var enteredUsername = $('#usernameInput').val();
    var enteredPassword = $('#passwordInput').val();

    var adminUsername = 'admin';
    var adminPassword = '123';

    // Admin girişi kontrolü
    if (enteredUsername === adminUsername && enteredPassword === adminPassword) {
        alert('Admin girişi başarılı!');
        $('#logInModal').modal('hide'); // Formun kapatılması
        window.open('adminsayfa.html', '_blank'); // Yeni sekmede adminsayfa.html açma
    } else {
        // Müşteri ve kuafor girişi kontrolü
        $.ajax({
            url: 'http://localhost:8080/api/musteri',
            type: 'GET',
            success: function(musteriResponse) {
                var isMusteri = musteriResponse.some(function(user) {
                    return user.kullanici_adi === enteredUsername && user.sifre === enteredPassword;
                });

                if (isMusteri) {
                    alert('Müşteri girişi başarılı!');
                    $('#logInModal').modal('hide'); // Formun kapatılması
                    window.open('musterisayfa3.html', '_blank'); // Yeni sekmede kuaforsayfa.html açma
                } else {
                    // Kuafor girişi kontrolü
                    $.ajax({
                        url: 'http://localhost:8080/api/kuaforler',
                        type: 'GET',
                        success: function(kuaforResponse) {
                            var isKuafor = kuaforResponse.some(function(user) {
                                return user.kullanici_adi === enteredUsername && user.sifre === enteredPassword;
                            });

                            if (isKuafor) {
                                alert('Kuaför girişi başarılı!');
                                $('#logInModal').modal('hide'); // Formun kapatılması
                                window.open('kuaforsayfa.html', '_blank'); // Yeni sekmede kuaforsayfa.html açma
                            } else {
                                alert('Kullanıcı bulunamadı veya şifre yanlış!');
                            }
                        },
                        error: function(kuaforError) {
                            console.error('Kuaförler API hatası:', kuaforError);
                        }
                    });
                }
            },
            error: function(musteriError) {
                console.error('Müşteriler API hatası:', musteriError);
            }
        });
    }
});
