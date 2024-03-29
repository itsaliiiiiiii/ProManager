<?php 
session_start();
$conne = mysqli_connect("localhost", "root", "", "centre_formation");

if (isset($_POST['confirmer'])) {
    $_SESSION['s']=$_POST['seance'];
    $seance = $_POST['seance'];
    $req = mysqli_query($conne, "SELECT * from séance,appartenir,eleve,solde
                        where séance.id_groupe=appartenir.id_groupe
                        and séance.id_séance='$seance'
                        and appartenir.id_eleve=eleve.id_eleve
                        and eleve.id_eleve=solde.id_eleve
                        and solde.nombre_seance>0");

    ?><form action="absence_next_next.php" method="post">
        <table>
            <tr>
                <th>PRENOM</th>
                <th>NOM</th>
                <th>ID ELEVE</th>
                <th>ABSENCE</th>
            </tr>
        <?php
        $tab = [];
        while ($lg = mysqli_fetch_array($req)) {
            ?>
            <tr>
                <td><?php echo $lg['prenom_eleve'] ?></td>
                <td><?php echo $lg['nom_eleve'] ?></td>
                <td><?php echo $lg['id_eleve'] ?></td>
                <td>
                    <label for="">ABSCENT</label>
                    <input type="radio" name="abs[<?php echo $lg['id_eleve']; ?>]" value="absent" required>
                    <label for="">PRESENT</label>
                    <input type="radio" name="abs[<?php echo $lg['id_eleve']; ?>]" value="present" required>
                </td>
            </tr>
            <?php
        }
        ?></table>
        <input type="submit" name="confirm" value="confirm">
    </form><?php
}

if (isset($_POST['confirm'])) {
    $absences = $_POST['abs'];

    foreach ($absences as $id_eleve => $absence_value) {
        $id_eleve = mysqli_real_escape_string($conne, $id_eleve);
        $absence_value = mysqli_real_escape_string($conne, $absence_value);
        $e=$_SESSION['s'];
        $insert_query = "INSERT INTO présence(id_séance,id_eleve,présence) VALUES ('$e','$id_eleve', '$absence_value')";
        mysqli_query($conne, $insert_query);
    }
    $req1 = mysqli_query($conne, "SELECT id_eleve from présence where id_séance = '$e' and présence = 'pre'");
    while($ligne=mysqli_fetch_array($req1))
    {
    $IDELEVE=$ligne['id_eleve'];
    mysqli_query($conne, "UPDATE `solde` SET nombre_seance = nombre_seance - 1 WHERE solde.id_eleve = '$IDELEVE'");
    }

$req2 = mysqli_query($conne, "SELECT id_eleve from présence where id_séance = '$e' and présence = 'abs'");
$req3 = mysqli_query($conne, "SELECT id_eleve from présence where présence = 'abs'");

while($ligne1=mysqli_fetch_array($req2))
    {
        $occ = 0;
        while($ligne2=mysqli_fetch_array($req3))
            if ($ligne1['id_eleve'] == $ligne2['id_eleve'])
                $occ++;
        $id = $ligne1['id_eleve'];
        if ($occ > 1)  
            mysqli_query($conne, "UPDATE `solde` SET nombre_seance = nombre_seance - 1 WHERE solde.id_eleve = '$id'");
    }
$id_s = $_SESSION['s'];
$my_req = mysqli_query($conne, "SELECT * from séance where id_séance = '$id_s'");
$table = mysqli_fetch_array($my_req);
$tmp_id_en = $table['id_enseignant'];
$tmp_date_html = $table['date_séance'];
$tmp_sale = $table['sale_séance'];
$tmp_id_groupe = $table['id_groupe'];
$tmp_jour = $table['jour_séance'];
$tmp_time = $table['time_séance'];
$tmp_date = new DateTime($tmp_date_html);
$tmp_date -> add(new DateInterval('P7D'));
$tmp_date_formatted = $tmp_date->format('Y-m-d');
mysqli_query($conne, "INSERT into séance(date_séance,sale_séance,id_enseignant,id_groupe,jour_séance,time_séance) 
values ('$tmp_date_formatted','$tmp_sale','$tmp_id_en','$tmp_id_groupe','$tmp_jour','$tmp_time')");
}
?>
