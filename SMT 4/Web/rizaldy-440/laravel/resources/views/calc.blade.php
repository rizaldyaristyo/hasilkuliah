@extends('layouts.master')
@section('title', 'Kalk')
@section('content')
  <style>
    #big {
      width: 145px;
      height: 70px;
      background-color: skyblue;
      border: 3px solid black;
      color: black;
      border-radius: 20px;
      padding: 20px;
    }
    input {
      width: 20px;
      height: 20px;
      background-color: gray;
      border: 3px solid black;
      color: white;
      border-radius: 50%;
      padding: 30px;
      margin: 5px;
      font-size: 15px;
    }
  </style>
  <body>
    <form name="form1" style="padding-left: 40vw; padding-top: 4vw">
      <input type="text" name="answer" style="width: 280px; padding: 20px; border-radius: 10px" />
      <div style="display: flex; padding-left: 13px">
        <input type="button" value="9" onclick="button(this)" />
        <input type="button" value="8" onclick="button(this)" />
        <input type="button" value="7" onclick="button(this)" />
        <input type="button" value="+" onclick="button(this)" />
      </div>
      <div style="display: flex; padding-left: 13px">
        <input type="button" value="6" onclick="button(this)" />
        <input type="button" value="5" onclick="button(this)" />
        <input type="button" value="4" onclick="button(this)" />
        <input type="button" value="-" onclick="button(this)" />
      </div>
      <div style="display: flex; padding-left: 13px">
        <input type="button" value="3" onclick="button(this)" />
        <input type="button" value="2" onclick="button(this)" />
        <input type="button" value="1" onclick="button(this)" />
        <input type="button" value="*" onclick="button(this)" />
      </div>
      <div style="display: flex; padding-left: 13px">
        <input type="button" value="/" onclick="button(this)" />
        <input type="button" value="0" onclick="button(this)" />
        <input type="button" value="." onclick="button(this)" />
        <input type="button" value="=" onclick="equation()" style="" />
      </div>
      <div style="display: flex; padding-left: 13px">
        <input type="button" value="%" onclick="button(this)" />
        <input type="button" value="**" onclick="button(this)" />
        <input type="button" value="Clear All" onclick="ac()" id="big" />
      </div>
    </form>
  </body>
@endsection
