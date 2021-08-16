const fill = (list,listCategorys) => {
   console.log(listCategorys);
    let table = "";
    let options = "";

    if(list.length > 0){
        for(let i = 0; i < list.length; i++) {
            table += `
			<tr>
				<td>${ i + 1 }</td>
				<td>${list[i].name}</td>
				<td>${list[i].datePremiere}</td>
				<td><img width="130" height="120" src="data:image/jpeg;base64,${list[i].imgGame}"></td>
				<td>${list[i].status ? "Activo" : "Inactivo"}</td>
				<td>
					<button type="button" class="btn btn-info">Ver</button>
					<button type="button" class="btn btn-primary">Modificar</button>
					<button type="button" class="btn btn-danger">Eliminar</button>
				</td>
			</tr>
			`;
        }
        for(let i = 0; i < listCategorys.length; i++) {
            options += `
            <option value="${listCategorys[i].idCategory}">${listCategorys[i].name}</option>
            `;
        }
    }else{
        table = `
		<tr class="text-center">
			<td colspan="7">No hay registros para mostrar</td>
		</tr>
		`;
    }
    $(`#container > tbody`).html(table);
    $(`#category_id`).html(options);
};

const findAll = () => {
    const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

    $.ajax({
        type: 'GET',
        url: contextPath + '/readGames',
        data: { }
    }).done(function(res){
        console.log(res);
        fill(res.listGames,res.listCategorys);
    });
};

findAll();


$('#btn-registrar').on('click',function(e){
    const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

    var nam,img,fech,cate;
    var data=new FormData();
    data.append("name",document.getElementById("name").value);
    data.append("date",document.getElementById("datePremiere").value);
    data.append("idCategory",document.getElementById("category_id").value);
    data.append("image",$('input[type=file]')[0].files[0]);
    data.append("action","create");

    $.ajax({
        url : contextPath + "/createGames" ,
        type: "POST",
        data:data,
        processData: false,
        contentType: false,
        success:function(resp){
       alert(resp.message);
    },
    error: function (jqXHR,estado,error){
        alert("Error")
    }

    })
})

