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
            margin: 0;
            padding: 0;
            background: #f5f5f5;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            flex-direction: column;
        }

        .container {
            width: 80%;
            margin: 50px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            border-radius: 15px;
            overflow: hidden;
        }

        h1 {
            text-align: center;
            color: #3498db;
            margin: 20px 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 15px;
            text-align: center;
            border-bottom: 1px solid #ecf0f1;
        }

        th {
            background-color: #3498db;
            color: #fff;
        }

        form {
            text-align: center;
            padding: 20px;
            background-color: #3498db;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }

        label {
            color: #fff;
            font-size: 18px;
            margin-right: 10px;
        }

        input[type="text"] {
            padding: 15px;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            width: 60%;
            margin-bottom: 20px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #2c3e50;
            color: #fff;
            padding: 15px 30px;
            font-size: 18px;
            cursor: pointer;
            border: none;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        input[type="submit"]:hover {
            background-color: #1a252f;
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
    
    if(isset($_POST['confirmer'])){
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
