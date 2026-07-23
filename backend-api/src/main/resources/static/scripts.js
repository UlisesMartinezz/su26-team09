/* =========================
   BARBER LOGIN — Tab switching
========================= */

function showTab(name) {
    document.querySelectorAll('.tab-btn').forEach(function(btn) {
        btn.classList.toggle('active', btn.dataset.tab === name);
    });
    document.querySelectorAll('.panel').forEach(function(panel) {
        panel.classList.toggle('active', panel.id === name + '-panel');
    });
}

/* =========================
   BARBER LOGIN — Auto-select tab on page load
========================= */

window.addEventListener('DOMContentLoaded', function() {
    var showReg = document.body.getAttribute('data-show-register') === 'true';
    showTab(showReg ? 'register' : 'login');
});

/* =========================
   BARBER SERVICES — Show add panel
========================= */

function showAdd() {
    document.getElementById('add-panel').style.display  = 'block';
    document.getElementById('edit-panel').style.display = 'none';
}

/* =========================
   BARBER SERVICES — Show edit panel
   Reads all values from data attributes on the clicked button.
   No FreeMarker needed in the onclick.
========================= */

function showEditFromBtn(btn) {
    var id       = btn.getAttribute('data-id');
    var name     = btn.getAttribute('data-name');
    var desc     = btn.getAttribute('data-desc');
    var price    = btn.getAttribute('data-price');
    var duration = btn.getAttribute('data-duration');
    var barberId = document.body.getAttribute('data-barber-id');

    document.getElementById('edit-id').value    = id;
    document.getElementById('edit-name').value  = name;
    document.getElementById('edit-desc').value  = desc;
    document.getElementById('edit-price').value = price;
    document.getElementById('edit-dur').value   = duration;
    document.getElementById('edit-form').action =
        '/barber/services/update/' + id + '/' + barberId;

    document.getElementById('add-panel').style.display  = 'none';
    document.getElementById('edit-panel').style.display = 'block';
    document.getElementById('edit-panel').scrollIntoView({ behavior: 'smooth' });
}
