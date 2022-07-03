<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/ARSTCreations/domumcss@main/domum.min.css" />
    <script src="https://cdn.jsdelivr.net/gh/ARSTCreations/domumcss@main/domum.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="style.css" />
    <title>WebLog</title>
  </head>
  <body style="font-family: Verdana, Geneva, Tahoma, sans-serif">
    <header>
      <?php include 'navbar.php';?>
    </header>
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
          <?php include 'articles.php';?>
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
    <footer style="margin-top: 2rem">
      <div style="padding: 30px; border-top-right-radius: 55px; width: 450px; background-color: var(--DCod)">
        <div style="display: flex">
          <div>
            <div class="d1" style="margin-top: 20px">"Deo Juvante"</div>
            <p style="text-align: center">Template &copy;2022 Rizaldy Aristyo</p>
          </div>
          <div style="margin-left: 40px">
            <ul class="list">
              <li><a href="#">Category 1</a></li>
              <li><a href="#">Category 2</a></li>
              <li><a href="#">Category 3</a></li>
              <li><a href="#">Category 4</a></li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
  </body>
  <script>
    initanima();
  </script>
</html>
