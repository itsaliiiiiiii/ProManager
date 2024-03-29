<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    session_start();
    error_reporting(E_ERROR | E_PARSE);
    $conne = mysqli_connect("localhost", "root", "", "centre_formation");
    $jour = $_POST['jr'];
    $heur = $_POST['hr'];
    $date=$_POST['Date'];
    $dateInPHP = date("Y-m-d", strtotime($date));
    $mat = $_SESSION['mat_by_gr'];
    $req = mysqli_query($conne, "SELECT sale_séance from séance where jour_séance = '$jour' and time_séance = '$heur'");
    $l=mysqli_fetch_array($req);
    if (mysqli_num_rows($req) < 6)
    {
        $b = (int)mysqli_num_rows($req) + 1;
        $req2 = mysqli_query($conne, "SELECT * from enseignant where enseignant.Nom_matiere = '$mat' and id_enseignant NOT IN (SELECT id_enseignant from séance where séance.jour_séance = '$jour' and séance.time_séance = '$heur')
                                 ");
        $li=mysqli_fetch_array($req2);
        $ens=$li['id_enseignant'];
        $grp=$_SESSION['id_gr'];
        mysqli_query($conne,"INSERT INTO `séance` (`date_séance`, `sale_séance`, `id_enseignant`, `id_groupe`, `jour_séance`, `time_séance`) VALUES ('$dateInPHP', '$b', '$ens', '$grp', '$jour', '$heur');");
        echo "Séance Ajouté \n";
        echo "Salle : ".$b."\n";
        echo "Enseignant : ".$ens;
        mysqli_query($conne,"UPDATE `groupe` SET `status_groupe` = 'ACTIF' WHERE `groupe`.`id_groupe` = '$grp'");
        // $req2 = mysqli_query($conne, "SELECT status_groupe from groupe where jour_séance = '$jour' and time_séance = '$heur'");
    }
    else
    {
        echo "Toutes les sales sont indisponibles \n";
        ?><a href="check_status.php">Go to this link </a>
    <?php }
     ?>
</body>
</html>