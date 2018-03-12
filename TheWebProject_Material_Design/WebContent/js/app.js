/**
 * 
 */


$(".button-collapse").sideNav();
$(document).ready(function(){$('.button-collapse').sideNav();

$('.dropdown-button').dropdown({
inDuration: 300,
outDuration: 225,
constrainWidth: false, // Does not change width of dropdown to that of the activator
hover: true, // Activate on hover
gutter: 0, // Spacing from edge
belowOrigin: true, // Displays dropdown below the button
alignment: 'left', // Displays dropdown with edge aligned to the left of button
stopPropagation: false // Stops event propagation
}
);
    });

$(document).ready(function() {
    $('select').material_select();
});

$(function(){
	   $('.stepper').activateStepper();
});

$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15, // Creates a dropdown of 15 years to control year,
    monthsFull: ['Januar', 'Februar', 'März', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'October', 'November', 'December'],
    weekdaysShort: ['Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam'],
    today: 'Heute',
    formatSubmit: 'dd.mm.yyyy',
    clear: 'Leeren',
    close: 'Ok',
    closeOnSelect: false // Close upon selecting a date,
  });

$('.carousel.carousel-slider').carousel({
    fullWidth: true,
    indicators: true
  });

$(document).ready(function(){
    $('.tooltipped').tooltip({delay: 50});
  });

$(document).ready(function(){
    $('.slider').slider();
  });