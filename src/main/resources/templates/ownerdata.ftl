<#include "header.ftl">
<ul class="nav nav-pills nav-justified">
    <li role="presentation"><a href="/owners">OWNERS</a></li>
    <li role="presentation"><a href="/vets">VETERINARIANS</a></li>
    <li role="presentation"><a href="/pettypes">PET TYPES</a></li>
</ul>
<hr>
<p><b><#if owner.id??>Edit<#else>Add new</#if> owner</b></p>
<form class="form-horizontal" action="/owners/save" method="post">
    <fieldset><legend>Owner's information</legend>
<#if owner.id??>
    <div class="form-group">
        <label for="id" class="col-sm-1 control-label">ID</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="id" value="${owner.id}" readonly="readonly">
        </div>
    </div>
</#if>
    <div class="form-group">
        <label for="lastName" class="col-sm-1 control-label">Lastname</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="lastName" <#if owner.id??>value="${owner.lastName}"</#if>>
        </div>
    </div>
    <div class="form-group">
        <label for="firstName" class="col-sm-1 control-label">Firstname</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="firstName" <#if owner.id??>value="${owner.firstName}"</#if>>
        </div>
    </div>
    <div class="form-group">
        <label for="city" class="col-sm-1 control-label">City</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="city" <#if owner.id??>value="${owner.city}"</#if>>
        </div>
    </div>
    <div class="form-group">
        <label for="address" class="col-sm-1 control-label">Address</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="address" <#if owner.id??>value="${owner.address}"</#if>>
        </div>
    </div>
    <div class="form-group">
        <label for="phone" class="col-sm-1 control-label">Phone</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="phone" <#if owner.id??>value="${owner.phone}"</#if>>
        </div>
    </div>
    <input type="submit" class="btn btn-primary btn-sm" value="Save">
    </fieldset>
</form>
<#include "footer.ftl">
