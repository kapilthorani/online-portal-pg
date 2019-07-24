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
				<ol class ="breadcrumb">
					<li><a href="${contextRoot}/home">Home</a></li>
					<li class="active">All PG</li>
				</ol>
				</c:if>
				
				<c:if test="${userClickCategoryPG == true}">
				<ol class ="breadcrumb">
					<li><a href="${contextRoot}/home">Home</a></li>
					<li class="active">Category</li>
					<li class="active">${category.name}</li>
				</ol>
				</c:if>
			</div>
		</div>
		
		</div>
	</div>


</div>