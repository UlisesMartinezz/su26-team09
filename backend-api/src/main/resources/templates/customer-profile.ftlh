<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ClipzConnect - Profile</title>
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
                <a href="/customer/dashboard/${customer.id}">Dashboard</a>
                <a href="/index">Log Out</a>
                <img src="/images/profileIcon.jpg" class="profile-icon" alt="Profile">
            </div>

        </nav>

        <!-- ================= PROFILE HUB ================= -->

        <section class="profile-section">

            <div class="profile-card">

                <h1>My Profile</h1>
                <p>Update your personal information</p>

                <form action="/customer/update-basic/${customer.id}" method="post">

                    <label>First Name</label>
                    <input type="text" name="firstName" value="${customer.firstName}" required>

                    <label>Last Name</label>
                    <input type="text" name="lastName" value="${customer.lastName}" required>

                    <label>Email Address</label>
                    <input type="email" name="email" value="${customer.email}" required>

                    <button type="submit">Save Basic Information</button>

                </form>
                
                <form action="/customer/update-personal/${customer.id}" method="post">

                    <label>Phone Number</label>
                    <input type="tel" name="phoneNumber" value="${customer.phoneNumber}" required>

                    <label>Password</label>
                    <input type="password" name="password" value="${customer.password}" required>

                    <label>Location</label>
                    <input type="text" name="location" value="${customer.location}" required>

                    <button type="submit">Save Personal Information</button>

                </form>

                <a href="/customer/dashboard/${customer.id}" class="cancel-btn">Cancel</a>

                <a href="/customer/delete/${customer.id}" class="delete-btn">Delete Account</a>

            </div>
        </section>
    </body>
</html>