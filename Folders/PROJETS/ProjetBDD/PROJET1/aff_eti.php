<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    body{
        width:50%;
        margin: 0 350px;
        height:70%;
        background-image: url(c.jpeg);
        background-repeat: no-repeat;
         background-position: center;
        background-size: cover;
        width:70%;
        font-family: montserrat;
    }
    table{
        background-color: gray;
        border-collapse: collapse;
        margin: 100px 0;
        padding: 5px;
        font-size: 0.9em;
        font-family: sans-serif;
        box-shadow: 0 0 20px rgb(0,0,0,0.15);
        opacity: 75%;
    }
    td,th{
        padding:10px;
        text-align: center;
    }
</style>
<body>
    <table>
    <tr>
        <th>ID_ELEVE</th>
        <th>PRENOM_ELEVE</th>
        <th>NOM_ELEVE</th>
        <th>DATE_NAISSANCE</th>
        <th>TELE_ELEVE</th>
    </tr>
</body>
<?php 
    $conne=mysqli_connect("localhost","root","","centre_formation");
    $req=mysqli_query($conne,"SELECT * from eleve ");
    while ($ligne=mysqli_fetch_array($req)) {
?>
    <tr>
        <td><?php  echo $ligne["id_eleve"] ;?></td>
        <td><?php echo $ligne["prenom_eleve"] ;?></td>
        <td><?php echo $ligne["nom_eleve"] ;?></td>
        <td><?php echo $ligne["date_naissance"] ;?></td>
        <td><?php echo $ligne["tele_eleve"] ;?></td>
    </tr>


<?php
    }
?>
</html>