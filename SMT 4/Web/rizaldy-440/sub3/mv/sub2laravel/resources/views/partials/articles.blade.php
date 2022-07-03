<div class="alignCenter" style='background-color: black; height: 700px; margin: 20px;display:flex; width:fit-content'>
@foreach($data as $d)
<div>
  <div class='autowidth' style='height: 300px'>
    <img src={{$d['image']}} alt='article' style='width: inherit; height: inherit; object-fit: cover' />
  </div>
  <div class='autowidth' style='background-color: var(--DCod); height: 400px; padding-top: 10px'>
    <h1 style='margin: 10px'>{{$d['judul']}}</h1>
    <p style='margin: 10px'>
      {{$d['isi_konten']}}<br /><br /><a href='#' style='color: white'>Read More...</a>
    </p>
  </div>
</div>
@endforeach
</div>