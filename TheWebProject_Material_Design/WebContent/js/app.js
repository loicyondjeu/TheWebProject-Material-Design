/**
 * app.js ist unser zentrales JS files. Sie übernimmt die Aufgaben der Initialisierung der JS
 * Komponente die wir benutzen.
 * Außerdem enthält sie Funktionen, die von uns programmiert wurden.
 * 
 * Loic
 */

/**
 * Funktion zur Auswahl des korrekten Wochentages
 * Jasmin Moos
 * */
function wochentag(i) {
	var tage = [ 'Sonntag', 'Montag', 'Dienstag', 'Mittwoch', 'Donnerstag',
			'Freitag', 'Samstag', 'Sonntag' ];
	var tag = (typeof (i) == 'object') ? i.getDay() : i;
	return tage[tag];
}


$(document).ready(function(){
				  $('.collapsible').collapsible();
	  			}); 
  
  
$(".button-collapse").sideNav();

$(document).ready(function(){$('.button-collapse').sideNav();

$('.dropdown-button').dropdown({
	inDuration: 300,
	outDuration: 225,
	constrainWidth: false, // Does not change width of dropdown to that of the activator
	hover: true, // Activate on hover
	gutter: 0, 
	belowOrigin: true, // Displays dropdown below the button
	alignment: 'left', // Displays dropdown with edge aligned to the left of button
	stopPropagation: false // Stops event propagation
	});
});

$(document).ready(function() {
    $('select').material_select();
});

$(function(){
	   $('.stepper').activateStepper();
});

$('.datepicker').pickadate({
    selectMonths: false,
    selectYears: 5,
    monthsFull: ['Januar', 'Februar', 'März', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'October', 'November', 'December'],
    weekdaysShort: ['Sonn', 'Mon', 'Dien', 'Mitt', 'Donn', 'Frei', 'Sam'],
    today: 'Heute',
    formatSubmit: 'dd.mm.yyyy',
    clear: 'Leeren',
    close: 'Ok',
    closeOnSelect: false
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