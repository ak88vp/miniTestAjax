function loadHomeContent() {
    let html = `<div class="col-9" id="list-product"></div>
        <div class="col-3" id="categorys"></div>`;
    document.getElementById('content').innerHTML = html;
    loadListHome()
    loadListCategory()
}

function loadListHome() {
    $.ajax({
        type: "Get",
        url: "http://localhost:8080/api/homes",
        success: function (homes) {
            console.log(homes)
            let html = `<div class="row p-3">`;
            for (let i = 0; i < homes.length; i++) {
                html += `<div class="col-4 p-3 ">
                            <div class="card align-items-center">
                              <img src="https://noithattrevietnam.com/uploaded/Kien-thuc-nha-dep/hinh-anh-nha-2-tang-mai-thai/1-hinh-anh-nha-2-tang-mai-thai.jpg" class="card-img-top" alt="...">
                              <div class="card-body">
                                <h5 class="card-title">${homes[i].name}</h5>
                               <a href="#" class="btn btn-primary" onclick="findOneSt(${homes[i].id})"> Chi tiết</a>
                              </div>
                            </div>
                            </div>`
            }
            html += `</div>`;
            document.getElementById('list-product').innerHTML = html;
        },
        error: function (error) {
            alert("lỗi b ưi")
        }
    })
}

function showCreate() {
    let html = `<div>
  <div class="form-group ">
  <br>
    <label for="formGroupExampleInput">Tên Nhà</label>
    <input type="text" class="form-control" id="name" placeholder="Nhập tên nhà ?">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Phòng Tắm</label>
    <input type="text" class="form-control" id="bathroom" placeholder="Số phòng tắm">
  </div>
  <div class="form-group b-3">
  <label for="formGroupExampleInput2">Thể loại</label>
  <select id="idCategory" class="form-control ">`;

    $.ajax({
        type: "Get",
        url: "http://localhost:8080/api/homes/category",
        success: function (categorys) {
            console.log(categorys)
            for (let i = 0; i < categorys.length; i++) {
                html += ` <option value="${categorys[i].id}">${categorys[i].name}</option>`
            }
            html += '</select> <br> <button onclick="saveHome1()" class="btn btn-warning">create</button></div>'
            document.getElementById("list-product").innerHTML = html;
        },
        error: function (error) {
            alert("sai lè")
        }
    })

}

function saveHome1() {
    let home = {
        name: document.getElementById("name").value,
        bathroom: document.getElementById("bathroom").value,
        category: {
            id: document.getElementById("idCategory").value
        }
    }
    console.log(home)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/api/homes",
        data: JSON.stringify(home),
        success: function (home) {
            alert("Thêm thành công nè  ! ! !")
            loadHomeContent()
        },
        error: function (error) {
            console.log(error)
        }
    })
}

function loadListCategory() {
    $.ajax({
        type: "Get",
        url: "http://localhost:8080/api/homes/category",
        success: function (category) {
            console.log(category)
            let html = `<div class="row p-3">`;
            for (let i = 0; i < category.length; i++) {
                html += '<div class="col-12 category p-3 m-2"><h5>' + category[i].name + '</h5></div>'
            }
            html += `</div>`;
            document.getElementById('categorys').innerHTML = html;
        },
        error: function (error) {
            alert("lỗi b ưi")
        }
    })
}

function findOneSt(id) {
    console.log(id);
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/homes/" + id,
        success: function (home) {
            console.log(home)
            document.getElementById("list-product").innerHTML = " <a href='' onclick=\"loadHomeContent()\"> Quay lại</a>" + "<br>" +
                "  <img class='girl' src=\"https://media.baodautu.vn/Images/chicuong/2019/07/27/mvl7y4jk.jpg\" alt=\"\">" + "<br>" +
                "<p>" + 'Tên   :   ' + home.name + "</p>" +
                "<p>" + 'Phòng tắm  :   ' + home.bathroom + "</p>" +
                "<p>" + 'Thể Loại  :   ' + home.category.name + "</p>" +
                "<p>" + 'Mô tả :   ' + home.category.description + "</p>" +
                `<button class="btn btn-warning" href='' onclick='deleteHome(${home.id})'> Xóa</button> &nbsp &nbsp &nbsp  &nbsp` +
                `<button class="btn btn-warning"  onclick='showEdit(${home.id})'> Edit </button>`

        }
    })
}

function showEdit(id) {
    console.log(id)
    let str='';
    $.ajax({
        type: "Get",
        url: "http://localhost:8080/api/homes/"+id,
        success:function (home){
            console.log(home)
            str+=`<div>
  <div class="form-group ">
  <br>
    <label for="formGroupExampleInput">Tên Nhà</label>
    <input type="text" class="form-control" id="name" value="${home.name}">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Phòng Tắm</label>
    <input type="text" class="form-control" id="bathroom" value="${home.bathroom}" >
  </div>
  <div class="form-group b-3">
  <label for="formGroupExampleInput2">Thể loại</label>
  <select id="idCategory" class="form-control ">\`;`

            $.ajax({
                type: "Get",
                url: "http://localhost:8080/api/homes/category",
                success: function (categorys) {
                    console.log(categorys)
                    for (let i = 0; i < categorys.length; i++) {
                        str += ` <option value="${categorys[i].id}">${categorys[i].name}</option>`
                    }
                    str += '</select> <br>'+ ' <button class="btn btn-warning" onclick="saveEdit1(' + home.id + ')">Save</button> </div>'
                    document.getElementById("list-product").innerHTML = str
                }
            })

        },
        error: function (error) {
            console.log(error)
        }
    })

}

function deleteHome(id) {
    console.log(id)
    if (confirm("Muốn xóa k nói 1 lời nào")) {
        $.ajax({
            type: "Delete",
            url: "http://localhost:8080/api/homes/" + id,
            success: loadListHome,
            error: function (error) {
                alert("tạch")
            }

        })
    } else findOneSt(id)


}
function saveEdit1(id){
    let home={
        name:document.getElementById("name").value,
        bathroom:document.getElementById("bathroom").value,
        category: {
            id:document.getElementById("idCategory").value,
        }
    }
    console.log(home)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json' // quy định kiểu dữ liệu trả về là json cho backend sử lý
        },
        type: "Put",
        url: "http://localhost:8080/api/homes/"+id,
        data: JSON.stringify(home),// chuyển đổi dữ liệu từ js thành json .
        success: loadHomeContent,
        error: function (error) {
            console.log(error)}
    })

}

function findByName() {
    let key = document.getElementById("key").value;
    console.log(key)
    $.ajax({
        type: "Get",
        url: "http://localhost:8080/api/homes/search?key=" + key,
        success: function (homes) {
            console.log(homes)
            let html = `<div class="row p-3">`;
            for (let i = 0; i < homes.length; i++) {
                html += `<div class="col-4 p-3 ">
                            <div class="card align-items-center">
                              <img src="https://noithattrevietnam.com/uploaded/Kien-thuc-nha-dep/hinh-anh-nha-2-tang-mai-thai/1-hinh-anh-nha-2-tang-mai-thai.jpg" class="card-img-top" alt="...">
                              <div class="card-body">
                                <h5 class="card-title">${homes[i].name}</h5>
                               <a href="#" class="btn btn-primary" onclick="findOneSt(${homes[i].id})">Go somewhere</a>
                              </div>
                            </div>
                            </div>`
            }
            html += `</div>`;
            document.getElementById('list-product').innerHTML = html;

        }
    })


}

