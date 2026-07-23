<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Barber Portal – ClipzConnect</title>
    <link rel="stylesheet" href="/css/styles.css"/>
    <script src="/js/scripts.js" defer></script>
</head>
<body style="display:flex;flex-direction:column;min-height:100vh;">
<nav class="provider-nav">
    <a class="brand" href="/index">✂ ClipzConnect</a>
    <span class="spacer"></span>
    <a href="/index">Home</a>
    <a href="/login">Customer Login</a>
</nav>

<div class="page-wrap">
    <div class="card-outer">
        <div class="tabs">
            <button class="tab-btn" data-tab="login"    onclick="showTab('login')">Barber Login</button>
            <button class="tab-btn" data-tab="register" onclick="showTab('register')">Create Account</button>
        </div>
        <div class="tab-card">

            <div id="login-panel" class="panel">
                <h2>Barber Sign In</h2>
                <#if error??><div class="alert">${error}</div></#if>
                <form method="post" action="/barber/login">
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" name="email" required placeholder="you@example.com"/>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" name="password" required placeholder="••••••••"/>
                    </div>
                    <button class="btn-primary" type="submit">Sign In</button>
                </form>
            </div>

            <div id="register-panel" class="panel">
                <h2>Create Barber Account</h2>
                <form method="post" action="/barber/save">
                    <div class="row2">
                        <div class="form-group">
                            <label>First Name</label>
                            <input type="text" name="firstName" required placeholder="Marcus"/>
                        </div>
                        <div class="form-group">
                            <label>Last Name</label>
                            <input type="text" name="lastName" required placeholder="Jones"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" name="email" required placeholder="barber@example.com"/>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" name="password" required placeholder="At least 8 characters"/>
                    </div>
                    <div class="row2">
                        <div class="form-group">
                            <label>Phone</label>
                            <input type="text" name="phoneNumber" placeholder="555-000-1234"/>
                        </div>
                        <div class="form-group">
                            <label>Location / Shop Address</label>
                            <input type="text" name="location" placeholder="123 Main St, City, NC"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Bio (optional)</label>
                        <textarea name="bio" rows="3" placeholder="Tell customers about your style…"></textarea>
                    </div>
                    <button class="btn-primary" type="submit">Create Account</button>
                </form>
            </div>

        </div>
    </div>
</div>
<footer class="provider-footer">© 2026 ClipzConnect – Barber Portal</footer>
</body>
</html>
