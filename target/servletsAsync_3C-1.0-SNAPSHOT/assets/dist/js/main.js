function listOfGames(){

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/servletsAsync_3C_war/readGames'

    }).done(function(res){

        let game = res.listGames;
        let tableBody = document.querySelector('#bodyGames');
        tableBody.innerHTML = '';
        for(let count of game){
            tableBody.innerHTML += ` 
           <td>${count.name}</td>
           <td>${count.datePremiere}</td>
           <td><img src="data:image/jpg;base64,${game.imgGame}"></td>
           <td>${count.Category_idCategory.name}</td>
           `
        }
    });
}
