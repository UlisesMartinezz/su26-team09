<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ClipzConnect - Find a Barber</title>
    <link rel="stylesheet" href="/styles.css">
</head>

<body>

    <!-- NAVBAR -->
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


    <!-- SEARCH SECTION -->

    <section class="section">

        <h1>Find a Barber</h1>

        <form action="/barbers/search" method="get">

            <label>Location</label>
            <input type="text" name="location" placeholder="Enter location">

            <label>Service</label>

            <select name="service">
                <option value="">All Services</option>

                <option value="Fade">Fade</option>

                <option value="Haircut">Haircut</option>

                <option value="Beard Trim">Beard Trim</option>

                <option value="Color">Hair Color</option>
            </select>

            <button type="submit">Search</button>
        </form>
    </section>

    <!-- BARBER RESULTS -->
    <section class="section">

        <h2>Available Barbers</h2>

        <div class="barber-grid">

            <!-- Example Barber Card -->
            <div class="barber-card">
                <img src="/images/barber1.jpg" alt="Barber">

                <h3>John Smith</h3>

                <p>Location: Greensboro</p>

                <p>Services:Fade, Haircut</p>

                <a href="/booking/barber/1">Book Appointment</a>
            </div>

            <div class="barber-card">
                <img src="/images/barber2.jpg" alt="Barber">

                <h3>Mike Johnson</h3>

                <p>Location: High Point</p>

                <p>Services: Beard Trim</p>

                <a href="/booking/barber/2">Book Appointment</a>
            </div>
        </div>
    </section>
    <footer>
        <p>&copy; 2026 ClipzConnect. All rights reserved.</p>
    </footer>
</body>
</html>