<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="0;url=etudiant.html">
    <title>Document</title>
</head>
<body>
<?php 
            session_start();
            $Id=$_SESSION['id_recharge'];

            $conne=mysqli_connect("localhost","root","","centre_formation");
            $req=mysqli_query($conne,"SELECT id_eleve from solde where id_eleve='$Id'");

            $nbr=$_POST['nb'];
            $b=mysqli_query($conne,"SELECT * from solde where solde.id_eleve='$Id'");
            $tab=mysqli_fetch_array($b);
            $NBS=$tab['nombre_seance'];
            
            $total=(int)$NBS + (int)$nbr;
            $req1=mysqli_query($conne,"UPDATE `solde` SET `nombre_seance` = '$total' WHERE `solde`.`id_eleve` = '$Id'");
            echo "Recharge Effectué ";
        ?> 
</body>
</html>