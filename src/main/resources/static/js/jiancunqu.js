var admin = {

    id: "",
    name: "",
    phoneNum: "",
    realIdNum: "",
    volume: "",
};

function modifyModalDisplay(id, name, phoneNum, realIdNum, volume) {
    admin.id = id;
    admin.name = name;
    admin.phoneNum = phoneNum;
    admin.realIdNum = realIdNum;
    admin.volume = volume;
    document.getElementById("phoneNumModify").value = phoneNum;
    document.getElementById("realIdNumModify").value = realIdNum;
    document.getElementById("volumeModify").value = volume;
}

function modifyPost() {
    admin.phoneNum = document.getElementById("phoneNumModify").value;
    admin.realIdNum = document.getElementById("realIdNumModify").value;
    admin.volume = document.getElementById("volumeModify").value;
    post('/admin/modify', {
        id: admin.id,
        name: admin.name,
        phoneNum: admin.phoneNum,
        realIdNum: admin.realIdNum,
        volume: admin.volume,
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