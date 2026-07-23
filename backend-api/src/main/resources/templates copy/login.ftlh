<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ClipzConnect - Login</title>
        <link rel="stylesheet" href="/styles.css">
    </head>

    <body>

        <!-- ================= NAVBAR ================= -->
        <nav class="navbar">

            <div class="nav-left">
                <img src="/images/ClipzConnectLogo.jpg.jpeg" class="logo" alt="Logo">
                <h2>ClipzConnect</h2>
            </div>

            <div class="nav-right">
                <a href="/index">Home</a>
                <a href="/customer/new">Sign Up</a>
                <img src="/images/profileIcon.jpg" class="profile-icon" alt="Profile">
            </div>

        </nav>

        <!-- ================= LOGIN BOX ================= -->
        <main>

            <div class="signup-section">

                <div class="signup-card">

                    <h1>Sign In</h1>

                    <p>Welcome back!</p>

                    <#if error??><p class="error">${error}</p></#if>

                    <!-- Login Form -->
                    <form action="/customer/login" method="post">

                        <input type="email" name="email" placeholder="Email Address" required>
                        <input type="password" name="password" placeholder="Password" required>

                        <button type="submit" class="create-account-btn">
                            Sign In
                        </button>

                        <p class="signin-text">
                            Don’t have an account?
                            <a href="/customer/new" class="signin-link">Create Account</a>
                        </p>

                    </form>

                </div>

            </div>

        </main>

        <!-- ================= FOOTER ================= -->
        <footer>
            <p>&copy; 2026 ClipzConnect. Created as an educational project.</p>
        </footer>
    </body>
</html>