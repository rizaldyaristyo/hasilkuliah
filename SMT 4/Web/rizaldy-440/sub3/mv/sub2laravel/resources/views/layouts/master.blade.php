<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <link rel="stylesheet" href="https://cdn.statically.io/gh/ARSTCreations/domumcss/main/domum.min.css" />
    <script src="https://cdn.statically.io/gh/ARSTCreations/domumcss/main/domum.min.js"></script>
    <link rel="stylesheet" href="{{asset('style.css')}}" />
    <script src="{{asset('calc.js')}}"></script>
    <title>@yield('title')</title>
  </head>
  <body style="font-family: Verdana, Geneva, Tahoma, sans-serif">
    <header>
      @include("partials.navbar")
    </header>
    @yield("content")
    <footer style="margin: top 2rem;">
        @include("partials.footer")
    </footer>
  </body>
  <script>
    initanima();
  </script>
</html>
