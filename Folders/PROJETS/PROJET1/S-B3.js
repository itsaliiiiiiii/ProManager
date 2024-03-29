function changerMatiere2() {
    var NvSelect = document.getElementById("NV");
    var MaSelect = document.getElementById("MA");

    // Efface les options actuelles
    MaSelect.innerHTML = "";
  
    // Options dépendantes du pays sélectionné
    if (NvSelect.value === "1AC" || NvSelect.value==="2AC" || NvSelect.value==="TC") {
      ajouterOption(MaSelect, "ggg", "MATH");
      ajouterOption(MaSelect, "bbb", "PC");
      ajouterOption(MaSelect, "ddd", "SVT");
      // Ajoutez d'autres régions de la France au besoin
    } else if (NvSelect.value === "3AC" || NvSelect.value==="1BAC") {
      ajouterOption(MaSelect, "PC", "PC");
      ajouterOption(MaSelect, "MATH", "MATH");
      ajouterOption(MaSelect, "SVT", "SVT");
      ajouterOption(MaSelect, "FR", "FR");
      ajouterOption(MaSelect, "HG", "HG");
      ajouterOption(MaSelect, "EI", "EI");
      // Ajoutez d'autres régions de l'Espagne au besoin
    }
    else if(NvSelect.value==="2BAC"){
        ajouterOption(MaSelect, "PC", "PC");
        ajouterOption(MaSelect, "MATH", "MATH");
        ajouterOption(MaSelect, "SVT", "SVT");
        ajouterOption(MaSelect, "PH", "PH");
        ajouterOption(MaSelect, "AN", "AN");
    }
    // Ajoutez d'autres pays avec leurs régions au besoin
  }
  function changerMatiere() {
    var NvSelect = document.getElementById("NV");
    var MaSelect = document.getElementById("MA");
  
    // Efface les options actuelles
    MaSelect.innerHTML = "";
  
    // Options dépendantes du pays sélectionné
    if (NvSelect.value === "1AC" || NvSelect.value==="2AC" || NvSelect.value==="TC") {
      ajouterOption(MaSelect, "MATH", "MATH");
      ajouterOption(MaSelect, "PC", "PC");
      ajouterOption(MaSelect, "SVT", "SVT");
      // Ajoutez d'autres régions de la France au besoin
    } else if (NvSelect.value === "3AC" || NvSelect.value==="1BAC") {
      ajouterOption(MaSelect, "PC", "PC");
      ajouterOption(MaSelect, "MATH", "MATH");
      ajouterOption(MaSelect, "SVT", "SVT");
      ajouterOption(MaSelect, "FR", "FR");
      ajouterOption(MaSelect, "HG", "HG");
      ajouterOption(MaSelect, "EI", "EI");
      // Ajoutez d'autres régions de l'Espagne au besoin
    }
    else if(NvSelect.value==="2BAC"){
        ajouterOption(MaSelect, "PC", "PC");
        ajouterOption(MaSelect, "MATH", "MATH");
        ajouterOption(MaSelect, "SVT", "SVT");
        ajouterOption(MaSelect, "PH", "PH");
        ajouterOption(MaSelect, "AN", "AN");
    }
    // Ajoutez d'autres pays avec leurs régions au besoin
  }
  
  function ajouterOption(select, valeur, texte) {
    var option = document.createElement("option");
    option.value = valeur;
    option.text = texte;
    select.add(option);
  }
  let option=document.getElementById("NV");
  option.addEventListener("click",function () {
    changerMatiere()
    
  })
  let placeholder=document.getElementById("place")
  let price=document.getElementById("prix");
  price.addEventListener("click",event1);
  price.addEventListener("blur",event1);
  price.addEventListener("dbclick",event1);
  price.addEventListener("focus",event1);
  price.addEventListener("focusout",event1);
  price.oninput = function() {event1()};
  function event1() {
    let a=price.value
    placeholder.placeholder=a*150
    console.log(a)

  }
