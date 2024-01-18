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