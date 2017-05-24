<#include "header.ftl">
<ul class="nav nav-pills nav-justified">
    <li role="presentation"><a href="/owners">OWNERS</a></li>
    <li role="presentation"><a href="/vets">VETERINARIANS</a></li>
    <li role="presentation"><a href="/pettypes">PET TYPES</a></li>
</ul>
<hr>
<h4><#if visit.id??>Update<#else>Add new</#if> visit</h4>
<div class="panel panel-default panel-custom-inline">
    <div class="panel-heading">
        <h3 class="panel-title">Pet</h3>
    </div>
    <div class="panel-body">

    <table class="table table-condensed">
        <tr>
            <th>Name</th>
            <td>${pet.name}</td>
        </tr>
        <tr>
            <th>Birth date</th>
            <td>${pet.birthDate}</td>
        </tr>
        <tr>
            <th>Type</th>
            <td>${pet.petType.name}</td>
        </tr>
        <tr>
            <th>Owner</th>
            <td>${pet.owner.firstName} ${pet.owner.lastName}</td>
        </tr>
    </table>
    </div>
</div>

<form class="form-horizontal" action="/owners/${pet.owner.id}/pets/${pet.id}/visits/save" method="post">
    <fieldset><legend>Visit details</legend>
    <#if visit.id??>
        <div class="form-group">
            <label for="id" class="col-sm-1 control-label">ID</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="id" value="${visit.id}" readonly="readonly">
            </div>
        </div>
    </#if>
        <div class="form-group">
            <label for="vetId" class="col-sm-1 control-label">Veterinarian</label>
            <div class="col-sm-3">
                <select class="form-control" id ="vetId" name ="vetId">
                <#list vetList as vet>
                    <option value = "${vet.id}" <#if visit.vet??><#if visit.vet.id == vet.id>selected="selected"</#if></#if>>${vet.firstName} ${vet.lastName}</option>
                </#list>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="visitDate" class="col-sm-1 control-label">Date</label>
            <div class="col-sm-3">
                <input type="date" class="form-control" name="visitDate" <#if visit.id??>value="${visit.visitDate?iso_local}"</#if>>
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-1 control-label">Description</label>
            <div class="col-sm-3">
                <textarea class="form-control" name="description" rows="7" cols="25"><#if visit.id??>${visit.description}</#if></textarea>
            </div>
        </div>
            <input type="submit" class="btn btn-primary btn-sm" value="Save">
    </fieldset>
</form>
<#include "footer.ftl">
