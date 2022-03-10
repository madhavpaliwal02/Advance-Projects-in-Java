function doLike(pid, uid) {
    console.log(pid + ", " + uid);

    const d = {
        uid: uid,
        pid: pid,
        operation: 'like'
    }

    $.ajax({
        url: "LikeServlet",
        data: d,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
        },
        error: function (jqXHR, textStatus, errorThrows) {
            console.log(data)
        }
    })
}