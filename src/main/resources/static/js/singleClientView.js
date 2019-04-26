$("a#createapp").click(function(){

    var _data = {};
    _data["clientId"] = $(this).data("clientid");
    _data["firstName"] = $(this).data("firstname");
    _data["secondName"] = $(this).data("secondname");
    _data["thirdName"] = $(this).data("thirdname");

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/appointment",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "";
            $('#result').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-add").prop("disabled", false);
            location.reload();

        },
        error: function (e) {

            var json = e.responseText;
            $('#result').html(json);
            $("a#clickview").hide();
            console.log("ERROR : ", e);
            $("#btn-add").prop("disabled", false);
        }
    });

});

$("a#delete").click(function(){
    var $row = $(this).closest("tr");    // Find the row
    var $text = $row.find(".id").text();

    var _data = {};
    _data["id"] = $text;

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/delete/appointment",
        data: JSON.stringify(_data),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            
            console.log("SUCCESS : ", data);
            location.reload();

        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

});

$("a#upload").click(function(){
    var x = document.getElementById("fileDisplay");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
});

$(document).ready(function () {
    $("#btnSubmit").click(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        saveFile();
    });
});

function saveFile() {
    
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
    data.append("CustomField", "This is some extra data, testing");
    $("#btnSubmit").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/admin/doUpload",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("SUCCESS : ", data);
            $("#btnSubmit").prop("disabled", false);

        },
        error: function (e) {
            console.log("ERROR : ", e);
            $("#btnSubmit").prop("disabled", false);

        }
    });

}

function getFileParam() {
    
    //todo розібратися з цим
    try {
        var file = document.getElementById('file').files[0];

        if (file) {
            var fileSize = 0;

            if (file.size > 1024 * 1024) {
                fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
            } else {
                fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
            }

            document.getElementById('file-name1').innerHTML = 'Имя: ' + file.name;
            document.getElementById('file-size1').innerHTML = 'Розмір: ' + fileSize;
            saveFile();
            document.getElementById('file-result').innerHTML = 'Файл успішно завантажено';

            if (/\.(jpe?g|bmp|gif|png)$/i.test(file.name)) {
                var elPreview = document.getElementById('preview1');
                elPreview.innerHTML = '';
                var newImg = document.createElement('img');
                newImg.className = "preview-img";

                if (typeof file.getAsDataURL == 'function') {
                    if (file.getAsDataURL().substr(0, 11) == 'data:image/') {
                        newImg.onload = function () {
                            document.getElementById('file-name1').innerHTML += ' (' + newImg.naturalWidth + 'x' + newImg.naturalHeight + ' px)';
                        };
                        newImg.setAttribute('src', file.getAsDataURL());
                        elPreview.appendChild(newImg);
                    }
                } else {
                    var reader = new FileReader();
                    reader.onloadend = function (evt) {
                        if (evt.target.readyState == FileReader.DONE) {
                            newImg.onload = function () {
                                document.getElementById('file-name1').innerHTML += ' (' + newImg.naturalWidth + 'x' + newImg.naturalHeight + ' px)';
                            };

                            newImg.setAttribute('src', evt.target.result);
                            elPreview.appendChild(newImg);
                        }
                    };

                    var blob;
                    if (file.slice) {
                        blob = file.slice(0, file.size);
                    } else if (file.webkitSlice) {
                        blob = file.webkitSlice(0, file.size);
                    } else if (file.mozSlice) {
                        blob = file.mozSlice(0, file.size);
                    }
                    reader.readAsDataURL(blob);
                }
            }
        }
    } catch (e) {
        var file = document.getElementById('file').value;
        file = file.replace(/\\/g, "/").split('/').pop();
        document.getElementById('file-name1').innerHTML = 'Имя: ' + file;
    }
}

$("button#downloadFile").click(function() {

    var _data = {};
    _data["fileId"] = $(this).data("fileid");
    _data["fileName"] = $(this).data("filename");

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/admin/client/downloadFile/" + $(this).data("fileid"),
        cache: false,
        timeout: 600000,
        success: function (data, status, xhr) {
            window.location.href = "/admin/client/downloadFile/" + _data["fileId"];
            //window.open(data.fileUrl);
            // window.location.href = '${pageContext.request.contextPath}/licenses/downloadFile/' + data;
            // window.open(data.fileUrl);
            // var ct = xhr.getResponseHeader("content-type") || "";
            //
            // var nameOffile = _data["fileName"];
            //
            // var formatOfFile = nameOffile.slice((Math.max(0, nameOffile.lastIndexOf(".")) || Infinity) + 1);
            //
            // var textFile = null,
            //     makeTextFile = function (text) {
            //
            //         var fileData = new Blob([text], {type: 'text/plain; charset=UTF-8"'});
            //
            //         // If we are replacing a previously generated file we need to
            //         // manually revoke the object URL to avoid memory leaks.
            //         if (textFile !== null) {
            //             window.URL.revokeObjectURL(textFile);
            //         }
            //
            //         textFile = window.URL.createObjectURL(fileData);
            //
            //         return textFile;
            //     };
            //
            // var link = document.getElementById('downloadlink');
            // // link.href = makeTextFile(data);
            // link.href = window.URL.createObjectURL(data);
            // link.download = nameOffile;
            // // link.style.display = 'block';
            //
            // document.getElementById('downloadlink').click();
            //

        },
        error: function (e) {

            // var nameOffile = _data["fileName"];
            //
            // var formatOfFile = nameOffile.slice((Math.max(0, nameOffile.lastIndexOf(".")) || Infinity) + 1);
            //
            // var textFile = null,
            //     makeTextFile = function (text) {
            //
            //         var data = new Blob([text], {type: 'image/png'});
            //
            //         // If we are replacing a previously generated file we need to
            //         // manually revoke the object URL to avoid memory leaks.
            //         // if (textFile !== null) {
            //         //     window.URL.revokeObjectURL(textFile);
            //         // }
            //
            //         textFile = window.URL.createObjectURL(data);
            //
            //         return textFile;
            //     };
            //
            //     var link = document.getElementById('downloadlink');
            //     link.href = makeTextFile(e.responseText);
            //     link.download = nameOffile;
            //     // link.style.display = 'block';
            //
            // document.getElementById('downloadlink').click();


        }
    });

});