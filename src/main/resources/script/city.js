function showALL(){
    $.ajax({
        type:"Get",
        url: "http://localhost:8080/api/cities",
        success: function (city){
            console.log(city)
            let str=``
            for (let i = 0; i < city.length; i++) {
                str+=`<tr>
                <th scope="row">${i}</th>
                <td>${city[i].name}</td>
                <td>${city[i].nation.name}</td>
                <td><button class="btn btn-success" > SỬA</button></td>
                <td><button class="btn btn-success" onclick="deleteCities(${city[i].id})"> XÓA</button></td>
                </tr>
                
 `
            }
            document.getElementById("content").innerHTML=str;
        }
    })
}
function deleteCities(id){
    if (confirm("Muốn xóa k nói 1 lời nào")) {
        $.ajax({
            type: "Delete",
            url: "http://localhost:8080/api/cities/" + id,
            success: showALL(),
            error: function (error) {
                alert("tạch")
            }

        })
    }
}
function showCreate(){
    let html = `<div>
  <div class="form-group ">
  <br>
    <label for="formGroupExampleInput"> Tên Thành Phố</label>
    <input type="text" class="form-control" id="name" placeholder="Nhập tên thành phố ?">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Diện tích</label>
    <input type="number" class="form-control" id="acreage" placeholder="Diện tích">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Dân số</label>
    <input type="number" class="form-control" id="population" placeholder="Dân số">
  </div><div class="form-group">
    <label for="formGroupExampleInput2">GDP</label>
    <input type="number" class="form-control" id="GDP" placeholder="GDP">
  </div><div class="form-group">
    <label for="formGroupExampleInput2">Giới thiệu</label>
    <input type="text" class="form-control" id="introduce" placeholder="giới thiêu">
  </div>
  <div class="form-group b-3">
  <label for="formGroupExampleInput2">Quốc gia</label>
  <select id="idNation" class="form-control ">`;

    $.ajax({
        type: "Get",
        url: "http://localhost:8080/api/cities/nation",
        success: function (nation) {
            console.log(nation)
            for (let i = 0; i < nation.length; i++) {
                html += ` <option value="${nation[i].id}">${nation[i].name}</option>`
            }
            html += '</select> <br> <button onclick="create()" class="btn btn-warning">create</button></div>'
            document.getElementById("content").innerHTML = html;
        },
        error: function (error) {
            alert("sai lè")
        }
    })
}
function create(){
let city ={
    name:document.getElementById("name").value,
    acreage:document.getElementById("acreage").value,
    population:document.getElementById("population").value,
    GDP:document.getElementById("GDP").value,
    introduce:document.getElementById("introduce").value,
    nation:{
        id:document.getElementById("idNation").value
    }
}
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/api/cities",
        data: JSON.stringify(city),
        success: function () {
            alert("Thêm thành công nè  ! ! !")
            showALL()
        },
        error: function (error) {
            console.log(error)
        }
    })
}


