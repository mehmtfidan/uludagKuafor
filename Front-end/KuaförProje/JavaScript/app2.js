$(document).ready(function() {
  const baseUrl = 'http://localhost:8080/api/kuaforler';

  // Kuaforleri listeleme
  function listKuaforler() {
    $.ajax({
      url: baseUrl,
      method: 'GET',
      success: function(response) {
        $('#kuaforBody').empty(); // Tabloyu temizle
        response.forEach(function(kuafor) {
          $('#kuaforBody').append(`
            <tr data-id="${kuafor.id}">
              <td>${kuafor.id}</td>
              <td>${kuafor.ad}</td>
              <td>${kuafor.soyad}</td>
              <td>${kuafor.kullanici_adi}</td>
              <td>
                <button class="deleteButton" data-id="${kuafor.id}">Sil</button>
                <button class="editButton" data-id="${kuafor.id}">Düzenle</button>
              </td>
            </tr>
          `);
        });
      },
      error: function(error) {
        console.error('Veri getirme hatası:', error);
      }
    });
  }

  // Sayfa yüklendiğinde kuaforleri listele
  listKuaforler();

  // Yeni kuafor ekleme
  $('#addForm').submit(function(event) {
    event.preventDefault();
    const ad = $('#name').val();
    const soyad = $('#surname').val();
    const kullaniciAdi = $('#username').val();
    const sifre = $('#password').val();
    const newKuafor = {
      ad: ad,
      soyad: soyad,
      kullanici_adi: kullaniciAdi,
      sifre: sifre
    };

    $.ajax({
      url: baseUrl,
      method: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(newKuafor),
      success: function(response) {
        console.log('Ekleme başarılı:', response);
        listKuaforler(); // Yeniden listele
        $('#addForm')[0].reset(); // Formu temizle
      },
      error: function(error) {
        console.error('Ekleme hatası:', error);
      }
    });
  });

  // Kuafor silme
  $(document).on('click', '.deleteButton', function() {
    const id = $(this).data('id');
    $.ajax({
      url: `${baseUrl}/${id}`,
      method: 'DELETE',
      success: function() {
        console.log('Silme başarılı');
        listKuaforler(); // Yeniden listele
      },
      error: function(error) {
        console.error('Silme hatası:', error);
      }
    });
  });
});


$(document).ready(function () {
  const baseUrl = 'http://localhost:8080/api/kuaforler';


//Kuaförleri Listeleme
function listKuaforler() {
  $.ajax({
      url: baseUrl,
      method: 'GET',
      success: function (response) {
          $('#kuaforBody').empty(); // Tabloyu temizle
          response.forEach(function (kuafor) {
              $('#kuaforBody').append(`
            <tr data-id="${kuafor.id}">
              <td>${kuafor.ad}</td>
              <td>${kuafor.soyad}</td>
              <td>
                <button class="deleteButton" data-id="${kuafor.id}">Sil</button>
                <button class="editButton" data-id="${kuafor.id}">Düzenle</button>
              </td>
            </tr>
          `);
          });
      },
      error: function (error) {
          console.error('Veri getirme hatası:', error);
      }
  });
}

listKuaforler();

// Yeni kuafor ekleme
$('#addForm').submit(function(event) {
  event.preventDefault();
  const ad = $('#name').val();
  const soyad = $('#surname').val();
  const newKuafor = {
    ad: ad,
    soyad: soyad,
  };

  $.ajax({
    url: baseUrl,
    method: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(newKuafor),
    success: function(response) {
      console.log('Ekleme başarılı:', response);
      listKuaforler(); // Yeniden listele
      $('#addForm')[0].reset(); // Formu temizle
    },
    error: function(error) {
      console.error('Ekleme hatası:', error);
    }
  });

 // Kuafor silme
 $(document).on('click', '.deleteButton', function() {
  const id = $(this).data('id');
  $.ajax({
    url: `${baseUrl}/${id}`,
    method: 'DELETE',
    success: function() {
      console.log('Silme başarılı');
      listKuaforler(); // Yeniden listele
    },
    error: function(error) {
      console.error('Silme hatası:', error);
    }
  });
});
});
});