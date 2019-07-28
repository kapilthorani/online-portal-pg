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
	case 'All PG':
		$('#listPG').addClass('active');
		break;
	default:
		if(menu == "Home") break;
		$('#listPG').addClass('active');
		$('a_'+menu).addClass('active');
		break;
	}
	
	
	// code for jquery dataTable
	
	var $table = $('#pgListTable');
	
	//execute the below code only where we have this table
	if($table.length) {
		//console.log('Inside the table!');
		var jsonUrl ='';
		
		if(window.categoryId =='') {
			
			jsonUrl = window.contextRoot +'/json/data/all/pgs';
		}
		else {
			jsonUrl = window.contextRoot +'/json/data/category/'+ window.categoryId +'/pgs';
		}
		
		$table.DataTable( {
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records', '10 Records', 'ALL']],
			pageLength: 5,
			//data:pgs
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			
			columns: [
				
				{
					data: 'bookingCode',
					mRender: function(data,type,row) {
					 return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
					}
				},
				{
					data: 'name'
				},
				{
					data: 'rent',
					mRender: function(data,type,row) {
						return '&#8360; ' +data
					}
				},
				{
					data: 'gender'
				},
				{
					data: 'location'
				},
				{
					data: 'pgtype'
				},
				{
					data: 'bedAvailable',
					mRender: function(data,type,row) {
						if(data < 1) {
						return '<span style="color:red">Unavailable</span>';
						}
						return data
					}
				},
				{
					data: 'views'
				},
				{
					data: 'id',
					mRender: function(data,type,row) {
						var str ='';
							str +='<a href="'+window.contextRoot+ '/show/'+data+'/pg" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
							
							if(row.bedAvailable < 1) {
			        			  str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
			        		  }
			        		  else {

			        			  str += '<a href="'+window.contextRoot+ '/book/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';  
			        		  }
							return str
					}
				}
				
			]
		});
	}
	
	
});