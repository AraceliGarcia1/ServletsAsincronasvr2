const fill = (list) => {
    let table = "";

    if(list.length > 0){
        for(let i = 0; i < list.length; i++) {
            table += `
			<tr>
				<td>${ i + 1 }</td>
				<td>${list[i].name}</td>
				<td>${list[i].datePremiere}</td>
				<td><img src="data:image/jpeg;base64,${list[i].imgGame}"></td>
				<td>${list[i].status ? "Activo" : "Inactivo"}</td>
				<td>
					<button type="button" class="btn btn-info">Ver</button>
					<button type="button" class="btn btn-primary">Modificar</button>
					<button type="button" class="btn btn-danger">Eliminar</button>
				</td>
			</tr>
			`;
        }
    }else{
        table = `
		<tr class="text-center">
			<td colspan="5">No hay registros para mostrar</td>
		</tr>
		`;
    }
    $(`#container > tbody`).html(table);
};

const findAll = () => {
    const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

    $.ajax({
        type: 'GET',
        url: contextPath + '/readGames',
        data: { }
    }).done(function(res){
        fill(res.listGames);
    });
};

findAll();


$('#main form').on('submit',function(e){
    e.preventDefault
    $(document).on ('ready',function(){
        var pet = $('#main form').attr('action');
        var net = $('#main form').attr('method');
        var nam,img,fech,cate;

        $.ajax({
            beforeSend: function (){
                nam = document.fo.nombre.value;
                img = document.fo.imagen.value;
                fech = document.fo.datePremiere.value
                cate= document.fo.Category_idCategoria.name.value
            },
            url : pet,
            type: met,
            data:{name:nam,imgGame:img,datePremiere:fech,Category_idCategoria.name:cate},
        success:function(resp){
            $('#status').html()
            console.log(resp)
        },
        error: function (jqXHR,estado,error){
            $('#status').html()
            console.log(estado)
            console.log(error)
        },
        complete: function (jqXHR,estado){
            console.log(estado)
        },


    })


    })

})

