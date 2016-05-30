$('ul.first-nav > li').click(function (e) {
e.preventDefault();
$('ul.first-nav > li').removeClass('active');
$(this).addClass('active');

})