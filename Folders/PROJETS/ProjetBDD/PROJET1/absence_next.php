<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
         body {
             font-family: 'Montserrat', sans-serif;
            /* margin: 0;
            padding: 0;
            /* height: 100vh; */
            display: flex;  
            align-items: center;
            justify-content: center;
            background: linear-gradient(to right, #3498db, #2c3e50);
             animation: fadeIn 1s ease-in-out; 
        } 

        table {
            background-color: #fff;
            border-collapse: collapse;
            width: 80%;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
            opacity: 0.9;
            animation: fadeIn 1s ease-in-out;
    
        }

        th,
        td {
            padding: 15px;
            text-align: center;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }

            to {
                opacity: 1;
            }
        }
    </style>
<body>
<?php  
    
    error_reporting(E_ERROR | E_PARSE);
    $conne=mysqli_connect("localhost","root","","centre_formation");
    
    if(isset($_POST['ID'])){
    $Id=$_POST['ID'];
    $date=$_POST['ID'];
    $date_php= new DateTime($date);
    $datenv=$date_php->format('Y-m-d');
    $req2=mysqli_query($conne, "SELECT * from séance,groupe 
                                where date_séance = '$datenv'
                                and groupe.id_groupe=séance.id_groupe ");
    ?><h1> LISTE DES SEANCES : </h1>
    <table>
        <tr>
            <th>ID_SEANCE</th>
            <th>ID_GROUPE</th>
            <th>NOM_MATIERE</th>
            <th>NIVEAU_SCOLAIRE</th>
            <th>SALLE_SEANCE</th>
            <th>JOUR_SEANCE</th>
            <th>TIME_SEANCE</th>
        </tr>
    <?php
    while($ligne = mysqli_fetch_array($req2))
    {
        ?>
        <tr>
        <td><?php  echo $ligne['id_séance']    ?></td>
        <td><?php  echo $ligne['id_groupe']    ?></td>
        <td><?php  echo $ligne['nom_matiere']    ?></td>
        <td><?php  echo $ligne['Niveau_Scolaire']    ?></td>
        <td><?php  echo $ligne['sale_séance']    ?></td>
        <td><?php  echo $ligne['jour_séance']    ?></td>
        <td><?php  echo $ligne['time_séance']    ?></td>
     <?php }
    }
    
?>
    <form action="absence_next_next.php" method="post">
        <label for="seance">ID SEANCE</label>
        <input type="text" name="seance" id=""><br>
        <input type="submit" name="confirmer" value="confirmer">
    </form>
    
</body>
</html>
