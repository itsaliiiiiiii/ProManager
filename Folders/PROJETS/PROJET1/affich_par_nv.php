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
    <form action="affich_par_nv.php" method="post">
    <div class="info">
        <Label for="NG">Niveau Scolaire</Label>
        <select name="NG" id="">
            <option value="1AC">1AC</option>
            <option value="2AC">2AC</option>
            <option value="3AC">3AC</option>
            <option value="TC">TC</option>
            <option value="1BAC">1BAC</option>
            <option value="2BAC">2BAC</option>
        </select>
        <input type="submit" value="Confirmer" name="confirmer">
    </div>
    </form>
</div>
<?php  
    error_reporting(E_ERROR | E_PARSE);
    $conne=mysqli_connect("localhost","root","","centre_formation");
    if(isset($_POST['NG'])){
        ?><table>
        <tr>
            <th>ID ELEVE</th>
            <th>NOM_ELEVE</th>
            <th>PRENOM_ELEVE</th>
            <th>ID_GROUPE</th>
            <th>TELE_ELEVE</th>
            <th>NOMBRE SEANCES</th>
            <th>TYPE_FORMATION</th>
        </tr>
        <?php
        $NV=$_POST['NG'];
    }
    $req=mysqli_query($conne,"SELECT * FROM eleve,appartenir,groupe,solde
                    where eleve.id_eleve=appartenir.id_eleve 
                    and eleve.id_eleve=solde.id_eleve
                    and groupe.id_groupe=appartenir.id_groupe
                    and groupe.Niveau_Scolaire='$NV' 
                    and eleve.type_formation='Soutien Scolaire'");

    while($ligne=mysqli_fetch_array($req)){
?>
    <tr>
        <td><?php  echo $ligne['id_eleve']  ;      ?></td>
        <td><?php  echo $ligne['prenom_eleve']  ;      ?></td>
        <td><?php  echo $ligne['nom_eleve']    ;    ?></td>
        <td><?php  echo $ligne['id_groupe']    ;    ?></td>
        <td><?php  echo $ligne['tele_eleve']    ;    ?></td>
        <td><?php  echo $ligne['nombre_seance']    ;    ?></td>
        <td><?php  echo $ligne['type_formation']    ;    ?></td>
    </tr>

</body>
</html>
<?php }?>


</html>