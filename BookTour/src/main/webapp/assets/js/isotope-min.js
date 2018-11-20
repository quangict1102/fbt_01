 var grid=$('.isotope');
  var filter=$('.filter-button-group input');
  var suche=$('.quicksearch');
  var qsRegex;
  var buttonFilter;
  
  grid.isotope({
    itemSelector: '.isotope-item',
     layoutMode: 'fitRows',
	  filter: function() {
		 // console.log(searchResult);
		  var searchResult = qsRegex ? $(this).text().match( qsRegex ) : true;
		  var buttonResult = buttonFilter ? $(this).is( buttonFilter ) : true;
		  console.log(buttonFilter);
		    console.log($(this).is( buttonFilter ));
		  return searchResult && buttonResult;
  	}
  });


  
  // use value of search field to filter
  var quicksearch = suche.keyup( debounce( function() {
	  qsRegex = new RegExp( quicksearch.val(), 'gi' );
	  grid.isotope();
  }, 200 ) );
  
  
  // debounce so filtering doesn't happen every millisecond
	function debounce( fn, threshold ) {
	  var timeout;
	  return function debounced() {
		if ( timeout ) {
		  clearTimeout( timeout );
		}
		function delayed() {
		  fn();
		  timeout = null;
		}
		timeout = setTimeout( delayed, threshold || 100 );
	  };
	}

  $('#shuffle').click(function(){
    grid.isotope('shuffle');
  });



 // filter functions
var filterFns = {
  // show if number is greater than 50
  numberGreaterThan150: function() {
    var number = $(this).find('.numberAdults').text();
    return parseInt( number, 10 ) > 200;
  },
  // show if name ends with -ium
  numberLThan150: function() {
	    var number = $(this).find('.numberAdults').text();
	    return parseInt( number, 10 ) < 200;
	  },
}; 
$('.filters').on( 'click', 'input', function() {
  // get filter value from input value
  var filterValue = this.value;
  // use filterFn if matches value
  filterValue = filterFns[ filterValue ] || filterValue;
  grid.isotope({ filter: filterValue });
});



  filter.change(function(){
    var filters = [];
    var filtersRadio = [];
    filter.filter(':checked').each(function(){
      filters.push( this.value );
    });
    filters = filters.join(','); 
    $('.filters').on( 'click', 'input', function() {
    	  // get filter value from input value
    	  var filterValue = this.value;
    	  // use filterFn if matches value
    	  filterValue = filterFns[ filterValue ] || filterValue;
    	  filtersRadio.push( this.value );
    	});
    
     //filters = filters.join(', '); 	//OR
			//AND
    
	buttonFilter = filters;
	console.log(filters);
    grid.isotope();
  });
  grid.imagesLoaded().progress( function() {
	    grid.isotope('layout');
	        });