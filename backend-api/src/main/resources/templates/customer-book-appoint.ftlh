<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Appointment</title>
    <link rel="stylesheet" href="/styles.css">
</head>

<body>

<nav class="navbar">
    <div class="nav-left">
        <img src="/images/ClipzConnectLogo.jpg.jpeg" class="logo">
        <h2>ClipzConnect</h2>
    </div>

    <div class="nav-right">
        <a href="/customer/dashboard/${customer.id}">
            Dashboard
        </a>
    </div>
</nav>

<section class="section">

    <h1>Book Appointment</h1>

    <div class="barber-card">

        <img src="/images/${barber.thumbnailUrl}" alt="Barber">

        <h2>${barber.firstName} ${barber.lastName}</h2>

        <p>${barber.location}</p>

        <p>${barber.bio}</p>

    </div>

    <form action="/customer/${customer.id}/book" method="post">

        <input type="hidden"
               name="customer.id"
               value="${customer.id}">

        <label>Select Service</label>

        <select name="barberService.id">

            <#list services as service>

                <option value="${service.id}">
                    ${service.name} -
                    $${service.price}
                </option>

            </#list>

        </select>

        <label>Select Time</label>

        <select name="timeslot.id">

            <#list timeslots as timeslot>

                <option value="${timeslot.id}">
                    ${timeslot.startTime}
                </option>

            </#list>

        </select>

        <label>Notes</label>

        <textarea
            name="notes"
            rows="4"
            placeholder="Any requests?"></textarea>

        <input type="hidden"
               name="status"
               value="Scheduled">

        <input type="hidden"
               name="location"
               value="${barber.location}">

        <br><br>

        <button type="submit">
            Book Appointment
        </button>

    </form>

</section>

</body>
</html>