<?php

$nama = str_replace(" ", "_", strtolower($_POST['nama']));
$alamat = $_POST['alamat'];

require_once 'dompdf/autoload.inc.php';
use Dompdf\Dompdf;
use Dompdf\Options;
$options = new Options();
$options->set('isRemoteEnabled', TRUE);
$dompdf = new Dompdf($options);
$contxt = stream_context_create([ 
    'ssl' => [ 
        'verify_peer' => FALSE, 
        'verify_peer_name' => FALSE,
        'allow_self_signed'=> TRUE
    ] 
]);
$dompdf->setHttpContext($contxt);
$html = '<style>'.
  '@font-face {'.
  '  font-family: "webhostglyph";'.
  '  src: URL("asset/webhostinghub-glyphs/webhostinghub-glyphs.ttf") format("truetype");'.
  '}'.
  'html {'.
  '  font-family: webhostglyph;'.
  '}'.
  '.bg {'.
  '  position: absolute;'.
  '  border: 2px;'.
  '  border-color: black;'.
  '  border-style: solid;'.
  '}'.
  '.pp {'.
  '  object-fit: cover;'.
  '  width: 640px;'.
  '  height: 640px;'.
  '  position: absolute;'.
  '  border-radius: 50%;'.
  '  transform: translate(230px, 250px);'.
  '}'.
  '.rb {'.
  '  position: absolute;'.
  '  transform: translate(210px, 220px);'.
  '}'.
  '.lid {'.
  '  position: absolute;'.
  '  text-align: center;'.
  '  transform: translate(610px, 10px);'.
  '  font-size: 20pt;'.
  '  width: 600px;'.
  '}'.
  '.name {'.
  '  position: absolute;'.
  '  text-align: center;'.
  '  transform: translate(268px, 910px);'.
  '  font-size: 50pt;'.
  '  width: 600px;'.
  '}'.
  '.job {'.
  '  position: absolute;'.
  '  text-align: center;'.
  '  transform: translate(410px, 1130px);'.
  '  font-size: 20pt;'.
  '  width: 300px;'.
  '}'.
  '</style>'.
  '<div>'.
  '  <img class="bg" src="asset/idcarddpn.png" />'.
  '  <img class="pp" src="asset/122713784_130467621830463_1653404940396938305_n.jpg" />'.
  '  <img class="rb" src="asset/ribbon2.png" />'.
  '  <h5 class="lid">LID. 2001001</h5>'.
  '  <h1 class="name">Rizaldy Aristyo</h1>'.
  '  <h3 class="job">Riset dan Pengembangan</h3>'.
  '</div>';
$dompdf->load_html($html);
$dompdf->render();
$dompdf->stream('laporan_'.$nama.'.pdf');

?>