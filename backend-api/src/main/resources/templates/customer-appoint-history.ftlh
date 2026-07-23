<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ClipzConnect - Appointment History</title>
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

        <h3>
            Welcome Back, ${customer.firstName}!
        </h3>

        <a href="/customer/dashboard/${customer.id}">
            Home
        </a>

        <a href="/customer/index">
            Log Out
        </a>

        <img src="/images/profileIcon.jpg" class="profile-icon" alt="Profile">

    </div>

</nav>



<!-- ================= APPOINTMENT HISTORY ================= -->


<section class="section">

    <h1>
        Appointment History
    </h1>


    <div class="history-grid">


    <#list appointments as appointment>


        <div class="history-card">


            <h3>
                Appointment
            </h3>


            <p>
                <strong>Status:</strong>
                ${appointment.status}
            </p>


            <p>
                <strong>Location:</strong>
                ${appointment.location}
            </p>


            <p>
                <strong>Notes:</strong>
                ${appointment.notes}
            </p>


            <#if appointment.timeslot??>

                <p>
                    <strong>Date:</strong>
                    ${appointment.timeslot.startTime}
                </p>

            </#if>



            <!-- ================= LEAVE REVIEW FORM ================= -->

            <form action="/customer/review/${customer.id}" method="post">


                <!-- Send customer information -->
                <input type="hidden" 
                    name="customer.id" 
                    value="${customer.id}">


                <!-- Send barber information from appointment -->
                <input type="hidden" 
                    name="barber.id" 
                    value="${appointment.barber.id}">


                <!-- Send appointment information -->
                <input type="hidden" 
                    name="appointment.id" 
                    value="${appointment.id}">


                <label>
                    Rating (1-10)
                </label>

                <input type="number"
                    name="rating"
                    min="1"
                    max="10"
                    required>



                <label>
                    Comments
                </label>

                <textarea name="comments"
                        placeholder="Write your review..."
                        required></textarea>



                <button type="submit" class="review-btn">
                    Submit Review
                </button>


            </form>


        </div>


    <#else>


        <div class="history-card">

            <h3>
                No Appointments Found
            </h3>

            <p>
                You have no previous appointments.
            </p>

        </div>


    </#list>


    </div>


</section>



<footer>

    <p>
        &copy; 2026 ClipzConnect. All rights reserved.
    </p>

</footer>


</body>

</html>