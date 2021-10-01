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
    var array = ["#user_cedula_update", "#user_name_update",
        "#username_update", "#roles_update", "#user_email_update"];
    var datosTabla = [];
    $('.data').click(function () {
        $(this).parents('tr').find('td').each(function () {
            datosTabla.push($(this).html());
        });
        $(array[0]).val(datosTabla[0]);
        $(array[1]).val(datosTabla[1]);
        $(array[2]).val(datosTabla[2]);
        $(array[3]).val(datosTabla[3]);
        $(array[4]).val(datosTabla[4]);
        datosTabla = [];
    })
});
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