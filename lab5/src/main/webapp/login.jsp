<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" action="LoginServlet" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username"  type="text" class="form-control" name="userName" placeholder="Username" value="${cookie.username != null ? cookie.username.value : ''}"
                    />
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" type="password" name="password" class="form-control" placeholder="Password" value="${cookie.password != null ? cookie.password.value : ''}" />

                </div>
                <div class="form-group">
                    <input type="checkbox" id = "check1" name = "cb1" value = "remember">
                    <label for="check1"> Remember username & password</label>
                </div>
                <% if(request.getAttribute("message") != null) { %>

                    <div class="form-group">
                        <div class="alert alert-danger alert-dismissible fade show">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <p><%= request.getAttribute("message") %></p>
                        </div>
                    </div>
                <% } %>

                <div class="form-group">
                    <button class="btn btn-success px-5" type="submit">Login</button>
                </div>
                <div class="form-group">
                    <p>Forgot password? <a href="#">Click here</a></p>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
