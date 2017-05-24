<#include "header.ftl">
<ul class="nav nav-pills nav-justified">
    <li role="presentation"><a href="/owners">OWNERS</a></li>
    <li role="presentation"><a href="/vets">VETERINARIANS</a></li>
    <li role="presentation" class="active"><a href="/pettypes">PET TYPES</a></li>
</ul>
<hr>
<div class="panel panel-default panel-custom-inline">
    <div class="panel-heading">
        <h3 class="panel-title">List of pet types</h3>
    </div>
        <table class="table table-condensed table-striped">
            <tr>
                <th>Id</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
            <#list petTypeList as petType>
            <tr>
                <td>${petType.id}</td>
                <td>${petType.name}</td>
                <td>
                    <a href="/pettypes/edit/${petType.id}" class="btn btn-primary btn-xs">Edit</a>
                    <a href="/pettypes/delete/${petType.id}" class="btn btn-danger btn-xs">Delete</a>
                </td>
            </tr>
            </#list>
         </table>
</div>
<br/>
<form class="form-horizontal" action="/pettypes/save" method="post">
    <fieldset>
        <legend><#if petType.id??>Edit<#else>Add new</#if> pet type</legend>
        <#if petType.id??>
        <div class="form-group">
            <label for="id" class="col-sm-1 control-label">ID</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="id" value="${petType.id}" readonly="readonly">
            </div>
        </div>
        </#if>
        <div class="form-group">
            <label for="name" class="col-sm-1 control-label">Type</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="name" <#if petType.id??>value="${petType.name}"</#if>>
            </div>
        </div>
            <input type="submit" class="btn btn-primary btn-sm" value="Save">
    </fieldset>
</form>
<#include "footer.ftl">
