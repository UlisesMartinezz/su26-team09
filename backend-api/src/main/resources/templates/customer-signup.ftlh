<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ClipzConnect - Sign Up</title>
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
            <a href="/customer/login">Sign In</a>
            <img src="/images/profileIcon.jpg" class="profile-icon" alt="Profile">
        </div>

    </nav>

    <!-- ================= SIGN UP ================= -->

    <section class="signup-section">

        <div class="signup-card">

            <h1>Create an Account</h1>

            <p>Select the type of account you would like to create.</p>

            <!-- Account Type -->

            <div class="account-type">

                <label>
                    <input type="radio"
                        name="accountType"
                        value="customer"
                        checked>
                    Customer
                </label>

                <label>
                    <input type="radio"
                        name="accountType"
                        value="barber">
                    Barber
                </label>

            </div>

            <form id="signupForm" action="/customer/save" method="post">

                <input type="text" name="firstName" placeholder="First Name" required>

                <input type="text" name="lastName" placeholder="Last Name" required>

                <input type="email" name="email" placeholder="Email Address" required>

                <input type="tel" name="phoneNumber" placeholder="Phone Number" required>

                <input type="text" name="location" placeholder="Location" required>

                <!-- Barber Fields -->

                <div id="barberFields">

                    <input type="text" placeholder="Barbershop Name">

                    <input type="text" placeholder="Specialty">

                    <input type="number" placeholder="Years of Experience">

                    <textarea placeholder="Tell customers about yourself"></textarea>

                </div>

                <input type="password" name="password" placeholder="Password" required>

                <input type="password" placeholder="Confirm Password" required>

                <input type="hidden" name="accountStatus" value="ACTIVE">

                <button type="submit" class="create-account-btn">
                    Create Account
                </button>

                <p class="signin-text">
                    Already have an account?
                    <a href="/customer/login" class="signin-link">Sign In</a>
                </p>

            </form>

        </div>

    </section>

    <!-- ================= FOOTER ================= -->

    <footer>

        <p>&copy; 2026 ClipzConnect. All rights reserved.</p>

    </footer>

    <script>
        const customer = document.querySelector('input[value="customer"]');
        const barber = document.querySelector('input[value="barber"]');
        const barberFields = document.getElementById("barberFields");
        const signupForm = document.getElementById("signupForm");

        function showCustomer() {
            customer.checked = true;
            barberFields.style.display = "none";
        }

        function showBarber() {
            barber.checked = true;
            barberFields.style.display = "block";
        }

        // Radio button listeners
        customer.addEventListener("change", showCustomer);
        barber.addEventListener("change", showBarber);

        // Read the URL parameter from the homepage
        const params = new URLSearchParams(window.location.search);
        const type = params.get("type");

        if (type === "barber") {
            showBarber();
        } else {
            showCustomer();
        }

        // Handle form submission
        signupForm.addEventListener("submit", function(event) {

            if (customer.checked) {
                return true;
            } 
            if (barber.checked) {
                event.preventDefault();
                window.location.href = "provider-prototype/providerDashboard.html";
            }
        });
    </script>

    </body>
</html>