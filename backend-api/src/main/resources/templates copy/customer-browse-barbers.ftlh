<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Browse Barbers</title>
    <link rel="stylesheet" href="/styles.css">
</head>

<body>

<nav class="navbar">
    <div class="nav-left">
        <img src="/images/ClipzConnectLogo.jpg.jpeg" class="logo">
        <h2>ClipzConnect</h2>
    </div>

    <div class="nav-right">
        <a href="/customer/dashboard/${customer.id}">Dashboard</a>
        <a href="/customer/index">Log Out</a>
    </div>
</nav>

<section class="section">

    <h1>Find a Barber</h1>

    <form action="/customer/search" method="get">

        <input type="text"
               name="location"
               placeholder="Search by location">

        <select name="service">
            <option value="">All Services</option>

            <#list services as service>
                <option value="${service.name}">
                    ${service.name}
                </option>
            </#list>

        </select>

        <button type="submit">Search</button>

    </form>

</section>


<section class="section">

    <h2>Available Barbers</h2>

    <div class="barber-grid">

        <#list barbers as barber>

        <div class="barber-card">

            <img src="/images/${barber.thumbnailUrl}" alt="Barber">

            <h3>${barber.firstName} ${barber.lastName}</h3>

            <p>${barber.location}</p>

            <p>${barber.bio}</p>

            <a href="/appointment/book/{customerId}/{barberId}">
                Book Appointment
            </a>

        </div>

        </#list>

    </div>

</section>

</body>
</html>