function undo() {
    Swal.fire({
        title: '¿Estas seguro?',
        text: "¡No podras revertir este cambio!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#8a3ac5',
        cancelButtonColor: '#f93154',
        confirmButtonText: 'Confirmar'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: 'ventas/undo'
            })
            Swal.fire(
                '¡Eliminado!',
                'Los datos de la venta se han eleminado.',
                'success'
            ).then(() => {
                location.href = "/ventas"
            })
        }
    })
}

(() => {
    'use strict';
    const form = document.querySelector('.needs-validation');
    const input = document.querySelector('.amount');
    input.setAttribute("required", true);
    form.addEventListener('submit', (event) => {
        if (!form.checkValidity()) {
            event.preventDefault();
            event.stopPropagation();
        }
        form.classList.add('was-validated');
    }, false);

})();
function deleteLastIndex(){
    Swal.fire({
        title: '¿Estas seguro?',
        text: "¡No podras revertir este cambio!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#8a3ac5',
        cancelButtonColor: '#f93154',
        confirmButtonText: 'Confirmar'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: 'ventas/delete'
            })
            Swal.fire(
                '¡Eliminado!',
                'El ultimo producto se elimino correctamente.',
                'success'
            ).then(() => {
                location.href = "/ventas"
            })
        }
    })
}