<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="0;url=etud_soft.html">  
    <title>Document</title>
</head>
<body>
    <?php  
        $conne=mysqli_connect("localhost","root","","centre_formation") ;
        session_start();
        $ld=$_SESSION['id_eleve_soft'];
        $matiere=$_SESSION['languages'];
        $nbr=$_POST['nbr'];
        mysqli_query($conne,"INSERT INTO solde(id_eleve,nom_matiere,nombre_seance) values ('$ld','$matiere','$nbr')")
    ?>
</body>
</html>