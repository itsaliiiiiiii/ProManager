<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <h2>Centre de formation</h2>
    <form action="test.php" method="post">
        <label for="prenom">Prenom:</label>
        <input type="text" name="prenom">
        <br><br>
        <label for="nom">Nom:</label>
        <input type="text" name="nom">
        <br><br>
        <input type="submit" name="login" value="log in">
    </form>
</body>
</html>


<?php
    $ser="localhost";
    $user="root";
    $pass="";
    $name="centreformation";

    $conne=mysqli_connect($ser,$user,$pass,$name);
    if(isset($_POST["login"])){
        if(empty($_POST["prenom"])) {
            echo "please enter a first _name";
        }
        elseif(empty($_POST["nom"])){
            echo"please enter a last_name:";
        }
        else{
            $first_name=$_POST["prenom"];
            $last_name=$_POST["nom"];
            $sql=mysqli_query($conne,"INSERT INTO eleve(prenom,nom) VALUES ('{$first_name}','{$last_name}')");
    };
    
}


?>
