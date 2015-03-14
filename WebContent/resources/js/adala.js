$(function() {
	$('.hoverable').hover(function() {
		$(this).find('.minor').show();
	}, function() {
		$(this).find('.minor').hide();
	});
});