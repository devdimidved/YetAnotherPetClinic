<#include "header.ftl">
<ul class="nav nav-pills nav-justified">
    <li role="presentation"><a href="/owners">OWNERS</a></li>
    <li role="presentation"><a href="/vets">VETERINARIANS</a></li>
    <li role="presentation"><a href="/pettypes">PET TYPES</a></li>
</ul>
<hr>
<h4><#if pet.id??>Update<#else>Add</#if> pet's data</h4>
<strong>Owner</strong>
<br>${owner.lastName} ${owner.firstName}
<br>
<form class="form-horizontal" action="/owners/${owner.id}/pets/save" method="post">
    <fieldset><legend><#if pet.id??>Edit<#else>Add new</#if> pet</legend>
<#if pet.id??>
    <div class="form-group">
        <label for="id" class="col-sm-1 control-label">ID</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="id" value="${pet.id}" readonly="readonly">
        </div>
    </div>
</#if>
    <div class="form-group">
        <label for="petType" class="col-sm-1 control-label">Type</label>
        <div class="col-sm-3">
            <select class="form-control" id = "petType" name = "petType">
            <#list petTypeList as petTypes>
                <option value = "${petTypes.id}" <#if pet.petType??><#if pet.petType.id == petTypes.id>selected="selected"</#if></#if>>${petTypes.name}</option>
            </#list>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="name" class="col-sm-1 control-label">Name</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="name" <#if pet.id??>value="${pet.name}"</#if>>
        </div>
    </div>
    <div class="form-group">
        <label for="birthDate" class="col-sm-1 control-label">Birth date</label>
        <div class="col-sm-3">
            <input type="date" name="birthDate" class="form-control" <#if pet.id??>value="${pet.birthDate?iso_local}"</#if>>
        </div>
    </div>
    <input type="submit" class="btn btn-primary btn-sm" value="Save">
    </fieldset>
</form>
<#include "footer.ftl">
