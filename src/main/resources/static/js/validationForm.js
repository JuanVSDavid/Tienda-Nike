(() => {
    'use strict';
    const forms = document.querySelectorAll('.needs-validation');
    const inputs = document.querySelectorAll('.form-control');
    inputs.forEach(input => {
        input.setAttribute('required', true);
    })
    Array.prototype.slice.call(forms).forEach((form) => {
        form.addEventListener('submit', (event) => {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    });
})();