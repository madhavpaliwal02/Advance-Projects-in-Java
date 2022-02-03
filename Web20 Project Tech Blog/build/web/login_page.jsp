<%@page import="com.tech.blog.entities.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>

        <!--CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link href="CSS/style.css" rel="stylesheet" type="text/css"/>
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

        <main class="d-flex align-items-center" style="height:75vh">

            <div class="container">
                <div class="row">

                    <div class="col-md-4 offset-md-4">
                        <div class="card">

                            <div class="card-header primary-bg text-dark text-center">
                                <span class="fa fa-user-plus fa-3x"></span>
                                <p>Login Here!</p>
                            </div>


                            <%
                                Message msg = (Message) session.getAttribute("msg");
                                if (msg != null) {
                            %>

                            <div class="alert <%= msg.getCssClass() %>" role="alert">
                                <%= msg.getContent() %>
                            </div>

                            <% session.removeAttribute("msg");
                                }
                            %>

                            <div class="card-body">
                                <form action="LoginServlet">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Email address</label>
                                        <input name="userEmail" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input name="userPass" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                    </div>
                                    <div class="form-check">
                                        <input name="ckBox" type="checkbox" class="form-check-input" id="exampleCheck1">
                                        <label class="form-check-label" for="exampleCheck1">Check me out</label>
                                    </div>
                                    <div class="container text-center">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>

                </div>
            </div>

        </main>

        <!--JS-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
