<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ClipzConnect - Customer Dashboard</title>
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

                <h3>Welcome Back, ${customer.firstName}!</h3>

                <a href="/customer/dashboard/${customer.id}">Home</a>
                <a href="/customer/index">Log Out</a>
                <img src="/images/profileIcon.jpg" class="profile-icon" alt="Profile">
            </div>

        </nav>

        <!-- ================= DASHBOARD STATS ================= -->

        <section class="dashboard-stats">

            <div class="stat-card">
                <a href="/customer/profile/${customer.id}" class="card-link">
                    <h3>Manage Profile</h3>
                    <p>Update your personal details and preferences</p>
                </a>
            </div>

            <div class="stat-card">
                <a href="/customer/appointment/${customer.id}" class="card-link">
                    <h3>Appointment History</h3>
                    <p>View past cuts and barber visits</p>
                </a>
            </div>

            <div class="stat-card">
                <a href="/customer/appointment/book/${customer.id}" class="card-link">
                    <h3>Book Appointment</h3>
                <p>Schedule your next haircut with a barber</p>
                </a>
            </div>

        </section>

        <!-- ================= UPCOMING APPOINTMENTS ================= -->

        <#list appointments as appointment>
            
            <div class="account-card">
                
                <h3>Next Appointment</h3>

                <p><strong>Status:</strong>${appointment.status}</p>

                <p><strong>Location:</strong>${appointment.location}</p>

                <P><strong>Notes:</strong>${appointment.notes}</P>
            </div>
        </#list>

        <!-- ================= FOOTER ================= -->
        <footer>
            <p>&copy; 2026 ClipzConnect. All rights reserved.</p>
        </footer>

    </body>
</html>