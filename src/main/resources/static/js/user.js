let index = {
    init:function () {
        $("#btn-save").on("click", ()=>{
            this.save();
        });
    },

    save:function (){
        let data = {
            username:$("#username").val(),
            password:$("#password").val(),
            email:$("#email").val()
        };

        $.ajax({
            type: "post",
            url: "/blog/api/user",
            data:JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            if(resp.status === 200) {
                alert("회원 가입이 완료되었습니다.");
                location.href = "/blog";
            }else {
                console.log(resp)
                alert("회원 가입 실패\n" +
                    JSON.stringify(resp));
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    }
}

index.init()