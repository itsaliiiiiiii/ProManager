<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style3.css">
</head>
<body>
    <?php
    session_start();
    $id=$_POST['GR'];
    $conne=mysqli_connect("localhost","root","","centre_formation");
    $req1=mysqli_query($conne,"SELECT * from appartenir where id_groupe='$id'");
    if(mysqli_num_rows($req1)>=4){
        $req=mysqli_query($conne,"SELECT  * from groupe where id_groupe='$id'  and status_groupe='NON ACTIF'");
        if(mysqli_num_rows($req)==0){
            echo "LE COURS EST DéJA LANCé ";
        }
        else {
            $tab = mysqli_fetch_array($req);
            $_SESSION['mat_by_gr'] = $tab['nom_matiere'];
            $_SESSION['id_gr'] = $tab['id_groupe'];
            echo  $_SESSION['id_gr'];
            ?><section class="main">
            <section class="container">
            <form action="assign_sale.php" class="form" method="post">
                <div class="input-box">
                    <label for="adresse">Jour</label><br>
                    <div class="select-box">
                        <select id="NV" name="jr">
                            <option value=""></option>
                            <option>lundi</option>
                            <option>mardi</option>
                            <option>mercredi</option>
                            <option>jeudi</option>
                            <option>vendredi</option>
                            <option>samedi</option>
                        </select>
                    </div>
                </div>
                <div class="input-box">
                    <label for="adresse">Heure Du Seance</label><br>
                    <div class="select-box">
                        <select id="NV" name="hr">
                            <option value=""></option>
                            <option>5</option>
                            <option>7</option>
                        </select>
                    </div>
                </div>
                <input type="submit" name="SUIVANT" value="SUIVANT" class="s">
            </form>
        </section>
        </section>
        <?php }}
        else{
            echo"LE COURS NE PEUT PAS SE LANCER POUR LE MOMENT";
        } ?>
</body>
</html>