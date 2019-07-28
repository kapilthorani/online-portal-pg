<div class="container">

	<!--BreadCrumb  -->
	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/pgs">PGs</a></li>
				<li class="active">${pg.name}</li>
			</ol>

		</div>

	</div>
	<div class="row">

		<!-- Display the PG Image -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${pg.bookingCode}.jpg"
					class="img img-responsive" />

			</div>

		</div>
		<!-- Display the PG Description -->
		<div class="col-xs-12 col-sm-8">

			<h3>${pg.name}</h3>
			<hr />
			<p>${pg.description}</p>
			<hr />

			<h4>
				Rent: <strong> &#8377; ${pg.rent} /-</strong>
			</h4>
			<hr />

			<!-- Checking validity available Bed -->
			<c:choose>

				<c:when test="${pg.bedAvailable < 1}">
					<h6>
						Bed Status: <span style="color: red">Unavailable</span>
					</h6>
				</c:when>
				<c:otherwise>
					<h6>Bed Available: ${pg.bedAvailable}</h6>
				</c:otherwise>
			</c:choose>

			<c:choose>

				<c:when test="${pg.bedAvailable < 1}">
				
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
					<span class="glyphicon glyphicon-shopping-cart"></span>Add To Book </strike></a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${pg.id}/pg" class="btn btn-success"> <span
						class="glyphicon glyphicon-shopping-cart"></span>Add To Book </a>
				</c:otherwise>
			</c:choose>


			<a href="${contextRoot}/show/all/pgs" class="btn btn-primary">Back</a>

		</div>

	</div>

</div>