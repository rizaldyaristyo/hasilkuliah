@extends('layouts.master')
@section('title', 'Home')
@section('content')
    <main>
      <div
        style="
          background-image: url('https://images.unsplash.com/photo-1509023464722-18d996393ca8?ixlib=rb-1.2.1&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=1170&amp;q=80;');
          display: flex;
          height: 700px;
          width: 100%;
          padding-top: 20px;
          background-size: 100vw 140vh;
          background-attachment: fixed;
        "
      >
        <div>
          <a href="#" class="fa fa-twitter" style="text-decoration: none; color: white; margin-left: 20px"></a>
          <a href="#" class="fa fa-github" style="text-decoration: none; color: white; margin-left: 5px"></a>
          <a href="#" class="fa fa-instagram" style="text-decoration: none; color: white; margin-left: 5px"></a>
          <a href="#" class="fa fa-linkedin" style="text-decoration: none; color: white; margin-left: 5px"></a>
        </div>
        <div class="d1 alignCenter reveal" style="color: lime; text-shadow: 2px 4px black">
          <b><i>- Deo Juvante -</i></b>
        </div>
        <div>
          <i class="fa fa-search" style="font-size: large; margin-right: 5px"></i>
          <input style="margin-right: 20px; max-width: 100px" />
        </div>
      </div>

      <center>
        <div class="autoalign" style="overflow-x: scroll; overflow-y: hidden; padding-top: 4rem; padding-bottom: 4rem; padding-left: 4vw; padding-right: 4vw">
          @include("partials.articles")
        </div>
        <div class="pagination alignCenter">
          <a href="#">&laquo;</a>
          <a href="#">1</a>
          <a href="#" class="active">2</a>
          <a href="#">3</a>
          <a href="#">4</a>
          <a href="#">5</a>
          <a href="#">6</a>
          <a href="#">&raquo;</a>
        </div>
      </center>
    </main>
@endsection