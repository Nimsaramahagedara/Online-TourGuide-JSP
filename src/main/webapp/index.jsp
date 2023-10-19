<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Tour Guide</title>
    <script src="https://kit.fontawesome.com/24b485c31a.js" crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
    <link rel="stylesheet" href="styles/style.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;600&display=swap" rel="stylesheet">
</head>
<body>
    <header>
        <div class="logo">
            <img src="images/logo.png" alt="">
            <p class="logo-text">| The Online Tour Guide</p>
        </div>
        <div class="menu">
            <div class="user-icon">
               <i class="fa-solid fa-user"></i> 
            </div>
            
            <a href="" class="sign-in" style="display:none ;">Sign in</a>
            <i class="fa-solid fa-chevron-down" onclick="menu()" id="menubtn"></i>

            <div class="drop-menu">
                <a href="">My Bookings</a>
                <a href="">My Account</a>
                <a href="">My Bookings</a>
                <a href="">My Bookings</a>
                <a href="">My Account</a>
                <a href="" class="sign-out">Sign Out</a>
            </div>
        </div>

    </header>
<!--Main Banner-->
    <div class="banner">
        <form action="" class="search-form" method="GET">
            <h1>A World of Endless Travel Possibilities</h1>
            <p>See the world via screen, plan your trip for the best experience.</p>
            <div class="search-field">
                <i class="fa-solid fa-magnifying-glass"></i>
                <input type="text" class="search-bar" placeholder="Search" name="search">
            </div>

            <a href="">Explore Now</a>
            <input type="submit" value="" style="visibility:hidden ;">
            
        </form>

    </div>
<!--Explore Section-->
    <section class="explore">
        <div class="explore-text">
            <h1>Explore the beauty in one click</h1>
            <p>No matter where you are, the world is in front of you.</p>
        </div>
        <div class="explore-images">
            <div class="image-box">
                <img src="images/Explore/america.jpg" alt="">
                <a href="" class="text">
                    <h2>America</h2>
                    <p>Tour in America</p>
                </a>
            </div>
            <div class="image-box">
                <img src="images/Explore/Australia.jpg" alt="">
                <a href="" class="text">
                    <h2>Australia</h2>
                    <p>Tour in Australia</p>
                </a>
            </div>
            <div class="image-box">
                <img src="images/Explore/Europe.jpeg" alt="">
                    <a href="" class="text">
                        <h2>Europe</h2>
                        <p>Tour in Europe</p>
                    </a>    
            </div>
            <div class="image-box">
                <img src="images/Explore/africa.jpg" alt="">
                <a href="" class="text">
                    <h2>Africa</h2>
                    <p>Tour in Africa</p>
                </a>
            </div>
        </div>
    </section>
    <section class="tours">
        <div class="text">
            <h1>All Tours</h1>
            <p>Move the world in your screen, talk to guide in real-time.</p>
        </div>
        <div class="tour-container">
            <div class="tour">
                <a href="" class="image">
                    <img src="images/TourImages/1.jpg" alt="">
                </a>
                <h2>Tour Name</h2>
                <p>Brief</p>
                <a href="" class="price-and-go">
                    <h2>USD <span>20</span></h2>
                    <i class="fa-regular fa-circle-right"></i>
                </a>
            </div>
            <div class="tour">
                <a href="" class="image">
                    <img src="images/TourImages/1.jpg" alt="">
                </a>
                <h2>Tour Name</h2>
                <p>Brief</p>
                <a href="" class="price-and-go">
                    <h2>USD <span>20</span></h2>
                    <i class="fa-regular fa-circle-right"></i>
                </a>
            </div>
            <div class="tour">
                <a href="" class="image">
                    <img src="images/TourImages/1.jpg" alt="">
                </a>
                <h2>Tour Name</h2>
                <p>Brief</p>
                <a href="" class="price-and-go">
                    <h2>USD <span>20</span></h2>
                    <i class="fa-regular fa-circle-right"></i>
                </a>
            </div>
            <div class="tour">
                <a href="" class="image">
                    <img src="images/TourImages/1.jpg" alt="">
                </a>
                <h2>Tour Name</h2>
                <p>Brief</p>
                <a href="" class="price-and-go">
                    <h2>USD <span>20</span></h2>
                    <i class="fa-regular fa-circle-right"></i>
                </a>
            </div>



            <div class="tour">
                <a href="" class="image">
                    <img src="images/TourImages/1.jpg" alt="">
                </a>
                <h2>Tour Name</h2>
                <p>Brief</p>
                <a href="" class="price-and-go">
                    <h2>USD <span>20</span></h2>
                    <i class="fa-regular fa-circle-right"></i>
                </a>
            </div>
            <div class="tour">
                <a href="" class="image">
                    <img src="images/TourImages/1.jpg" alt="">
                </a>
                <h2>Tour Name</h2>
                <p>Brief</p>
                <a href="" class="price-and-go">
                    <h2>USD <span>20</span></h2>
                    <i class="fa-regular fa-circle-right"></i>
                </a>
            </div>
            <div class="tour">
                <a href="" class="image">
                    <img src="images/TourImages/1.jpg" alt="">
                </a>
                <h2>Tour Name</h2>
                <p>Brief</p>
                <a href="" class="price-and-go">
                    <h2>USD <span>20</span></h2>
                    <i class="fa-regular fa-circle-right"></i>
                </a>
            </div>
            <div class="tour">
                <a href="" class="image">
                    <img src="images/TourImages/1.jpg" alt="">
                </a>
                <h2>Tour Name</h2>
                <p>Brief</p>
                <a href="" class="price-and-go">
                    <h2>USD <span>20</span></h2>
                    <i class="fa-regular fa-circle-right"></i>
                </a>
            </div>

        </div>

        <div class="page-navigator">
            <a href="">1</a>
            <a href="">2</a>
            <a href="">3</a>
            <a href="">4</a>
            <a href="">5</a>
            <a href="">Next</a>
        </div>
    </section>

<!--Footer-->
    <div class="footer">
        <div class="foot-box">
            <img src="images/logowithSlogan.png" alt="">
            <div class="social-icons">
               <a href=""><i class="fa-brands fa-linkedin"></i></a> 
               <a href=""><i class="fa-brands fa-square-facebook"></i></a> 
               <a href=""><i class="fa-brands fa-square-twitter"></i></a> 
               <a href=""><i class="fa-brands fa-square-instagram"></i></a> 
               <a href=""><i class="fa-brands fa-youtube"></i></a> 
            </div>
        </div>
        <div class="foot-box">
            <a href="">About us</a>
            <a href="">Become our guide</a>
            <a href="">Terms & Condition</a>
            <a href="">Terms & Condition</a>
        </div>
        <div class="foot-box">
            <a href="">About us</a>
            <a href="">Become our guide</a>
            <a href="">Terms & Condition</a>
            <a href="">Terms & Condition</a>
        </div>
    </div>
    <footer>
        <p>2022 Glide All Right Reserved <a href="mailto:glide@gmail.com">contact@glide.com</a></p>
    </footer>
    
</body>
</html>