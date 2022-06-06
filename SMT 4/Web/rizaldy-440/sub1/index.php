<html>
	<body>
		<h1>Form Pendaftaran Member</h1>
		<p>Silahkan masukkan nama dan alamat Anda, untuk mencetak laporan PDF menggunakan dompdf</p>
		<form action="topdf.php" method="POST">
      <label>Nama</label><input type="text" name="nama" /><br />
      <label>Posisi / Jabatan</label><input type="text" name="alamat" /><br />
      <input type="submit" name="kirim" id="topdf" value="Ambil Laporan!" />
		</form>
	</body>
</html>