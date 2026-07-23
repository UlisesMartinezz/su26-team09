<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Availability – ClipzConnect</title>
    <link rel="stylesheet" href="/css/styles.css"/>
</head>
<body style="display:flex;flex-direction:column;min-height:100vh;">
<nav class="provider-nav">
    <a class="brand" href="/index">✂ ClipzConnect</a>
    <span class="spacer"></span>
    <a href="/barber/dashboard/${barber.id}" class="active">Dashboard</a>
    <a href="/barber/profile/${barber.id}">Profile</a>
    <a href="/barber/services/${barber.id}">Services</a>
    <a href="/barber/reviews/${barber.id}">Reviews</a>
    <a href="/barber/appointments/${barber.id}">Availability</a>
</nav>

<div class="provider-page" style="max-width:960px;">
    <h1>Availability &amp; Timeslots</h1>
    <p style="color:#777;font-size:.9rem;margin-bottom:28px;">
        Add open windows so customers can book appointments.
    </p>

    <div class="appt-layout">

        <div>
            <#if timeslots?has_content>
            <table class="appt-table">
                <thead>
                    <tr><th>Start</th><th>End</th><th>Status</th><th></th></tr>
                </thead>
                <tbody>
                    <#list timeslots as slot>
                    <tr>
                        <td>${slot.startTime}</td>
                        <td>${slot.endTime}</td>
                        <td>
                            <#if slot.isAvailable>
                                <span class="badge badge-avail">Open</span>
                            <#else>
                                <span class="badge badge-booked">Booked</span>
                            </#if>
                        </td>
                        <td>
                            <#if slot.isAvailable>
                            <a class="btn-del"
                               href="/barber/timeslots/delete/${slot.id}/${barber.id}"
                               onclick="return confirm('Remove this timeslot?')">Remove</a>
                            </#if>
                        </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
            <#else>
                <div class="empty-state">
                    <p style="font-size:2rem;margin-bottom:12px;">🗓</p>
                    <p>No timeslots yet. Add your first available window using the form.</p>
                </div>
            </#if>
        </div>

        <div class="side-panel">
            <h2>Add Availability Window</h2>
            <form method="post" action="/barber/timeslots/add/${barber.id}">
                <div class="form-group">
                    <label>Start Date &amp; Time</label>
                    <input type="datetime-local" name="startTime" required/>
                    <p class="tip">Select the start of your open window.</p>
                </div>
                <div class="form-group">
                    <label>End Date &amp; Time</label>
                    <input type="datetime-local" name="endTime" required/>
                    <p class="tip">Select when this slot closes.</p>
                </div>
                <button class="btn-primary full" type="submit">Add Timeslot</button>
            </form>
        </div>

    </div>
</div>
<footer class="provider-footer">© 2026 ClipzConnect</footer>
</body>
</html>
