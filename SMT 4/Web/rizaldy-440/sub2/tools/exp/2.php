<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<style>
    .center {
    margin: auto;
    width: 50%;
    padding: 10px;
    text-align: center;
    }
</style>
<body style="font-family: Verdana, Geneva, Tahoma, sans-serif">
  <header>
    <?php include '../../navbar.php';?>
  </header>
  <div style="text-align: center">
    <h1>You're Subscribed!</h1>
    <p>
      The following information will going <br>
      to be added to our database <br>
      for further newsletter processing <br>
      Thankyou for following us! Keep it up to date! <br>
    </p>
  </div>  
  <div class="center" style="border: 3px solid gray;width: fit-content;">
    <?php
    global $name,$email,$website,$feedback,$age,$t1,$t2;
    $name = $_POST["name"];
    $email = $_POST["email"];
    $website = $_POST["website"];
    $feedback = $_POST["feedback"];
    $age = $_POST["age"];
    $t1 = $_POST["t1"] ?? " ";
    $t2 = $_POST["t2"] ?? " ";

    class TheParent{
      function f1(){
        echo "Name: ".$GLOBALS['name'];
      }
      function f2(){
        echo "<br>Age: ".$GLOBALS['age']."<br>Topics Selected: ".$GLOBALS['t1']." ".$GLOBALS['t2'];
      }
    }

    abstract class AbstractParent{
      abstract public function absf1();
      abstract public function absf2();
    }

    class AbstractChild extends AbstractParent{ 
      public function absf1(){
        echo "<br>E-Mail: ".$GLOBALS['email'];
      }
      public function absf2(){
        echo "<br>Website: ".$GLOBALS['website'];
      }
    }

    trait Trait1 {
    public function absf1() {
        echo $GLOBALS['t1'];
      }
    }

    trait Trait2 {
    public function absf2() {
        echo $GLOBALS['t2'];
      }
    }

    class Traits {
      use Trait1,Trait2;
    }

    $tp = new TheParent();
    $tp->f1();
    $tp->f2();

    $tp = new AbstractChild();
    $tp->absf1();
    $tp->absf2();

    $trt = new Traits();
    echo "<br> Selected Topics: ";
    $trt->absf1();
    echo " ";
    $trt->absf2();
    ?>
  </div>
  <div class="center">
    <a href="1.php" style="text-align: center; color:aliceblue">Go Back</a>
  </div>
  
</body>
</html>