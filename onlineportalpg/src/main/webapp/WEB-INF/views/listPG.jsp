<div class ="container">

	<div class ="row">
		<!-- Would to be display a sidebar  -->
		<div class ="col-md-3">
			<%@include file ="./shared/sidebar.jsp" %>
		</div>
		
		<!-- To display the Actual PG's -->
		<div class ="col-md-9">
		
		<!-- Added BreadCrumb Component -->
		<div class ="row">
			<div class ="col-md-12">
				<c:if test="${userClickAllPG == true}">
				
				<script>
					window.categoryId = '';
				</script>
				<ol class ="breadcrumb">
					<li><a href="${contextRoot}/home">Home</a></li>
					<li class="active">All PG</li>
				</ol>
				</c:if>
				
				<c:if test="${userClickCategoryPG == true}">
				
				<script>
					window.categoryId = '${category.id}';
				</script>
				<ol class ="breadcrumb">
					<li><a href="${contextRoot}/home">Home</a></li>
					<li class="active">Category</li>
					<li class="active">${category.name}</li>
				</ol>
				</c:if>
			</div>
		</div>
		
		<div class ="row">
		
			<div class ="col-xs-12">
				
				<table id="pgListTable" class="table table-striped table-borderd">
					
					<thead>
						
						<tr>
							<th></th>
							<th>Name</th>
							<th>Rent</th>
							<th>Gender</th>
							<th>Location</th>
							<th>PG Type</th>
							<th>Bed Available</th>
							<th>Views</th>
							<th></th>
						</tr>
					
					</thead>
					<tfoot>
						
						<tr>
							<th></th>
						    <th>Name</th>
							<th>Rent</th>
							<th>Gender</th>
							<th>Location</th>
							<th>PG Type</th>
							<th>Bed Available</th>
							<th>Views</th>
							<th></th>
						</tr>
					</tfoot>
				</table>
				
			</div>
		</div>
		</div>
	</div>


</div>