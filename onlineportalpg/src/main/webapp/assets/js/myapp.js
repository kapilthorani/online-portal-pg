$(function() {
	// solving the active menu problem
	switch (menu) {
	
	
	case 'Admin':
		$('#admin').addClass('active');
		break;
	case 'Owner':
		$('#owner').addClass('active');
		break;
	case 'Tenant':
		$('#tenant').addClass('active');
		break;
	case 'Search PG':
		$('#searchpg').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Services':
		$('#services').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	default:
		$('#home').addClass('active');
	break;
	}
});