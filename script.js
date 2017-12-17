var lines;
var randomNumber;
var lastRandomNumber;
var loop;

$(document.body).ready(function () {
  
  // load the words from the server
  $.ajax({
    url: 'searches.txt'
  }).done(function(content) {
    
    lines = content.replace(/\r\n|\r/g, '\n').trim().split('\n');
    

    if (lines && lines.length) {
      $('#button').on('click', function () {
        while (randomNumber === lastRandomNumber) {
          randomNumber = parseInt(Math.random() * lines.length);// makes the word
          randomNumber2 = parseInt(Math.random() * lines.length);// makes the 2nd word
          // no infinite thing
          if (lines.length === 1) { break; }
        }
        // keep track of the last random number
        lastRandomNumber = randomNumber;
        
        // show the corresponding line
        window.open("https://www.google.com/search?q=" + lines[randomNumber] + "%20" + lines[randomNumber2]);
        
        }
      
      );
    }})});