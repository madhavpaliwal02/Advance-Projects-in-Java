
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!--CSS-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .banner-background{
                clip-path: polygon(25% 0%, 100% 0%, 75% 100%, 0% 100%);
            }
        </style>
    </head>
    <body>

        <!--Navbar-->
        <%@include file="normal_navbar.jsp" %>

        <main class="primary-bg p-5 banner-background">

            <div class="container align-items-center">
                <div class="col-md-6 offset-md-3">

                    <div class="card">
                        <div class="card-header text-center" style="background: lightcyan">
                            <span class="fa fa-3x fa-user-circle-o"></span>
                            <br/>
                            Register Here !</div>
                        <div class="card-body">
                            <form id="reg-form" action="RegisterServlet" method="POST">

                                <div class="form-group">
                                    <label for="user_name">User Name</label>
                                    <input name="user_name" type="text" class="form-control" id="exampleInputUsername1" aria-describedby="emailHelp" placeholder="Enter Username">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input name="user_email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input name="user_pass" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>

                                <div class="form-group">
                                    <label for="gender">Select Gender</label>
                                    <br/>
                                    <input type="radio" name="gender" value="Male" /> Male
                                    <input type="radio" name="gender" value="Female" /> Female
                                    <input type="radio" name="gender" value="Other" /> Other
                                </div>      

                                <div class="form-group">
                                    <textarea class="form-control" name="about" id="" rows="4" placeholder="Enter about yourself" ></textarea>
                                </div>

                                <div class="form-check">
                                    <input name="ckbox" type="checkbox" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">Agree terms and conditions</label>
                                </div>
                                <br/>
                                <br/>

                                <div class="container text-center" id="loader" style=" display: none">
                                    <span class="fa fa-refresh fa-spin fa-3x"></span>
                                    <h4>Please Wait..</h4>
                                </div>

                                <button id="submit-btn" type="submit" class="btn btn-primary">Submit</button>
                            </form>

                        </div>
                    </div>

                </div>
            </div>

        </main>


        <!--JS-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <script src="JS/newjs.js" type="text/javascript"></script>
        <!--        <script>
                    $(document).ready(function () {
                        console.log("loaded...")
        
                        $('#reg-form').on('submit', function (event) {
                            event.preventDefault();
        
                            let form = new FormData(this);
                            $("#$submit-btn").hide();
                            $("#loader").show();
                            // send register servlet
                            $.ajax({
                                url: "RegisterServlet",
                                type: 'POST',
                                data: form,
        
                                success: function (data, textStatus, jqXHR) {
                                    console.log(data)
        
                                    $("#$submit-btn").show();
                                    $("#loader").hide();
                                    if (data.trim() === 'done') {
                                        swal("Registered Successfully...\n\
                                            We are Redirecting to the login page...")
                                                .then((value) => {
                                                    window.location = "login_page.jsp"
                                                });
                                    } else {
                                        swal(data);
                                    }
                                }, // success end
        
                                error: function (jqXHR, textStatus, errorThrown) {
                                    console.log(jqXHR)
        
                                    $("#$submit-btn").show();
                                    $("#loader").hide();
                                    swal("Something went wrong ! Please try again...")
                                }, // error end
        
                                processData: false,
                                contentType: false
        
                            }); // ajax end
                        }); // on end
                    });  // ready end
                </script>-->

        <script>
            $(document).ready(function () {
                console.log("loaded........")
                $('#reg-form').on('submit', function (event) {
                    event.preventDefault();
                    let form = new FormData(this);
                    $("#submit-btn").hide();
                    $("#loader").show();
                    //send register servlet:
                    $.ajax({
                        url: "RegisterServlet",
                        type: 'POST',
                        data: form,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data)
                            $("#submit-btn").show();
                            $("#loader").hide();
                            if (data.trim() === 'done')
                            {
                                swal("Registered successfully..We are going to redirect to login page")
                                        .then((value) => {
                                            window.location = "login_page.jsp"
                                        });
                            } else
                            {
                                swal(data);
                            }
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $("#submit-btn").show();
                            $("#loader").hide();
                            swal("something went wrong..try again");
                        },
                        processData: false,
                        contentType: false
                    });
                });
            });
        </script>


    </body>
</html>
