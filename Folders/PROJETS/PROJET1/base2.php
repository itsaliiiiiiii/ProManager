<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Document</title>
    <link rel="stylesheet" href="style3.css">
    
</head>
<style>
    *{
    padding:0;
    margin: 0;
    text-decoration: none;
    list-style: none;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

a{
    text-decoration: none;
}
body{
    background-color: rgb(130,106,251);
}
.main{
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    display: flex;
    padding: 0 20px;
    width: 100%;
    
}
.container{
    position: relative;
    background-color: #fff;
    width: 100%;
    margin: 0 100px;
    padding: 25px;
    border-radius: 10px;
    box-shadow: 0 0 15px rgb(0,0,0,0.1);
}
.container .form{
    margin-top: 30px;
}
.form .input-box{
    width:100%;
    margin-top: 20px;
}
.input-box label{
    color:#333;
}
.form :where(.input-box input, .select-box){
    position: relative;
    height: 50px;
    width:100%;
    outline: none;
    font-size: 1rem;
    color: #707070;
    margin-top: 8px;
    border: 1px solid #ddd;
    border-radius: 6px;
    padding: 0 15px;
}
.form .gender-option{
    margin: 0 20px;
    display: flex;
    column-gap: 50px;
}
.titre{
    font-size: 1rem;
    font-weight: bold;
}
.select-box select{
    width: 100%;
    height:100%;
    outline: none;
    border: none;
    color: #707070;
    font-size: 1rem;
}
.form .s{
    width: 30%;
    float: right;
    height:50px;
    color: #fff;
    font-size: 1rem;
    border: none;
    cursor: pointer;
    border-radius: 6px;
    font-weight: 600;
    background-color: rgb(88,106,251);
}
nav{
    height: 55px;
    width: 100%;
}
nav ul{
    float:right;
    margin-right: 60px;
}
nav ul li{
    display: inline-block;
    line-height: 55px;
    margin: 20px 20px;
}
nav ul li a{
    color:black;
    font-size: 15px;
    padding: 7px 13px;
    border-radius: 3px;
    text-transform: uppercase; 
}

a.active:hover{
    background-color:#87CEFA ;
    transition: .5s;
     
}

 #prix{
    width: 50%;
}
</style>
<body>
    <header>
        <nav>
            <ul>
                <li><a class="active" href="site.html">HOME</a></li>
                <li><a class="active" href="#">ABOUT US</a></li>
                <li><a class="active" href="#">CONTACT</a></li>
            </ul>  
            </nav>
    </header>
    <?php 
        
    ?> 
        
    <section class="main">
        <section class="container">
        <form action="base2_next.php" class="form" method="post">
            <?php 
            $conne=mysqli_connect("localhost","root","","centre_formation");
            session_start();
            $prenom=$_POST["prenom"];
            $nom=$_POST["nom"];
            $tele=$_POST["telephone"];
            $type_formation="Formation Langue";
            $req=mysqli_query($conne,"INSERT INTO eleve(nom_eleve,prenom_eleve,tele_eleve,type_formation) VALUES ('$nom','$prenom','$tele','$type_formation')");  
            $req3=mysqli_query($conne,"SELECT * FROM eleve where nom_eleve='$nom' and prenom_eleve='$prenom' and tele_eleve='$tele'");
            $li=mysqli_fetch_array($req3);
            $id=$li['id_eleve'];
            $_SESSION['id_eleve_fl'] = $id;
            $mati=$_POST['langue'];
            $_SESSION['nom_matiere']=$mati;
            $req=mysqli_query($conne,"SELECT id_groupe FROM groupe where groupe.nom_matiere='$mati' ");
            $check=0;
            while($l=mysqli_fetch_array($req)){
                $m=$l['id_groupe'];
                $nbr=mysqli_query($conne,"SELECT id_eleve from appartenir where id_groupe='$m'");
                if(mysqli_num_rows($nbr)<8){
                    $check++;
                    echo "GROUPE : ".$m?><br><?php }
            }
            if($check==0){
                $CR=mysqli_query($conne,"INSERT INTO `groupe` (`id_groupe`, `status_groupe`, `nom_matiere`, `Niveau_Scolaire`) VALUES (NULL, 'NON ACTIF', '$mati', 'B')");
                $req4=mysqli_query($conne,"SELECT id_groupe FROM groupe where nom_matiere='$mati'  and id_groupe NOT IN (select id_groupe from appartenir)");
                $lig=mysqli_fetch_array($req4);
                $idGr=$lig['id_groupe'];
                mysqli_query($conne,"INSERT INTO `appartenir` (`id_eleve`, `id_groupe`) VALUES ('$id', '$idGr')");
                echo "Etudiant ".$nom." ".$prenom. " est enregeste dans le groupe ".$idGr;
            }
            else{
            ?>
       

            
        <?php 
       $req5=mysqli_query($conne,"INSERT INTO `appartenir` (`id_eleve`, `id_groupe`) VALUES ('$id','$m')");
       echo "Etudiant ".$nom." ajouté dans le groupe ".$m;
        }
            ?>
            <div class="input-box">
                <label for="nbr">Nombre de Séances</label>
                <div class="seance">
                <input type="texe" name="nbr"  id="prix" placeholder="Saisi Nombre de Séances">
                <br>
                <div class="input-box">
                    <label for="m">The price</label>
                    <input type="text" id="place" name="m" disabled="all"  placeholder="">
                    <br><br>
                </div>
                </div>
                <br><br>
            </div>
            <input type="submit" name="SUIVANT" value="SUIVANT" class="s">
            
        </form>
    </section>
    </section>
    <script src="S-B3.js"></script> 
</body>
</html>



