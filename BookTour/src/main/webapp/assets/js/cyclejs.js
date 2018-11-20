function cycle($item, $cycler) {
	setTimeout(cycle, 2000, $item.next(), $cycler);

	$item.slideUp(1000, function() {
		$item.appendTo($cycler).show();
	});

}
cycle($('#cycler div:first'), $('#cycler'));