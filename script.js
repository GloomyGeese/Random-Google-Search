var lines;
var randomNumber;
var lastRandomNumber;
var randomNumber2;

$(document.body).ready(function () {
  
  // load the words from the server
  "use strict";
  $.ajax({
    // switch the comments out if you just want to use the default github searches.txt
    url: 'searches.txt'
   // url: 'https://raw.githubusercontent.com/GloomyGeese/Random-Google-Search/RGS-JavaScript/searches.txt'
  }).done(function(content) {
    
    lines = content.replace(/\r\n|\r/g, '\n').trim().split('\n');
    

    if (lines && lines.length) {
      $('#button').on('click', function () {
        var loop = prompt("How many random google searches would you like?")
        if (loop>0) {
          while (loop>0) {
            loop--;
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
      }
        }
      
      );
    }});
});
