$(document).ready( function () {
    // Tabla con agregado traducción español
    $('#tabla').DataTable( {
        "language": {
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "",
            "sInfo":           "",
            "sInfoEmpty":      "",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Filtrar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "",
                "sLast":     "",
                "sNext":     "",
                "sPrevious": ""
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            },
            "buttons": {
                "copy": "Copiar",
                "colvis": "Visibilidad"
            }
        }
    } );
} );