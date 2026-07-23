<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Reviews – ClipzConnect</title>
    <link rel="stylesheet" href="/css/styles.css"/>
</head>
<body style="display:flex;flex-direction:column;min-height:100vh;">
<nav class="provider-nav">
    <a class="brand" href="/index">✂ ClipzConnect</a>
    <span class="spacer"></span>
    <a href="/barber/dashboard/${barber.id}">Dashboard</a>
    <a href="/barber/profile/${barber.id}">Profile</a>
    <a href="/barber/services/${barber.id}">Services</a>
    <a href="/barber/reviews/${barber.id}" class="active">Reviews</a>
    <a href="/barber/appointments/${barber.id}">Availability</a>
</nav>

<div class="provider-page">
    <h1>Customer Reviews</h1>

    <#if reviews?has_content>
        <#list reviews as review>
        <div class="review-card-provider">
            <div class="review-header">
                <div>
                    <span class="reviewer">
                        <#if review.customer??>${review.customer.firstName} ${review.customer.lastName}<#else>Anonymous</#if>
                    </span>
                    <div class="rev-date">${review.createdAt!''}</div>
                </div>
                <div>
                    <div class="stars">
                        <#list 1..5 as i><#if i <= review.rating>★<#else>☆</#if></#list>
                    </div>
                    <div style="text-align:right;font-size:.8rem;color:#888;">${review.rating}/5</div>
                </div>
            </div>

            <p class="comment">${review.comments!}</p>

            <#if review.replyText?has_content>
                <div class="reply-box">
                    <div class="label">Your Reply</div>
                    <p>${review.replyText}</p>
                </div>
            </#if>

            <details class="reply-form">
                <summary style="cursor:pointer;font-size:.85rem;color:#1a1a2e;font-weight:600;padding:4px 0;margin-bottom:8px;">
                    <#if review.replyText?has_content>Edit Reply<#else>Reply to this review</#if>
                </summary>
                <form method="post" action="/barber/reviews/${review.id}/reply/${barber.id}">
                    <textarea name="replyText" rows="3"
                        placeholder="Write a professional reply…">${review.replyText!}</textarea>
                    <div class="action-row">
                        <button class="btn-sm btn-reply" type="submit">Save Reply</button>
                        <a class="btn-sm btn-delete"
                           href="/barber/reviews/${review.id}/delete/${barber.id}"
                           onclick="return confirm('Remove this review?')">Delete Review</a>
                    </div>
                </form>
            </details>
        </div>
        </#list>
    <#else>
        <div class="empty-state">
            <p style="font-size:2rem;margin-bottom:12px;">⭐</p>
            <p>No reviews yet. Reviews left by customers will appear here.</p>
        </div>
    </#if>
</div>
<footer class="provider-footer">© 2026 ClipzConnect</footer>
</body>
</html>
