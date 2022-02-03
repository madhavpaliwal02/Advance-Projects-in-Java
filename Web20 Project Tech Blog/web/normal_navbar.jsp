<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><span class="fa fa-asterisk"></span> My Project</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <!--Home Page-->
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp"> <span class="fa fa-institution"></span> Home</a>
                </li>
                <!--Contact Page-->
                <li class="nav-item">
                    <a class="nav-link" href="#"> <span class="fa fa-address-book-o"></span> Contact</a>
                </li>
                <!--Categories-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <span class="fa fa-gear"></span> Categories
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Programming Languages</a></li>
                        <li><a class="dropdown-item" href="#">Projects Implementation</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Data Structures</a></li>
                    </ul>
                </li>
                <!--Login-->
                <li class="nav-item">
                    <a class="nav-link" href="login_page.jsp" tabindex="-1" aria-disabled="false">
                        <span class="fa fa-user-circle">Login</span> </a>
                </li>
                <!--Sign In-->
                <li class="nav-item">
                    <a class="nav-link" href="register_page.jsp" tabindex="-1" aria-disabled="false">
                        <span class="fa fa-user-plus">Sign Up</span> </a>
                </li>
            </ul>
            <!--Search Bar-->
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>