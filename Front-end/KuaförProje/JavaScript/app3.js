$('#loginButton').on('click', function(event) {
    event.preventDefault(); // Formun doğrudan submit olmasını engeller

    var enteredUsername = $('#usernameInput').val();
    var enteredPassword = $('#passwordInput').val();

    // Müşteri girişi kontrolü
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
                window.open('randevualma.html', '_blank'); // Yeni sekmede randevualma.html açma
            } else {
                alert('Kullanıcı bulunamadı veya şifre yanlış!');
            }
        },
        error: function(musteriError) {
            console.error('Müşteriler API hatası:', musteriError);
        }
    });
});
