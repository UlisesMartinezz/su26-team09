<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>My Profile – ClipzConnect</title>
    <link rel="stylesheet" href="/css/styles.css"/>
</head>
<body data-show-register="${(showRegister!false)?c}" style="display:flex;flex-direction:column;min-height:100vh;">
<nav class="provider-nav">
    <a class="brand" href="/index">✂ ClipzConnect</a>
    <span class="spacer"></span>
    <a href="/barber/dashboard/${barber.id}">Dashboard</a>
    <a href="/barber/profile/${barber.id}" class="active">Profile</a>
    <a href="/barber/services/${barber.id}">Services</a>
    <a href="/barber/reviews/${barber.id}">Reviews</a>
    <a href="/barber/appointments/${barber.id}">Availability</a>
</nav>

<div class="provider-page">
    <h1>My Profile</h1>
    <div class="provider-card">

        <div class="avatar-row">
            <#if barber.thumbnailUrl?has_content>
                <img class="avatar" src="${barber.thumbnailUrl}" alt="Profile photo"/>
            <#else>
                <div class="avatar-fallback">${barber.firstName?substring(0,1)}</div>
            </#if>
            <div class="name-block">
                <h2>${barber.firstName} ${barber.lastName}</h2>
                <p class="sub">${barber.email}</p>
                <p class="sub">${barber.accountStatus}</p>
            </div>
        </div>

        <form method="post" action="/barber/profile/update/${barber.id}">
            <div class="row2">
                <div class="form-group">
                    <label>First Name</label>
                    <input type="text" name="firstName" value="${barber.firstName}" required/>
                </div>
                <div class="form-group">
                    <label>Last Name</label>
                    <input type="text" name="lastName" value="${barber.lastName}" required/>
                </div>
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" value="${barber.email}" required/>
            </div>
            <div class="row2">
                <div class="form-group">
                    <label>Phone</label>
                    <input type="text" name="phoneNumber" value="${barber.phoneNumber!}"/>
                </div>
                <div class="form-group">
                    <label>Location / Shop Address</label>
                    <input type="text" name="location" value="${barber.location!}"/>
                </div>
            </div>
            <div class="form-group">
                <label>Profile Photo URL</label>
                <input type="url" name="thumbnailUrl" value="${barber.thumbnailUrl!}" placeholder="https://…"/>
                <p class="hint">Leave blank to keep current photo.</p>
            </div>
            <div class="form-group">
                <label>Bio</label>
                <textarea name="bio" rows="4">${barber.bio!}</textarea>
            </div>
            <hr class="divider"/>
            <p style="font-weight:600;margin-bottom:14px;color:#555;">Change Password (leave blank to keep current)</p>
            <div class="form-group">
                <label>New Password</label>
                <input type="password" name="password" placeholder="••••••••"/>
                <p class="hint">Must be at least 8 characters.</p>
            </div>
            <button class="btn-primary" type="submit">Save Changes</button>
        </form>

        <hr class="divider"/>
        <p style="font-size:.85rem;color:#888;margin-bottom:12px;">Danger zone — this action cannot be undone.</p>
        <a class="btn-danger" href="/barber/delete/${barber.id}"
           onclick="return confirm('Delete your account permanently?')">Delete Account</a>
    </div>
</div>
<footer class="provider-footer">© 2026 ClipzConnect</footer>
</body>
</html>
