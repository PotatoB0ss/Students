/**
 *
 */


 $('document').ready(function (){

    $('.table .btn-warning').on('click', function (event){

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(student, status){
            $('#edit-id').val(student.id)
           $('#edit-name').val(student.name)
           $('#edit-department').val(student.department)
        });

        $('#editModal').modal();

    });

});


$('documen').ready(function (){

    $('.table .btn-danger').on('click', function (event){

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(student, status){
            $('#delete-id').val(student.id)
        });



        $('#deleteModal').modal();

    });

});