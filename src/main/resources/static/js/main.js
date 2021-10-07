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
$(document).ready(function () {
    var dataTable = $('#datatable').DataTable({
        "sDom": '<"H"lr>t<"F"ip>',
        "ordering": false,
        "language": {
            "lengthMenu": "Mostrar _MENU_ registros",
            "zeroRecords": "No se encontrarón resultados.",
            "info": "Registros del _START_ al _END_ de _TOTAL_ registros.",
            "infoEmpty": "Registros del 0 al 0 de 0 registros.",
            "infoFiltered": "(Filtrando de _MAX_ registros)",
            "sSearch": "Buscar:",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": ">",
                "sPrevious": "<"
            },
            "sProcessing": "Procesando...",
        }

    });
    $("#datatable-search").keyup(function () {
        dataTable.search($(this).val()).draw();
    });
    //Usuarios
    var arrayUser = ["#user_cedula_update", "#user_name_update",
        "#username_update", "#roles_update", "#user_email_update"];
    var datosTabla = [];
    $('.dataUser').click(function () {
        $(this).parents('tr').find('td').each(function () {
            datosTabla.push($(this).html());
        });
        $(arrayUser[0]).val(datosTabla[0]);
        $(arrayUser[1]).val(datosTabla[1]);
        $(arrayUser[2]).val(datosTabla[2]);
        $(arrayUser[3]).val(datosTabla[3]);
        $(arrayUser[4]).val(datosTabla[4]);
        datosTabla = [];
    })
    //Clientes
    var arrayClient = ["#client_cedula_update", "#client_name_update", "#client_address_update",
        "#client_tel_update", "#client_email_update"];
    $('.dataClient').click(function () {
        $(this).parents('tr').find('td').each(function () {
            datosTabla.push($(this).html());
        });
        $(arrayClient[0]).val(datosTabla[0]);
        $(arrayClient[1]).val(datosTabla[1]);
        $(arrayClient[2]).val(datosTabla[2]);
        $(arrayClient[3]).val(datosTabla[3]);
        $(arrayClient[4]).val(datosTabla[4]);
        datosTabla = [];
    })
    //Proveedores
    var arraySupplier = ["#supplier_nit_update", "#supplier_name_update", "#supplier_address_update",
    "#supplier_tel_update", "#supplier_city_update"];
    $('.dataSupplier').click(function () {
        $(this).parents('tr').find('td').each(function () {
            datosTabla.push($(this).html());
        });
        $(arraySupplier[0]).val(datosTabla[0]);
        $(arraySupplier[1]).val(datosTabla[1]);
        $(arraySupplier[2]).val(datosTabla[2]);
        $(arraySupplier[3]).val(datosTabla[3]);
        $(arraySupplier[4]).val(datosTabla[4]);
        datosTabla = [];
    })
});

function deleteSupplier(supplier_nit) {
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
                url: '/deleteSupplier/' + supplier_nit
            })
            Swal.fire(
                '¡Eliminado!',
                'El usuario se ha eliminado.',
                'success'
            ).then(() => {
                location.href = "/proveedores"
            })
        }
    })
}

function deleteClient(client_cedula) {
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
                url: '/deleteClient/' + client_cedula
            })
            Swal.fire(
                '¡Eliminado!',
                'El usuario se ha eliminado.',
                'success'
            ).then(() => {
                location.href = "/clientes"
            })
        }
    })
}

function deleteUser(user_cedula) {
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
                url: '/deleteUser/' + user_cedula
            })
            Swal.fire(
                '¡Eliminado!',
                'El usuario se ha eliminado.',
                'success'
            ).then(() => {
                location.href = "/usuarios"
            })
        }
    })
}