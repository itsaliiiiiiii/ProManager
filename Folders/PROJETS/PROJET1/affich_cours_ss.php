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
        margin: 0 50px;
        height:70%;
        background-repeat: no-repeat;
         background-position: center;
        background-size: cover;
        width:90%;
        font-family: montserrat;
    }
      .formulaire{
        font-size: 20px;
        box-shadow: 0 0 30px rgb(0, 0, 0,0.15);
        background-color: #616161;
        width: 20%;
        height:150px;
        text-align: center;
        margin-left: 130px;
        margin-top: 20px;
    }
    .formulaire .info{
        padding: 50px 0;
    }
    table{
        background-color: gray;
        border-collapse: collapse;
        margin: 20px 0;
        padding: 10px;
        font-size: 0.9em;
        font-family: sans-serif;
        box-shadow: 0 0 20px rgb(0,0,0,0.15);
        opacity: 75%;
        width: 100%;
    }
    td,th{
        padding:10px;
        text-align: center;
    }
    
</style>
<body>
    <?php 
    error_reporting(E_ERROR | E_PARSE);
        $jr=$_POST['JR'];
        $conne=mysqli_connect("localhost","root","","centre_formation");
        $req=mysqli_query($conne,"SELECT * FROM séance,groupe,enseignant
                            where groupe.id_groupe=séance.id_groupe 
                            and séance.id_enseignant=enseignant.id_enseignant 
                            and jour_séance='$jr'
                        ");
        ?>
        <h1> LISTE DES SEANCES : </h1>
        <table>
            <tr>
                <th>ID_SEANCE</th>
                <th>ID_GROUPE</th>
                <th>NOM_MATIERE</th>
                <th>NIVEAU_SCOLAIRE</th>
                <th>DATE SEANCE</th>
                <th>SALLE_SEANCE</th>
                <th>JOUR_SEANCE</th>
                <th>TIME_SEANCE</th>
                <th>NOM_ENSEIGNANT</th>
                <th>PRENOM_ENSEIGNANT</th>
            </tr>

        <?php
        while($ligne=mysqli_fetch_array($req)){
            ?>
        <tr>
        <td><?php  echo $ligne['id_séance']    ?></td>
        <td><?php  echo $ligne['id_groupe']    ?></td>
        <td><?php  echo $ligne['nom_matiere']    ?></td>
        <td><?php  echo $ligne['Niveau_Scolaire']    ?></td>
        <td><?php  echo $ligne['date_séance']?></td>
        <td><?php  echo $ligne['sale_séance']    ?></td>
        <td><?php  echo $ligne['jour_séance']    ?></td>
        <td><?php  echo $ligne['time_séance']    ?></td>
        <td><?php  echo $ligne['nom_enseignant']    ?></td>
        <td><?php  echo $ligne['prenom_enseignant']    ?></td>
        </tr>
        <?php    
        } 
    ?>
    </table>
</body>
</html>