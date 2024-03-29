<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php 
        $p=$_POST['prenom'];
        $n=$_POST['nom'];
        $t=$_POST['telephone'];
        $e=$_POST['m'];
        $conne=mysqli_connect("localhost","root","","centre_formation");
        $req=mysqli_query($conne,"INSERT INTO enseignant(prenom_enseignant,nom_enseignant,tele_enseignant,email_enseignant,Nom_matiere,type_formation) values ('$p','$n','$t','$e','ALL PROGRAMMING LANGUAGES','INFORMATIQUE')");
    if($req){
        echo"insertion effectué";
    }
    ?>
</body>
</html>