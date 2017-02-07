<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/country">Country</a></li>
					<li><a href="/admin/producer">Producer</a></li>
					<li><a href="/admin/model">Model</a></li>
					<li><a href="/admin/color">Color</a></li>
					<li><a href="/admin/os">Os</a></li>
					<li><a href="/admin/typedisplay">Type display</a></li>
					<li class="active"><a href="/admin/item">Smartphones</a><span
						class="sr-only">(current)</span></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-2 col-xs-12"></div>
	<div class="col-md-8 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/item"
					method="POST" modelAttribute="item">

					

					<div class="form-group">
						<label class="col-sm-2 control-label">Producer</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="producer" id="producerId"
								items="${producers}" itemValue="id" itemLabel="name" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Model</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="model" id="modelId"
								items="${models}" itemValue="id" itemLabel="name" />
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-2 control-label">Os</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="os" id="osId"
								items="${oss}" itemValue="id" itemLabel="name" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Type display</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="typeDisplay"
								id="typedisplayId" items="${typeDisplays}" itemValue="id"
								itemLabel="name" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Color</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="color" id="colorId"
								items="${colors}" itemValue="id" itemLabel="name" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="batteryCapacity" /></label>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">Battery capacity</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control"
								path="batteryCapacity" id="batteryCapacity" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="displaySize" /></label>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Display size</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="displaySize"
								id="displaySize" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="camera" /></label>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Camera</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="camera"
								id="camera" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="price" /></label>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Price</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="price"
								id="price" />
						</div>
					</div>





					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Create</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-xs-2">
				<h3>Name</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Color</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Os</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Type display</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Country</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Battery capacity</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Display size</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Camera</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Price</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Update</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Delete</h3>
			</div>
		</div>

		<c:forEach items="${items}" var="item">
			<div class="row">
				<div class="col-md-2 col-xs-2">${item.producer.name} ${item.model.name}</div>
				<div class="col-md-1 col-xs-1">${item.color.name}</div>
				<div class="col-md-1 col-xs-1">${item.os.name}</div>
				<div class="col-md-1 col-xs-1">${item.typeDisplay.name}</div>
				<div class="col-md-1 col-xs-1">${item.producer.country.name}</div>
				<div class="col-md-1 col-xs-1">${item.batteryCapacity}</div>
				<div class="col-md-1 col-xs-1">${item.displaySize}</div>
				<div class="col-md-1 col-xs-1">${item.camera}</div>
				<div class="col-md-1 col-xs-1">${item.price}</div>
				<div class="col-md-1 col-xs-1">
					<a class="btn btn-warning" href="/admin/item/update/${item.id}">update</a>
				</div>
				<div class="col-md-1 col-xs-1">
					<a class="btn btn-danger" href="/admin/item/delete/${item.id}">delete</a>
				</div>
			</div>
		</c:forEach>

	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>