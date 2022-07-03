<!DOCTYPE html>
<html lang="en" style="font-family: Verdana, Geneva, Tahoma, sans-serif">
  <head>
    <title>Waslis</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/ARSTCreations/domumcss@main/domum.min.css" />
    <script src="https://cdn.jsdelivr.net/gh/ARSTCreations/domumcss@main/domum.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <script src="watchlist.js"></script>
  </head>
  <style>
    td,
    tr,
    th {
      border: 1px solid white;
      width: 50%;
      padding: 15px;
    }
  </style>
  <body>
    <header>
      @include("partials.navbar")
    </header>
    <div class="sideBar">
      <div class="leftBar" style="background-color: var(--DVoid)">
        <div class="barContent">
          <div class="responsiveD3" style="text-align: center">
            <i>
              THE GRAND<br />
              MOVIE LIST
            </i>
          </div>
          <div class="d2 alignCenter">
            <input id="movieTitleEntry" type="text" placeholder="Movie Title" />
            <input id="movieRatingEntry" type="text" placeholder="Movie Rating" />
            <button onclick="addMovie()" style="width: 85%">Add New Entry</button>
            <input id="search" type="text" placeholder="Search" />
          </div>
        </div>
      </div>
      <div class="rightBody">
        <div class="d5">
          <table id="tablenya" style="border: 2px; text-align: center"></table>
        </div>
      </div>
    </div>
  </body>
</html>
