<#include "header.ftl">
<ul class="nav nav-pills nav-justified">
    <li role="presentation" class="active"><a href="/owners">OWNERS</a></li>
    <li role="presentation"><a href="/vets">VETERINARIANS</a></li>
    <li role="presentation"><a href="/pettypes">PET TYPES</a></li>
</ul>
<hr>
<div class="row">
<form class="navbar-form navbar-left" role="search" action="/owners">
    <div class="form-group">
        <input name="name" type="text" class="form-control" placeholder="Enter part of name">
    </div>
    <button type="submit" class="btn btn-default">Search</button>
</form>
</div>
<div class="panel panel-default panel-custom-inline">
    <div class="panel-heading">
        <h3 class="panel-title">List of owners</h3>
    </div>
    <table class="table table-condensed table-striped">
        <tr>
            <th>Id</th>
            <th>Owner</th>
            <th>City</th>
            <th>Address</th>
            <th>Phone</th>
        </tr>
    <#if ownerList??>
    <#list ownerList as owner>
        <tr>
            <td>${owner.id}</td>
            <td><a href="/owners/${owner.id}">${owner.lastName} ${owner.firstName} <span class="badge">${owner.pets?size}</span></a></td>
            <td>${owner.city}</td>
            <td>${owner.address}</td>
            <td>${owner.phone}</td>
        </tr>
    </#list>
    </#if>
    </table>
</div>
<br>
<a href="/owners/add" class="btn btn-success btn-sm">Add new owner</a>
<#include "footer.ftl">
