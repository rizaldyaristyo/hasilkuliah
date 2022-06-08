<!DOCTYPE html>
<html lang="en" style="font-family: Verdana, Geneva, Tahoma, sans-serif">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
</head>
<style>
    .center {
    margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;
    }
</style>
<header>
  <?php include '../../navbar.php';?>
</header>
<body style="text-align: center">
    <?php
    //$text="Andi Belajar Pemrograman Web";
    $text="JOIN THE NEWSLETTER!";
    echo "<h1>";
    foreach(explode(' ',$text) as $x) echo $x." ";
    echo "</h1>";
    //echo var_dump(explode(' ',$text));
    ?>
    <div class="center" style="width:fit-content;border: solid;border-radius: 5px;border-color: black;background-color:black;">
        <form action="2.php" method="post" style="font-size: x-large;">
            Name: <input type="text" name="name" required><br>
            E-mail: <input type="text" name="email" required><br>
            Website: <input type="text" name="website" required><br><br>
            Feedback: <textarea name="feedback" rows="5" cols="25" required></textarea><br>
            Age:
            <input type="radio" name="age" value=">18" required>>18
            <input type="radio" name="age" value="18-21" required>18-21
            <input type="radio" name="age" value="22<" required>22<<br>
            Topics to Subscribe:
            <input type="checkbox" name="t1" value="Tech"> Tech
            <input type="checkbox" name="t2" value="Academics"> Academics<br>
            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
</body>
</html>