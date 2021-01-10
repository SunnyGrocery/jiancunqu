var admin = {

    id: "",
    name: "",
    phoneNum: "",
    realIdNum: "",
    volume: "",
};

function modifyPost(id) {
    post('/admin/modify', {
        id: id,
        phoneNum: document.getElementById('phoneNumModify' + id).value,
        realIdNum: document.getElementById('realIdNumModify' + id).value,
        volume: document.getElementById('volumeModify' + id).value,
    });
}

function forbidPost(id, available) {
    post('/admin/forbid', {
        id: id,
        available: available,
    });
}

function addPost() {
    post('/admin/add', {
        id: document.getElementById('idAdd').value,
        name: document.getElementById('nameAdd').value,
        pwd: document.getElementById('pwdAdd').value,
        phoneNum: document.getElementById('phoneNumAdd').value,
        realIdNum: document.getElementById('realIdNumAdd').value,
        available: true,
    });
}
function deletePost(id) {
    post('/admin/delete', {
        id: id,
    });
}

function post(URL, PARAMS) {
    var temp = document.createElement("form");
    temp.action = URL;
    temp.method = "post";
    temp.style.display = "none";
    for (var x in PARAMS) {
        var opt = document.createElement("textarea");
        opt.name = x;
        opt.value = PARAMS[x];
        temp.appendChild(opt);
    }
    document.body.appendChild(temp);
    temp.submit();
    return temp;
}