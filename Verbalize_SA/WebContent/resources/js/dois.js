$(function() {
	$('#galleryimg').mixItUp();
});
/* $('.timer').each(count); */
jQuery(function($) {
	// custom formatting example
	$('.timer').data(
			'countToOptions',
			{
				formatter : function(value, options) {
					return value.toFixed(options.decimals).replace(
							/\B(?=(?:\d{3})+(?!\d))/g, ',');
				}
			});

	// start all the timers
	$('#gallery').waypoint(function() {
		$('.timer').each(count);
	});

	function count(options) {
		var $this = $(this);
		options = $.extend({}, options || {}, $this.data('countToOptions')
				|| {});
		$this.countTo(options);
	}
});

$('.quotes').quovolver({
	equalHeight : true
});