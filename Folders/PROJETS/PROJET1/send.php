<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php
    $conne=mysqli_connect("localhost","root","","centre_formation");
    $ng=$_POST["NG"];
    $req=mysqli_query($conne,"SELECT * FROM appartenir,eleve where eleve.id_eleve=appartenir.id_eleve AND id_groupe='$ng'");
    while($ligne=mysqli_fetch_array($req)){
?>
    <table>
        <tr>
        <th>ID ELEVE</th>
        <th>NOM ELEVE</th>
        <th>PRENOM ELEVE</th>
        </tr>
        <tr><td><?php echo $ligne["id_eleve"]?></td></tr>
        <tr><td><?php echo $ligne["nom_eleve"]?></td></tr>
        <tr><td><?php echo $ligne["prenom_eleve"]?></td></tr>
    </table>
<?php
    }
    ?>
</body>
</html>
