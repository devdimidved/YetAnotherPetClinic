<#include "header.ftl">
<ul class="nav nav-pills nav-justified">
    <li role="presentation"><a href="/owners">OWNERS</a></li>
    <li role="presentation" class="active"><a href="/vets">VETERINARIANS</a></li>
    <li role="presentation"><a href="/pettypes">PET TYPES</a></li>
</ul>
<hr>
<div class="panel panel-default panel-custom-inline">
    <div class="panel-heading">
        <h3 class="panel-title">List of veterinarians</h3>
    </div>
    <table class="table table-condensed table-striped">
    <tr>
        <th>Id</th>
        <th>Lastname</th>
        <th>Firstname</th>
        <th>Actions</th>
    </tr>
<#list vetList as vet>
    <tr>
        <td>${vet.id}</td>
        <td>${vet.lastName}</td>
        <td>${vet.firstName}</td>
        <td>
            <a href="/vets/edit/${vet.id}" class="btn btn-primary btn-xs">Edit</a>
            <a href="/vets/delete/${vet.id}" class="btn btn-danger btn-xs">Delete</a>
        </td>
    </tr>
</#list>
</table>
</div>
<br/>
<form class="form-horizontal" action="/vets/save" method="post">
    <fieldset>
        <legend><#if vet.id??>Edit<#else>Add new</#if> veterinarian</legend>
<#if vet.id??>
    <div class="form-group">
        <label for="id" class="col-sm-1 control-label">ID</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="id" value="${vet.id}" readonly="readonly">
        </div>
    </div>
</#if>
    <div class="form-group">
        <label for="lastName" class="col-sm-1 control-label">Lastname</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="lastName" <#if vet.id??>value="${vet.lastName}"</#if>>
        </div>
    </div>
    <div class="form-group">
        <label for="firstName" class="col-sm-1 control-label">Firstname</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="firstName" <#if vet.id??>value="${vet.firstName}"</#if>>
        </div>
    </div>
    <input type="submit" class="btn btn-primary btn-sm" value="Save">
    </fieldset>
</form>
<#include "footer.ftl">
