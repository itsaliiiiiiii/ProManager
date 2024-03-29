<!DOCTYPE html>
<html lang="fr">
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
                height: 100vh;
                display: flex;
                align-items: center;
                justify-content: center;
                background: linear-gradient(to right, #3498db, #2c3e50);
                animation: fadeIn 1s ease-in-out;
                flex-direction: column;
            }

            .formulaire {
                font-size: 20px;
                box-shadow: 0 0 30px rgba(0, 0, 0, 0.2);
                background-color: #fff;
                width: 40%;
                padding: 20px;
                text-align: center;
                border-radius: 10px;
                animation: slideIn 1s ease-in-out;
                display: block;
            }

            .formulaire label,
            .formulaire input {
                display: block;
                margin: 10px 0;
            }

            .formulaire input[type="text"] {
                width: calc(100% - 20px);
                padding: 10px;
                box-sizing: border-box;
                border: 1px solid #ddd;
                border-radius: 5px;
                transition: border-color 0.3s;

            }

            .formulaire input[type="text"]:focus {
                border-color: #3498db;
            }

            .formulaire input[type="submit"] {
                background-color: #3498db;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
                float: right;
                margin-right: 40px;
                margin-bottom: 20px;
            }

            .formulaire input[type="submit"]:hover {
                background-color: #2980b9;
            }

            table {
                background-color: #fff;
                border-collapse: collapse;
                width: 80%;
                margin: 20px 0;
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
            h3{
                float: left;
                color: red;
            }
            @keyframes fadeIn {
                from { opacity: 0; }
                to { opacity: 1; }
            }

            @keyframes slideIn {
                from { transform: translateY(-20px); }
                to { transform: translateY(0); }
            }
        </style>
<body>
    <div class="formulaire">
        <form action="emploi_etud.php" method="post">
            <div class="info"></div>
            <Label for="PR">Prenom</Label>
            <input type="text" name="PR" required><br>
            <Label for="NM">Nom</Label>
            <input type="text" name="NM" required><br>
            <input type="submit" value="Confirmer" name="confirmer " class="id">
    </form>
    </div>
    
    <?php  error_reporting(E_ERROR | E_PARSE);
    $conne=mysqli_connect("localhost","root","","centre_formation");
    if(isset($_POST['PR']) and isset($_POST['NM'])){
        ?>
        <h3><?php echo $_POST['NM']."   ".$_POST['PR'] ?></h3>
        <table>
        <tr>
            <th>JOUR SEANCE</th>
            <th>TIME SEANCE</th>
            <th>SALE SEANCE</th>
            <th>ID GROUPE</th>
            <th>NOM MATIERE</th>
            <th>NIVEAU SCOLAIRE</th>
        </tr>
        <?php
        $pr=$_POST['PR'];
        $nm=$_POST['NM'];
    }
    $req=mysqli_query($conne,"SELECT  DISTINCT s.time_séance,s.jour_séance ,s.sale_séance,s.id_groupe,
                    g.nom_matiere,g.Niveau_Scolaire FROM eleve e,séance s,groupe g,appartenir a
                    where  e.id_eleve=a.id_eleve
                    and g.id_groupe=a.id_groupe
                    and g.id_groupe=s.id_groupe
                    and e.prenom_eleve='$pr' 
                    and e.nom_eleve='$nm'
                    ");

    while($ligne=mysqli_fetch_array($req)){
?>
    <tr>
        <td><?php  echo $ligne['jour_séance']    ;    ?></td>
        <td><?php  echo $ligne['time_séance']    ;    ?></td>
        <td><?php  echo $ligne['sale_séance']    ;    ?></td>
        <td><?php  echo $ligne['id_groupe']    ;    ?></td>
        <td><?php  echo $ligne['nom_matiere']    ;    ?></td>
        <td><?php  echo $ligne['Niveau_Scolaire']    ;    ?></td>
    </tr>

</body>
</html>
<?php }?>