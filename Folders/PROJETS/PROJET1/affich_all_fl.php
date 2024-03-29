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
             flex-direction: column;
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
    $req=mysqli_query($conne,"SELECT * FROM eleve,appartenir,groupe

                       where type_formation='Formation Langue'
                       and appartenir.id_groupe=groupe.id_groupe
                       and eleve.id_eleve=appartenir.id_eleve");
    ?>
    
    <table>
        <tr>
            <th>ID ELEVE</th>
            <th>NOM_ELEVE</th>
            <th>PRENOM_ELEVE</th>
            <th>ID_GROUPE</th>
            <th>NIVEAU_SCOLAIRE</th>
        </tr>
    <?php while($ligne=mysqli_fetch_array($req)){
        ?>
        <tr>
            <td><?php echo $ligne['id_eleve']?></td>
            <td><?php echo $ligne['nom_eleve']?></td>
            <td><?php echo $ligne['prenom_eleve']?></td>
            <td><?php echo $ligne['id_groupe']?></td>
            <td><?php echo $ligne['Niveau_Scolaire']?></td>
        </tr>
    
    <?php } ?>
    </table>
</body>
</html>