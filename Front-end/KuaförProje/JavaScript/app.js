$(document).ready(function() {
  const baseUrl = 'http://localhost:8080/api/kuaforler';

  function listKuaforler() {
    $.ajax({
      url: baseUrl,
      method: 'GET',
      success: function(response) {
        $('#kuaforBody').empty(); // Tabloyu temizle
        response.forEach(function(kuafor) {
          $('#kuaforBody').append(`
            <tr>
              <td>${kuafor.ad}</td>
              <td>${kuafor.soyad}</td>
              <td>${kuafor.kullanici_adi}</td>
              <td>${kuafor.sifre}</td>
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
        alert('Kauför Başarıyla Eklendi!');
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
        alert('Kauför Başarıyla Silindi!');

      },
      error: function(error) {
        console.error('Silme hatası:', error);
      }
    });
  });
 // Düzenleme butonlarına tıklama işlevi
$(document).on('click', '.editButton', function() {
  const id = $(this).data('id');
  const row = $(this).closest('tr');
  const ad = row.find('td:eq(0)').text();
  const soyad = row.find('td:eq(1)').text();
  const kullaniciAdi = row.find('td:eq(2)').text();
  const sifre = row.find('td:eq(3)').text();

  showEditForm(id, ad, soyad, kullaniciAdi, sifre);
});

function showEditForm(id, ad, soyad, kullaniciAdi, sifre) {
  $('#editId').val(id);
  $('#editName').val(ad);
  $('#editSurname').val(soyad);
  $('#editUsername').val(kullaniciAdi);
  $('#editPassword').val(sifre);
  $('#editForm').show();
}

  //kuafor güncelleme
  $('#editForm').submit(function(event) {
    event.preventDefault();
    const id = $('#editId').val();
    const ad = $('#editName').val();
    const soyad = $('#editSurname').val();
    const kullaniciAdi = $('#editUsername').val();
    const sifre = $('#editPassword').val();

    const updatedKuafor = {
      ad: ad,
      soyad: soyad,
      kullanici_adi: kullaniciAdi,
      sifre: sifre
    };

    $.ajax({
      url: `${baseUrl}/${id}`,
      method: 'PUT',
      contentType: 'application/json',
      data: JSON.stringify(updatedKuafor),
      success: function(response) {
        console.log('Güncelleme başarılı:', response);
        listKuaforler(); // Güncelleme sonrası tabloyu yenile
        $('#editForm')[0].reset(); // Formu temizle
        $('#editForm').hide(); // Formu gizle
        alert('Kauför Başarıyla Güncellendi!');
      },
      error: function(error) {
        console.error('Güncelleme hatası:', error.responseText); 
      }
    });
  });
});

function showEditForm(ad, soyad, kullaniciAdi, sifre) {
  $('#editName').val(ad);
  $('#editSurname').val(soyad);
  $('#editUsername').val(kullaniciAdi);
  $('#editPassword').val(sifre);
  $('#editForm').show();
}