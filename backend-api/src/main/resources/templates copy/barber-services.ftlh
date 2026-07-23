<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>My Services – ClipzConnect</title>
    <link rel="stylesheet" href="/css/styles.css"/>
    <script src="/js/scripts.js" defer></script>
</head>
<body data-barber-id="${barber.id}" style="display:flex;flex-direction:column;min-height:100vh;">
<nav class="provider-nav">
    <a class="brand" href="/index">✂ ClipzConnect</a>
    <span class="spacer"></span>
    <a href="/barber/dashboard/${barber.id}">Dashboard</a>
    <a href="/barber/profile/${barber.id}">Profile</a>
    <a href="/barber/services/${barber.id}" class="active">Services</a>
    <a href="/barber/reviews/${barber.id}">Reviews</a>
    <a href="/barber/appointments/${barber.id}">Availability</a>
</nav>

<div class="provider-page" style="max-width:900px;">
    <h1>Service Menu</h1>
    <div class="services-layout">

        <div>
            <button onclick="showAdd()" class="btn-primary" style="margin-bottom:20px;">+ Add Service</button>

            <#if services?has_content>
                <#list services as svc>
                <div class="service-card">
                    <div class="svc-header">
                        <span class="svc-name">${svc.name}</span>
                        <span class="svc-price">$${svc.price?string("0.00")}</span>
                    </div>
                    <p class="svc-desc">${svc.description!}</p>
                    <p class="svc-meta">
                        <#if svc.durationMinutes??>⏱ ${svc.durationMinutes} min<#else>Duration not set</#if>
                    </p>
                    <div class="svc-actions">
                        <button class="btn-sm btn-edit"
                            data-id="${svc.id}"
                            data-name="${svc.name}"
                            data-desc="${svc.description!''}"
                            data-price="${svc.price}"
                            data-duration="${svc.durationMinutes!''}"
                            onclick="showEditFromBtn(this)">
                            Edit
                        </button>

                        <a class="btn-sm btn-delete"
                           href="/barber/services/delete/${svc.id}/${barber.id}"
                           onclick="return confirm('Remove ${svc.name?js_string}?')">Remove</a>
                    </div>
                </div>
                </#list>
            <#else>
                <div class="empty-state">
                    <p style="font-size:2rem;margin-bottom:12px;">✂</p>
                    <p>No services yet. Click "+ Add Service" to get started.</p>
                </div>
            </#if>
        </div>

        <div>
            <div id="add-panel" class="side-panel" style="display:none;">
                <h2>Add New Service</h2>
                <form method="post" action="/barber/services/add/${barber.id}">
                    <div class="form-group">
                        <label>Service Name</label>
                        <input type="text" name="name" required placeholder="e.g. Skin Fade"/>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" rows="3" placeholder="What's included…"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Price ($)</label>
                        <input type="number" name="price" required min="0" step="0.01" placeholder="25.00"/>
                    </div>
                    <div class="form-group">
                        <label>Duration (minutes, optional)</label>
                        <input type="number" name="durationMinutes" min="5" step="5" placeholder="45"/>
                    </div>
                    <button class="btn-primary full" type="submit">Add Service</button>
                </form>
            </div>

            <div id="edit-panel" class="side-panel" style="display:none;">
                <h2>Edit Service</h2>
                <form id="edit-form" method="post" action="">
                    <input type="hidden" id="edit-id" name="serviceId"/>
                    <div class="form-group">
                        <label>Service Name</label>
                        <input id="edit-name" type="text" name="name" required/>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea id="edit-desc" name="description" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Price ($)</label>
                        <input id="edit-price" type="number" name="price" required min="0" step="0.01"/>
                    </div>
                    <div class="form-group">
                        <label>Duration (minutes)</label>
                        <input id="edit-dur" type="number" name="durationMinutes" min="5" step="5"/>
                    </div>
                    <button class="btn-primary full" type="submit">Save Changes</button>
                </form>
            </div>
        </div>
    </div>
</div>
<footer class="provider-footer">© 2026 ClipzConnect</footer>
</body>
</html>
