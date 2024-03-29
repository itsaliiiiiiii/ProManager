<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Montserrat', sans-serif;
            background: url('your-background-image.jpg') center/cover no-repeat; /* Add your background image */
        }

        .formulaire {
            font-size: 20px;
            box-shadow: 0 0 30px rgba(0, 0, 0, 0.15);
            background-color: #ffffff; /* Light background color */
            width: 30%;
            max-width: 400px;
            padding: 20px;
            text-align: center;
            border-radius: 10px;
        }

        .formulaire .info {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50; /* Green submit button color */
            color: #fff; /* Text color */
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049; /* Darker green color on hover */
        }
    </style>
        <body>
    <div class="formulaire">
    <form action="affich_cours_ss.php" method="post">
        <div class="info">
        <Label for="JR">Jour :</Label><br>
        <select name="JR" id="">
            <option>lundi</option>
            <option>mardi</option>
            <option>mercredi</option>
            <option>jeudi</option>
            <option>vendredi</option>
            <option>samedi</option>
        </select><br><br>
        <input type="submit" value="Confirmer" name="confirmer">
    </div>
    </form>
        </div>

</body>
</html>
